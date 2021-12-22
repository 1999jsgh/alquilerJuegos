package com.example.demo.entidad;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

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
	
	@OneToMany(mappedBy = "idUsuario", cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<Usuario> usuario;
	
	@OneToMany(mappedBy = "idJuego", cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<Juego> juego;
	
	
	
	
	public Alquiler( String precio, String fechaRecibido, String fechaEntrega, List<Usuario> usuario,
			List<Juego> juego) {
		super();
		this.precio = precio;
		this.fechaRecibido = fechaRecibido;
		this.fechaEntrega = fechaEntrega;
		this.usuario = usuario;
		this.juego = juego;
	}


	public Alquiler() {
		super();
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
	public List<Usuario> getUsuario() {
		return usuario;
	}
	public void setUsuario(List<Usuario> usuario) {
		this.usuario = usuario;
	}
	public List<Juego> getJuego() {
		return juego;
	}
	public void setJuego(List<Juego> juego) {
		this.juego = juego;
	}


	@Override
	public String toString() {
		return "Alquiler [idAlquiler=" + idAlquiler + ", precio=" + precio + ", fechaRecibido=" + fechaRecibido
				+ ", fechaEntrega=" + fechaEntrega + ", usuario=" + usuario + ", juego=" + juego + "]";
	}


	

}
