import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.sergio.classicmodels.dtos.ClienteDTO;
import com.sergio.classicmodels.utils.DBUtils;

public class Main {
public static void main(String[] args) throws ClassNotFoundException, SQLException {
	
	Connection conexionBDD = DBUtils.conectarConBBDD();
	
	Statement statement =	conexionBDD.createStatement();
	
	ResultSet clientes = statement.executeQuery("SELECT * FROM customers");
	
	List<ClienteDTO> listaClientes = new ArrayList<>();
	
	while(clientes.next()) {
	ClienteDTO cliente = new ClienteDTO(clientes.getString("customerName"), clientes.getString("phone"));
	listaClientes.add(cliente);
	}
	
	for(ClienteDTO cliente : listaClientes) {
		System.out.println(cliente.toString());
	}
	
}
}
