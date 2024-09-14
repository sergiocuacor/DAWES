package com.sergio.classicmodels.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtils {

	public static Connection conectarConBBDD() throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		String servidor = "jdbc:mysql://localhost:3306/classicmodels";
		
		String username = "root";
		
		String password = "PracticaRoot";
		
		Connection conexionBDD = DriverManager.getConnection(servidor, username, password);
		return conexionBDD;
	}
	
}
