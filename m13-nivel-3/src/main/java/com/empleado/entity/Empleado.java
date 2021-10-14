package com.empleado.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "empleados")
public class Empleado {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column
	private String nombre;
	
	@Column
	private String apellidos;
	
	@Column
	@Enumerated(EnumType.STRING)
	private CargoEnum cargo;
	
	
	public Empleado() {
		super();
	}

	public Empleado(String nombre, String apellidos, CargoEnum cargo) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.cargo = cargo;
	}
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public CargoEnum getCargo() {	
		return cargo;
	}

	public void setCargo(CargoEnum cargo) {
		this.cargo = cargo;
	}

	
}
