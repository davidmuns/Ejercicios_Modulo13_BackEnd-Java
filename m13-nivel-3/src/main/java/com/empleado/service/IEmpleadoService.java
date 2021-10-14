package com.empleado.service;

import java.util.ArrayList;

import com.empleado.entity.CargoEnum;
import com.empleado.entity.Empleado;

public interface IEmpleadoService {
	public void insertarEmpleado(Empleado empleado);
	public void borrarEmpleado(long id);
	public void actualizarEmpleado(Empleado empleado);
	public Empleado getEmpleado(long id);
	public ArrayList<Empleado> getListaEmpleados();
	public ArrayList<Empleado> getListaEmpleadosPorCargo(CargoEnum cargo);
}
