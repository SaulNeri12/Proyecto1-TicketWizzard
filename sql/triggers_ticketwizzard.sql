
-- Trigger para generar asientos y boletos automáticamente
DELIMITER //

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
            INSERT INTO boleto (numero_serie, numero_control, precio_original, id_evento, id_asiento)
            VALUES (
                CONCAT(LEFT(UUID(), 8)),  -- Genera un número de serie único
                CONCAT(NEW.id_evento, '-', fila, '-', LPAD(numero, 2, '0')),  -- Genera un número de control
                NEW.precio_base_boleto,  -- Precio original (puedes ajustar esto según tus necesidades)
                NEW.id_evento,
                id_asiento_nuevo
            );
            
            SET numero = numero + 1;
        END WHILE;
        
        SET fila = CHAR(ASCII(fila) + 1);
        SET numero = 1;
    END WHILE;
END//

DELIMITER ;
