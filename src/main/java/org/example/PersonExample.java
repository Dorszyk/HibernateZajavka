package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class PersonExample {
    public static void main(String[] args) {

        try (
                SessionFactory sessionFactory = createSessionFactory();
                Session session = sessionFactory.openSession();


        ) {

            session.beginTransaction();

            Person person = new Person();
            person.setName("Piotrek");
            person.setAge(37);
            session.persist(person);

            session.getTransaction().commit();

            Person person1 = session.find(Person.class, 1);
            System.out.println(person1);
        }

    }

    private static SessionFactory createSessionFactory() {
        Configuration configuration = new Configuration();
        configuration.configure("/META-INF/hibernate.cfg.xml");
        return configuration.buildSessionFactory();
    }
}
