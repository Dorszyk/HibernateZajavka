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
                    .setFirstResult(0)
                    .setMaxResults(10)
                    .getResultList();
            session.getTransaction().commit();
            return owners;
        }
    }

    void saveTestData() {
        try (Session session = SelectHQLOneToMany.getSession()) {
            if (Objects.isNull(session)) {
                throw new RuntimeException("Session is null");
            }
            session.beginTransaction();

            Toy toy1 = ExampleData.someToy1();
            Toy toy2 = ExampleData.someToy2();
            Toy toy3 = ExampleData.someToy3();
            Toy toy4 = ExampleData.someToy4();
            session.persist(toy1);
            session.persist(toy2);
            session.persist(toy3);
            session.persist(toy4);


            Pet pet1 = ExampleData.somePet1();
            Pet pet2 = ExampleData.somePet2();
            Pet pet3 = ExampleData.somePet3();
            Pet pet4 = ExampleData.somePet4();
            pet1.setToys(Set.of(toy1,toy2));
            pet2.setToys(Set.of(toy2,toy3));
            pet3.setToys(Set.of(toy1,toy2,toy3));
            pet4.setToys(Set.of(toy2,toy3,toy4));

            Owner owner1 = ExampleData.someOwner1();
            Owner owner2 = ExampleData.someOwner2();
            owner1.setPets(Set.of(pet1,pet2));
            owner2.setPets(Set.of(pet3,pet4));
            owner1.getPets().forEach(pet -> pet.setOwner(owner1));
            owner2.getPets().forEach(pet -> pet.setOwner(owner2));
            session.persist(owner1);
            session.persist(owner2);

            session.getTransaction().commit();


        }
    }

    public void selectExample8() {
        try (Session session = SelectHQLOneToMany.getSession()) {
            if (Objects.isNull(session)) {
                throw new RuntimeException("Session is null");
            }

            session.beginTransaction();
            String select8 = """
                    select ow from Owner ow
                    inner join fetch ow.pets pt
                    inner join fetch pt.toys ts
                    """;
            session.createQuery(select8, Owner.class)
                    .getResultList()
                    .forEach(entity -> System.out.println("###ENTITY: " + entity));

            session.getTransaction().commit();
        }
    }
}
