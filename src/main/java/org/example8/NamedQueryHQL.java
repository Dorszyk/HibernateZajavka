package org.example8;

public class NamedQueryHQL {
    public static void main(String[] args) {

        OwnerRepository ownerRepository = new OwnerRepository();

        ownerRepository.selectExampleNamedQuery("adrian@zajavka.pl");

        NamedQuery.closeSessionFactory();
    }
}

