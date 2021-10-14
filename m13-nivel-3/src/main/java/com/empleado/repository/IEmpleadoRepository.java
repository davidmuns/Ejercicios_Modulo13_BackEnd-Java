package com.empleado.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.empleado.entity.Empleado;

@Repository
public interface IEmpleadoRepository extends JpaRepository<Empleado, Long>{
	//List<Empleado> findByNombre(String nombre);
}
