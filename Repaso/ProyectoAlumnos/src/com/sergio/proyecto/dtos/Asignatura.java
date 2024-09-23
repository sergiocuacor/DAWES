package com.sergio.proyecto.dtos;

public class Asignatura {

	private String nombreAsignatura;
	private String descripcion;
	private Integer numHoras;
	private String nombreProfesor;
	
	
	
	public Asignatura(String nombreAsignatura, String descripcion, Integer numHoras, String nombreProfesor) {
		super();
		this.nombreAsignatura = nombreAsignatura;
		this.descripcion = descripcion;
		this.numHoras = numHoras;
		this.nombreProfesor = nombreProfesor;
	}
	public String getNombreAsignatura() {
		return nombreAsignatura;
	}
	public void setNombreAsignatura(String nombreAsignatura) {
		this.nombreAsignatura = nombreAsignatura;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Integer getNumHoras() {
		return numHoras;
	}
	public void setNumHoras(Integer numHoras) {
		this.numHoras = numHoras;
	}
	public String getNombreProfesor() {
		return nombreProfesor;
	}
	public void setNombreProfesor(String nombreProfesor) {
		this.nombreProfesor = nombreProfesor;
	}
	@Override
	public String toString() {
		return "Asignatura [nombreAsignatura=" + nombreAsignatura + ", descripcion=" + descripcion + ", numHoras="
				+ numHoras + ", nombreProfesor=" + nombreProfesor + "]";
	}
	
	
	
	
	
}
