package org.grupo5.webapp.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;



@Entity
@Table(name="Membresias")
public class Membresia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int membresiaId;
    private String tipo;
    private double costo;
    private String beneficios;

    public Membresia() {
    }

    public Membresia(String tipo, double costo, String beneficios) {
        this.tipo = tipo;
        this.costo = costo;
        this.beneficios = beneficios;
    }

    public Membresia(int membresiaId, String tipo, double costo, String beneficios) {
        this.membresiaId = membresiaId;
        this.tipo = tipo;
        this.costo = costo;
        this.beneficios = beneficios;
    }

    public int getMembresiaId() {
        return membresiaId;
    }

    public void setMembresiaId(int membresiaId) {
        this.membresiaId = membresiaId;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public String getBeneficios() {
        return beneficios;
    }

    public void setBeneficios(String beneficios) {
        this.beneficios = beneficios;
    }

    @Override
    public String toString() {
        return "Membresia{" + "membresiaId=" + membresiaId + ", tipo=" + tipo + ", costo=" + costo + ", beneficio=" + beneficios + '}';
    }
    
    
}
