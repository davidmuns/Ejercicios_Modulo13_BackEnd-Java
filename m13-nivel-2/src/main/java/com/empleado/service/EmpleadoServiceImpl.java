package com.empleado.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.empleado.beans.CargoEnum;
import com.empleado.beans.Empleado;
import com.empleado.controller.ConexionJDBC;

@Service
public class EmpleadoServiceImpl implements IEmpleadoService {
	
	private ConexionJDBC conexion = ConexionJDBC.getInstance();
	
	public void insertarEmpleado (Empleado empleado) {
		String query = "insert into empleados (nombre, cargo, salario)" + " values (?, ?, ?)";
		try {
			PreparedStatement preparedStmt;
			preparedStmt = conexion.getConexion().prepareStatement(query);
			preparedStmt.setString(1, empleado.getNombre());
			preparedStmt.setString(2, empleado.getCargo().getNombre());
			preparedStmt.setInt(3, empleado.getCargo().getSalario());
			preparedStmt.executeUpdate();
		} catch (SQLException ex) {
			System.out.print(ex.getMessage());
		}
	}
	
	public void borrarEmpleado(int id) {
		String query = "delete from empleados where id=" + id;
		try {
		PreparedStatement preparedStmt = conexion.getConexion().prepareStatement(query);
		preparedStmt.executeUpdate();
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	public void actualizarEmpleado(Empleado empleado) {
		String query = "update empleados set nombre=?, cargo=?, salario=? where id=?";
		
		try {
			PreparedStatement preparedStmt = conexion.getConexion().prepareStatement(query);
			preparedStmt.setString(1, empleado.getNombre());
			preparedStmt.setString(2, empleado.getCargo().getNombre());
			preparedStmt.setInt(3, empleado.getCargo().getSalario());
			preparedStmt.setInt(4, empleado.getId());
			System.out.println(preparedStmt.toString());
			
			preparedStmt.executeUpdate();
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	public Empleado getEmpleado(int id) {
		Empleado empleado = null;
		
		try {
			Statement s = conexion.getConexion().createStatement();
			String sql = "SELECT * FROM empleados WHERE ID="+id;
			s.execute(sql);
			ResultSet rs = s.getResultSet();
			rs.next();
			empleado = new Empleado(rs.getInt(1), rs.getString(2), CargoEnum.valueOf(rs.getString(3)));
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		
		return empleado;
	}
	
	public ArrayList<Empleado> getListaEmpleados(){
		ArrayList<Empleado> list = new ArrayList<Empleado>();
		try {
			Statement s = conexion.getConexion().createStatement();
			String sql = "select * from empleados";
			s.execute(sql);
			ResultSet rs = s.getResultSet();
			while (rs.next()) {
				Empleado empleado = new Empleado(rs.getInt(1), rs.getString(2), CargoEnum.valueOf(rs.getString(3)));
				list.add(empleado);
			}
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		
		return list;
	}
	
	public ArrayList<Empleado> getListaEmpleadosPorCargo(CargoEnum cargo){
		ArrayList<Empleado> listaEmpleadosPorCargo = new ArrayList<Empleado>();
		for(Empleado e: getListaEmpleados()) {
			if(e.getCargo().getNombre().equalsIgnoreCase(cargo.getNombre())) {
				listaEmpleadosPorCargo.add(e);
			}
		}
		return listaEmpleadosPorCargo;
	}
	
	
}
