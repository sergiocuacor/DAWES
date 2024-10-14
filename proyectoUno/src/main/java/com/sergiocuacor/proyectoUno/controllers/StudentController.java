package com.sergiocuacor.proyectoUno.controllers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
		studentList.add(new Student(1,"kARLine", "8549853J", 65));
	}

	@GetMapping("/list")
	public List<Student> getListaAlumnos() {
		return studentList;
	}

	@PostMapping("/add")
	public List<Student> add() {
		studentList.add(new Student(2,"Joe Rogan", "83349859M", 58));
		return studentList;
	}

	@PostMapping("/addManually")
	public ResponseEntity<?> add1(@RequestBody Student student) {
		for (Student s : studentList) {
			if (student.getDni().equalsIgnoreCase(s.getDni())) {
				return ResponseEntity.status(HttpStatus.CONFLICT).body("ERROR: This student is already in the list.");
			}
		}
		studentList.add(student);
		return ResponseEntity.ok(student);
	}

	@PostMapping("/addManually1")
	public ResponseEntity<?> add2(@RequestBody Student student) {
		for (Student s : studentList) {
			if (student.getDni().equalsIgnoreCase(s.getDni())) {
				return ResponseEntity.status(HttpStatus.CONFLICT).body("ERROR: This student is already in the list.");
			}
		}
		studentList.add(student);
		return ResponseEntity.status(HttpStatus.CREATED).body("Success: new student added to the list.");
	}
	/*
	 * SI AL AÑADIR UN STUDENT YA EXISTE (POR DNI POR EJEMPLO), DEVOLVEMOS UN ERROR
	 */

	@PutMapping("/update/{id}")
	public List<Student> modifyStudent(@RequestBody Student updatedStudent, @PathVariable Integer id) {
		for (Student student : studentList) {
			if (student.getId().equals(id)) {
				student.setName(updatedStudent.getName());
				student.setAge(updatedStudent.getAge());
			}
		}

		return studentList;

	}

	
	@DeleteMapping("/remove/{id}")
	public ResponseEntity<?> removeById(@PathVariable Integer id) {
		
		boolean removed = false;
		
		Iterator<Student> iterator = studentList.iterator();
		
		while(iterator.hasNext()) {
			Student student = iterator.next();
			if(student.getId().equals(id)) {
				iterator.remove();
				removed = true;
			}
			
		}
		if(removed) {
			return ResponseEntity.status(HttpStatus.OK).body("Student removed");
		} else {
			return ResponseEntity.status(HttpStatus.NOT_MODIFIED).body("Error: no student was removed");
		}
	}
	
	@DeleteMapping("/remove2/{id}")
	public List<Student> removeById2(@PathVariable Integer id) {
		boolean removed = studentList.removeIf(student -> student.getId().equals(id));
		if (removed) {
			return studentList;
		} else {
			throw new Error();
		}
	}

	
}
