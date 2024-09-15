package com.sergio.classicmodels.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.sergio.classicmodels.dtos.ClienteDTO;
import com.sergio.classicmodels.utils.DBUtils;

public class ClientesModelo {

	public List<ClienteDTO> recuperarNombreTelefonoTodosClientes() throws SQLException, ClassNotFoundException {
		Connection conexionBDD = DBUtils.conectarConBBDD(); // Apertura conexion

		Statement statement = conexionBDD.createStatement();

		ResultSet clientes = statement.executeQuery("SELECT * FROM customers");

		List<ClienteDTO> listaClientes = new ArrayList<>();

		while (clientes.next()) {
			ClienteDTO cliente = new ClienteDTO(clientes.getString("customerName"), clientes.getString("phone"));
			listaClientes.add(cliente);
		}
		conexionBDD.close(); // Cierre conexión
		return listaClientes;
	}

	public List<ClienteDTO> recuperarNombreTelefonoFiltraPorNombre(String nombre)
			throws ClassNotFoundException, SQLException {

		String query = "SELECT * FROM customers WHERE customerName LIKE ? "; // Creamos la query

		Connection conexionBDD = DBUtils.conectarConBBDD(); // Conexion con BD

		PreparedStatement ps = conexionBDD.prepareStatement(query); // Cargamos la query de BDD
		ps.setString(1, "%" + nombre + "%"); // Seteamos el parámetro ? de la query

		ResultSet clientes = ps.executeQuery(); // Guardamos los objetos ResultSet que nos devuelve la ejecución de la
												// query
		List<ClienteDTO> listaClientes = new ArrayList<ClienteDTO>(); // Creamos la lista de clientes

		while (clientes.next()) { // Mientras que haya clientes
			ClienteDTO cliente = new ClienteDTO(clientes.getString("customerName"), clientes.getString("phone"));
			listaClientes.add(cliente);// Instanciamos el cliente y lo guardamos en la lista
		}
		conexionBDD.close(); // Cierre BDD
		return listaClientes;

	}

	public List<ClienteDTO> recuperarClienteFiltroNombreTelefonoPais(String nombre, String telefono, String pais)
			throws ClassNotFoundException, SQLException {

		String query = "SELECT * FROM customers WHERE customerName LIKE ? AND phone LIKE ? AND country LIKE ? ";

		Connection conexionBDD = DBUtils.conectarConBBDD();

		PreparedStatement ps = conexionBDD.prepareStatement(query);
		ps.setString(1, "%" + nombre + "%");
		ps.setString(2, "%" + telefono + "%");
		ps.setString(3, "%" + pais + "%");

		ResultSet clientes = ps.executeQuery();

		List<ClienteDTO> listaClientes = new ArrayList<ClienteDTO>();

		while (clientes.next()) {
			ClienteDTO cliente = new ClienteDTO(clientes.getString("customerName"), clientes.getString("phone"));
			listaClientes.add(cliente);
		}
		conexionBDD.close();

		return listaClientes;
	}

}
