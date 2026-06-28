package com.vanesca.controladores;

	import java.util.HashMap;

	import org.springframework.stereotype.Controller;
	import org.springframework.ui.Model;
	import org.springframework.web.bind.annotation.GetMapping;
	import org.springframework.web.bind.annotation.PathVariable;


	@Controller
	public class ControladorRecetas {

	   
	    private static String[] listaRecetas = {"Pizza", "Espagueti", "Lasaña"};
	    private static HashMap<String, String[]> recetasConIngredientes = new HashMap<String, String[]>();

	    // Constructor para llenar los datos 
	    
	    public ControladorRecetas() {
	        String[] pizza = {"Pan", "Salsa de tomate", "Queso", "Pepperoni"};
	        recetasConIngredientes.put("Pizza", pizza);
	        
	        String[] espagueti = {"Pasta", "Salsa de tomate", "Carne molida", "Queso parmesano"};
	        recetasConIngredientes.put("Espagueti", espagueti);
	        
	        String[] lasaña = {"Pasta", "Salsa de tomate", "Queso", "Albahaca", "Espinaca", "Champiñones"};
	        recetasConIngredientes.put("Lasaña", lasaña);
	    }

	    // Ruta para obtener todas las recetas
	    @GetMapping("/recetas")
	    public String obtenerTodasLasRecetas(Model modelo) {
	        modelo.addAttribute("listaRecetas", listaRecetas);
	        return "recetas.jsp"; // Redirige a recetas.jsp
	    }

	    // Ruta para ver el detalle de una receta especifica
	    @GetMapping("/recetas/{nombre}")
	    public String obtenerRecetaPorNombre(@PathVariable("nombre") String nombre, Model modelo) {

	    	modelo.addAttribute("nombreReceta",nombre);
	    	
	        // Buscamos si la receta existe en nuestro HashMap
	        if(recetasConIngredientes.containsKey(nombre)) {
	        	modelo.addAttribute("ingredientes", recetasConIngredientes.get(nombre));
	        	
	        } else {
	        	 // Si no existe, mandamos un indicador de error y el mensaje solicitado
	        	 
	        	   modelo.addAttribute("mensajeError", "La receta no se encuentra en nuestra lista.");

	        }
	            
	        	    	
	        return "detalleReceta.jsp"; 
	        // Redirige a detalleReceta.jsp
	    }
	}