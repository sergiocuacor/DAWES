package com.sergiocuacor.proyectoUno.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.sergiocuacor.proyectoUno.entities.Student;

@RestController
@RequestMapping("/students")
public class StudentController {

	private List<Student> studentList; // PROPIEDAD

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
	public List<Student> add() {
		studentList.add(new Student("Joe Rogan", "83349859M", 58));
		return studentList;
	}

	@PostMapping("/addManually")
	public ResponseEntity<?> add1(@RequestBody Student student) {
		for(Student s : studentList) {
			if(student.getDni().equalsIgnoreCase(s.getDni())) {
				return ResponseEntity.status(HttpStatus.CONFLICT).body("ERROR: This student is already in the list.");
			}
		}
		studentList.add(student);
		return ResponseEntity.ok(student);
	}
	
	
	/* SI AL AÑADIR UN STUDENT YA EXISTE (POR DNI POR EJEMPLO), DEVOLVEMOS UN ERROR*/

	public List<Student> modifyStudent(@RequestBody Student student){
		return null;
	}
	
	@DeleteMapping("/remove/{name}")
	public List<Student> removeByName(@PathVariable String name) {
		boolean removed = studentList.removeIf(student -> student.getName().equals(name));
		if(removed) {
			return studentList;
		} else {
			throw new Error();
		}
	}
	

}
