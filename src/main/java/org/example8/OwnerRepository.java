package org.example8;


import org.hibernate.Session;

import java.util.Objects;

public class OwnerRepository {


    public void selectExampleNamedQuery(final String email) {
        try (Session session = NamedQuery.getSession()) {
            if (Objects.isNull(session)) {
                throw new RuntimeException("Session is null");
            }

            session.beginTransaction();

            session.createNamedQuery("Owner.findOwnerByEmail", Owner.class)
                    .setParameter("email", email)
                    .getResultList()
                    .forEach(entity -> System.out.println("###ENTITY: " + entity));

            session.getTransaction().commit();
        }
    }
}
