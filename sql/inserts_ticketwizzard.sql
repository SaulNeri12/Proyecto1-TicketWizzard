
-- [INSERCION DE CIUDADES]
INSERT INTO ciudad(nombre, estado) VALUES ('Hermosillo', 'Sonora');
INSERT INTO ciudad(nombre, estado) VALUES ('Guadalajara', 'Jalisco');
INSERT INTO ciudad(nombre, estado) VALUES ('Monterrey', 'Nuevo Leon');
INSERT INTO ciudad(nombre, estado) VALUES ('CDMX', 'Ciudad de Mexico');
INSERT INTO ciudad(nombre, estado) VALUES ('Puebla', 'Puebla');

-- [INSERCION DE EVENTOS]

SET @id_ciudad = 1;

INSERT INTO evento(nombre, descripcion) VALUES (
	'El Show de Franco Escamilla', 
	'En este show, Franco Escamilla compartirá anécdotas y reflexiones sobre su vida personal, incluyendo cómo aconseja a sus hijos cuando se meten en problemas, así como temas como género, amistad y romance. También compartirá historias divertidas y	críticas irónicas sobre la vida cotidiana.'
);

-- Franco Escamilla
SET @id_evento = 1;

-- Presentacion de Franco Escamilla 20 de Septiembre del 2024 en el Mentidero, Hermosillo Sonora
INSERT INTO presentacion(fecha_hora, venue, id_ciudad, id_evento) VALUES(  
	'2024-09-20 22:30:00', 
	'El Mentidero',
	@id_ciudad,
	@id_evento
);

INSERT INTO evento(nombre, descripcion) VALUES (
	'Lucha Libre CMLL', 
	'Un auténtico ritual de intensas emociones se experimentan en las Arenas México, Coliseo, Guadalajara y Puebla, los magnos escenarios donde se presenta la Mejor Lucha Libre del Mundo, la del Consejo Mundial de Lucha Libre (CMLL).'
);

-- [INSERCION DE PRESENTACIONES DE EVENTOS]

-- ciudad de mexico
SET @id_ciudad = 4;
-- Lucha Libre
SET @id_evento = 2; 

-- Presentacion de Lucha Libre 16 de Septiembre del 2024 en Arena Mexico, CDMX
INSERT INTO presentacion(fecha_hora, venue, id_ciudad, id_evento) VALUES(  
	'2024-09-16 22:00:00', 
	'Arena Mexico',
	@id_ciudad,
	@id_evento
);

-- Franco escamilla
SET @id_evento = 1;
-- Ciidad de puebla
SET @id_ciudad = 5;

-- Presentacion de Franco Escamilla 21 de Septiembre del 2024 en Puebla, Puebla
INSERT INTO presentacion(fecha_hora, venue, id_ciudad, id_evento) VALUES(  
	'2024-09-21 21:30:00', 
	'Arena Puebla',
	@id_ciudad,
	@id_evento
);

-- Lucha Libre en Arena Mexico, CDMX
SET @id_presentacion = 2;

-- [INSERCION DE BOLETOS]
INSERT INTO boleto(fila, asiento, precio_original, fecha_limite_venta, en_venta, id_presentacion) VALUES(
	'Ring Naranja',
	'RN-34',
	304,
	'2024-09-15 23:59:00',
	TRUE,
	@id_presentacion
);

-- [INSERCION DE USUARIOS]
INSERT INTO usuario (email, nombre_completo, domicilio, fecha_nacimiento, edad, saldo, contrasena)
VALUES
('juan.perez@example.com', 'Juan Pérez', 'Calle Falsa 123, Ciudad', '1990-01-15', 34, 1000.00, 'password123'),
('ana.garcia@example.com', 'Ana García', 'Avenida Siempre Viva 456, Ciudad', '1985-05-23', 39, 500.00, 'securepass456'),
('luis.martinez@example.com', 'Luis Martínez', 'Boulevard del Río 789, Ciudad', '2000-09-30', 23, 750.00, 'luispassword789'),
('maria.lopez@example.com', 'María López', 'Plaza Mayor 101, Ciudad', '1995-12-02', 28, 200.00, 'mariapass101'),
('pedro.sanchez@example.com', 'Pedro Sánchez', 'Calle del Sol 202, Ciudad', '1992-07-16', 32, 1200.00, 'pedrosecure202'),
('laura.ramirez@example.com', 'Laura Ramírez', 'Calle del Mar 303, Ciudad', '1988-04-10', 36, 300.00, 'laurapass303'),
('carla.moreno@example.com', 'Carla Moreno', 'Calle del Bosque 404, Ciudad', '1993-11-22', 30, 1500.00, 'carlapass404'),
('jorge.silva@example.com', 'Jorge Silva', 'Avenida de la Luna 505, Ciudad', '1997-03-17', 27, 800.00, 'jorgepass505'),
('valeria.ortiz@example.com', 'Valeria Ortiz', 'Calle del Viento 606, Ciudad', '1999-08-25', 25, 600.00, 'valeriapass606'),
('andres.fernandez@example.com', 'Andrés Fernández', 'Calle de los Olivos 707, Ciudad', '1987-10-08', 37, 950.00, 'andrespass707');


-- [INSERCION DE TRANSACCIONES]











