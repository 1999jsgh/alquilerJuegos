package com.example.demo.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Utils;
import com.example.demo.dto.AlquilerDto;
import com.example.demo.entidad.Alquiler;
import com.example.demo.entidad.Juego;
import com.example.demo.entidad.Usuario;
import com.example.demo.repositorio.AlquilerRepository;
import com.example.demo.repositorio.JuegoRepository;
import com.example.demo.repositorio.UsuarioRepository;

@RestController
@RequestMapping(path = "/alquiler")
public class AlquilerControlador {
	
	@Autowired
	private AlquilerRepository rAlquilerRepository;
	
	@Autowired
	private UsuarioRepository rUsuarioRepository;
	
	@Autowired
	private JuegoRepository rJuegoRepository;
	
	@GetMapping("/traerAlquiler")
	public List<Alquiler>findAll(){
		return rAlquilerRepository.findAll();
		
	}
	
	@PostMapping("/registro")
	public Map<String, Object>agregar(@RequestBody AlquilerDto alquilerDto){
		List<Juego> juegos=new ArrayList<Juego>();
		List<Juego> juegos2=alquilerDto.getJuego();
		int cont=0;
		for(int i=0;i<juegos2.size();i++) {
			Optional<Juego> juegoResul=rJuegoRepository.findById(juegos2.get(i).getIdJuego());
			if(juegoResul.isPresent()) {
				juegos.add(juegoResul.get());
				cont++;
			}
		}
		Optional<Usuario> usuario = rUsuarioRepository.findById(alquilerDto.getIdUsuario());
		if(usuario.isPresent()) {
			List<Usuario> usu=(List<Usuario>) usuario.get();
		
			Alquiler alqui=new Alquiler(alquilerDto.getPrecio(),alquilerDto.getFechaRecibido(),alquilerDto.getFechaEntrega(),usu,juegos);
			rAlquilerRepository.save(alqui);
			
			return Utils.mapear(true,"Registro exitoso", alqui);

		}
		return Utils.mapear(true,"Registro maluco", null);
		
	}
	@PostMapping(path="/mostrarAlquiler/{idusuario}")
	public Map<String, Object>mostrarAlquiler(@PathVariable int idusuario){
		List<Alquiler> listaAlquiler=rAlquilerRepository.findById(idusuario);
		
		 return Utils.mapear(true, "Alquileres realizados.", listaAlquiler);
		
	}
}
