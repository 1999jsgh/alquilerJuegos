package com.example.demo.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Utils;
import com.example.demo.dto.JuegoDto;
import com.example.demo.entidad.Juego;
import com.example.demo.repositorio.JuegoRepository;

@RestController
@RequestMapping(path = "/juego")
public class JuegoControlador {

	@Autowired
	private JuegoRepository rJuegoRepositorio;
	
	@GetMapping("/traerJuegos")
	public List<Juego>findAll(){
		return rJuegoRepositorio.findAll();
		
	}
	@PostMapping("/registro")
	public Map<String, Object> create(@RequestBody JuegoDto juego) {
		try {
			Juego j = new Juego(juego.getTitulo(), juego.getAno(), juego.getProtagonista(),juego.getDirector(),juego.getTecnologia());
			rJuegoRepositorio.save(j);
			return Utils.mapear(true, "Registro exitoso", null);

		} catch (Exception e) {
			return Utils.mapear(true, "Error de Registro", null);
		}

	}	
}
