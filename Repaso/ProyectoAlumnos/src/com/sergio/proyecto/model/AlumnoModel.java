package com.sergio.proyecto.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.sergio.proyecto.dtos.Alumno;
import com.sergio.proyecto.utils.DBUtils;

public class AlumnoModel {

	public List<Alumno> devolverListaAlumnos() throws ClassNotFoundException, SQLException{
		
		
		
		
		Connection con = DBUtils.conectarConBBDD();
		
		String sql = "SELECT * FROM alumnos WHERE nombre LIKE ? AND edad LIKE ? AND dni LIKE ? AND sexo LIKE ? ";
		
		PreparedStatement ps = con.prepareStatement(sql);
		return null;
		
		
	}
	
}
