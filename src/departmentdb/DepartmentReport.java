package departmentdb;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;
import model.Department;
import model.Employee;

public class DepartmentReport {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("departmentdbPU");
        EntityManager em = emf.createEntityManager();

        // แสดงข้อมูลของทุกพนักงาน (ตาม ID)
        List<Employee> employees = em.createQuery("SELECT e FROM Employee e").getResultList();
        System.out.println("All employee (by ID)");
        System.out.println("---------------------------");
        for (Employee employee : employees) {
            System.out.println("ID: " + employee.getEmployeeid());
            System.out.println("Name: " + employee.getName());
            System.out.println("Job: " + employee.getJob());
            System.out.println("Salary: " + employee.getSalary());
            System.out.println("Department: " + employee.getDepartmentid().getName());
            System.out.println("---------------------------");
        }

        // แสดงข้อมูลของทุกพนักงาน (ตามแผนก)
        List<Department> departments = em.createQuery("SELECT d FROM Department d").getResultList();
        System.out.println("All employee (by Department)");
        System.out.println("---------------------------");
        for (Department department : departments) {
            System.out.print("Department ID: " + department.getDepartmentid());
            System.out.println(" Department Name: " + department.getName());
            System.out.println("---------------------------");
            List<Employee> employeesInDepartment = em.createQuery("SELECT e FROM Employee e WHERE e.departmentid = :department")
                    .setParameter("department", department)
                    .getResultList();
            for (Employee employee : employeesInDepartment) {
                System.out.println("ID: " + employee.getEmployeeid());
                System.out.println("Name: " + employee.getName());
                System.out.println("Job: " + employee.getJob());
                System.out.println("Salary: " + employee.getSalary());
                System.out.println("---------------------------");
            }
        }

        em.close();
        emf.close();
    }
}
