
package org.grupo5.webapp.service;

import java.util.List;
import org.grupo5.webapp.model.Membresia;


public interface IMembresiaService {
    public List<Membresia>listarMembresias();
    
    public void agregarMembresia(Membresia membresia);
    
    public void eliminarMembresia(int membresiaId);
    
    public Membresia buscarMembresiaId(int membresiaId);
    
    public void editarMembresia(Membresia membresia);
}
