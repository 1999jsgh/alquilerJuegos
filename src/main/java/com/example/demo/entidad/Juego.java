package com.example.demo.entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "juego")
public class Juego {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idjuego")
	private int idJuego;

	private String titulo;
	private String ano;
	private String protagonista;
	private String director;
	private String tecnologia;

	
	
	
	public Juego(String titulo, String ano, String protagonista, String director, String tecnologia) {
		super();
		
		this.titulo=titulo;
		this.ano=ano;
		this.protagonista=protagonista;
		this.director=director;
		this.tecnologia=tecnologia;

		
	}
	
	
	
	public Juego() {
		super();
	}



	public int getIdJuego() {
		return idJuego;
	}
	public void setIdJuego(int idJuego) {
		this.idJuego = idJuego;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getAno() {
		return ano;
	}
	public void setAno(String ano) {
		this.ano = ano;
	}
	public String getProtagonista() {
		return protagonista;
	}
	public void setProtagonista(String protagonista) {
		this.protagonista = protagonista;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public String getTecnologia() {
		return tecnologia;
	}
	public void setTecnologia(String tecnologia) {
		this.tecnologia = tecnologia;
	}



	@Override
	public String toString() {
		return "Juego [idJuego=" + idJuego + ", titulo=" + titulo + ", ano=" + ano + ", protagonista=" + protagonista
				+ ", director=" + director + ", tecnologia=" + tecnologia + "]";
	}
	
	
}
