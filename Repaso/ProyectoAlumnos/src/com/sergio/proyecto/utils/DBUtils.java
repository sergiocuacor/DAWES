package com.sergio.proyecto.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtils {

	private static Connection con;

    public static  Connection obtenerConexionBBDD() throws ClassNotFoundException, SQLException {
        if(con == null || con.isClosed()) {
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            String url = "jdbc:mysql://localhost:3306/colegioproyecto";
            String user = "root";
            String pass = "PracticaRoot";
            
            con = DriverManager.getConnection(url, user, pass);
        }
        return con;
    }
	
}
