/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.grupo5.webapp.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.grupo5.webapp.model.Pelicula;
import org.grupo5.webapp.service.PeliculaService;

@WebServlet("/pelicula-servlet")
@MultipartConfig
public class PeliculaServlet extends HttpServlet {
   
    private PeliculaService peliculaService;
    
    @Override
    public void init() throws ServletException{
        super.init();
        this.peliculaService = new PeliculaService();
    }
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Pelicula> peliculas = peliculaService.listarPeliculas();
        req.setAttribute("peliculas", peliculas);
        req.getRequestDispatcher("./peliculas/lista-peliculas/lista-peliculas.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<String> datosPelicula = new ArrayList<>();
        String titulo = req.getParameter("titulo");
        String genero = req.getParameter("genero");
        String estreno = req.getParameter("estreno");
        String director = req.getParameter("director");

        datosPelicula.add("Titulo : " + titulo);
        datosPelicula.add("Marca : " + genero);
        datosPelicula.add("Estreno: " + estreno);
        datosPelicula.add("Director: " + director);

        String msj = null;

        if (titulo.isEmpty()) {
            msj = " El Campo De Titulo Necesita Llenarse =(!";
        } else if (genero.isEmpty()) {
            msj = "El Campo De Genero Necesita Llenarse =(";
        } else if (estreno.isEmpty()) {
            msj = "El Campo De Estreno Necesita Llenarse=(";
        } else if (director.isEmpty()) {
            msj = "El Campo De Director Necesita Llenarse =(";
        }

        req.setAttribute("mensaje", msj);
        req.setAttribute("datosPelicula", datosPelicula);

        getServletContext().getRequestDispatcher("/formulario-peliculas/formulario-peliculas.jsp").forward(req, resp);

    }



}
