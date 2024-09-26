package com.sergio.proyecto.main;

import java.sql.SQLException;
import java.util.Scanner;

import com.sergio.proyecto.utils.ScannerUtils;
import com.sergio.proyecto.view.AlumnoView;
import com.sergio.proyecto.view.AsignaturaView;

public class MenuPrincipal {

	Scanner sc = ScannerUtils.getScanner();

	public void invocarMenuPrincipal() throws ClassNotFoundException, SQLException {

		System.out.println("*** CRUD ALUMNOS Y ASIGNATURAS ***\n");

		Boolean esOpcionValida = false;

		do {
			System.out.println("Seleccione una opción");
			System.out.println("1. Alumnos");
			System.out.println("2. Asignaturas");
			Integer eleccion = Integer.parseInt(sc.nextLine());
			if (eleccion == 1) {
				esOpcionValida = true;
				invocarMenuAlumnos();

			} else if (eleccion == 2) {
				// TODO: Menu principal asignaturas
				esOpcionValida = true;
				invocarMenuAsignaturas();
			}
		} while (!esOpcionValida);

	}

	public void invocarMenuAlumnos() throws ClassNotFoundException, SQLException {
		int opcion;
		do {
		System.out.println("\n*** CRUD Alumnos ***");
		System.out.println("1. Consultar Alumnos");
		System.out.println("2. Insertar un nuevo alumno");
		System.out.println("3. Actualizar alumno");
		System.out.println("4. Eliminar alumno");
		System.out.println("5. Salir");

		AlumnoView alumnoView = new AlumnoView();
		
		
		
		
			opcion = Integer.parseInt(sc.nextLine());
			switch (opcion) {
			case 1:
				alumnoView.invocarMenuConsultarAlumnos();
				break;
			case 2:
				alumnoView.invocarMenuInsertarAlumno();
				break;
			case 3:
				alumnoView.invocarMenuActualizarAlumno();
				break;
			case 4:
				alumnoView.invocarMenuBorrarAlumno();
				break;
			case 5:
				System.out.println("Saliendo del programa..");
				return;
			default:
				System.out.println("");
				break;
			}
		} while(opcion != 5);
	}

	public void invocarMenuAsignaturas() throws ClassNotFoundException, SQLException {
		System.out.println("\n*** CRUD Asignaturas ***");
		System.out.println("1. Consultar Asignaturas");
		System.out.println("2. Insertar una nueva asignatura");
		System.out.println("3. Actualizar asignatura");
		System.out.println("4. Eliminar asignatura");
		System.out.println("5. Salir");

		AsignaturaView asignaturaView = new AsignaturaView();

		int opcion = Integer.parseInt(sc.nextLine());

		switch (opcion) {
		case 1:
			asignaturaView.invocarMenuConsultarAsignaturas();
			break;
		case 2:
			asignaturaView.invocarMenuInsertarAsignatura();
			break;
		case 3:
			
			break;
		case 4:
			asignaturaView.invocarMenuBorrarAsignaturas();
			break;
		}
	}

}
