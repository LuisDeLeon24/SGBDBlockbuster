package org.grupo5.webapp.service;

import java.util.List;
import org.grupo5.webapp.model.Tienda;

public interface ITiendaService {
    public List<Tienda> listarTiendas();
    
    public void agregarTienda(Tienda tienda);
    
    public void eliminarTienda(int tiendaId);
    
    public Tienda buscarTienda(int tiendaId);
    
    public void editarTienda(Tienda tienda);
}
