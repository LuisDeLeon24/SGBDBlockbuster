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
    protected void doGet (HttpServletRequest req, HttpServletResponse resq) throws ServletException, IOException {
        List<Empleado>empleados = empleadoService.listarempleados();
        req.setAttribute("empleados", empleados);
        req.getRequestDispatcher(".listar-Empleados/listar-Empleados-jsp").forward(req, resq);
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<String> datosEmpleado = new ArrayList<>();
        String mensaje = "";
        String nombreEmpleado = req.getParameter("nombreEmpleado");
        String puesto = req.getParameter("puesto");
        String salario = req.getParameter("salario");
        String tiendaId = req.getParameter("tiendaId");
        
        if(nombreEmpleado.isBlank()){
        datosEmpleado.add("Nombre Empleado: " + nombreEmpleado);
        }
        
        if(puesto.isBlank()){
        datosEmpleado.add("Nombre puesto: " + puesto);
        }
        if(salario.isBlank()){
        datosEmpleado.add("Salario: " + salario);
        }
        if(tiendaId.isBlank()){
        datosEmpleado.add("tiendaId: " + tiendaId);
        }
        
    }
}
