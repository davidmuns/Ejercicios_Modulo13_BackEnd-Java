package com.empleado.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.empleado.beans.Empleado;
import com.empleado.repository.IEmpleadoRepository;

@Service
public class EmpleadoServiceImpl implements IEmpleadoService{
	
	@Autowired
	IEmpleadoRepository iEmpleadoRepository;
	
	public ArrayList<Empleado> getListaEmpleados() {
		return iEmpleadoRepository.getListaEmpleados();
	}
	
	public void insertarEmpleado(Empleado empleado) {
		iEmpleadoRepository.getListaEmpleados().add(empleado);
	}
	
	public void borrarEmpleado(int id) {
		for(Empleado e : iEmpleadoRepository.getListaEmpleados()) {
			if(id == e.getId()) {
				iEmpleadoRepository.getListaEmpleados().remove(e);
				break;
			}
		}
	}
	
	public ArrayList<Empleado> getListaEmpleadosPorCargo(String cargo) {
		ArrayList<Empleado> listaEmpleadosPorCargo = new ArrayList<Empleado>();	
		for(Empleado e : iEmpleadoRepository.getListaEmpleados()) {
			if(cargo.equalsIgnoreCase(e.getCargo().getNombre())) {
				listaEmpleadosPorCargo.add(e);
			}
		}
		return listaEmpleadosPorCargo;
	}

	public Empleado getEmpleadoPorId(int id) {
		for(Empleado e : iEmpleadoRepository.getListaEmpleados()) {
			if(id == e.getId()) {
				return e;
			}
		}
		return null;
	}
	
	public void actualizarEmpleado(Empleado empleado) {
		for(Empleado e : iEmpleadoRepository.getListaEmpleados()) {
			if(empleado.getId()==e.getId()) {
				e.setNombre(empleado.getNombre());
				e.setCargo(empleado.getCargo());
				break;
			}
		}
	}
}
