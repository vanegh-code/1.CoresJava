CREATE DATABASE IF NOT EXISTS canciones_db;
USE canciones_db;

CREATE TABLE IF NOT EXISTS canciones (
    id INT AUTO_INCREMENT PRIMARY KEY,
    album VARCHAR(255),
    artista VARCHAR(255),
    fecha_actualizacion DATE,
    fecha_creacion DATE,
    genero VARCHAR(100),
    idioma VARCHAR(100),
    titulo VARCHAR(255)
);

SELECT * FROM canciones_db.canciones;

INSERT INTO canciones (id, album, artista, fecha_actualizacion, fecha_creacion, genero, idioma, titulo) VALUES
(1, 'Mr Simple', 'Super Junior', '2025-11-27', '2025-11-27', 'Kpop', 'coreano', 'Mr. Simple'),
(2, 'Loveshot', 'EXO', '2025-11-27', '2025-11-27', 'kpop', 'coreano', 'Love shot'),
(3, 'ATE', 'Stray Kids', '2026-06-22', '2026-06-22', 'kpop', 'coreano', 'Chk Chk Boom'),
(4, 'ATE', 'Stray Kids', '2026-06-22', '2026-06-22', 'kpop', 'coreano', 'Chk Chk Boom');

SELECT * FROM canciones_db.canciones;