package com.sergiocuacor.proyectoUno.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sergiocuacor.proyectoUno.entities.Student;

@RestController
public class MainRestControllers {

	private List<Student> listStudents ; // PROPIEDAD

	@GetMapping("/hello")
	public String helloWorld() {
		return "Hello world";
	}

	@GetMapping("/alumnos")
	public List<Student> getListaAlumnos() {

		listStudents.add(new Student("Carlitos", "85694896M", 12));
		listStudents.add(new Student("Manfredo", "8938593P", 67));
		listStudents.add(new Student("Paco", "El del bar", 53));

		return listStudents;
	}

	public MainRestControllers() {
		super();
		this.listStudents = new ArrayList<Student>();
	}

	
	
	
	

}
