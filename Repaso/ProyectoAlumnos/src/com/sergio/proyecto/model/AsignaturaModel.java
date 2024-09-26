package com.sergio.proyecto.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sergio.proyecto.dtos.Asignatura;
import com.sergio.proyecto.utils.DBUtils;

public class AsignaturaModel {
// nombre,descripcion,numero_horas,nombre_profesor,

	public List<Asignatura> consultarAsignaturas(String nombre, String descripcion, String numeroHoras,
			String nombreProfesor) throws ClassNotFoundException, SQLException {

		Connection con = DBUtils.obtenerConexionBBDD();

		List<Asignatura> listaAsignaturas = new ArrayList<Asignatura>();

		String sql = "SELECT * FROM asignaturas WHERE nombre LIKE ? AND descripcion like ? AND numero_horas like ? "
				+ " AND nombre_profesor LIKE ? ";

		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, "%" + nombre + "%");
		ps.setString(2, "%" + descripcion + "%");
		ps.setString(3, "%" + numeroHoras + "%");
		ps.setString(4, "%" + nombreProfesor + "%");

		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			listaAsignaturas.add(new Asignatura(rs.getString("nombre"), rs.getString("descripcion"),
					rs.getInt("numero_horas"), rs.getString("nombre_profesor")));
		}

		con.close();
		return listaAsignaturas;
	}

	public Integer insertarAsignatura(String nombre, String descripcion, Integer numeroHoras, String nombreProfesor)
			throws ClassNotFoundException, SQLException {

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

	public Integer actualizarAsignatura(String nombre, String descripcion, String numeroHoras, String nombreProfesor,
			Integer id) throws ClassNotFoundException, SQLException {

		Connection con = DBUtils.obtenerConexionBBDD();

		String sql = "UPDATE asignaturas SET nombre = WHEN ? = '' THEN nombre ELSE ? END, "
				+ "descripcion = WHEN ? = '' THEN descripcion else ? END, "
				+ "numero_horas = WHEN ? = '' THEN numero_horas ELSE ? END, "
				+ "nombre_profesor = WHEN = ? '' THEN nombre_profesor ELSE ? END " + " WHERE id LIKE ?";

		PreparedStatement ps = con.prepareStatement(sql);

		ps.setString(1, "%" + nombre + "%");
		ps.setString(2, "%" + nombre + "%");
		ps.setString(3, "%" + descripcion + "%");
		ps.setString(4, "%" + descripcion + "%");
		ps.setString(5, "%" + numeroHoras + "%");
		ps.setString(6, "%" + numeroHoras + "%");
		ps.setString(7, "%" + nombreProfesor + "%");
		ps.setString(8, "%" + nombreProfesor + "%");
		
		ps.setInt(9, id);

		Integer resultado = ps.executeUpdate();
		con.close();

		return resultado;
		
	}
	
	public Integer borrarAsignatura(Integer id) throws ClassNotFoundException, SQLException {
		
		Connection con = DBUtils.obtenerConexionBBDD();
		
		String sql = "DELETE FROM asignaturas WHERE id LIKE ? ";
		
		PreparedStatement ps = con.prepareStatement(sql);
		
		ps.setInt(1, id);
		
		Integer resultado = ps.executeUpdate();
		
		con.close();
		return resultado;
	}
	

}
