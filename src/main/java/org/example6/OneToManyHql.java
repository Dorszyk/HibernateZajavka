package org.example6;
public class OneToManyHql {
    public static void main(String[] args) {

        OwnerRepository ownerRepository = new OwnerRepository();

        ownerRepository.insertHQL();
        ownerRepository.updateHQL("romek@zajavka.pl","+48 987 654 321","romek150@zajavka.pl");
        ownerRepository.deleteHQL("romek150@zajavka.pl");
        ownerRepository.deleteHQL("romek@zajavka.pl");


        HQLOneToMany.closeSessionFactory();
    }
}
