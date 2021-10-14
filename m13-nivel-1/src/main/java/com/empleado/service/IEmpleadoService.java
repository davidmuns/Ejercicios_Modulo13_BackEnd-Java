package com.empleado.service;

import java.util.ArrayList;

import com.empleado.beans.Empleado;

public interface IEmpleadoService {
	public void insertarEmpleado(Empleado empleado);
	public void borrarEmpleado(int id);
	public void actualizarEmpleado(Empleado empleado);
	public Empleado getEmpleadoPorId(int id);
	public ArrayList<Empleado> getListaEmpleadosPorCargo(String cargo);
	public ArrayList<Empleado> getListaEmpleados();
	
}
