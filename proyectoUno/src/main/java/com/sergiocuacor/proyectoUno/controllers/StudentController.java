package com.sergiocuacor.proyectoUno.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sergiocuacor.proyectoUno.entities.Student;

@RestController
@RequestMapping("/students")
public class StudentController {

	
	private List<Student> studentList; //PROPIEDAD

	public StudentController() {
		super();
		this.studentList = new ArrayList<Student>();
		studentList.add(new Student("kARLine", "8549853J", 65));
	}

	@GetMapping("/list")
	public List<Student> getListaAlumnos() {
		return studentList;
	}
	
	@PostMapping("/add")
	public List<Student> add(){
		studentList.add(new Student("Joe Rogan", "83349859M", 58));
		return studentList;
	}

	public List<Student> remove(){
		
		
		
		return studentList;
	}
	
}
