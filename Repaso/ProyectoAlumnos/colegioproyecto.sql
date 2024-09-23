DROP DATABASE IF EXISTS colegioproyecto;

create database colegioproyecto;

use colegioproyecto;


CREATE TABLE alumnos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    apellido VARCHAR(50) NOT NULL,
    dni VARCHAR(20) UNIQUE NOT NULL,
    sexo ENUM('M', 'F') NOT NULL,
    edad INT
);

CREATE TABLE asignaturas (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    descripcion VARCHAR(100),
    numero_horas INT NOT NULL,
    nombre_profesor VARCHAR(100) NOT NULL
);

CREATE TABLE alumno_asignatura (
    alumno_id INT,
    asignatura_id INT,
    PRIMARY KEY (alumno_id, asignatura_id),
    FOREIGN KEY (alumno_id) REFERENCES alumnos(id),
    FOREIGN KEY (asignatura_id) REFERENCES asignaturas(id)
);
