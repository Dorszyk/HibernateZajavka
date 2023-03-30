package org.example7;

import java.util.Set;

public class OneToManyHqlSelect {
    public static void main(String[] args) {

        OwnerRepository ownerRepository = new OwnerRepository();

        ownerRepository.selectExample8();

      //  ownerRepository.insertData( ExampleData.someOwner3(),Set.of());
      //  ownerRepository.insertData( ExampleData.someOwner4(),Set.of());
      //  ownerRepository.insertData( ExampleData.someOwner5(),Set.of());

        /* ownerRepository.deleteAll();

       Owner owner1 = ownerRepository.insertData(
                ExampleData.someOwner1(), Set.of(ExampleData.somePet1(), ExampleData.somePet2()));

        Owner owner2 = ownerRepository.insertData(
                ExampleData.someOwner2(), Set.of(ExampleData.somePet3(), ExampleData.somePet4()));

         */


       // ownerRepository.selectExample2()
        //       .forEach(entity -> System.out.println("###Entity: " +(entity)));

      // ownerRepository.selectExample5()
      //                 .forEach(entity -> System.out.println("###Entity: " +(entity)));

        SelectHQLOneToMany.closeSessionFactory();
    }
}

