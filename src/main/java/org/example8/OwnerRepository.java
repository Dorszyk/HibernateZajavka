package org.example8;


import org.hibernate.Session;

import java.util.Objects;
import java.util.Optional;

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

    Optional<Owner> getOwner(Integer ownerId) {
        try (Session session = NamedQuery.getSession()) {
            if (Objects.isNull(session)) {
                throw new RuntimeException("Session is null");
            }
            System.out.println("###BEFORE GET OWNER\n------------------------------");
            Owner owner = session.find(Owner.class, ownerId);
            System.out.println("-------------------------------\n###AFTER GET OWNER");
            System.out.println("###BEFORE GET PETS\n-------------------------------");
            System.out.println(owner);
            System.out.println("-------------------------------\n###AFTER GET PETS");
            return Optional.of(owner);
        }
    }
}
