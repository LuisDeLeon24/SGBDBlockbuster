
package org.grupo5.webapp.service;

import java.util.List;
import org.grupo5.webapp.model.Pelicula;


public interface IPeliculaService {
    public List<Pelicula>listarPeliculas();
    
    public void agregarPelicula(Pelicula pelicula);
    
    public void eliminarPelicula(int peliculaId);
    
    public Pelicula buscarPeliculaId(int peliculaId);
    
    public void editarPelicula(Pelicula pelicula);
}
