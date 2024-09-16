
DELIMITER //

CREATE PROCEDURE actualizar_boletos()
BEGIN
    -- Hace que los boletos que pasaron de su fecha limite no esten
		-- mas en venta
		UPDATE boleto SET en_venta = FALSE
    WHERE fecha_limite_venta < NOW();
END //

DELIMITER ;

