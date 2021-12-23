package com.example.demo.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entidad.Alquiler;

public interface AlquilerRepository extends JpaRepository<Alquiler, Integer>{
	
	@Override
	List<Alquiler> findAll();
    
    @Query(nativeQuery = true,value = " SELECT * FROM `aquiler` WHERE idUsuario=?")
    List<Alquiler> findById(int idUsuario);
}
