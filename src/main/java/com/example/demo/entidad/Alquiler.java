package com.example.demo.entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "aquiler")
public class Alquiler {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idalquiler")
	private int idAlquiler;
	
	private String precio;
	
	@Column(name = "fecharecibido")
	private String fechaRecibido;
	
	@Column(name = "fechaentrega")
	private String fechaEntrega;
	
	@ManyToOne
	@JoinColumn(name="idusuario")
	private Usuario usuario;
	
	@ManyToOne
	@JoinColumn(name="idjuego")
	private Juego juego;
	
	private int estado;

	
	public Alquiler() {
		super();
	}
	
	
	
	public Alquiler(String precio, String fechaRecibido, String fechaEntrega, Usuario usuario, Juego juego,int estado) {
		super();
		this.precio = precio;
		this.fechaRecibido = fechaRecibido;
		this.fechaEntrega = fechaEntrega;
		this.usuario = usuario;
		this.juego = juego;
		this.estado = estado;

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
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Juego getJuego() {
		return juego;
	}
	public void setJuego(Juego juego) {
		this.juego = juego;
	}



	public int getEstado() {
		return estado;
	}



	public void setEstado(int estado) {
		this.estado = estado;
	}


	

}
