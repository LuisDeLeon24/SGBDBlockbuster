
import jakarta.persistence.EntityManager;
import java.util.List;
import org.grupo5.webapp.model.Empleado;
import org.grupo5.webapp.util.JPAUtil;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author robin
 */
public class Main {
    private static EntityManager em = JPAUtil.getEntityManager();
    
    public static void main(String [] args){
        List<Empleado> empleados = em.createQuery("SELECT e FROM Empleado e", Empleado.class).getResultList();
        empleados.forEach(empleado -> System.out.println(empleado));
    }
}
