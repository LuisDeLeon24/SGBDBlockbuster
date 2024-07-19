/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.grupo5.webapp.service;

import jakarta.persistence.EntityManager;
import java.util.List;
import org.grupo5.webapp.model.Empleado;
import org.grupo5.webapp.model.Tienda;
import org.grupo5.webapp.util.JPAUtil;

/**
 *
 * @author senor
 */
public class TiendaService implements ITiendaService{

    private EntityManager em;

    public TiendaService() {
        this.em = JPAUtil.getEntityManager();
    }

    @Override
    public List<Tienda> listarTiendas() {
        return em.createQuery("SELECT t FROM Tienda t", Tienda.class).getResultList();
    }

    @Override
    public void agregarTienda(Tienda tienda) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void eliminarTienda(int tiendaId) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Tienda buscarTienda(int tiendaId) {
        return em.find(Tienda.class, tiendaId);
    }

    @Override
    public void editarTienda(Tienda tienda) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
