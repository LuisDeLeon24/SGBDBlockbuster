/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.grupo5.webapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 *
 * @author robin
 */
@Table(name="Tiendas")
@Entity
public class Tienda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long tiendaId;
    private String direccion;
    private String ciudad;
    private String tematica;

    public Tienda() {
    }
    
    
    public Tienda(String direccion, String ciudad, String tematica) {
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.tematica = tematica;
    }

    public Tienda(long tiendaId, String direccion, String ciudad, String tematica) {
        this.tiendaId = tiendaId;
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.tematica = tematica;
    }

    public long getTiendaId() {
        return tiendaId;
    }

    public void setTiendaId(long tiendaId) {
        this.tiendaId = tiendaId;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getTematica() {
        return tematica;
    }

    public void setTematica(String tematica) {
        this.tematica = tematica;
    }

    @Override
    public String toString() {
        return "tiendaId=" + tiendaId + ", direccion=" + direccion ;
    }
    
}