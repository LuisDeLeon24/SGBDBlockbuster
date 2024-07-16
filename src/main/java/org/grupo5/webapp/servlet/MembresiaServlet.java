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
import org.grupo5.webapp.model.Membresia;
import org.grupo5.webapp.service.MembresiaService;

@WebServlet("/membresia-servlet")
@MultipartConfig
public class MembresiaServlet extends HttpServlet {
   
    private MembresiaService membresiaService;
    
    @Override
    public void init() throws ServletException{
        super.init();
        this.membresiaService = new MembresiaService();
    }
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Membresia> membresias = membresiaService.listarMembresias();
        req.setAttribute("membresias", membresias);
        req.getRequestDispatcher("./membresias/lista-membresias/lista-membresias.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<String> datosMembresia = new ArrayList<>();
        String tipo = req.getParameter("tipo");
        String costo = req.getParameter("costo");
        String beneficios = req.getParameter("beneficios");

        datosMembresia.add("Tipo : " + tipo);
        datosMembresia.add("Costo : " + costo);
        datosMembresia.add("Beneficio: " + beneficios);

        String msj = null;

        if (tipo.isEmpty()) {
            msj = " El Campo De Tipo Necesita Llenarse =(!";
        } else if (costo.isEmpty()) {
            msj = "El Campo De Costo Necesita Llenarse =(";
        } else if (beneficios.isEmpty()) {
            msj = "El Campo De Beneficio Necesita Llenarse=(";
        }

        req.setAttribute("mensaje", msj);
        req.setAttribute("datosMembresia", datosMembresia);


    }



}
