/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.grupo5.webapp.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 *
 * @author informatica
 */
@Table(name="Empleados")
@Entity
public class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long empleadoId;
    private String nombreEmpleado;
    private String puesto;
    private double salario;
    private int tiendaId2;
    @ManyToOne
    @JoinColumn(name = "tiendaId")
    private Tienda tiendaId;

    public Empleado() {
    }

    public Empleado(String nombreEmpleado, String puesto, double salario, Tienda tiendaId) {
        this.nombreEmpleado = nombreEmpleado;
        this.puesto = puesto;
        this.salario = salario;
        this.tiendaId = tiendaId;
    }

    public Empleado(String nombreEmpleado, String puesto, double salario, int tiendaId2) {
        this.nombreEmpleado = nombreEmpleado;
        this.puesto = puesto;
        this.salario = salario;
        this.tiendaId2 = tiendaId2;
    }
    

    public Empleado(long empleadoId, String nombreEmpleado, String puesto, double salario, Tienda tiendaId) {
        this.empleadoId = empleadoId;
        this.nombreEmpleado = nombreEmpleado;
        this.puesto = puesto;
        this.salario = salario;
        this.tiendaId = tiendaId;
    }

    

    public long getEmpleadoId() {
        return empleadoId;
    }

    public void setEmpleadoId(long empleadoId) {
        this.empleadoId = empleadoId;
    }

    public String getNombreEmpleado() {
        return nombreEmpleado;
    }

    public void setNombreEmpleado(String nombreEmpleado) {
        this.nombreEmpleado = nombreEmpleado;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
        
    }

    public Tienda getTiendaId() {
        return tiendaId;
    }

    public void setTiendaId(Tienda tiendaId) {
        this.tiendaId = tiendaId;
    }

    public int getTiendaId2() {
        return tiendaId2;
    }

    public void setTiendaId2(int tiendaId2) {
        this.tiendaId2 = tiendaId2;
    }
    
    
    @Override
    public String toString() {
        return "Empleado{" + "empleadoId=" + empleadoId + ", nombreEmpleado=" + nombreEmpleado + ", puesto=" + puesto + ", salario=" + salario + ", tiendaId=" + tiendaId.getDireccion() + '}';
    }

    

}
