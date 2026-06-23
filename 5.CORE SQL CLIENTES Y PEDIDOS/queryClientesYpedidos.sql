

-- 2. INSERCIÓN DE DATOS DE PRUEBA
-- Insertar  cinco nuevos clientes en la tabla «clientes»
INSERT INTO clientes (nombre, direccion, telefono) VALUES
('Ana Gómez', 'Av. Apoquindo 1200, Las Condes', '+56987654321'),
('Carlos Plaza', 'Gran Avenida 4500, San Miguel', '+56922222222'),
('María José', 'Providencia 340, Providencia', '+56933333333'),
('Juan Pedro', 'Alameda 850, Santiago', '+56944444444'),
('Lucía Fernández', 'Pajaritos 2100, Maipú', '+56955555555');

-- Inserta diez nuevos pedidos en la tabla «pedidos», Ana tiene 3 pedidos, Carlos tiene 2 pedidos, María tiene 4 pedidos,Juan tiene 1 pedidos, Lucía se queda con 0 pedidos

INSERT INTO pedidos (clientes_id_clientes, fecha, total) VALUES
(1, '2026-06-01', 25),
(1, '2026-06-05', 15),
(1, '2026-06-10', 42), 
(2, '2026-06-02', 12),
(2, '2026-06-12', 31), 
(3, '2026-06-03', 55),
(3, '2026-06-07', 85),
(3, '2026-06-15', 19),
(3, '2026-06-20', 12), 
(4, '2026-06-04', 63);  

-- Proyecta todos los clientes de la tabla «clientes» y sus respectivos pedidos.
SELECT * FROM clientes INNER JOIN pedidos ON pedidos.clientes_id_clientes = clientes.id_clientes;

-- Proyecta todos los pedidos realizados por un cliente específico, utilizando su ID.

SELECT * FROM clientes INNER JOIN pedidos ON pedidos.clientes_id_clientes = clientes.id_clientes
WHERE id_clientes = 1;

-- Calcula el total de todos los pedidos para cada cliente.
SELECT clientes_id_clientes, sum(total)
FROM pedidos
group by clientes_id_clientes;

SELECT * FROM pedidos;

-- Elimina un cliente específico de la tabla «clientes» y todos sus pedidos asociados de la tabla «pedidos».
-- Paso 1: Eliminar primero todos los pedidos asociados al cliente
DELETE FROM pedidos 
WHERE clientes_id_clientes = 2;

SELECT * FROM pedidos;
SELECT * FROM clientes;

-- Paso 2: Ahora que el cliente no tiene pedidos , se elimina
DELETE FROM clientes 
WHERE id_clientes = 2;

SELECT * FROM clientes;

-- Proyecta los tres clientes que han realizado más pedidos, ordenados de forma descendente por el número de pedidos.
SELECT 
    c.id_clientes AS id_cliente,
    c.nombre AS cliente,
    sum(p.total) AS numero_pedidos
FROM clientes c
INNER JOIN pedidos p ON c.id_clientes = p.clientes_id_clientes
GROUP BY c.id_clientes, c.nombre
ORDER BY numero_pedidos DESC;