package org.example9;


import jakarta.persistence.PersistenceException;
import org.hibernate.JDBCException;
import org.hibernate.Session;

import java.sql.SQLException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class CustomerRepository {

    Customer insertCustomer(final Customer customer) {
        try (Session session = ExceptionOneToOne.getSession()) {
            if (Objects.isNull(session)) {
                throw new RuntimeException("Session is null");
            }
            System.out.println("###BEFORE INSERT\n------------------------------");
            session.beginTransaction();
            session.persist(customer);
            session.getTransaction().commit();
            System.out.println("-------------------------------\n###AFTER INSERT");
            return customer;
        } catch (PersistenceException ex) {
            JDBCException jdbcException = (JDBCException) ex.getCause();
            System.err.println(jdbcException.getSQL());
            System.err.println(jdbcException.getSQLState());
            SQLException sqlException = jdbcException.getSQLException();
            System.err.println(sqlException.getErrorCode());
            System.err.println(sqlException.getMessage());
            return null;
        }
    }

    List<Customer> listCustomer() {
        try (Session session = ExceptionOneToOne.getSession()) {
            if (Objects.isNull(session)) {
                throw new RuntimeException("Session is null");
            }
            session.beginTransaction();
            String query = "select cust from Customer cust";
            List<org.example9.Customer> customers = session.createQuery(query, Customer.class).list();
            session.getTransaction().commit();
            return customers;
        }
    }

    Optional<Customer> getCustomer(final Integer customerId) {
        try (Session session = ExceptionOneToOne.getSession()) {
            if (Objects.isNull(session)) {
                throw new RuntimeException("Session is null");
            }
            return Optional.ofNullable(session.find(Customer.class, customerId));
        }
    }

    void updateCustomer(Integer customerId, Address newAddress) {
        try (Session session = ExceptionOneToOne.getSession()) {
            if (Objects.isNull(session)) {
                throw new RuntimeException("Session is null");
            }
            session.beginTransaction();
            org.example9.Customer customer = session.find(Customer.class, customerId);
            customer.setAddress(newAddress);
            session.getTransaction().commit();
        }
    }

    void deleteCustomer(Integer customerId) {
        try (Session session = ExceptionOneToOne.getSession()) {
            if (Objects.isNull(session)) {
                throw new RuntimeException("Session is null");
            }
            session.beginTransaction();
            session.remove(session.find(Customer.class, customerId));
            session.getTransaction().commit();
        }
    }

    public void deleteAll() {
        try (Session session = ExceptionOneToOne.getSession()) {
            if (Objects.isNull(session)) {
                throw new RuntimeException("Session is null");
            }
            session.beginTransaction();
            String query = "select cust from Customer cust";
            session.createQuery(query, Customer.class).list().forEach(session::remove);
            session.getTransaction().commit();
        }
    }

    void testSession(final int customerId) {
        try (Session session = ExceptionOneToOne.getSession()) {
            if (Objects.isNull(session)) {
                throw new RuntimeException("Session is null");
            }
            session.beginTransaction();
            Customer c1 = session.find(Customer.class, customerId);
            Customer c2 = session.find(Customer.class, customerId);

            System.out.println("c1 == c2 :" + (c1 == c2));
            System.out.println("c1.equals(c2) :" + c1.equals(c2));

            session.getTransaction().commit();
        }
    }

}
