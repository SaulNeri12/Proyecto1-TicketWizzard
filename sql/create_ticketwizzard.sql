
-- Crear la base de datos
CREATE DATABASE IF NOT EXISTS ticketwizzard;

-- usamos la base de datos de ticketwizzard
USE ticketwizzard;

-- Tabla de Usuarios
CREATE TABLE usuario (
    id_usuario INT AUTO_INCREMENT PRIMARY KEY,
    email VARCHAR(100) UNIQUE NOT NULL,
    nombre_completo VARCHAR(100) NOT NULL,
    domicilio VARCHAR(200) NOT NULL,
    fecha_nacimiento DATE NOT NULL,
    edad INT NOT NULL,
    saldo DECIMAL(10, 2) DEFAULT 0,
    contrasena VARCHAR(255) NOT NULL
);

-- Tabla de Ciudades
CREATE TABLE ciudad (
	id_ciudad INT AUTO_INCREMENT PRIMARY KEY,
	nombre VARCHAR(100) UNIQUE NOT NULL,
	estado VARCHAR(100) NOT NULL
);

-- Tabla de Eventos
CREATE TABLE evento (
    id_evento INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    descripcion TEXT NULL
);

-- Tabla de presentacion de eventos
CREATE TABLE presentacion (
	id_presentacion INT AUTO_INCREMENT PRIMARY KEY,
	fecha_hora DATETIME NOT NULL,
	venue VARCHAR(100) NOT NULL,
	terminada TINYINT(1) NOT NULL,
	id_ciudad INT NOT NULL,
	id_evento INT NOT NULL,
	FOREIGN KEY (id_ciudad) REFERENCES ciudad(id_ciudad),
	FOREIGN KEY (id_evento) REFERENCES evento(id_evento)
);

-- Tabla de Boletos
CREATE TABLE boleto (
    id_boleto INT AUTO_INCREMENT PRIMARY KEY,
    numero_serie CHAR(8) UNIQUE NULL,
    fila VARCHAR(100) NOT NULL,
    asiento VARCHAR(50) NOT NULL,
    numero_control VARCHAR(50) UNIQUE NULL,
    precio_original DECIMAL(10, 2) NOT NULL,
    precio_reventa DECIMAL(10, 2),
    fecha_limite_venta DATETIME NULL,
    en_venta BOOLEAN DEFAULT FALSE,
    id_usuario INT NULL,
    id_presentacion INT NOT NULL,
		adquirido_boletera TINYINT(1) NULL,
    FOREIGN KEY (id_usuario) REFERENCES usuario(id_usuario),
    FOREIGN KEY (id_presentacion) REFERENCES presentacion(id_presentacion)
);

-- Tabla de Transacciones
CREATE TABLE transaccion (
    id_transaccion INT AUTO_INCREMENT PRIMARY KEY,
    id_comprador INT NOT NULL,
    id_vendedor INT NULL,
    monto DECIMAL(10, 2) NULL,
    fecha_hora TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    tipo ENUM('compra_boletera', 'compra_reventa') NOT NULL,
    FOREIGN KEY (id_comprador) REFERENCES usuario(id_usuario),
    FOREIGN KEY (id_vendedor) REFERENCES usuario(id_usuario),
    FOREIGN KEY (id_boleto) REFERENCES boleto(id_boleto)
);

-- Tabla de boletos involucrados en una transaccion
CREATE TABLE transaccion_boleto (
	id_transaccion_boleto INT AUTO_INCREMENT PRIMARY KEY,
	monto DECIMAL(10,2) NOT NULL,
	id_boleto INT NULL,
	id_transaccion INT NOT NULL,
  FOREIGN KEY (id_boleto) REFERENCES boleto(id_boleto)
	FOREIGN KEY (id_transaccion) REFERENCES transaccion(id_transaccion)
);


