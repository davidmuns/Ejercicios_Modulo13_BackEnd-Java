package com.empleado.service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empleado.entity.CargoEnum;
import com.empleado.entity.Empleado;
import com.empleado.repository.IEmpleadoRepository;

@Service
public class EmpleadoServiceImpl implements IEmpleadoService{
	
	@Autowired
	IEmpleadoRepository iEmpleadoRepository;
		
	@Override
	public void insertarEmpleado(Empleado empleado) {
		iEmpleadoRepository.save(empleado);
	}

	@Override
	public void borrarEmpleado(long id) {
		iEmpleadoRepository.deleteById(id);
	}

	@Override
	public void actualizarEmpleado(Empleado empleado) {
		iEmpleadoRepository.save(empleado);	
	}

	@Override
	public Empleado getEmpleado(long id) {
		Optional<Empleado> empleado = iEmpleadoRepository.findById(id);
		return empleado.get();
	}

	@Override
	public ArrayList<Empleado> getListaEmpleados() {	
		return (ArrayList<Empleado>) iEmpleadoRepository.findAll();
	}
	
	@Override
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
