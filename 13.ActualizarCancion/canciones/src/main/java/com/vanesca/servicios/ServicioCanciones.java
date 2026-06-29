package com.vanesca.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vanesca.modelos.Cancion;
import com.vanesca.repositorios.RepositorioCanciones;

@Service
public class ServicioCanciones{

	 @Autowired
	 private RepositorioCanciones repoCanciones;
	  
	  public List<Cancion> obtenerTodasLasCanciones(){
		  return this.repoCanciones.findAll();
		  }
	  public Cancion obtenerCancionPorId(Long id){
		  return repoCanciones.findById(id).orElse(null);
	  }
	  
	// agregar cancion
	  public Cancion agregarCancion(Cancion cancion){
		 return repoCanciones.save(cancion); 
	  }
	  
	// actualizar cancion

	  public Cancion actualizaCancion(Cancion cancion) {
	      return repoCanciones.save(cancion);
	  }
}
