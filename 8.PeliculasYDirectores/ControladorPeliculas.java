package com.vanesca.demo.controladores;

import java.util.HashMap;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/peliculas")
public class ControladorPeliculas {

	private static HashMap<String, String> listaPeliculas = new HashMap<String, String>();
	
	public ControladorPeliculas() {
		listaPeliculas.put("Winnie the Pooh", "Don Hall");	
		listaPeliculas.put("El zorro y el sabueso", "Ted Berman");
		listaPeliculas.put("Tarzán", "Kevin Lima");		
		listaPeliculas.put("Mulán", "Barry Cook");
		listaPeliculas.put("Oliver", "Kevin Lima");	
		listaPeliculas.put("Big Hero 6", "Don Hall");
	}
	
	//metodo para buscar todas las peliculas
	
	@GetMapping("")
	public String obtenerTodasLasPeliculas() {
		String peliculas = "";
		
		for(String pelicula : listaPeliculas.keySet()) {
			String director = listaPeliculas.get(pelicula);
			peliculas += pelicula + ", " + director + "<br>";
		}
		return peliculas;
	}
	
	//metodo para buscar pelicula por nombre
	
	@GetMapping("/{nombre}")
	public String obtenerPeliculaPorNombre(@PathVariable("nombre")String nombre) {
		
		for(String pelicula : listaPeliculas.keySet()) {
			if(pelicula.equals(nombre)) {
			return "Película: " + pelicula + ", Director: " + listaPeliculas.get(pelicula);
			}
		}
			return "La película no se encuentra en la lista";
		
		}
	
	// metodo buscar informacion de pelicula por el nombre del director
	
	@GetMapping("/director/{nombre}")
	public String obtenerPeliculasPorDirector(@PathVariable("nombre") String nombre) {
	    String resultado = "";

	    for (String pelicula : listaPeliculas.keySet()) {
	        String director = listaPeliculas.get(pelicula);
	        if (director.equalsIgnoreCase(nombre)) {
	            resultado += "Pelicula: " + pelicula + ", dirigida por " + director + "<br>";
	        }
	    }

	    return resultado.isEmpty() ? "No contamos con películas con ese director en nuestra lista." : resultado;
	}
	
	
	
	
	
}
