
package org.grupo5.webapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Clientes")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long clienteId;
    private String nombreCliente;
    private String telefono;
    private String generoFavorito;
    private long membresiaId;

    public Cliente() {
    }

    public Cliente(long clienteId, String nombreCliente, String telefono, String generoFavorito, long membresiaId) {
        this.clienteId = clienteId;
        this.nombreCliente = nombreCliente;
        this.telefono = telefono;
        this.generoFavorito = generoFavorito;
        this.membresiaId = membresiaId;
    }

    public Cliente(String nombreCliente, String telefono, String generoFavorito, long membresiaId) {
        this.nombreCliente = nombreCliente;
        this.telefono = telefono;
        this.generoFavorito = generoFavorito;
        this.membresiaId = membresiaId;
    }

    public long getClienteId() {
        return clienteId;
    }

    public void setClienteId(long clienteId) {
        this.clienteId = clienteId;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getGeneroFavorito() {
        return generoFavorito;
    }

    public void setGeneroFavorito(String generoFavorito) {
        this.generoFavorito = generoFavorito;
    }

    public long getMembresiaId() {
        return membresiaId;
    }

    public void setMembresiaId(long membresiaId) {
        this.membresiaId = membresiaId;
    }
    

    @Override
    public String toString() {
        return "Cliente{" + "clienteId=" + clienteId + ", nombreCliente=" + nombreCliente + ", telefono=" + telefono + ", generoFavorito=" + generoFavorito + ", membresiaId=" + membresiaId + '}';
    }
    
    
}
