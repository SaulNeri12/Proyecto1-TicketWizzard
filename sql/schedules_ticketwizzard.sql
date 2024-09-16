
CREATE EVENT IF NOT EXISTS actualizar_fechas_venta_boletos
ON SCHEDULE EVERY 1 HOUR
STARTS NOW()
DO
CALL actualizar_boletos();

