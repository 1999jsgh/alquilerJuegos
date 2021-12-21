package com.example.demo.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entidad.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
		
	@Override
	List<Usuario> findAll();
	
	
}