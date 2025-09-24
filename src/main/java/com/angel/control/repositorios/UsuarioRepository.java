package com.angel.control.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.angel.control.entidades.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}