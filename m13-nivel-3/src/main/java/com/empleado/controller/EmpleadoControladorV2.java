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

import com.empleado.entity.CargoEnum;
import com.empleado.entity.Empleado;
import com.empleado.service.IEmpleadoService;

//@Controller
@RequestMapping("empleados")
public class EmpleadoControladorV2 {

	@Autowired
	IEmpleadoService iEmpleadoService;

	@GetMapping("") // http://localhost:8080/v1/empleados
	public String inicio(Model model) {
		model.addAttribute("lista", iEmpleadoService.getListaEmpleados());
		model.addAttribute("empleado", new Empleado());
		model.addAttribute("button", "insertar");
		model.addAttribute("action", "/empleados/nuevo");
		return "empleados";
	}

	@PostMapping("/nuevo") // http://localhost:8080/v1/empleados/nuevo
	public String insert(Empleado empleado, Model model) {
		iEmpleadoService.insertarEmpleado(empleado);
		model.addAttribute("lista", iEmpleadoService.getListaEmpleados());
		model.addAttribute("empleado", new Empleado());
		model.addAttribute("button", "insertar");
		model.addAttribute("action", "/empleados/nuevo");
		return "empleados";
	}

	@GetMapping("/borrar/{id}") // http://localhost:8080/v1/empleados/borrar/"id"
	public String borrar(@PathVariable int id, Model model) {
		iEmpleadoService.borrarEmpleado(id);
		model.addAttribute("empleado", new Empleado());
		model.addAttribute("lista", iEmpleadoService.getListaEmpleados());
		model.addAttribute("button", "insertar");
		model.addAttribute("action", "/empleados/nuevo");
		return "empleados";
	}

	@GetMapping("/editar/{id}") // http://localhost:8080/v1/empleados/editar/"id"
	public String editar(@PathVariable int id, Model model) {
		Empleado empleado = iEmpleadoService.getEmpleado(id);
		model.addAttribute("empleado", empleado);
		model.addAttribute("lista", iEmpleadoService.getListaEmpleados());
		model.addAttribute("button", "editar");
		model.addAttribute("action", "/empleados/actualizar");
		return "empleados";
	}

	@PostMapping("/actualizar") // http://localhost:8080/v1/empleados/actualizar
	public String actualizar(Empleado empleado, Model model) {
		iEmpleadoService.actualizarEmpleado(empleado);
		model.addAttribute("empleado", new Empleado());
		model.addAttribute("lista", iEmpleadoService.getListaEmpleados());
		model.addAttribute("button", "insertar");
		model.addAttribute("action", "/empleados/nuevo");
		return "empleados";
	}

	@GetMapping("/cargo") // http://localhost:8080/v1/empleados/buscar
	public String buscar(@RequestParam CargoEnum cargo, Model model) {
		ArrayList<Empleado> listaEmpleadosPorCargo = iEmpleadoService.getListaEmpleadosPorCargo(cargo);
		model.addAttribute("lista", listaEmpleadosPorCargo);
		model.addAttribute("empleado", new Empleado());
		model.addAttribute("button", "insertar");
		model.addAttribute("action", "/empleados/nuevo");

		return "empleados";
	}
}
