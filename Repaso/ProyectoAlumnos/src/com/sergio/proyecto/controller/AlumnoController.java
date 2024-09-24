package com.sergio.proyecto.controller;

import java.sql.SQLException;
import java.util.List;

import com.sergio.proyecto.dtos.Alumno;
import com.sergio.proyecto.model.AlumnoModel;

public class AlumnoController {

	public Integer insertarAlumno(String nombre, String apellido, String dni, String sexo, Integer edad) throws ClassNotFoundException, SQLException {
		
		return new AlumnoModel().insertarAlumno(nombre, apellido, dni, sexo, edad);
		
	}
	
	public List<Alumno> consultarAlumnos(String nombre, String apellido, String dni, String sexo, Integer edad) throws ClassNotFoundException, SQLException{
		
		
		return new AlumnoModel().consultarAlumnos(nombre, apellido, dni, sexo, edad);
	}
	
	public Integer actualizarAlumno(String nombre, String apellido, String dni, String sexo, Integer edad) throws ClassNotFoundException, SQLException {
	
		return new AlumnoModel().actualizarAlumno(nombre, apellido, dni, sexo, edad, edad);
	}
	
	public Integer borrarAlumno(Integer id) throws ClassNotFoundException, SQLException {
		return new AlumnoModel().borrarAlumno(id);
	}
}
