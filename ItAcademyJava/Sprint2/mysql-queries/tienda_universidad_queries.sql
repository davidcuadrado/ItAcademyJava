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


SELECT DISTINCT p.apellido1, p.apellido2, nombre FROM persona p INNER JOIN alumno_se_matricula_asignatura ON p.id = alumno_se_matricula_asignatura.id_alumno ORDER BY p.apellido1 ASC, p.apellido2 ASC, p.nombre ASC;
SELECT DISTINCT p.apellido1, p.apellido2, nombre, telefono FROM persona p LEFT JOIN alumno_se_matricula_asignatura asma ON p.id = asma.id_alumno HAVING telefono IS NULL;
SELECT p.apellido1, p.apellido2, nombre FROM persona p INNER JOIN alumno_se_matricula_asignatura asma ON p.id = asma.id_alumno WHERE fecha_nacimiento >= 1999-01-01 AND fecha_nacimiento <= 1999-12-31;
SELECT DISTINCT p.apellido1, p.apellido2, nombre, telefono FROM persona p LEFT JOIN alumno_se_matricula_asignatura asma ON p.id = asma.id_alumno WHERE p.nif = '%K' HAVING telefono IS NULL ;
SELECT a.* FROM asignatura a LEFT JOIN grado g ON a.id_grado = g.id WHERE a.cuatrimestre = 3 AND a.curso = 3 AND g.id = 7;
SELECT p.apellido1, p.apellido2, p.nombre, d.nombre FROM persona p LEFT JOIN profesor ON p.id = profesor.id_profesor LEFT JOIN departamento d ON profesor.id_departamento = d.id ORDER BY p.apellido1 ASC, p.apellido2 ASC, p.nombre ASC;
SELECT p.nif, asignatura.nombre, curso_escolar.anyo_inicio, curso_escolar.anyo_fin FROM persona p LEFT JOIN alumno_se_matricula_asignatura ON p.id = alumno_se_matricula_asignatura.id_alumno LEFT JOIN asignatura ON alumno_se_matricula_asignatura.id_asignatura = asignatura.id LEFT JOIN curso_escolar ON asignatura.id = curso_escolar.id WHERE nif = "26902806M";
SELECT DISTINCT d.nombre FROM grado g LEFT JOIN asignatura a ON a.id_grado = g.id LEFT JOIN profesor p ON p.id_profesor = a.id_profesor LEFT JOIN departamento d ON d.id = p.id_departamento WHERE g.nombre = "Grado en Ingeniería Informática (Plan 2015)" AND d.nombre IS NOT NULL;
SELECT DISTINCT p.nif FROM persona p LEFT JOIN alumno_se_matricula_asignatura asma ON p.id = asma.id_alumno LEFT JOIN asignatura a ON a.id = asma.id_asignatura LEFT JOIN curso_escolar ce ON ce.id = asma.id_curso_escolar WHERE ce.anyo_inicio = 2018 AND ce.anyo_fin = 2019;


SELECT d.nombre AS departamento, p.apellido1, p.apellido2, p.nombre FROM persona p LEFT JOIN profesor prof ON p.id = prof.id_profesor LEFT JOIN departamento d ON prof.id_departamento = d.id ORDER BY d.nombre ASC, p.apellido1 ASC, p.apellido2 ASC, p.nombre ASC;
SELECT d.nombre AS departamento, p.apellido1, p.apellido2, p.nombre FROM persona p LEFT JOIN profesor prof ON p.id = prof.id_profesor LEFT JOIN departamento d ON prof.id_departamento = d.id WHERE d.nombre IS NULL ORDER BY p.apellido1 ASC, p.apellido2 ASC, p.nombre ASC;
SELECT d.nombre AS departamento_sin_profesor, prof.id_profesor FROM departamento d LEFT JOIN profesor prof ON d.id = prof.id_departamento HAVING prof.id_profesor IS NULL;
SELECT prof.id_profesor AS profesor_no_imparte, a.id AS asignatura FROM profesor prof LEFT JOIN asignatura a ON prof.id_profesor = a.id_profesor HAVING asignatura IS NULL;
SELECT a.id AS asignatura_no_prof, prof.id_profesor FROM asignatura a LEFT JOIN profesor prof ON a.id_profesor = prof.id_profesor HAVING prof.id_profesor IS NULL;
SELECT DISTINCT d.nombre AS nunca_impartieron, a.curso AS asignatura_curso FROM departamento d LEFT JOIN profesor prof ON d.id = prof.id_departamento LEFT JOIN asignatura a ON a.id_profesor = prof.id_profesor HAVING asignatura_curso IS NULL;


SELECT COUNT(DISTINCT asma.id_alumno) AS cantidad_alumnos FROM alumno_se_matricula_asignatura asma;
SELECT COUNT(DISTINCT asma.id_alumno) AS alumnes_1999 FROM alumno_se_matricula_asignatura asma LEFT JOIN persona p ON asma.id_alumno = p.id WHERE p.fecha_nacimiento >= 1999-01-01 AND p.fecha_nacimiento <= 1999-12-31;
SELECT DISTINCT d.nombre, COUNT(p.id_profesor) AS numero_profesores FROM departamento d LEFT JOIN profesor p ON d.id = p.id_departamento GROUP BY d.nombre HAVING numero_profesores > 0 ORDER BY numero_profesores DESC;
SELECT DISTINCT d.nombre, COUNT(p.id_profesor) AS numero_profesores FROM departamento d LEFT JOIN profesor p ON d.id = p.id_departamento GROUP BY d.nombre; 
SELECT DISTINCT g.nombre, COUNT(a.id) AS numero_asignaturas FROM grado g LEFT JOIN asignatura a ON g.id = a.id_grado GROUP BY g.nombre ORDER BY `numero_asignaturas` DESC;
SELECT DISTINCT g.nombre, COUNT(a.id) AS numero_asignaturas FROM grado g LEFT JOIN asignatura a ON g.id = a.id_grado GROUP BY g.nombre HAVING numero_asignaturas > 40 ORDER BY `numero_asignaturas` DESC;
SELECT g.nombre, a.tipo, COUNT(a.creditos) AS suma_creditos FROM grado g LEFT JOIN asignatura a ON g.id = a.id_grado GROUP BY a.tipo, g.nombre;
SELECT ce.anyo_inicio, COUNT(asma.id_alumno) AS suma_alumnos FROM curso_escolar ce LEFT JOIN alumno_se_matricula_asignatura asma ON ce.id = asma.id_curso_escolar GROUP BY ce.anyo_inicio;
SELECT prof.id_profesor, p.nombre, p.apellido1, p.apellido2, COUNT(a.id) AS suma_asignaturas FROM profesor prof LEFT JOIN persona p ON prof.id_profesor = p.id LEFT JOIN asignatura a ON prof.id_profesor = a.id_profesor GROUP BY prof.id_profesor ORDER BY suma_asignaturas DESC;
SELECT p.* FROM persona p INNER JOIN alumno_se_matricula_asignatura asma ON p.id = asma.id_alumno  ORDER BY p.fecha_nacimiento DESC limit 1;
SELECT prof.id_profesor, d.nombre AS nombre_departamento, a.nombre AS nombre_asignatura FROM profesor prof LEFT JOIN departamento d ON prof.id_departamento = d.id LEFT JOIN asignatura a ON prof.id_profesor = a.id_profesor WHERE a.nombre IS NULL and d.id IS NOT NULL;
