/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.grupo5.webapp.service;

import java.util.List;
import org.grupo5.webapp.model.Empleado;

/**
 *
 * @author informatica
 */
public interface IEmpleadoService {
    public List<Empleado> listarempleados();
    
    public void agregarEmpleado(Empleado empleado);
    
    public void eliminarEmpleado(int empleadoId);
    
    public Empleado buscarEmpleadoProId(int empleadoId);
}
