package com.example.demo.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entidad.Alquiler;

public interface AlquilerRepository extends JpaRepository<Alquiler, Integer>{
	
	@Override
	List<Alquiler> findAll();
}
