package com.vanesca.modelos;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "canciones")
public class Cancion {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	//validaciones size
	
	@Size(min = 5, message= "Al menos 5 caracteres de longitud")
	private String titulo;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "artista_id")
	@JsonBackReference
	private Artista artista;
	
	@Size(min = 3, message= "Al menos 3 caracteres de longitud")
	private String album;
	
	@Size(min = 3, message= "Al menos 3 caracteres de longitud")
	private String genero;
	
	@Size(min = 3, message= "Al menos 3 caracteres de longitud")
	private String idioma;

	@CreationTimestamp
	@Column (name = "fecha_creacion", updatable = false )
	private LocalDateTime fechaCreacion;
	
	
	@UpdateTimestamp
	@Column (name = "fecha_actualizacion")
	private LocalDateTime fechaActualizacion;

	//constructor
	public Cancion() {
		
	}
	
	
//getter y setters
	
	public Long getId() {
		return id;
	}


	public String getTitulo() {
		return titulo;
	}


	public Artista getArtista() {
		return artista;
	}


	public String getAlbum() {
		return album;
	}


	public String getGenero() {
		return genero;
	}


	public String getIdioma() {
		return idioma;
	}


	public LocalDateTime getFechaCreacion() {
		return fechaCreacion;
	}


	public LocalDateTime getFechaActualizacion() {
		return fechaActualizacion;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}


	public void setArtista(Artista artista) {
		this.artista = artista;
	}


	public void setAlbum(String album) {
		this.album = album;
	}


	public void setGenero(String genero) {
		this.genero = genero;
	}


	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}


	public void setFechaCreacion(LocalDateTime fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}


	public void setFechaActualizacion(LocalDateTime fechaActualizacion) {
		this.fechaActualizacion = fechaActualizacion;
	}
	
	
}
