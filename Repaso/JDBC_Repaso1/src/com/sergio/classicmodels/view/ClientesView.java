package com.sergio.classicmodels.view;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.sergio.classicmodels.controller.ClientesController;
import com.sergio.classicmodels.dtos.ClienteDTO;

public class ClientesView {

	public void menuRecuperaNombreTelefono() throws ClassNotFoundException, SQLException {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduzca el nombre del empleado:");
		
		String nombreEmpleado = sc.nextLine();
		
		ClientesController cc = new ClientesController();
		List<ClienteDTO> listaClientes = cc.recuperarNombreTelefonoCliente(nombreEmpleado);
		
		for(ClienteDTO c : listaClientes) {
			System.out.println("Nombre: "+ c.getCustomerName()+", Teléfono: "+c.getPhone());
		}
		
	}
	
	public void menuRecuperarClienteFiltroNombreTelefonoPais() throws ClassNotFoundException, SQLException {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Nombre del empleado:");
		String nombre = sc.nextLine();
		System.out.println("Telefono del empleado:");
		String telefono = sc.nextLine();
		System.out.println("País del empleado:");
		String pais = sc.nextLine();
		
		ClientesController cc = new ClientesController();
		List<ClienteDTO> listaClientes = cc.recuperarClientesFiltroNombreTelefonoPais(nombre, telefono, pais);
		
		for(ClienteDTO c : listaClientes) {
		System.out.println("Nombre: "+ c.getCustomerName()+", Telefono: "+ c.getPhone());	
		}
	}
	
}
