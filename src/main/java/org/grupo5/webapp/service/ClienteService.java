
package org.grupo5.webapp.service;

import jakarta.persistence.EntityManager;
import java.util.List;
import org.grupo5.webapp.model.Cliente;
import org.grupo5.webapp.util.JPAUtil;


public class ClienteService implements IClienteService{
        
    private EntityManager em;
    
    public ClienteService(){
        this.em = JPAUtil.getEntityManager();
    }
    
    @Override
    public List<Cliente> listarClientes() {
        return em.createQuery("SELECT c FROM Cliente c", Cliente.class).getResultList();
    }

    @Override
    public void agregarCliente(Cliente cliente) {
        em.persist(cliente);
    }

    @Override
    public void eliminarCliente(int clienteId) {
    }

    @Override
    public Cliente buscarClienteId(int clienteId) {
        Cliente cliente = null;
        return cliente;
    }

    @Override
    public void editarCliente(Cliente cliente) {
    }
    
}
