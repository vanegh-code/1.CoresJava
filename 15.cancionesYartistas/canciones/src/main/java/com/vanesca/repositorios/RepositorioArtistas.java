package com.vanesca.repositorios;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.vanesca.modelos.Artista;

// Anotación @Repository para marcar la interfaz como componente de acceso a datos
@Repository
//  Extensión de CrudRepository asociando el modelo Artista y su tipo de ID (Long)
public interface RepositorioArtistas extends CrudRepository<Artista, Long> {

    // Método para recuperar la lista completa de artistas de la base de datos
    List<Artista> findAll();
}