package com.sergiocuacor.proyectoUno.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sergiocuacor.proyectoUno.entities.Student;

@RestController
@RequestMapping("/alumnos")
public class StudentController {

	
	private List<Student> studentList; //PROPIEDAD

	public StudentController() {
		super();
		this.studentList = new ArrayList<Student>();
		studentList.add(new Student("Carlitos", "85694896M", 12));
		
	}

	@GetMapping("/list")
	public List<Student> getListaAlumnos() {

		return studentList;
	}
	
	@PostMapping("/add")
	public List<Student> add(){
		studentList.add(new Student(null, null, null));
		return studentList;
	}

	
	
}
