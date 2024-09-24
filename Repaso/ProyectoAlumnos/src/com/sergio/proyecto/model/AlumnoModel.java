package com.sergio.proyecto.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.sergio.proyecto.dtos.Alumno;
import com.sergio.proyecto.utils.DBUtils;

public class AlumnoModel {

	public List<Alumno> consultarAlumnos(String nombre, String apellido, String dni, String sexo, Integer edad)
			throws ClassNotFoundException, SQLException {

		List<Alumno> listaAlumnos = new ArrayList<Alumno>();

		Connection con = DBUtils.obtenerConexionBBDD();

		String sql = "SELECT * FROM alumnos WHERE nombre LIKE ? AND apellido LIKE ? AND dni LIKE ? AND sexo LIKE ? AND edad LIKE ? ";

		PreparedStatement ps = con.prepareStatement(sql);

		ps.setString(1, "%" + nombre + "%");
		ps.setString(2, apellido);
		ps.setString(3, dni);
		ps.setString(4, sexo);
		ps.setInt(5, edad);

		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			listaAlumnos.add(new Alumno(rs.getString("nombre"), rs.getString("apellido"), rs.getString("dni"),
					rs.getString("sexo"), rs.getInt("edad")));
		}
		con.close();
		return listaAlumnos;
	}

	public Integer insertarAlumno(String nombre, String apellido, String dni, String sexo, Integer edad)
			throws ClassNotFoundException, SQLException {

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

	public Integer actualizarAlumno(String nombre, String apellido, String dni, String sexo, Integer edad, Integer id)
			throws ClassNotFoundException, SQLException {

		Connection con = DBUtils.obtenerConexionBBDD();

		String sql = "UPDATE alumnos SET nombre = CASE WHEN ? = '' THEN nombre ELSE ? END, "
				+ "apellido = CASE WHEN ? = '' THEN apellido ELSE ? END, "
				+ "dni = CASE WHEN ? = '' THEN apellido ELSE ? END, " + "sexo = CASE WHEN ? = '' THEN sexo ELSE ? END,"
				+ "edad = CASE WHEN ? = '' THEN edad ELSE ? END " + " WHERE id LIKE ? ";

		PreparedStatement ps = con.prepareStatement(sql);

		ps.setString(1, nombre);
		ps.setString(2, nombre);
		ps.setString(3, apellido);
		ps.setString(4, apellido);
		ps.setString(5, dni);
		ps.setString(6, dni);
		ps.setString(7, sexo);
		ps.setString(8, sexo);
		ps.setInt(9, edad);
		ps.setInt(10, edad);
		
		ps.setInt(11, id);
		
		Integer resultado = ps.executeUpdate();
		con.close();
		return resultado;
	}
	
	public Integer borrarAlumno(Integer id) throws ClassNotFoundException, SQLException {
		
		Connection con = DBUtils.obtenerConexionBBDD();
		
		String sql = "DELETE FROM alumnos WHERE id LIKE ? ";
		
		PreparedStatement ps = con.prepareStatement(sql);
		
		ps.setInt(1, id);
		
		Integer resultado = ps.executeUpdate();
		
		con.close();
		return resultado;
	}

}
