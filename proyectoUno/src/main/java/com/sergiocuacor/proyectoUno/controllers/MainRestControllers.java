package com.sergiocuacor.proyectoUno.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sergiocuacor.proyectoUno.entities.Student;

@RestController
public class MainRestControllers {

	
	@GetMapping("/hello")
	public String helloWorld() {
		return "Hello world";
	}

	

	
	

	
	
	
	

}
