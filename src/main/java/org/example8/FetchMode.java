package org.example8;

public class FetchMode {
    public static void main(String[] args) {

        OwnerRepository ownerRepository = new OwnerRepository();

        System.out.println(ownerRepository.getOwner(2));

        NamedQuery.closeSessionFactory();

    }
}
