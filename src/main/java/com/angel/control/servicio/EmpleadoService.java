package com.angel.control.servicio;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.angel.control.entidades.Empleado;

public interface EmpleadoService {

    public List<Empleado> findAll();

    public Page<Empleado> findAll(Pageable pageable);

    public void save(Empleado empleado);

    public Empleado findOne(Long id);

    public void delete(Long id);
}