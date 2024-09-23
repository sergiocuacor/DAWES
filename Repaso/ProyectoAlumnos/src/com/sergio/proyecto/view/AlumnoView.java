package com.sergio.proyecto.view;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.sergio.proyecto.controller.AlumnoController;
import com.sergio.proyecto.dtos.Alumno;
import com.sergio.proyecto.utils.ScannerUtils;

public class AlumnoView {
	Scanner sc = ScannerUtils.getScanner();
	public void invocarMenuInsertarAlumno() throws ClassNotFoundException, SQLException {
		
		System.out.println("*** INSERTAR ALUMNO ***");
		System.out.println("Nombre:");	
		String nombre = sc.nextLine();
		
		System.out.println("Apellido:");
		String apellido = sc.nextLine();
		
		System.out.println("DNI:");
		String dni = sc.nextLine();
		
		System.out.println("SEXO: M/F");
		String sexo = sc.nextLine();
		
		System.out.println("Edad: ");
		Integer edad = Integer.parseInt(sc.nextLine());
		
		Integer resultado = new AlumnoController().insertarAlumno(nombre, apellido, dni, sexo, edad);
		
		if(resultado ==1) {
			System.out.println("Alumno registrado con éxito");
		}
	}
	
	public void invocarMenuConsultarAlumnos() throws ClassNotFoundException, SQLException {
		System.out.println("** CONSULTAR ALUMNO/S **");
		System.out.println("Nombre: ");
		String nombre = sc.nextLine();
		System.out.println("Apellido: ");
		String apellido = sc.nextLine();
		System.out.println("DNI: ");
		String dni = sc.nextLine();
		System.out.println("SEXO ( M / F ): ");
		String sexo = sc.nextLine();
		Integer edad = Integer.parseInt(sc.nextLine());
		
		List<Alumno> listaAlumnos = new AlumnoController().consultarAlumnos(nombre, apellido, dni, sexo, edad);
		
		for(Alumno a : listaAlumnos) {
			System.out.println(a.toString());
		}
	}
	
	
}
