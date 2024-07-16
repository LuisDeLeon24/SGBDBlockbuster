
package org.grupo5.webapp.service;

import jakarta.persistence.EntityManager;
import java.util.List;
import org.grupo5.webapp.model.Membresia;
import org.grupo5.webapp.util.JPAUtil;

public class MembresiaService implements IMembresiaService{
    
    private EntityManager em;
    
    public MembresiaService(){
        this.em = JPAUtil.getEntityManager();
    }
    
    @Override
    public List<Membresia> listarMembresias() {
        return em.createQuery("SELECT m FROM Membresia m", Membresia.class).getResultList();
    }

    @Override
    public void agregarMembresia(Membresia membresia) {
        em.persist(membresia);
    }

    @Override
    public void eliminarMembresia(int membresiaId) {
    }

    @Override
    public Membresia buscarMembresiaId(int membresiaId) {
        Membresia membresia = null;
        return membresia;
    }

    @Override
    public void editarMembresia(Membresia membresia) {
    }
    
}
