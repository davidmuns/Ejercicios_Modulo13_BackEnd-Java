package com.empleado.beans;

public enum CargoEnum {
	Director("Director", 5000), Comercial("Comercial", 2000), Gerente("Gerente", 3500);
	
	private String nombre;
	private int salario;
	
	private CargoEnum(String nombre, int salario) {
		this.nombre = nombre;
		this.salario = salario;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public int getSalario() {
		return this.salario;
	}
}
