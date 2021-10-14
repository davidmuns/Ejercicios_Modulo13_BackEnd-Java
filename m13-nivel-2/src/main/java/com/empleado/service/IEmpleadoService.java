package com.empleado.service;

import java.util.ArrayList;

import com.empleado.beans.CargoEnum;
import com.empleado.beans.Empleado;

public interface IEmpleadoService {
	public void insertarEmpleado(Empleado empleado);
	public void borrarEmpleado(int id);
	public void actualizarEmpleado(Empleado empleado);
	public Empleado getEmpleado(int id);
	public ArrayList<Empleado> getListaEmpleados();
	public ArrayList<Empleado> getListaEmpleadosPorCargo(CargoEnum cargo);
	
	
}
