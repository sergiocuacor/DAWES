package com.sergio.proyecto.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sergio.proyecto.dtos.Alumno;
import com.sergio.proyecto.utils.DBUtils;

public class AlumnoModel {

	public List<Alumno> consultarAlumnos(String nombre, String apellido, String dni, String sexo, Integer edad) throws ClassNotFoundException, SQLException{
		
		List<Alumno> listaAlumnos = new ArrayList<Alumno>();
		
		Connection con = DBUtils.obtenerConexionBBDD();
		
		String sql = "SELECT * FROM alumnos WHERE nombre LIKE ? AND apellido LIKE ? AND dni LIKE ? AND sexo LIKE ? AND edad LIKE ? ";
		
		PreparedStatement ps = con.prepareStatement(sql);
		
		ps.setString(1, "%"+ nombre + "%");
		ps.setString(2, apellido);
		ps.setString(3, dni);
		ps.setString(4, sexo);
		ps.setInt(5, edad);
		
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			listaAlumnos.add(new Alumno(rs.getString("nombre"), rs.getString("apellido"), rs.getString("dni"), rs.getString("sexo"), rs.getInt("edad")));
		}
		con.close();
		return listaAlumnos;
	}
	
	public Integer insertarAlumno(String nombre, String apellido, String dni, String sexo, Integer edad) throws ClassNotFoundException, SQLException{
		
		
		Connection con = DBUtils.obtenerConexionBBDD();
		
		String sql = "INSERT INTO alumnos (nombre, apellido, dni, sexo, edad) VALUES(?,?,?,?,?)";	
		
		PreparedStatement ps = con.prepareStatement(sql);
		
		ps.setString(1, nombre);
		ps.setString(2, apellido);
		ps.setString(3, dni);
		ps.setString(4, sexo);
		ps.setInt(5, edad);
		
		Integer resultado = ps.executeUpdate();
		
		con.close();
		
		return resultado;
	}
	
}
