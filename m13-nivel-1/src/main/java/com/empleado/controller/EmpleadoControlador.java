package com.empleado.controller;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.empleado.beans.Empleado;
import com.empleado.service.IEmpleadoService;

@RestController
@RequestMapping("v1/empleados")
public class EmpleadoControlador {
	
	@Autowired // Inyecta dependencia
	IEmpleadoService iEmpleadoServiceImpl;
	
	// Peticiones HTTP(se pueden hacer desde una aplicación cliente como postman) 
	
	@GetMapping("/listado") // http://localhost:8080/v1/empleados/listado
	public ArrayList<Empleado> getListaEmpleados() {
		return iEmpleadoServiceImpl.getListaEmpleados();
	}
	
	//@PathVariable convierte objeto formato json a objeto java
	@GetMapping("/cargo/{cargo}") //http://localhost:8080/v1/empleados/cargo/"nombre cargo"
	public ArrayList<Empleado> getListaPorCargo(@PathVariable String cargo) {
		return iEmpleadoServiceImpl.getListaEmpleadosPorCargo(cargo);
	}
	
	//@PathVariable convierte objeto formato json a objeto java
	@GetMapping("/{id}") //http://localhost:8080/v1/empleados/"num id"
	public Empleado getEmpleadoPorId(@PathVariable int id) {
		return iEmpleadoServiceImpl.getEmpleadoPorId(id);
	}

	@PostMapping("/nuevo") //http://localhost:8080/v1/empleados/nuevo
	public void crearNuevoEmpleado(@RequestBody Empleado empleado) {
		iEmpleadoServiceImpl.insertarEmpleado(empleado);
	}

	@DeleteMapping("/{id}") //http://localhost:8080/v1/empleados/"num id"
	public void borrarEmpleado(@PathVariable int id) {
		iEmpleadoServiceImpl.borrarEmpleado(id);
	}

	@PutMapping("/actualizacion") //http://localhost:8080/v1/empleados/actualizacion
	public void actualizarEmpleado(@RequestBody Empleado empleado) {
		iEmpleadoServiceImpl.actualizarEmpleado(empleado);
	}

}
