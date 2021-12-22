package com.example.demo.dto;

import java.util.List;
import java.util.Set;

import com.example.demo.entidad.Juego;
import com.example.demo.entidad.Usuario;

public class AlquilerDto {

	private int idAlquiler;
	private String precio;
	private String fechaRecibido;
	private String fechaEntrega;
	private int idUsuario;
	
	private
	List<Juego> juego;
	
	
	
	public AlquilerDto( String precio, String fechaRecibido, String fechaEntrega, int idUsuario,
			List<Juego> juego) {
		super();
		this.precio = precio;
		this.fechaRecibido = fechaRecibido;
		this.fechaEntrega = fechaEntrega;
		this.idUsuario = idUsuario;
		this.juego = juego;
	}
	public List<Juego> getJuego() {
		return juego;
	}
	public void setJuego(List<Juego> juego) {
		this.juego = juego;
	}
	public int getIdAlquiler() {
		return idAlquiler;
	}
	public void setIdAlquiler(int idAlquiler) {
		this.idAlquiler = idAlquiler;
	}
	public String getPrecio() {
		return precio;
	}
	public void setPrecio(String precio) {
		this.precio = precio;
	}
	public String getFechaRecibido() {
		return fechaRecibido;
	}
	public void setFechaRecibido(String fechaRecibido) {
		this.fechaRecibido = fechaRecibido;
	}
	public String getFechaEntrega() {
		return fechaEntrega;
	}
	public void setFechaEntrega(String fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}
	public int getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	

}
