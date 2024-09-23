create database colegioproyecto;
use colegioproyecto;

create table alumno(
id int auto_increment PRIMARY KEY,
edad int,
dni varchar(15),
sexo enum('H','M')
);

create table asignatura(
id int auto_increment PRIMARY KEY,
descripcion varchar(50),
numHoras int,
profesor varchar(20)
);

create table alumno_asignatura(

);
