package com.empleado.entity;

import java.io.Serializable;

public enum CargoEnum implements Serializable {
	DIRECTOR("Director/a Gral", 7500), 
	COMERCIAL("Comercial", 2000), 
	GERENTE("Gerente", 3750),
	PROGRAMADOR("Programador/a", 2500),
	FINANZAS("Director/a finaciero/a", 3500),
	MARKETING("Project Manager", 3000),
	ALMACEN("Mozo Almacén", 1150),
	RIESGOS("Risk Manager", 3150),
	ADMINISTRATIVO("Administrativo/a", 1300);
	
	private String nombre;
	private int salario;
	
	private CargoEnum(String nombre, int salario) {
		this.nombre = nombre;
		this.salario = salario;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setSalario(int salario) {
		this.salario = salario;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public int getSalario() {
		return this.salario;
	}
}
