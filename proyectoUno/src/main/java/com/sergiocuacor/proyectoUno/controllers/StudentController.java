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
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.sergiocuacor.proyectoUno.entities.Student;

@RestController
@RequestMapping("/students")
public class StudentController {

	private List<Student> studentList; // PROPIEDAD

	public StudentController() {
		super();
		this.studentList = new ArrayList<Student>();
		studentList.add(new Student(1, "kARLine", "8549853J", 65));
	}

	@GetMapping("/list")
	public List<Student> getListaAlumnos() {
		return studentList;
	}

	@GetMapping("/list/{id}")
	public ResponseEntity<?> getStudent(@PathVariable Integer id) {
		for (Student s : studentList) {
			if (s.getId().equals(id)) {
				return ResponseEntity.ok(s);
			}
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("El alumno con ID "+id+" no existe");
	}

	@PostMapping("/add")
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
	
	public ResponseEntity<?> update(@RequestBody Student studentUpdate){
		Student studentAux = null;
		
		try {
			
			for(Student student : studentList) {
				if(studentUpdate.getDni().equals(student.getName())) {
					studentAux = student;
				}
			}
		
			if(studentAux != null) {
				studentAux.setName(studentUpdate.getName());
				studentAux.setAge(studentUpdate.getAge());
				
				return ResponseEntity.ok(studentAux);
			}else {
				return ResponseEntity.badRequest().body("User not found");
			}
		} catch(Exception ex) {
			return ResponseEntity.internalServerError().body("An error occured while trying to update");
		}
		
	}
	

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteById(@PathVariable Integer id) {

		boolean removed = false;

		Iterator<Student> iterator = studentList.iterator();

		while (iterator.hasNext()) {
			Student student = iterator.next();
			if (student.getId().equals(id)) {
				iterator.remove();
				removed = true;
			}

		}
		if (removed) {
			return ResponseEntity.status(HttpStatus.OK).body("Student removed");
		} else {
			return ResponseEntity.status(HttpStatus.NOT_MODIFIED).body("Error: no student was removed");
		}
	}

	@DeleteMapping("/delete2/{id}") // Alternativa al delete
	public List<Student> deleteById2(@PathVariable Integer id) {

		boolean removed = studentList.removeIf(student -> student.getId().equals(id));
		if (removed) {
			return studentList;
		} else {
			throw new Error();
		}
	}

	@DeleteMapping("/delete3")
	public ResponseEntity<?> deleteById3(@RequestBody Student studentDelete) {
		Student studentAux = null;

		try {
			for (Student student : studentList) {
				if (studentDelete.getDni().equals(student.getDni())) {
					studentAux = student;
				}
			}
			
			if (studentAux != null) {
				studentList.remove(studentAux);
				return ResponseEntity.ok(studentList);
			} else {
				return ResponseEntity.badRequest().body("Student not found");
			}
			
		} catch (Exception ex) {
			return ResponseEntity.internalServerError().body("ERROR processing the elimination process.");
		}

	}
}
