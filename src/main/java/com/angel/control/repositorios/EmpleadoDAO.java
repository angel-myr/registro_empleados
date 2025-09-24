package com.angel.control.repositorios;

import org.springframework.data.repository.CrudRepository;

import com.angel.control.entidades.Empleado;

public interface EmpleadoDAO extends CrudRepository<Empleado, Long> {

}