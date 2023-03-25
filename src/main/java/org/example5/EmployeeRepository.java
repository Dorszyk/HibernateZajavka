package org.example5;


import org.hibernate.Session;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class EmployeeRepository {

    List<Employee> insertData(final List<Employee> employees) {
        try (Session session = HibernateUtilManyToMany.getSession()) {
            if (Objects.isNull(session)) {
                throw new RuntimeException("Session is null");
            }
            session.beginTransaction();
            employees.forEach(session::persist);
            session.getTransaction().commit();
            return employees;
        }
    }

    List<Employee> listEmployees() {
        try (Session session = HibernateUtilManyToMany.getSession()) {
            if (Objects.isNull(session)) {
                throw new RuntimeException("Session is null");
            }
            session.beginTransaction();
            String query = "select employee from Employee employee";
            List<Employee> employees= session.createQuery(query, Employee.class).list();
            session.getTransaction().commit();
            return employees;
        }
    }
    Optional<Employee> getEmployees( Integer employeeId) {
        try (Session session = HibernateUtilManyToMany.getSession()) {
            if (Objects.isNull(session)) {
                throw new RuntimeException("Session is null");
            }
            return Optional.ofNullable(session.find(Employee.class, employeeId));
        }
    }

    void updateEmployee(Integer employeeId, Project newProject) {
        try (Session session = HibernateUtilManyToMany.getSession()) {
            if (Objects.isNull(session)) {
                throw new RuntimeException("Session is null");
            }
            session.beginTransaction();
            Employee employee = session.find(Employee.class, employeeId);
            employee.getProjects().add(newProject);
            session.getTransaction().commit();
        }
    }

    void deleteEmployee(Integer employeeId) {
        try (Session session = HibernateUtilManyToMany.getSession()) {
            if (Objects.isNull(session)) {
                throw new RuntimeException("Session is null");
            }
            session.beginTransaction();
            session.remove(session.find(Employee.class, employeeId));
            session.getTransaction().commit();
        }
    }

    public void deleteAll() {
        try (Session session = HibernateUtilManyToMany.getSession()) {
            if (Objects.isNull(session)) {
                throw new RuntimeException("Session is null");
            }
            session.beginTransaction();
            String query = "select employee from Employee employee";
            session.createQuery(query, Employee.class).list().forEach(session::remove);
            session.getTransaction().commit();
        }
    }
}
