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
import org.grupo5.webapp.model.Tienda;
import org.grupo5.webapp.service.TiendaService;

@WebServlet("/tienda-servlet")
@MultipartConfig
public class TiendaServlet extends HttpServlet {

    private TiendaService tiendaService;

    @Override
    public void init() throws ServletException {
        super.init();
        this.tiendaService = new TiendaService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Tienda> tiendas = tiendaService.listarTiendas();
        req.setAttribute("tiendas", tiendas);
        req.getRequestDispatcher("./Tienda/Listar-Tiendas/listar-Tiendas.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<String> tiendasList = new ArrayList<>();
        int tiendaId = Integer.parseInt(req.getParameter("tiendaId"));
        String direccion = req.getParameter("direccion");
        String ciudad = req.getParameter("ciudad");
        String tematica = req.getParameter("tematica");
        
        
        if (tiendaId==0) {
            tiendasList.add("ID: " + tiendaId);
        }
        if (direccion.isBlank()) {
            tiendasList.add("Direccion: " + direccion);
        }
        if (ciudad.isBlank()) {
            tiendasList.add("Salario: " + ciudad);
        }
        if (tematica.isBlank()) {
            tiendasList.add("tiendaId: " + tematica);
        }
    }
    
    

}
