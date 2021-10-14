package com.empleado.controller;

import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.empleado.entity.CargoEnum;
import com.empleado.entity.Empleado;
import com.empleado.repository.IEmpleadoRepository;
import com.empleado.service.EmpleadoServiceImpl;
import com.empleado.service.IEmpleadoService;

@Controller
@RequestMapping("empleados")
public class EmpleadoControlador {

	@Autowired
	private IEmpleadoService iEmpleadoService; 
	
	@GetMapping("/")
	public String iniciar(Model model) {
		model.addAttribute("lista", iEmpleadoService.getListaEmpleados());
		model.addAttribute("persona", new Empleado());
		return "index";
		
	}
	
	@GetMapping("muestraFormulario")
	public String mostarFormEmpleado(Empleado e) {
		return "add-empleado";
	}
	
	@GetMapping("lista")
	public String listaEmpleados(Model model) {
		model.addAttribute("empleados", this.iEmpleadoService.getListaEmpleados());
		return "index";
	}
	
	@PostMapping("add")
	public String addEmpleado(Empleado e, Model model) {
		this.iEmpleadoService.insertarEmpleado(e);
		return "redirect:lista";
	}
	
	
	@GetMapping("editar/{id}")
	public String mostrarFormActualizar(@PathVariable long id, Model model) {	
		model.addAttribute("empleado", iEmpleadoService.getEmpleado(id));
		return "actualizar-empleado";
	}
	
	@PostMapping("actualizar/{id}")
	public String actualizarEmpleado(Empleado e, Model model) {
		this.iEmpleadoService.actualizarEmpleado(e);
		model.addAttribute("empleados", this.iEmpleadoService.getListaEmpleados());
		return "index";
	}
	
	@GetMapping("borrar/{id}")
	public String borrarEmpleado(@PathVariable long id, Model model) {
		this.iEmpleadoService.borrarEmpleado(id);
		model.addAttribute("empleados", this.iEmpleadoService.getListaEmpleados());
		return "index";	
	}
	
	@GetMapping("/cargo") // http://localhost:8080/v1/empleados/buscar
	public String buscar(@RequestParam CargoEnum cargo, Model model) {
		ArrayList<Empleado> listaEmpleadosPorCargo = iEmpleadoService.getListaEmpleadosPorCargo(cargo);
		model.addAttribute("lista", listaEmpleadosPorCargo);
		model.addAttribute("empleado", new Empleado());
		model.addAttribute("button", "insertar");
		model.addAttribute("action", "/empleados/nuevo");

		return "index";
	}

}
