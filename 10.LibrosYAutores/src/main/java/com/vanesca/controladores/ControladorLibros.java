package com.vanesca.controladores;

import java.util.HashMap;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ControladorLibros {

	private static HashMap<String, String> listaLibros = new HashMap<String, String>();	
	
	public ControladorLibros() {
		listaLibros.put("Odisea", "Homero");	
		listaLibros.put("Don Quijote de la Mancha", "Miguel de Cervantes");
		listaLibros.put("El Código Da Vinci", "Dan Brown");		
		listaLibros.put("Alicia en el país de las maravillas", "Lewis Carroll");
		listaLibros.put("El Hobbit", "J.R.R. Tolkien");	
		listaLibros.put("El alquimista", "Paulo Coelho");	
	}
		// 1. Método que responde a la ruta /libros y retorna libros.jsp
	
		@GetMapping("/libros")
		public String obtenerTodosLosLibros(Model modelo) {
			
			// los nombres de los libros a la vista
			modelo.addAttribute("listaLibros", listaLibros.keySet());
			return "libros.jsp";
		}
				// 2. Método que responde a la ruta /libros/{nombre} y retorna detalleLibro.jsp
		@GetMapping("/libros/{nombre}")
		public String obtenerInformacionDelLibro(@PathVariable("nombre") String nombre, Model modelo) {
			if (listaLibros.containsKey(nombre)) {
				modelo.addAttribute("nombreLibro", nombre);
				modelo.addAttribute("nombreAutor", listaLibros.get(nombre));
				modelo.addAttribute("encontrado", true);
			} else {
				modelo.addAttribute("encontrado", false);
				modelo.addAttribute("mensajeError", "El libro no se encuentra en nuestra lista.");
			}
			return "detalleLibro.jsp";
		}
				// 3. Método que responde a la ruta /libros/formulario y retorna formularioLibros.jsp
		@GetMapping("/libros/formulario")
		public String formularioLibro() {
			return "formularioLibros.jsp";
		}
				// 4. Método que responde a la ruta /procesar/libro mediante POST y redirecciona
		@PostMapping("/procesar/libro")
		public String procesarLibro(@RequestParam("nombreLibro") String nombreLibro, 
				                    @RequestParam("nombreAutor") String nombreAutor) {
			// Guardamos el nuevo libro recibido desde el formulario
			listaLibros.put(nombreLibro, nombreAutor);
			// Redireccionamos limpiamente a la ruta de la lista
			return "redirect:/libros";
		}
		// 5. Método que procesa la búsqueda y redirige a la vista de detalle
		@GetMapping("/libros/buscar")
		public String buscarLibro(@RequestParam("nombreLibro") String nombreLibro) {
			// Redirige dinámicamente a la ruta de detalle /libros/{nombre}
			return "redirect:/libros/" + nombreLibro;
		}
	}
