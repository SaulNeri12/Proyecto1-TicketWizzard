-- Crear la base de datos
CREATE DATABASE IF NOT EXISTS ticketwizzard;

-- Usar la base de datos de ticketwizzard
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
    nombre VARCHAR(100) UNIQUE NOT NULL,
    descripcion TEXT NULL,
    fecha_hora DATETIME NOT NULL,
		precio_base_boleto DECIMAL(10,2) NOT NULL,
    venue VARCHAR(100) NOT NULL,
    terminado TINYINT(1) NULL,
    id_ciudad INT NOT NULL,
    FOREIGN KEY (id_ciudad) REFERENCES ciudad(id_ciudad)
);

-- Tabla de Asientos (Nueva)
CREATE TABLE asiento (
    id_asiento INT AUTO_INCREMENT PRIMARY KEY,
    fila VARCHAR(10) NOT NULL,
    numero INT NOT NULL,
    id_evento INT NOT NULL,
    FOREIGN KEY (id_evento) REFERENCES evento(id_evento),
    UNIQUE KEY unique_asiento_evento (id_evento, fila, numero)
);

-- Tabla de Boletos (Modificada)
CREATE TABLE boleto (
    id_boleto INT AUTO_INCREMENT PRIMARY KEY,
    numero_serie CHAR(8) UNIQUE NULL,
    numero_control VARCHAR(50) UNIQUE NULL,
    precio_original DECIMAL(10, 2) NOT NULL,
    precio_reventa DECIMAL(10, 2),
    fecha_limite_venta DATETIME NULL,
    en_venta BOOLEAN DEFAULT TRUE NOT NULL,
    id_usuario INT NULL,
    id_evento INT NOT NULL,
    id_asiento INT NOT NULL,
    adquirido_boletera TINYINT(1) NULL,
    FOREIGN KEY (id_usuario) REFERENCES usuario(id_usuario),
    FOREIGN KEY (id_evento) REFERENCES evento(id_evento),
    FOREIGN KEY (id_asiento) REFERENCES asiento(id_asiento)
);

-- Tabla de Transacciones
CREATE TABLE transaccion (
    id_transaccion INT AUTO_INCREMENT PRIMARY KEY,
    id_comprador INT NOT NULL,
    id_vendedor INT NULL,
		id_boleto INT NOT NULL,
    monto DECIMAL(10, 2) NULL,
		fecha_hora TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    fecha_apartado DATETIME NULL,
    estado ENUM('terminada', 'en espera') NOT NULL,
    tipo ENUM('boletera', 'reventa') NOT NULL,
    FOREIGN KEY (id_comprador) REFERENCES usuario(id_usuario),
    FOREIGN KEY (id_vendedor) REFERENCES usuario(id_usuario),
		FOREIGN KEY (id_boleto) REFERENCES boleto(id_boleto)
);

