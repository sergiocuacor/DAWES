package com.sergio.proyecto.controller;

import java.sql.SQLException;

import com.sergio.proyecto.model.AsignaturaModel;

public class AsignaturaController {

	public Integer insertarAsignatura(String nombre, String descripcion, Integer numeroHoras, String nombreProfesor) throws ClassNotFoundException, SQLException {
		return new AsignaturaModel().insertarAsignatura(nombre, descripcion, numeroHoras, nombreProfesor);
	}
	
}
