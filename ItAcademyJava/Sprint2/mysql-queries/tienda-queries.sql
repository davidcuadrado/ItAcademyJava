USE tienda;
SELECT nombre FROM producto;
SELECT nombre, precio FROM producto;
SELECT * FROM producto;
SELECT nombre, precio AS precio_€, precio*1.08 AS precio_$ FROM producto;
SELECT nombre AS nom_de_producto, precio AS euros, precio*1.08 AS dolars FROM producto;
SELECT UPPER(nombre), precio FROM producto;
SELECT LOWER(nombre), precio FROM producto;
SELECT nombre, SUBSTRING(UPPER(nombre), 1, 2) FROM fabricante;
SELECT nombre, ROUND(precio, 1) FROM producto;
SELECT nombre, TRUNCATE(precio, 0) FROM producto;
SELECT codigo_fabricante FROM producto;
SELECT DISTINCT codigo_fabricante FROM producto;
SELECT nombre FROM fabricante ORDER BY nombre;
SELECT nombre FROM fabricante ORDER BY nombre DESC;
SELECT nombre AS nombre_asc, precio FROM producto p ORDER BY nombre ASC, precio DESC;
SELECT * FROM fabricante LIMIT 5;
SELECT * FROM fabricante LIMIT 2 offset 3;
SELECT nombre, precio FROM producto ORDER BY precio ASC LIMIT 1;
SELECT nombre, precio FROM producto ORDER BY precio DESC LIMIT 1;
SELECT nombre FROM producto WHERE codigo_fabricante = 2;
SELECT p.nombre AS nombre_producto, p.precio, f.nombre AS nombre_fabricante FROM producto p LEFT JOIN fabricante f ON p.codigo_fabricante = f.codigo;
SELECT p.nombre AS nombre_producto, p.precio, f.nombre AS nombre_fabricante FROM producto p LEFT JOIN fabricante f ON p.codigo_fabricante = f.codigo ORDER BY f.nombre;
SELECT p.codigo AS codigo_producto, p.nombre AS nombre_producto, f.codigo AS codigo_fabricante, f.nombre AS nombre_fabricante FROM producto p LEFT JOIN fabricante f ON p.codigo_fabricante = f.codigo;
SELECT p.nombre AS producto_nombre, p.precio, f.nombre AS fabricante_nombre FROM producto p LEFT JOIN fabricante f ON p.codigo_fabricante = f.codigo ORDER BY p.precio ASC LIMIT 1;
SELECT p.nombre AS producto_nombre, p.precio, f.nombre AS fabricante_nombre FROM producto p LEFT JOIN fabricante f ON p.codigo_fabricante = f.codigo ORDER BY p.precio DESC LIMIT 1;
SELECT f.nombre AS fabricante, p.* FROM fabricante f LEFT JOIN producto p ON f.codigo = p.codigo_fabricante WHERE f.nombre = 'Lenovo';
SELECT f.nombre AS fabricante, p.* FROM fabricante f LEFT JOIN producto p ON f.codigo = p.codigo_fabricante WHERE f.nombre = 'Crucial' AND precio > 200;
SELECT f.nombre AS fabricante, p.* FROM fabricante f LEFT JOIN producto p ON f.codigo = p.codigo_fabricante WHERE f.nombre = 'Lenovo' OR f.nombre = 'Hewlett-packard' OR f.nombre = 'Seagate';
SELECT f.nombre AS fabricante, p.* FROM fabricante f LEFT JOIN producto p ON f.codigo = p.codigo_fabricante WHERE f.nombre IN ('Asus', 'Hewlett-Packard', 'Seagate');
SELECT p.nombre, p.precio FROM producto p LEFT JOIN fabricante f ON f.codigo = p.codigo_fabricante WHERE f.nombre LIKE '%e';
SELECT p.nombre, p.precio FROM producto p LEFT JOIN fabricante f ON f.codigo = p.codigo_fabricante WHERE f.nombre LIKE '%w%';
SELECT p.nombre, p.precio, f.nombre AS fabricante FROM producto p LEFT JOIN fabricante f ON f.codigo = p.codigo_fabricante WHERE precio > 180 ORDER BY precio DESC, nombre ASC;
SELECT DISTINCT fabricante.codigo, fabricante.nombre FROM producto INNER JOIN fabricante ON fabricante.codigo = producto.codigo_fabricante;
SELECT fabricante.*, producto.* FROM fabricante LEFT JOIN producto ON fabricante.codigo = producto.codigo_fabricante;
SELECT fabricante.* FROM fabricante LEFT JOIN producto ON fabricante.codigo = producto.codigo_fabricante WHERE producto.codigo_fabricante IS NULL;
SELECT f.nombre AS fabricante, p.* FROM fabricante f LEFT JOIN producto p ON f.codigo = p.codigo_fabricante WHERE f.nombre = 'Lenovo';
SELECT p.* FROM producto p LEFT JOIN fabricante f ON p.codigo_fabricante = f.codigo WHERE p.precio = (SELECT p.precio FROM producto p LEFT JOIN fabricante f ON f.codigo = p.codigo_fabricante WHERE f.nombre = 'Lenovo' ORDER BY precio DESC LIMIT 1 );
SELECT f.nombre AS fabricante, p.nombre FROM producto p LEFT JOIN fabricante f ON f.codigo = p.codigo_fabricante WHERE f.nombre = 'Lenovo' ORDER BY p.precio DESC LIMIT 1;
SELECT f.nombre AS fabricante, p.nombre FROM producto p LEFT JOIN fabricante f ON f.codigo = p.codigo_fabricante WHERE f.nombre = 'Hewlett-Packard' ORDER BY p.precio ASC LIMIT 1;
SELECT p.nombre, p.precio FROM producto p LEFT JOIN fabricante f ON p.codigo_fabricante = f.codigo WHERE p.precio >= (SELECT p.precio FROM producto p LEFT JOIN fabricante f ON f.codigo = p.codigo_fabricante WHERE f.nombre = 'Lenovo' ORDER BY p.precio DESC LIMIT 1);
SELECT f.nombre AS fabricante, p.nombre FROM producto p LEFT JOIN fabricante f ON p.codigo_fabricante = f.codigo WHERE p.precio > (SELECT AVG(pr.precio) FROM producto pr INNER JOIN fabricante fr ON pr.codigo_fabricante = fr.codigo WHERE fr.nombre = 'Asus');
