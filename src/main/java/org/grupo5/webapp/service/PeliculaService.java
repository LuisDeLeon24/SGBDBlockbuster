
package org.grupo5.webapp.service;

import jakarta.persistence.EntityManager;
import java.util.List;
import org.grupo5.webapp.model.Pelicula;
import org.grupo5.webapp.util.JPAUtil;

public class PeliculaService implements IPeliculaService{
    
    private EntityManager em;
    
    public PeliculaService(){
        this.em = JPAUtil.getEntityManager();
    }
    
    @Override
    public List<Pelicula> listarPeliculas() {
        return em.createQuery("SELECT p FROM Pelicula p", Pelicula.class).getResultList();
    }

    @Override
    public void agregarPelicula(Pelicula pelicula) {
        em.persist(pelicula);
    }

    @Override
    public void eliminarPelicula(int peliculaId) {
    }

    @Override
    public Pelicula buscarPeliculaId(int peliculaId) {
        Pelicula pelicula = null;
        return pelicula;
    }

    @Override
    public void editarPelicula(Pelicula pelicula) {
    }
    
}
