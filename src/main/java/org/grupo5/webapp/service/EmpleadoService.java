/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.grupo5.webapp.service;

import jakarta.persistence.EntityManager;
import java.util.List;
import org.grupo5.webapp.model.Empleado;
import org.grupo5.webapp.util.JPAUtil;

/**
 *
 * @author informatica
 */
public class EmpleadoService implements IEmpleadoService {
    private EntityManager em;
    
    public EmpleadoService(){
        this.em = JPAUtil.getEntityManager();
    }

    @Override
    public List<Empleado> listarempleados(){
        return em.createQuery("SELECT e FROM Empleados e", Empleado.class).getResultList();
    }

    @Override
    public void agregarEmpleado(Empleado empleado) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void eliminarEmpleado(int empleadoId) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Empleado buscarEmpleadoProId(int empleadoId) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
