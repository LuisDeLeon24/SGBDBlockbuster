package org.grupo5.webapp.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import java.util.List;
import org.grupo5.webapp.model.Cliente;
import org.grupo5.webapp.model.Membresia;
import org.grupo5.webapp.util.JPAUtil;

public class ClienteService implements IClienteService {

    private EntityManager em;

    public ClienteService() {
        this.em = JPAUtil.getEntityManager();
    }

    @Override
    public List<Cliente> listarClientes() {
        return em.createQuery("SELECT c FROM Cliente c", Cliente.class).getResultList();
    }

    @Override
    public void agregarCliente(Cliente cliente) {
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.persist(cliente);
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public void eliminarCliente(int clienteId) {
    }

    @Override
    public Cliente buscarClienteId(int clienteId) {
        return em.find(Cliente.class, clienteId);
    }

    @Override
    public void editarCliente(Cliente cliente) {
    }

}
