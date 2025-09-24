package com.angel.control.repositorios;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.angel.control.entidades.Empleado;

public interface EmpleadoRepository extends PagingAndSortingRepository<Empleado, Long>{

}