
-- Inserta al menos cinco nuevos estudiantes
INSERT INTO estudiantes (nombre_estudiante, edad) VALUES
('Pedro Jimenez', 25),
('Vilma Hernandez', 22),
('Pablo Guzman', 26),
('Betty Kroll', 23),
('Barbara Marquez', 19);

-- Inserta al menos cuatro nuevos cursos

INSERT INTO cursos (nombre_cursos, duracion) VALUES
('Fundamentos de Fruticultura', '40 horas'),
('Entomología', '30 horas'),
('Reciclaje', '25 horas'),
('Floricultura', '60 horas');

-- Asociar a cuatro de los estudiantes a al menos dos cursos dados de alta

INSERT INTO inscripciones (estudiantes_id, cursos_id) VALUES
(1, 1), (1, 2), -- Pedro se inscribe en fund fruti y ento
(2, 1), (2, 3), -- Vilma se inscribe en fundfruti y reciclaje
(3, 2), (3, 4), -- Pablo se inscribe en entomologia y floricultura
(4, 3), (4, 4); -- Betty se inscribe en reciclaje y floricultura


-- Proyecta a todos los estudiantes y sus respectivos cursos.
SELECT 
    e.nombre_estudiante AS estudiante,
    c.nombre_cursos AS curso
FROM estudiantes e
INNER JOIN inscripciones i ON e.id = i.estudiantes_id
INNER JOIN cursos c ON i.cursos_id = c.id;

-- Proyecta todos los estudiantes que están inscritos en un curso específico, utilizando el nombre del curso como criterio de búsqueda.
SELECT 
    e.nombre_estudiante AS estudiante,
    c.nombre_cursos AS curso
FROM estudiantes e
INNER JOIN inscripciones i ON e.id = i.estudiantes_id
INNER JOIN cursos c ON i.cursos_id = c.id
WHERE c.nombre_cursos = 'Reciclaje';

-- Proyecta todos los cursos en los que está inscrito un estudiante específico, utilizando su nombre como criterio de búsqueda.
SELECT 
    c.nombre_cursos AS curso,
    e.nombre_estudiante AS estudiante
FROM cursos c
INNER JOIN inscripciones i ON c.id = i.cursos_id
INNER JOIN estudiantes e ON i.estudiantes_id = e.id
WHERE e.nombre_estudiante = 'Pedro Jimenez';

-- Cuenta el número de estudiantes inscritos en cada curso y muestra el nombre del curso junto con el número de estudiantes inscritos.

SELECT 
    c.nombre_cursos AS curso,
    COUNT(i.estudiantes_id) AS total_estudiantes
FROM cursos c
LEFT JOIN inscripciones i ON c.id = i.cursos_id
GROUP BY c.id, c.nombre_cursos;

-- Encuentra los estudiantes que no están inscritos en ningún curso.
SELECT 
    e.id AS estudiante_id,
    e.nombre_estudiante AS estudiante,
    e.edad
FROM estudiantes e
LEFT JOIN inscripciones i ON e.id = i.estudiantes_id
WHERE i.cursos_id IS NULL;