package com.sergio.proyecto.controller;

import java.sql.SQLException;
import java.util.List;

import com.sergio.proyecto.dtos.Asignatura;
import com.sergio.proyecto.model.AsignaturaModel;

public class AsignaturaController {

	public List<Asignatura> consultarAsignaturas(String nombre, String descripcion, Integer numeroHoras, String nombreProfesor) throws ClassNotFoundException, SQLException{
		
		return new AsignaturaModel().consultarAsignaturas(nombre, descripcion, descripcion, nombreProfesor);
	}
	
	public Integer insertarAsignatura(String nombre, String descripcion, Integer numeroHoras, String nombreProfesor) throws ClassNotFoundException, SQLException {
		return new AsignaturaModel().insertarAsignatura(nombre, descripcion, numeroHoras, nombreProfesor);
	}
	
	public Integer actualizarAsignatura(String nombre, String descripcion, Integer numeroHoras, String nombreProfesor, Integer id) throws ClassNotFoundException, SQLException {
		return new AsignaturaModel().actualizarAsignatura(nombre, descripcion, descripcion, nombreProfesor, numeroHoras);
	}
	
	public Integer borrarAsignatura(Integer id) throws ClassNotFoundException, SQLException {
		return new AsignaturaModel().borrarAsignatura(id);
	}
	
}
