package com.empleado.repository;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.empleado.beans.Empleado;


@Service
public class EmpleadoRepository implements IEmpleadoRepository{
	
	private static ArrayList<Empleado> listaEmpleados = new ArrayList<Empleado>();

	public ArrayList<Empleado> getListaEmpleados() {
		return listaEmpleados;
	}
	
	
}
