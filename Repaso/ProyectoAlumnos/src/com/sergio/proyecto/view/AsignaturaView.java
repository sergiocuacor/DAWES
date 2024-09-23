package com.sergio.proyecto.view;

import java.sql.SQLException;
import java.util.Scanner;

import com.sergio.proyecto.controller.AlumnoController;
import com.sergio.proyecto.controller.AsignaturaController;
import com.sergio.proyecto.utils.ScannerUtils;

public class AsignaturaView {

	Scanner sc = ScannerUtils.getScanner();

	public void invocarMenuInsertarAsignatura() throws ClassNotFoundException, SQLException {
		System.out.println("*** INSERTAR ASIGNATURA ***");
		System.out.println("Nombre de la asignatura:");
		String nombre = sc.nextLine();
		System.out.println("Descripción de la asignatura:");
		String descripcion = sc.nextLine();
		System.out.println("Número de horas de la asignatura:");
		Integer numeroHoras = Integer.parseInt(sc.nextLine());
		System.out.println("Profesor que imparte la asignatura: ");
		String nombreProfesor = sc.nextLine();

		Integer resultado = new AsignaturaController().insertarAsignatura(nombre, descripcion, numeroHoras,
				nombreProfesor);

		if (resultado == 1) {
			System.out.println("Asignatura insertada con éxito.");
		} else {
			System.out.println("Ha ocurrido un error al insertar la asignatura.");
		}
	}

}
