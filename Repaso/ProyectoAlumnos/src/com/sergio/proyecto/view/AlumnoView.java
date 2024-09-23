package com.sergio.proyecto.view;
import java.util.Scanner;

public class AlumnoView {

	public void insertarAlumno() {
		Scanner sc = new Scanner(System.in);
		System.out.println("*** INSERTAR ALUMNO ***");
		System.out.println("Nombre:");	
		String nombre = sc.nextLine();
		
		System.out.println("Apellido:");
		String apellido = sc.nextLine();
		
		System.out.println("DNI:");
		String dni = sc.nextLine();
		
		System.out.println("SEXO: H/M");
		String sexo = sc.nextLine();
	}
	
	
}
