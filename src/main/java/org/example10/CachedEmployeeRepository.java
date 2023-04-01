package org.example10;


import org.hibernate.Session;


import java.util.Objects;

public class CachedEmployeeRepository {

    CachedEmployee insertData(final CachedEmployee employee) {
        try (Session session = CachedHibernateUtil.getSession()) {
            if (Objects.isNull(session)) {
                throw new RuntimeException("Session is null");
            }
            session.beginTransaction();
            session.persist(employee);
            session.getTransaction().commit();
            return employee;
        }
    }

    void levelOneCached(int employeeId){

        try (Session session = CachedHibernateUtil.getSession()) {
            if (Objects.isNull(session)) {
                throw new RuntimeException("Session is null");
            }
            session.beginTransaction();

            CachedEmployee e1 = session.find(CachedEmployee.class, employeeId);
            System.out.printf("###E1 %s %s%n", e1.getName(),e1.getSurname());
            CachedEmployee e2 = session.find(CachedEmployee.class, employeeId);
            System.out.printf("###E2 %s %s%n", e2.getName(),e2.getSurname());
            CachedEmployee e3 = session.find(CachedEmployee.class, employeeId);
            System.out.printf("###E3 %s %s%n", e3.getName(),e3.getSurname());

            // session.evict(e1);
            // session.evict(e2);
            // session.evict(e3);


            session.getTransaction().commit();
           // session.clear();

        }
        try (Session session = CachedHibernateUtil.getSession()) {
            if (Objects.isNull(session)) {
                throw new RuntimeException("Session is null");
            }
            session.beginTransaction();

            CachedEmployee e2 = session.find(CachedEmployee.class, employeeId);
            System.out.printf("###E2 %s %s%n", e2.getName(),e2.getSurname());

            session.getTransaction().commit();

        }
        try (Session session = CachedHibernateUtil.getSession()) {
            if (Objects.isNull(session)) {
                throw new RuntimeException("Session is null");
            }
            session.beginTransaction();

            CachedEmployee e3 = session.find(CachedEmployee.class, employeeId);
            System.out.printf("###E3 %s %s%n", e3.getName(),e3.getSurname());


            session.getTransaction().commit();

        }

    }

    public void deleteAll() {
        try (Session session = CachedHibernateUtil.getSession()) {
            Objects.requireNonNull(session);
            session.beginTransaction();
            String query = "select emp from CachedEmployee emp";
            session.createQuery(query, CachedEmployee.class).list().forEach(session::remove);
            session.getTransaction().commit();
        }
    }
}
