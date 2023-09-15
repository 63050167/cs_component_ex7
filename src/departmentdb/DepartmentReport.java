package departmentdb;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import model.Department;
import model.Employee;

public class DepartmentReport {

    public static void main(String[] args) {
        // Get all employees
        List<Employee> employees = getEmployees();

        // Print all employees by ID
        printEmployeesById(employees);

        // Print all employees by department
        printEmployeesByDepartment(employees);
    }

    private static List<Employee> getEmployees() {
        // Create an EntityManager
        EntityManager em = Persistence.createEntityManagerFactory("departmentdbPU").createEntityManager();

        // Get all employees
        List<Employee> employees = em.createQuery("SELECT e FROM Employee e").getResultList();

        // Close the EntityManager
        em.close();

        return employees;
    }

    private static void printEmployeesById(List<Employee> employees) {
        System.out.println("All employee (by ID)");
        System.out.println("---------------------------");
        for (Employee employee : employees) {
            System.out.println("ID: " + employee.getEmployeeid());
            System.out.println("Name: " + employee.getName());
            System.out.println("Job: " + employee.getJob());
            System.out.println("Salary: " + employee.getSalary());
            System.out.println();
        }
    }

    private static void printEmployeesByDepartment(List<Employee> employees) {
        System.out.println("All employee (by Department)");
        System.out.println("---------------------------");
        for (Employee employee : employees) {
            // Get the department of the employee
            Department department = employee.getDepartmentid();

            // Print the employee information
            System.out.println("Department ID: " + department.getDepartmentid());
            System.out.println("Department Name: " + department.getName());
            System.out.println("ID: " + employee.getEmployeeid());
            System.out.println("Name: " + employee.getName());
            System.out.println("Job: " + employee.getJob());
            System.out.println("Salary: " + employee.getSalary());
            System.out.println();
        }
    }
}
