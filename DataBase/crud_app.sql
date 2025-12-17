-- =========================
-- CREACIÓN DE BASE DE DATOS
-- =========================
DROP DATABASE IF EXISTS crud_app;
CREATE DATABASE crud_app;
USE crud_app;

-- =========================
-- CREACIÓN DE TABLA
-- =========================
CREATE TABLE products (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(150) NOT NULL,
    description VARCHAR(500),
    price DECIMAL(18,2) NOT NULL,
    stock INT NOT NULL
);

-- =========================
-- INSERCIÓN DE PRODUCTOS
-- =========================
INSERT INTO products (name, description, price, stock) VALUES
('Vaso', 'Vaso de vidrio transparente', 10000, 100),
('Plato', 'Plato de cerámica blanca', 100000, 45),
('Cuchara', 'Cuchara de acero inoxidable', 5000, 200),
('Tenedor', 'Tenedor de acero inoxidable', 5000, 180),
('Cuchillo', 'Cuchillo de cocina', 15000, 90),
('Sartén', 'Sartén antiadherente 24cm', 80000, 30),
('Olla', 'Olla de aluminio 5 litros', 120000, 25),
('Taza', 'Taza para café', 12000, 150),
('Botella', 'Botella térmica 1L', 45000, 60),
('Tabla de cortar', 'Tabla de madera', 35000, 40),
('Licuadora', 'Licuadora 600W', 250000, 15),
('Horno eléctrico', 'Horno eléctrico pequeño', 450000, 8),
('Cafetera', 'Cafetera eléctrica', 180000, 20),
('Microondas', 'Microondas digital', 520000, 10),
('Nevera', 'Nevera 300 litros', 1500000, 5),
('Extractor', 'Extractor de jugos', 210000, 18),
('Batidora', 'Batidora manual', 90000, 35),
('Olla a presión', 'Olla a presión 6L', 230000, 12),
('Sanduchera', 'Sanduchera eléctrica', 110000, 22),
('Freidora de aire', 'Freidora de aire 4L', 380000, 14);

-- =========================
-- CONSULTA DE VERIFICACIÓN
-- =========================
SELECT * FROM products;