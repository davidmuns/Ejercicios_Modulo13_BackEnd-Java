package com.empleado.controller;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexionJDBC {
	
	private Connection conexion;
	
	private static ConexionJDBC instancia;

	private ConexionJDBC() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String connec = "jdbc:mysql://localhost:3306/empresa";
			this.conexion = DriverManager.getConnection(connec, "root", "");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static ConexionJDBC getInstance() {
		if(instancia==null) {
			return new ConexionJDBC();
		}
		return instancia;
	}
	
	public Connection getConexion() {
		return conexion;
	}
}
