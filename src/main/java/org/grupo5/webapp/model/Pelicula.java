package org.grupo5.webapp.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Peliculas")
public class Pelicula {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long peliculaId;
    private String titulo;
    private String genero;
    private String estreno;
    private String director;

    public Pelicula() {
    }

    public Pelicula(long peliculaId, String titulo, String genero, String estreno, String director) {
        this.peliculaId = peliculaId;
        this.titulo = titulo;
        this.genero = genero;
        this.estreno = estreno;
        this.director = director;
    }

    public Pelicula(String titulo, String genero, String estreno, String director) {
        this.titulo = titulo;
        this.genero = genero;
        this.estreno = estreno;
        this.director = director;
    }

    public long getPeliculaId() {
        return peliculaId;
    }

    public void setPeliculaId(long peliculaId) {
        this.peliculaId = peliculaId;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getEstreno() {
        return estreno;
    }

    public void setEstreno(String estreno) {
        this.estreno = estreno;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    @Override
    public String toString() {
        return "Pelicula{" + "peliculaId=" + peliculaId + ", titulo=" + titulo + ", genero=" + genero + ", estreno=" + estreno + ", director=" + director + '}';
    }
    
    
}
