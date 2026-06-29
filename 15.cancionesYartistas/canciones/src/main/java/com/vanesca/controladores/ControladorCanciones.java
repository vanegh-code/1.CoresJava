package com.vanesca.controladores;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.vanesca.modelos.Artista;
import com.vanesca.modelos.Cancion;
import com.vanesca.servicios.ServicioArtistas;
import com.vanesca.servicios.ServicioCanciones;

import jakarta.validation.Valid;

@Controller
public class ControladorCanciones {

	@Autowired
	private ServicioCanciones servicio;
	
	@Autowired
    private ServicioArtistas servicioArtistas;
	
//	Mostrar canciones
	@GetMapping("/canciones")
	public String desplegarCanciones(Model model) {
		model.addAttribute("listaCanciones", servicio.obtenerTodasLasCanciones());
		return "canciones.jsp";
	}
	
	@GetMapping("/canciones/detalle/{idCancion}")
	public String desplegarDetalleCancion(@PathVariable("idCancion") Long idCancion, Model model) {
		Cancion cancion = servicio.obtenerCancionPorId(idCancion);
		model.addAttribute("cancion",cancion);
		return "detalleCancion.jsp";
	}
	
//	Parte metodo agregar canciones
	@GetMapping("/canciones/formulario/agregar")
    public String formularioAgregarCancion(@ModelAttribute("cancion") Cancion cancion, Model model) {
        model.addAttribute("listaArtistas", servicioArtistas.obtenerTodosLosArtistas());
        return "agregarCancion.jsp";
	}
	
	// metodo procesar cancion redirige a algun lugar luego del formulario
	
	@PostMapping("/canciones/procesa/agregar")
    public String procesarAgregarCancion(@Valid @ModelAttribute("cancion") Cancion cancion,
                                         BindingResult result, 
                                         Model model) {
        if (result.hasErrors()) {
            model.addAttribute("listaArtistas", servicioArtistas.obtenerTodosLosArtistas());
            return "agregarCancion.jsp";
		}
        
        //verificar si selecciono un artista del formulario
        if (cancion.getArtista() != null && cancion.getArtista().getId() != null) {
            Artista artistaAsociado = servicioArtistas.obtenerArtistaPorId(cancion.getArtista().getId());
            cancion.setArtista(artistaAsociado);
        }
        
		servicio.agregarCancion(cancion);
		return "redirect:/canciones";
	}
	// 1. Muestra el formulario con los datos cargados de la canción seleccionada
	@GetMapping("/canciones/formulario/editar/{idCancion}")
	public String formularioEditarCancion(@PathVariable("idCancion") Long idCancion, Model model) {
	    Cancion cancion = servicio.obtenerCancionPorId(idCancion);
	    model.addAttribute("cancion", cancion);
	    return "editarCancion.jsp";
	}

		
	// 2. Procesa la actualización y valida que cumpla  restricciones del modelo
	
	@PutMapping("/canciones/procesa/editar/{idCancion}")
	public String procesarEditarCancion(@PathVariable("idCancion") Long idCancion,
	                                    @Valid @ModelAttribute("cancion") Cancion cancion, 
	                                    BindingResult result) {
	    if (result.hasErrors()) {
	        // Si hay errores de validación, vuelve a cargar la vista con los mensajes de error
	        return "editarCancion.jsp";
	    }
	    // asegura mantener el ID correcto del parámetro
	    cancion.setId(idCancion); 
	    servicio.actualizaCancion(cancion);
	    return "redirect:/canciones";
	}
	// eliminar cancion
	@DeleteMapping("/canciones/eliminar/{idCancion}")
	public String procesarEliminarCancion(@PathVariable("idCancion") Long idCancion) {
	    servicio.eliminaCancion(idCancion);
	    return "redirect:/canciones";
	}
	
}