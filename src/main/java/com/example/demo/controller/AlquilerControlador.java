package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

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
	public List<Alquiler> findAll() {
		return rAlquilerRepository.findAll();

	}

	@PostMapping(path = "/mostrarAlquiler/{idusuario}")
	public Map<String, Object> mostrarAlquiler(@PathVariable int idusuario) {
		List<Alquiler> listaAlquiler = rAlquilerRepository.findById(idusuario);
		if(listaAlquiler.size()!=0){
			
			return Utils.mapear(true, "Alquileres realizados.", listaAlquiler);

		}else {
			return Utils.noRepues(false, "Error de Parametro");

		}


	}

	@PostMapping("/registro")
	public Map<String, Object> agregar(@RequestBody AlquilerDto alquilerDto) {
		try {
			Optional<Usuario> usuario = rUsuarioRepository.findById(alquilerDto.getIdUsuario());
			Optional<Juego> juego = rJuegoRepository.findById(alquilerDto.getIdJuego());
			if (usuario.isPresent()) {
				Alquiler alqui = new Alquiler(alquilerDto.getPrecio(), alquilerDto.getFechaRecibido(),
						alquilerDto.getFechaEntrega(), usuario.get(), juego.get(), alquilerDto.getEstado());

				if (alquilerDto.getEstado() == 0 || alquilerDto.getEstado() == 1) {
					rAlquilerRepository.save(alqui);
					return Utils.mapear(true, "Registro exitoso", alqui);
				} else {
					return Utils.mapear(false, "Error dato Estado", null);
				}
			}
		} catch (Exception e) {
			return Utils.mapear(false, "Fallo de registro", null);

		}
		return Utils.mapear(false, "Error Registro", null);

	}

	@PostMapping("/reporte/{fechaIn}")
	public Map<String, Object> reporte(@PathVariable String fechaIn) {
		try {
			List<Alquiler> listarReporte = rAlquilerRepository.filtrarFecha(fechaIn);
			if (listarReporte.size() != 0) {
				return Utils.mapear(true, "registro reporte por fecha", listarReporte);
			} else {
				return Utils.noRepues(true, "Error de Formato de Fecha");
			}

		} catch (Exception e) {
			return Utils.noRepues(true, "Error de reporte fecha");
		}

	}

	@PostMapping("/alquilerDia/{disponible}")
	public Map<String, Object> filtrarDisponible(@PathVariable String disponible) {
		try {
			List<Alquiler> listarDisponible = rAlquilerRepository.filtrarDisponible(disponible);
			if (listarDisponible.size()!=0) {
				return Utils.mapear(true, "Alquileres realizados.", listarDisponible);

			}else {
				return Utils.noRepues(false, "Error de Parametro");

			}
		} catch (Exception e) {
			return Utils.mapear(false, "Error de reporte Alquiler por Dia", null);
		}

	}

}
