package com.example.demo.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entidad.Juego;

public interface JuegoRepository extends JpaRepository<Juego, Integer>{

	
}
