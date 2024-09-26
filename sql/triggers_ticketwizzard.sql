
DELIMITER //

CREATE TRIGGER before_insert_transaccion
BEFORE INSERT ON transaccion
FOR EACH ROW
BEGIN
    DECLARE saldo_comprador_actual DECIMAL(10, 2);
    DECLARE precio_boleto DECIMAL(10, 2);
    DECLARE comision DECIMAL(10, 2);
    DECLARE nuevo_saldo_vendedor DECIMAL(10, 2);

    -- 0. Verificar si el boleto está en venta
    IF (SELECT en_venta FROM boleto WHERE id_boleto = NEW.id_boleto) = 0 THEN
        SIGNAL SQLSTATE '45000' 
        SET MESSAGE_TEXT = 'El boleto que se intenta comprar no esta a la venta';
    END IF;

    -- 1. Determinar el tipo de transacción
    IF NEW.id_vendedor IS NOT NULL THEN
        SET NEW.tipo = 'reventa';
    ELSE
        SET NEW.tipo = 'boletera';
    END IF;

    -- 2. Obtener el saldo del comprador y el precio del boleto
    SELECT saldo INTO saldo_comprador_actual FROM usuario WHERE id_usuario = NEW.id_comprador;
    SELECT precio_original INTO precio_boleto FROM boleto WHERE id_boleto = NEW.id_boleto;

		-- en una reventa se pone el precio reventa, no el original
		IF NEW.id_vendedor IS NOT NULL THEN
    	SELECT precio_reventa INTO precio_boleto FROM boleto WHERE id_boleto = NEW.id_boleto;
		END IF;

    -- 3. Si el saldo es insuficiente, apartar el boleto por 10 minutos
    IF (saldo_comprador_actual - precio_boleto) < 0 THEN
        SET NEW.fecha_apartado = NOW() + INTERVAL 10 MINUTE;
        SET NEW.monto = 0;
        SET NEW.estado = 'en espera';
    ELSE
        -- 4. Si el saldo es suficiente, proceder con la compra
        -- Actualizar el saldo del comprador

        -- 5. Si es una reventa, actualizar el saldo del vendedor
        IF NEW.id_vendedor IS NOT NULL THEN
            -- Calcular la comisión del 3%
            SET comision = precio_boleto * 0.03;
            SET nuevo_saldo_vendedor = (SELECT saldo FROM usuario WHERE id_usuario = NEW.id_vendedor) + (precio_boleto - comision);

            -- Actualizar saldo del vendedor
            UPDATE usuario 
            SET saldo = nuevo_saldo_vendedor 
            WHERE id_usuario = NEW.id_vendedor;
				END IF;


	      UPDATE usuario 
  	    SET saldo = saldo_comprador_actual - precio_boleto
        WHERE id_usuario = NEW.id_comprador;

				SET NEW.monto = precio_boleto;

        -- 6. Actualizar el estado de la transacción a 'terminada'
        SET NEW.estado = 'terminada';

        -- 7. Actualizar el estado del boleto
        UPDATE boleto 
        SET en_venta = FALSE, 
            precio_reventa = NULL, 
            fecha_limite_venta = NULL, 
            id_usuario = NEW.id_comprador 
        WHERE id_boleto = NEW.id_boleto;

        -- 8. Marcar si el boleto fue adquirido de la boletera o en reventa
        IF NEW.id_vendedor IS NOT NULL THEN
            UPDATE boleto 
            SET adquirido_boletera = FALSE 
            WHERE id_boleto = NEW.id_boleto;
        ELSE
            UPDATE boleto 
            SET adquirido_boletera = TRUE 
            WHERE id_boleto = NEW.id_boleto;
        END IF;

        -- 9. Generar un nuevo número de serie para el boleto
        UPDATE boleto 
        SET numero_serie = LEFT(UUID(), 8) 
        WHERE id_boleto = NEW.id_boleto;
    END IF;
END//

-- Trigger para generar asientos y boletos automáticamente

CREATE TRIGGER after_evento_insert
AFTER INSERT ON evento
FOR EACH ROW
BEGIN
    DECLARE fila CHAR(1);
    DECLARE numero INT;
    DECLARE id_asiento_nuevo INT;
    
    SET fila = 'A';
    SET numero = 1;
    
    WHILE fila <= 'J' DO
        WHILE numero <= 2 DO
            -- Insertar asiento
            INSERT INTO asiento (fila, numero, id_evento)
            VALUES (fila, numero, NEW.id_evento);
            
            SET id_asiento_nuevo = LAST_INSERT_ID();
            
            -- Insertar boleto correspondiente
            INSERT INTO boleto (numero_serie, numero_control, precio_original, id_evento, id_asiento, fecha_limite_venta)
            VALUES (
                CONCAT(LEFT(UUID(), 8)),  -- Genera un número de serie único
                CONCAT(NEW.id_evento, '-', fila, '-', LPAD(numero, 2, '0')),  -- Genera un número de control
                NEW.precio_base_boleto,  -- Precio original (puedes ajustar esto según tus necesidades)
                NEW.id_evento,
                id_asiento_nuevo,
								NEW.fecha_hora
            );
            
            SET numero = numero + 1;
        END WHILE;
        
        SET fila = CHAR(ASCII(fila) + 1);
        SET numero = 1;
    END WHILE;
END//

DELIMITER ;
