package com.sergiocuacor.proyectoUno.entities;


public class Student {

	private String name;
	private String dni;
	private Integer age;
	
	
	
	public Student(String name, String dni, Integer age) {
		super();
		this.name = name;
		this.dni = dni;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}

	

}
