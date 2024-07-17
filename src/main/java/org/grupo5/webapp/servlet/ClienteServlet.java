
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
import org.grupo5.webapp.model.Cliente;
import org.grupo5.webapp.service.ClienteService;

@WebServlet("/cliente-servlet")
@MultipartConfig
public class ClienteServlet extends HttpServlet{
   
    private ClienteService clienteService;
    
    @Override
    public void init() throws ServletException{
        super.init();
        this.clienteService = new ClienteService();
    }
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Cliente> clientes = clienteService.listarClientes();
        req.setAttribute("clientes", clientes);
        req.getRequestDispatcher("./cliente/lista-clientes/lista-clientes.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getPathInfo();
        
        if(path == null || path.equals("/")){
            agregarCliente(req, resp);
        }else{
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
        }
        
        List<String> datosCliente = new ArrayList<>();
        String nombreCliente = req.getParameter("nombreCliente");
        String telefono = req.getParameter("telefono");
        String generoFavorito = req.getParameter("generoFavorito");
        String membresiaId = req.getParameter("membresiaId");

        datosCliente.add("Nombre : " + nombreCliente);
        datosCliente.add("Telefono : " + telefono);
        datosCliente.add("Genero Favorito : " + generoFavorito);
        datosCliente.add("Membresia Id: " + membresiaId);

        String msj = null;

        if (nombreCliente.isEmpty()) {
            msj = " El Campo De Nombre Necesita Llenarse =(!";
        } else if (telefono.isEmpty()) {
            msj = "El Campo De Telefono Necesita Llenarse =(";
        } else if (generoFavorito.isEmpty()) {
            msj = "El Campo De Genero Favorito Necesita Llenarse=(";
        } else if (membresiaId.isEmpty()) {
            msj = "El Campo De Membresia Necesita Llenarse =(";
        }

        req.setAttribute("mensaje", msj);
        req.setAttribute("datosCliente", datosCliente);

        //getServletContext().getRequestDispatcher("/formulario-clientes/formulario-clientes.jsp").forward(req, resp);

    }
    
    public void agregarCliente(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nombre = req.getParameter("nombreCliente");
        String telefono = req.getParameter("telefono");
        String genero = req.getParameter("generoFavorito");
        int membresiaId = Integer.parseInt(req.getParameter("membresiaId"));
        
        clienteService.agregarCliente(new Cliente(nombre, telefono, genero, membresiaId));
        
        resp.sendRedirect(req.getContextPath()+ "/");

    }


   
}
