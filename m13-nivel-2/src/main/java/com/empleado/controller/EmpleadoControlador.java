package com.empleado.controller;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.empleado.beans.CargoEnum;
import com.empleado.beans.Empleado;
import com.empleado.service.IEmpleadoService;

@Controller
@RequestMapping("/v1/empleados") // http://localhost:8080/v1/empleados
public class EmpleadoControlador {
		
	@Autowired
	IEmpleadoService iEmpleadoService;
	
	@GetMapping("") // http://localhost:8080/
	public String start(Model model) {
		ArrayList<Empleado> listaEmpleados = iEmpleadoService.getListaEmpleados();
		model.addAttribute("lista", listaEmpleados);
		model.addAttribute("empleado", new Empleado());
		model.addAttribute("button", "insertar");
		model.addAttribute("action", "/v1/empleados/nuevo");
		return "index";
	}
	
	@PostMapping("/nuevo") // http://localhost:8080/v1/empleados/nuevo
	public String insertar(Empleado empleado, Model model) {
		iEmpleadoService.insertarEmpleado(empleado);
		ArrayList<Empleado> listaEmpleados = iEmpleadoService.getListaEmpleados();
		model.addAttribute("lista", listaEmpleados);
		model.addAttribute("empleado", empleado);
		model.addAttribute("button", "insertar");
		model.addAttribute("action", "/v1/empleados/nuevo");
		return "index";
	}
	
	@GetMapping("/borrar/{id}") // http://localhost:8080/v1/empleados/borrar/"id"
	public String borrar(@PathVariable int id, Model model) {
		iEmpleadoService.borrarEmpleado(id);
		ArrayList<Empleado> listaEmpleados = iEmpleadoService.getListaEmpleados();
		model.addAttribute("empleado", new Empleado());
		model.addAttribute("lista", listaEmpleados);
		model.addAttribute("button", "insertar");
		model.addAttribute("action", "/v1/empleados/nuevo");
		return "index";
	}
	
	@GetMapping("/editar/{id}") // http://localhost:8080/v1/empleados/editar/"id"
	public String editar(@PathVariable int id, Model model) {
		Empleado empleado = iEmpleadoService.getEmpleado(id);
		ArrayList<Empleado> listaEmpleados = iEmpleadoService.getListaEmpleados();
		model.addAttribute("empleado", empleado);
		model.addAttribute("lista", listaEmpleados);
		model.addAttribute("button", "editar");
		model.addAttribute("action", "/v1/empleados/actualizar");
		return "index";
	}
	
	@PostMapping("/actualizar") // http://localhost:8080/v1/empleados/actualizar
	public String actualizar(Empleado empleado, Model model) {
		iEmpleadoService.actualizarEmpleado(empleado);
		ArrayList<Empleado> listaEmpleados = iEmpleadoService.getListaEmpleados();
		model.addAttribute("empleado", new Empleado());
		model.addAttribute("lista", listaEmpleados);
		model.addAttribute("button", "insertar");
		model.addAttribute("action", "/v1/empleados/nuevo");
		return "index";
	}
	
	@GetMapping("/cargo") // http://localhost:8080/v1/empleados/buscar
	public String buscar(@RequestParam CargoEnum cargo, Model model) {
		ArrayList<Empleado> listaEmpleadosPorCargo = iEmpleadoService.getListaEmpleadosPorCargo(cargo);
		model.addAttribute("lista", listaEmpleadosPorCargo);
		model.addAttribute("empleado", new Empleado());
		model.addAttribute("button", "insertar");
		model.addAttribute("action", "/v1/empleados/nuevo");
		return "index";
	}
	

}
