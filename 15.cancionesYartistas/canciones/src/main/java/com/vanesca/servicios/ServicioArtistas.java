package com.vanesca.servicios;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.vanesca.modelos.Artista;
import com.vanesca.repositorios.RepositorioArtistas;

// Anotación @Service para registrar la clase en el contenedor de Spring
@Service
public class ServicioArtistas {

    //  dependencia del repositorio de artistas
    @Autowired
    private RepositorioArtistas repoArtistas;

    // Devuelve una lista de objetos Artista de la tabla artistas
    public List<Artista> obtenerTodosLosArtistas() {
        return this.repoArtistas.findAll();
    }

    // Devuelve un solo objeto Artista por id sino devuelve null.
    public Artista obtenerArtistaPorId(Long id) {
        return this.repoArtistas.findById(id).orElse(null);
    }

    // Agrega el artista a la base de datos y lo devuelve creado
    public Artista agregarArtista(Artista artista) {
        return this.repoArtistas.save(artista);
    }
}