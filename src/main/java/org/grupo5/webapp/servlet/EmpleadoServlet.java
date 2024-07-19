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
import org.grupo5.webapp.model.Empleado;
import org.grupo5.webapp.model.Tienda;
import org.grupo5.webapp.service.EmpleadoService;

/**
 *
 * @author informatica
 */
@WebServlet("/empleado-servlet")
@MultipartConfig
public class EmpleadoServlet extends HttpServlet {
    private EmpleadoService empleadoService;
    @Override
    public void init() throws ServletException{
        super.init();
        this.empleadoService = new EmpleadoService();
    }
    
    @Override
    protected void doGet (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String parametro = req.getParameter("parametro");

        if (parametro.equals("1")) {
            List<Empleado> empleados = empleadoService.listarempleados();
            req.setAttribute("empleados", empleados);
            req.getRequestDispatcher("./Empleados/formulario-Empleado/formulario-Empleado.jsp").forward(req, resp);
        } else if (parametro.equals("2")) {
            List<Empleado> empleados = empleadoService.listarempleados();
            req.setAttribute("empleados", empleados);
            req.getRequestDispatcher("./Empleados/listar-Empleados/listar-Empleados.jsp").forward(req, resp);
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getPathInfo();

        if (path == null || path.equals("/")) {
            agregarEmpleados(req, resp);
        } else {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
        }
        List<String> datosEmpleado = new ArrayList<>();
        String nombreEmpleado = req.getParameter("nombreEmpleado");
        String puesto = req.getParameter("puestoEmpleado");
        String salario = req.getParameter("salario");
        String tiendaId = req.getParameter("tiendaId");
        
        datosEmpleado.add("Nombre : " + nombreEmpleado);
        datosEmpleado.add("puesto : " + puesto);
        datosEmpleado.add(" Salario : " + salario);
        datosEmpleado.add("tienda Id: " + tiendaId);
        String msj = null;
        
        if(nombreEmpleado.isBlank()){
        datosEmpleado.add("nombreEmpleado: " + nombreEmpleado);
        }
        
        if(puesto.isBlank()){
        datosEmpleado.add("puestoEmpleado: " + puesto);
        }
        if(salario.isBlank()){
        datosEmpleado.add("Salario: " + salario);
        }
        if(tiendaId.isBlank()){
        datosEmpleado.add("tiendaId2: " + tiendaId);
        }
        req.setAttribute("mensaje", msj);
        req.setAttribute("datosEmpleado", datosEmpleado);
    }
    
    public void agregarEmpleados(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nombreEmpleado = req.getParameter("nombreEmpleado");
        String puesto = req.getParameter("puestoEmpleado");
        double salario = Double.parseDouble(req.getParameter("salario"));
        int tiendaId2 = Integer.parseInt(req.getParameter("tiendaId2"));

        empleadoService.agregarEmpleado(new Empleado(nombreEmpleado, puesto, salario, tiendaId2));

        resp.sendRedirect(req.getContextPath() + "/");

    }
}
