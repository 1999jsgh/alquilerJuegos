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
import com.example.demo.dto.UsuarioDto;
import com.example.demo.entidad.Usuario;
import com.example.demo.repositorio.UsuarioRepository;

@RestController
@RequestMapping(path = "/usuario")
public class UsuarioControlador {

	@Autowired
	private UsuarioRepository rUsuarioRepository;

	@GetMapping("/traerUsuarios")
	public List<Usuario> findAll() {

		return rUsuarioRepository.findAll();

	}

	
	@PostMapping("/registro")
	public Map<String, Object> create(@RequestBody UsuarioDto usuario) {
		try {
			Usuario u = new Usuario(usuario.getNombre(), usuario.getTelefono(), usuario.getCorreo());
			rUsuarioRepository.save(u);
			return Utils.noRepues(true, "Registro exitoso");

		} catch (Exception e) {
			return Utils.mapear(true, "Error de Registro", null);
		}

	}

}
