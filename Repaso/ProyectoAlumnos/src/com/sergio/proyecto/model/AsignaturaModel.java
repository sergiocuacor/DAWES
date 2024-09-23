package com.sergio.proyecto.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.sergio.proyecto.utils.DBUtils;

public class AsignaturaModel {
// nombre,descripcion,numero_horas,nombre_profesor,
	public Integer insertarAsignatura(String nombre, String descripcion, Integer numeroHoras, String nombreProfesor) throws ClassNotFoundException, SQLException {
		
		Connection con = DBUtils.obtenerConexionBBDD();
		
		String sql = "INSERT INTO asignaturas (nombre, descripcion, numero_horas, nombre_profesor) "
				+ "VALUES (?, ?, ?, ?) ";
		
		PreparedStatement ps = con.prepareStatement(sql);
		
		ps.setString(1, nombre);
		ps.setString(2, descripcion);
		ps.setInt(3, numeroHoras);
		ps.setString(4, nombreProfesor);
		
		Integer resultado = ps.executeUpdate();
		
		con.close();
		
		return resultado;
	}
	
}
