package com.angel.control.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.angel.control.entidades.Empleado;
import com.angel.control.repositorios.EmpleadoDAO;
import com.angel.control.repositorios.EmpleadoRepository;

@Service
public class EmpleadoServiceImpl implements EmpleadoService {

    @Autowired
    private EmpleadoRepository empleadoRepository;

    @Autowired
    private EmpleadoDAO daoEmpleado;

    @Override
    @Transactional(readOnly = true)
    public List<Empleado> findAll() {
        return (List<Empleado>) empleadoRepository.findAll(Sort.unsorted());
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Empleado> findAll(Pageable pageable) {
        return empleadoRepository.findAll(pageable);
    }

    @Override
    @Transactional
    public void save(Empleado empleado) {
        daoEmpleado.save(empleado);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        daoEmpleado.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Empleado findOne(Long id) {
        return daoEmpleado.findById(id).orElse(null);
    }

}