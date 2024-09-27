

-- [INSERCION DE CIUDADES]
INSERT INTO ciudad(nombre, estado) VALUES ('Hermosillo', 'Sonora');
INSERT INTO ciudad(nombre, estado) VALUES ('Guadalajara', 'Jalisco');
INSERT INTO ciudad(nombre, estado) VALUES ('Monterrey', 'Nuevo Leon');
INSERT INTO ciudad(nombre, estado) VALUES ('CDMX', 'Ciudad de Mexico');
INSERT INTO ciudad(nombre, estado) VALUES ('Puebla', 'Puebla');

-- [INSERCION DE EVENTOS]

SET @id_ciudad = 1;

INSERT INTO evento(nombre, descripcion, fecha_hora, venue, terminado, id_ciudad, precio_base_boleto) VALUES (
	'El Show de Franco Escamilla', 
	'En este show, Franco Escamilla compartirá anécdotas y reflexiones sobre su vida personal, incluyendo cómo aconseja a sus hijos cuando se meten en problemas, así como temas como género, amistad y romance. También compartirá historias divertidas y	críticas irónicas sobre la vida cotidiana.',
	'2024-10-23',
	'El Mentidero',
	FALSE,
	@id_ciudad,
	300
), (
	'Lucha Libre CMLL', 
	'Un auténtico ritual de intensas emociones se experimentan en las Arenas México, Coliseo, Guadalajara y Puebla, los magnos escenarios donde se presenta la Mejor Lucha Libre del Mundo, la del Consejo Mundial de Lucha Libre (CMLL).',
	'2024-10-23',
	'Arena Mexico',
	FALSE,
	@id_ciudad,
	300
),
('Festival de Música de Guadalajara', 'Un festival que reúne a los mejores artistas nacionales e internacionales.', '2024-10-05 18:00:00', 'Auditorio Telmex', 0, 1, 500),
('Feria Internacional del Libro', 'Una de las ferias de libros más importantes de América Latina.', '2024-10-12 10:00:00', 'Expo Guadalajara', 0, 1, 100),
('Día de Muertos en Oaxaca', 'Celebración tradicional con altares y ofrendas en honor a los difuntos.', '2024-10-31 18:00:00', 'Zócalo de Oaxaca', 0, 1, 400),
('Carnaval de Veracruz', 'Un carnaval lleno de desfiles, música y bailes.', '2024-10-21 16:00:00', 'Malecón de Veracruz', 0, 3, 880),
('Cine en tu colonia', 'Proyección de películas al aire libre en diferentes colonias.', '2024-10-15 20:00:00', 'Parque de los Venados', 0, 4, 700),
('Concierto de Primavera', 'Concierto de música clásica al aire libre.', '2024-10-14 19:00:00', 'Bosque de Chapultepec', 0, 5, 340),
('Exposición de Arte Contemporáneo', 'Muestra de obras de artistas emergentes.', '2024-10-20 11:00:00', 'Museo de Arte Moderno', 0, 5, 1045);


-- [INSERCION DE USUARIOS]
INSERT INTO usuario (email, nombre_completo, domicilio, fecha_nacimiento, edad, saldo, contrasena)
VALUES
('juan.perez@example.com', 'Juan Pérez', 'Calle Falsa 123, Ciudad', '1990-01-15', 34, 1000.00, '5994471abb01112afcc18159f6cc74b4f511b99806da59b3caf5a9c173cacfc5'),
('ana.garcia@example.com', 'Ana García', 'Avenida Siempre Viva 456, Ciudad', '1985-05-23', 39, 500.00, '5994471abb01112afcc18159f6cc74b4f511b99806da59b3caf5a9c173cacfc5'),
('luis.martinez@example.com', 'Luis Martínez', 'Boulevard del Río 789, Ciudad', '2000-09-30', 23, 750.00, '5994471abb01112afcc18159f6cc74b4f511b99806da59b3caf5a9c173cacfc5'),
('maria.lopez@example.com', 'María López', 'Plaza Mayor 101, Ciudad', '1995-12-02', 28, 200.00, '5994471abb01112afcc18159f6cc74b4f511b99806da59b3caf5a9c173cacfc5'),
('pedro.sanchez@example.com', 'Pedro Sánchez', 'Calle del Sol 202, Ciudad', '1992-07-16', 32, 1200.00, '5994471abb01112afcc18159f6cc74b4f511b99806da59b3caf5a9c173cacfc5'),
('laura.ramirez@example.com', 'Laura Ramírez', 'Calle del Mar 303, Ciudad', '1988-04-10', 36, 300.00, '5994471abb01112afcc18159f6cc74b4f511b99806da59b3caf5a9c173cacfc5'),
('carla.moreno@example.com', 'Carla Moreno', 'Calle del Bosque 404, Ciudad', '1993-11-22', 30, 1500.00, '5994471abb01112afcc18159f6cc74b4f511b99806da59b3caf5a9c173cacfc5'),
('jorge.silva@example.com', 'Jorge Silva', 'Avenida de la Luna 505, Ciudad', '1997-03-17', 27, 800.00, '5994471abb01112afcc18159f6cc74b4f511b99806da59b3caf5a9c173cacfc5'),
('valeria.ortiz@example.com', 'Valeria Ortiz', 'Calle del Viento 606, Ciudad', '1999-08-25', 25, 600.00, '5994471abb01112afcc18159f6cc74b4f511b99806da59b3caf5a9c173cacfc5'),
('andres.fernandez@example.com', 'Andrés Fernández', 'Calle de los Olivos 707, Ciudad', '1987-10-08', 37, 950.00, '5994471abb01112afcc18159f6cc74b4f511b99806da59b3caf5a9c173cacfc5');

SELECT 'transacciones...';
-- [INSERCION DE TRANSACCIONES]
SET @id_boleto = (SELECT id_boleto FROM boleto WHERE id_evento = 1 LIMIT 1);
SET @id_comprador = (SELECT id_usuario FROM usuario WHERE nombre_completo LIKE '%juan%' LIMIT 1);

INSERT INTO transaccion(id_comprador, id_boleto) VALUES 
(
	@id_comprador,
	@id_boleto
);

SET @id_boleto = (SELECT id_boleto FROM boleto WHERE id_evento = 2 LIMIT 1);
SET @id_comprador = (SELECT id_usuario FROM usuario WHERE nombre_completo LIKE '%ana%' LIMIT 1);

INSERT INTO transaccion(id_comprador, id_boleto) VALUES 
(
	@id_comprador,
	@id_boleto
);

SET @id_boleto = (SELECT id_boleto FROM boleto WHERE id_evento = 3 LIMIT 1);
SET @id_comprador = (SELECT id_usuario FROM usuario WHERE nombre_completo LIKE '%laura%' LIMIT 1);

INSERT INTO transaccion(id_comprador, id_boleto) VALUES 
(
	@id_comprador,
	@id_boleto
);


-- TRANSACCION REVENTA
UPDATE boleto SET en_venta = true, precio_reventa = 100 WHERE id_boleto = 21;

INSERT INTO transaccion(id_comprador, id_vendedor, id_boleto) VALUES 
(
	1,
	2,
	21
);

