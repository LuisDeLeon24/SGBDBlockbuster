/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.grupo5.webapp.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
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
        return em.createQuery("SELECT e FROM Empleado e", Empleado.class).getResultList();
    }

    @Override
    public void agregarEmpleado(Empleado empleado) {
        EntityTransaction transaction = em.getTransaction();
        try{
            transaction.begin();
            em.persist(empleado);
            transaction.commit();
        }catch(Exception e){
            if(transaction.isActive()){
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public void eliminarEmpleado(int empleadoId) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Empleado buscarEmpleadoProId(int empleadoId) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void editarEmpleado(Empleado empleado) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
