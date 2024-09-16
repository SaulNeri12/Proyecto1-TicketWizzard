-- INSERCION DE TRANSACCIONES DE BOLETOS

DELIMITER //

CREATE TRIGGER transaccion_boleto BEFORE INSERT ON transaccion 
FOR EACH ROW
BEGIN

	DECLARE en_venta BOOLEAN;
  DECLARE tipo_transaccion ENUM('compra_boletera', 'compra_reventa');
  DECLARE precio_original DECIMAL(10, 2);
  DECLARE precio_reventa DECIMAL(10, 2);
  DECLARE saldo_comprador DECIMAL(10, 2);
  DECLARE nuevo_saldo_comprador DECIMAL(10, 2);
  DECLARE saldo_vendedor DECIMAL(10, 2);
  DECLARE comision_reventa_vendedor DECIMAL(10, 2);
  DECLARE nuevo_saldo_vendedor DECIMAL(10, 2);
  DECLARE fecha_evento_boleto DATETIME;
  DECLARE fecha_limite_venta DATETIME;


	SET en_venta = (SELECT en_venta FROM boleto WHERE id_boleto = NEW.id_boleto);
	IF en_venta = FALSE THEN
		-- no se puede comprar o vender un boleto que no esta en venta
		SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'El boleto no esta en venta';
	END IF;


	SET fecha_evento_boleto = (SELECT p.fecha_hora FROM boleto b INNER JOIN presentacion p ON b.id_presentacion = p.id_presentacion WHERE b.id_boleto = NEW.id_boleto);
	IF fecha_evento_boleto > NOW() THEN
		-- no se puede comprar o vender un boleto del cual su presentacion ya vencio
		SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'La fecha del evento del boleto ya paso';
	END IF;


	SET fecha_limite_venta = (SELECT fecha_limite_venta FROM boleto WHERE id_boleto = NEW.id_boleto);
	IF fecha_limite_venta IS NULL THEN
		-- no se puede comprar un boleto el cual su fecha de venta ya vencio 
		SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'No se pudo determinar la fecha limite de venta del boleto, porfavor intente mas tarde';
	END IF;

	IF fecha_limite_venta > NOW() THEN
		-- no se puede comprar un boleto el cual su fecha de venta ya vencio 
		SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'La fecha de venta del boleto ya vencio';
	END IF;

	-- [COMPRA EN BOLETERA]
	-- si no tiene vendedor es porque es una compra directa en boletera
	IF NEW.id_vendedor IS NOT NULL THEN 
		SET tipo_transaccion = 'compra_boletera';
		
		SET precio_original = (SELECT precio_original FROM boleto WHERE id_boleto = NEW.id_boleto);

		SET NEW.monto = precio_original;
		SET NEW.tipo = tipo_transaccion;
		
		SET saldo_comprador = (SELECT saldo FROM usuario WHERE id_usuario = NEW.id_comprador);
		SET nuevo_saldo_comprador = saldo_comprador - NEW.monto;

		IF nuevo_saldo_comprador < 0 THEN
			-- el comprador no tiene saldo suficiente para realizar la compra
			SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Saldo insuficiente';
		END IF;

		-- se actualiza el saldo del comprador 
		UPDATE usuario SET saldo = nuevo_saldo_comprador WHERE id_usuario = NEW.id_comprador;
		-- se actualiza la informacion del boleto
		UPDATE boleto SET adquirido_boletera = TRUE, en_venta = FALSE WHERE id_usuario = NEW.id_comprador;

		-- TODO: Generar numero de serie y numero de control para el boleto
	ELSE -- [COMPRA EN REVENTA]
		SET tipo_transaccion = 'compra_reventa';
		
		SET precio_reventa = (SELECT precio_reventa FROM boleto WHERE id_boleto = NEW.id_boleto);

		IF precio_reventa IS NULL THEN
			-- Se cancela la transaccion
			SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Ocurrio un error en la compra de reventa';
		END IF;

		SET NEW.monto = precio_reventa;
		SET NEW.tipo = tipo_transaccion;
		
		SET saldo_comprador = (SELECT saldo FROM usuario WHERE id_usuario = NEW.id_comprador);
		SET saldo_vendedor = (SELECT saldo FROM usuario WHERE id_usuario = NEW.id_vendedor);
		SET nuevo_saldo_comprador = saldo_comprador - NEW.monto;

		IF nuevo_saldo_comprador < 0 THEN
			-- el comprador no tiene saldo suficiente para realizar la compra
			SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Saldo insuficiente';
		END IF;

		-- Se actualiza el saldo del comprador... (saldo - monto_boleto)
		UPDATE usuario SET saldo = nuevo_saldo_comprador WHERE id_usuario = NEW.id_comprador;
		-- se le anade el monto del boleto revendido menos la comision del 3%
		SET comision_reventa_vendedor = NEW.monto * 0.03;
		SET nuevo_saldo_vendedor = (saldo_vendedor + NEW.monto) - comision_reventa_vendedor;
		-- Se actualiza el saldo del vendedor... (saldo_vendor + monto_boleto - 3% comision)
		UPDATE usuario SET saldo = nuevo_saldo_vendedor WHERE id_usuario = NEW.id_vendedor;
		-- se hace el cambio de duenio del boleto, precio en reventa nulo (ya que no esta en venta) y el como fue adquirido...
		UPDATE boleto SET adquirido_boletera = FALSE, precio_reventa = NULL, en_venta = FALSE WHERE id_usuario = NEW.id_comprador;

		-- TODO: Generar numero de serie y numero de control para el boleto
	END IF;
END //


-- TODO: Crear un TRIGGER para hacer que no se pueda vender boletos de una presentacion ya terminada (despues de la fecha 
-- del evento presentacion)
CREATE TRIGGER actualizacion_boleto BEFORE UPDATE ON boleto 
FOR EACH ROW
BEGIN

END //
























DELIMITER ;
