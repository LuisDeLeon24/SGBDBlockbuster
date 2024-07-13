
package org.grupo5.webapp.service;

import java.util.List;
import org.grupo5.webapp.model.Cliente;


public interface IClienteService {
     public List<Cliente>listarClientes();
    
    public void agregarCliente(Cliente cliente);
    
    public void eliminarCliente(int peliculaId);
    
    public Cliente buscarClienteId(int clienteId);
    
    public void editarCliente(Cliente cliente);
}
