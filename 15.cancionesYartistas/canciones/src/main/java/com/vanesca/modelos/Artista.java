package com.vanesca.modelos;


import java.time.LocalDateTime;
import java.util.List;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "artistas")
public class Artista {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 2, message = "El nombre debe tener al menos 2 caracteres")
    private String nombre;
    
    @Size(min = 2, message = "El apellido debe tener al menos 2 caracteres")
    private String apellido;
    
    @Size(min = 10, message = "La biografia debe tener al menos 10 caracteres")
    private String biografia;
    
    @CreationTimestamp
	@Column (name = "fecha_creacion", updatable = false )
	private LocalDateTime fechaCreacion;
	
	
	@UpdateTimestamp
	@Column (name = "fecha_actualizacion")
	private LocalDateTime fechaActualizacion;
	
	// A Relación uno a muchos (Un artista tiene muchas canciones)
	@OneToMany(mappedBy = "artista", fetch = FetchType.LAZY)
	@JsonManagedReference
	private List<Cancion> canciones;

    // Constructor vacío obligatorio
    public Artista() {
    }

	public Long getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public String getBiografia() {
		return biografia;
	}

	public LocalDateTime getFechaCreacion() {
		return fechaCreacion;
	}

	public LocalDateTime getFechaActualizacion() {
		return fechaActualizacion;
	}

	public List<Cancion> getCanciones() {
		return canciones;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public void setBiografia(String biografia) {
		this.biografia = biografia;
	}

	public void setFechaCreacion(LocalDateTime fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public void setFechaActualizacion(LocalDateTime fechaActualizacion) {
		this.fechaActualizacion = fechaActualizacion;
	}

	public void setCanciones(List<Cancion> canciones) {
		this.canciones = canciones;
	}
    
}
