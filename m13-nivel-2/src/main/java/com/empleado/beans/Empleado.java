package com.empleado.beans;


public class Empleado {
	
	private int id;
	private String nombre;
	private CargoEnum cargo;
	
	public Empleado() {
		
	}
	
	public Empleado(CargoEnum cargo) {
		this.cargo = cargo;
	}
	
	public Empleado(int id, String nombre, CargoEnum cargo) {
		this.id=id;
		this.nombre=nombre;
		this.cargo=cargo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public CargoEnum getCargo() {
		return cargo;
	}

	public void setCargo(CargoEnum cargo) {
		this.cargo = cargo;
	}
	
	

	
	
	
	
	
}
