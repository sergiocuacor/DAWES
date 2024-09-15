package com.sergio.classicmodels.controller;

import java.sql.SQLException;
import java.util.List;

import com.sergio.classicmodels.dtos.ClienteDTO;
import com.sergio.classicmodels.model.ClientesModelo;

public class ClientesController {

	public List<ClienteDTO> recuperarNombreTelefonoCliente(String nombre) throws ClassNotFoundException, SQLException{
		ClientesModelo cm = new ClientesModelo();
		return cm.recuperarNombreTelefonoFiltraPorNombre(nombre);//Llamada al método que recupera el listado de clientes
	}
	public List<ClienteDTO> recuperarNombreTelefonoTodosClientes() throws ClassNotFoundException, SQLException{
		ClientesModelo cm = new ClientesModelo();
		return cm.recuperarNombreTelefonoTodosClientes();
	}
	
	public List<ClienteDTO> recuperarClientesFiltroNombreTelefonoPais(String nombre, String telefono, String pais) throws ClassNotFoundException, SQLException{
		
		ClientesModelo cm = new ClientesModelo();
		return cm.recuperarClienteFiltroNombreTelefonoPais(nombre, telefono, pais);
		
	}
	
}
