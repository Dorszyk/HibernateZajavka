package org.example7;

import org.hibernate.Session;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class OwnerRepository {

    Owner insertData(final Owner owner, final Set<Pet> pets) {
        try (Session session = SelectHQLOneToMany.getSession()) {
            if (Objects.isNull(session)) {
                throw new RuntimeException("Session is null");
            }
            session.beginTransaction();
            owner.setPets(pets);
            pets.forEach(pet -> pet.setOwner(owner));
            session.persist(owner);
            session.getTransaction().commit();
            return owner;
        }
    }

    public void deleteAll() {
        try (Session session = SelectHQLOneToMany.getSession()) {
            if (Objects.isNull(session)) {
                throw new RuntimeException("Session is null");
            }
            session.beginTransaction();
            String query = "select owner from Owner owner";
            session.createQuery(query, Owner.class).list().forEach(session::remove);
            session.getTransaction().commit();
        }
    }
    List<OwnerTemp> selectExample1() {
        try (Session session = SelectHQLOneToMany.getSession()) {
            if (Objects.isNull(session)) {
                throw new RuntimeException("Session is null");
            }
            session.beginTransaction();
            String query = "FROM Owner ";
            List<OwnerTemp> owners= session.createQuery(query, OwnerTemp.class).list();
            session.getTransaction().commit();
            return owners;
        }
    }

    List<OwnerTemp> selectExample2() {
        try (Session session = SelectHQLOneToMany.getSession()) {
            if (Objects.isNull(session)) {
                throw new RuntimeException("Session is null");
            }

            session.beginTransaction();

            String selectExample2 = "select new org.example7.OwnerTemp(ow.id, ow.name) from  Owner ow";
            List<OwnerTemp> owners= session.createQuery(selectExample2, OwnerTemp.class).getResultList();
            session.getTransaction().commit();
            return owners;
        }
    }

    List<Owner> selectExample3() {
        try (Session session = SelectHQLOneToMany.getSession()) {
            if (Objects.isNull(session)) {
                throw new RuntimeException("Session is null");
            }

            session.beginTransaction();
            String selectExample3 = "select ow from Owner ow where ow.email LIKE :email" ;
            List<Owner> owners = session
                    .createQuery(selectExample3, Owner.class)
                            .setParameter("email","adrian@zajavka.pl")
                                    .getResultList();
            session.getTransaction().commit();
            return owners;
        }
    }
    List<Owner> selectExample4() {
        try (Session session = SelectHQLOneToMany.getSession()) {
            if (Objects.isNull(session)) {
                throw new RuntimeException("Session is null");
            }

            session.beginTransaction();
            String selectExample4 = "select ow from Owner ow order by ow.email ASC, ow.name DESC" ;
            List<Owner> owners = session
                    .createQuery(selectExample4, Owner.class)
                    .getResultList();
            session.getTransaction().commit();
            return owners;
        }
    }

    List<Owner> selectExample5() {
        try (Session session = SelectHQLOneToMany.getSession()) {
            if (Objects.isNull(session)) {
                throw new RuntimeException("Session is null");
            }

            session.beginTransaction();
            String select5_1 = "select ow from Owner ow order by ow.email DESC" ;
            List<Owner> owners = session.createQuery(select5_1, Owner.class)
                    .setFirstResult(1)
                    .setMaxResults(3)
                    .getResultList();
            session.getTransaction().commit();
            return owners;
        }
    }
}
