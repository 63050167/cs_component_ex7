/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package departmentdb;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import model.Department;
import model.Employee;


/**
 *
 * @author pisut
 */
public class Departmentdb {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Department department1 = new Department();
        Department department2 = new Department();
        department1.setName("IT");
        department2.setName("HR");
        Employee employee1 = new Employee();
        Employee employee2 = new Employee();
        Employee employee3 = new Employee();
        Employee employee4 = new Employee();

        employee1.setName("John");
        employee1.setJob("Network Admin");
        employee1.setSalary(56789);
        employee1.setDepartmentid(department1);

        employee2.setName("Marry");
        employee2.setJob("HR Manager");
        employee2.setSalary(46789);
        employee2.setDepartmentid(department2);
        
        employee3.setName("Henry");
        employee3.setJob("Programmer");
        employee3.setSalary(67890);
        employee3.setDepartmentid(department1);
        
        employee4.setName("Clark");
        employee4.setJob("HR recruiter");
        employee4.setSalary(36789);
        employee4.setDepartmentid(department2);
        
        persist(department1);
        persist(department2);
        persist(employee1);
        persist(employee2);
        persist(employee3);
        persist(employee4);
    }

    public static void persist(Object object) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("departmentdbPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(object);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }
    
}
