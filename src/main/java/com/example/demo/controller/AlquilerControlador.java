package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entidad.Alquiler;
import com.example.demo.repositorio.AlquilerRepository;

@RestController
@RequestMapping(path = "/alquiler")
public class AlquilerControlador {
	
	@Autowired
	private AlquilerRepository rAlquilerRepository;
	
	@GetMapping("/traerAlquiler")
	public List<Alquiler>findAll(){
		return rAlquilerRepository.findAll();
		
	}
}
