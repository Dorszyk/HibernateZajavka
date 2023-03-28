package org.example5;


import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.List;
import java.util.Set;

public class ManyToManyRunner {

    public static void main(String[] args) {

        EmployeeRepository employeeRepository = new EmployeeRepository();
        employeeRepository.deleteAll();

        List<Employee> employeesCreated = createEmployees(employeeRepository);

        employeeRepository.listEmployees().forEach(employee ->
                System.out.println("###Employees listing:" + employee));

        System.out.println("Employee 1: " + employeeRepository
                .getEmployees(employeesCreated.get(employeesCreated.size() - 1).getEmployeeID()));

        System.out.println("Employee 2: " + employeeRepository
                .getEmployees(employeesCreated.get(employeesCreated.size() - 2).getEmployeeID()));

        updateEmployees(employeeRepository, employeesCreated);

        employeeRepository.listEmployees()
                .forEach(employee -> System.out.println("###Employee listing: " + employee));

        employeeRepository.deleteEmployee(employeesCreated
               .get(employeesCreated.size()-1).getEmployeeID());

        employeeRepository.listEmployees()
                .forEach(employee -> System.out.println("###Employee listing: " + employee));

        HibernateUtilManyToMany.closeSessionFactory();

    }

    private static List<Employee> createEmployees(EmployeeRepository employeeRepository) {

        Project project1 = ExampleData.project1();
        Project project2 = ExampleData.project2();
        Project project3 = ExampleData.project3();
        Project project4 = ExampleData.project4();
        Employee employee1 = ExampleData.someEmployee1();
        Employee employee2 = ExampleData.someEmployee2();
        Employee employee3 = ExampleData.someEmployee3();
        Employee employee4 = ExampleData.someEmployee4();

        employee1.setProjects(Set.of(project1, project2));
        employee2.setProjects(Set.of(project2));
        employee3.setProjects(Set.of(project2, project3));
        employee4.setProjects(Set.of(project4));

        return employeeRepository.insertData(List.of(employee1, employee2, employee3,employee4));
    }

    private static void updateEmployees(
            final EmployeeRepository employeeRepository,
            final List<Employee> employeesCreated
    ) {

        Employee employeeToBeUpdated = employeesCreated.get(employeesCreated.size() - 1);
        Project newProject = Project.builder()
                .name("Zmiana po całości")
                .description("Ale Jaja")
                .deadline(OffsetDateTime.of(2025, 2, 1, 12, 0, 0, 0, ZoneOffset.UTC))
                .build();

        employeeRepository.updateEmployee(employeeToBeUpdated.getEmployeeID(), newProject);

        System.out.println("###Employee update: " + employeeRepository
                .getEmployees(employeesCreated.get(employeesCreated.size() - 1).getEmployeeID()));


    }
}
