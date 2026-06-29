package com.vanesca.controladores;

import java.util.List;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.vanesca.modelos.Artista;
import com.vanesca.servicios.ServicioArtistas;

@Controller
public class ControladorArtistas {

    @Autowired
    private ServicioArtistas servicioArtistas;

    // Ruta: "/artistas" - Devuelve la lista completa de artistas a artistas.jsp
    @GetMapping("/artistas")
    public String desplegarArtistas(Model model) {
        List<Artista> lista = servicioArtistas.obtenerTodosLosArtistas();
        model.addAttribute("listaArtistas", lista);
        return "artistas.jsp";
    }

    // Ruta: "/artistas/detalle/{idArtista}" - Envía el detalle a detalleArtista.jsp
    @GetMapping("/artistas/detalle/{idArtista}")
    public String desplegarDetalleArtista(@PathVariable("idArtista") Long idArtista, Model model) {
        Artista artista = servicioArtistas.obtenerArtistaPorId(idArtista);
        model.addAttribute("artista", artista);
        return "detalleArtista.jsp";
    }

    // Ruta: "/artistas/formulario/agregar" - Carga un objeto vacío para el formulario
    @GetMapping("/artistas/formulario/agregar")
    public String formularioAgregarArtista(@ModelAttribute("artista") Artista artista) {
        return "agregarArtista.jsp";
    }

    // Ruta: "/artistas/procesa/agregar" - Procesa el envío y valida los campos
    @PostMapping("/artistas/procesa/agregar")
    public String procesarAgregarArtista(@Valid @ModelAttribute("artista") Artista artista, 
                                         BindingResult result) {
        if (result.hasErrors()) {
            return "agregarArtista.jsp";
        }
        servicioArtistas.agregarArtista(artista);
        return "redirect:/artistas";
    }
}