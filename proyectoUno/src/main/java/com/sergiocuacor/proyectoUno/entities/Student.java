package com.sergiocuacor.proyectoUno.entities;


public class Student {

	private Integer id;
	private String name;
	private String dni;
	private Integer age;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	public Student(Integer id, String name, String dni, Integer age) {
		super();
		this.id = id;
		this.name = name;
		this.dni = dni;
		this.age = age;
	}
	
	
}
