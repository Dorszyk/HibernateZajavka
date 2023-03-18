package org.example3;

public class ExampleData {

    static Address someAddress1(){
        return Address.builder()
                .country("Poland")
                .city("Szczecin")
                .postalCode("70-112")
                .address("Witolda Starkiewicza 3")
                .build();
    }
    static Address someAddress2(){
        return Address.builder()
                .country("Poland")
                .city("Gdynia")
                .postalCode("81-357")
                .address("Świętojańska 16")
                .build();
    }

    static Customer someCustomer1(){
        return Customer.builder()
                .name("Piotr")
                .surname("Dorszyk")
                .phone("+48 321 654 987")
                .email("piotr.dorszyk@zajavka.pl")
                .address(someAddress1())
                .build();
    }

    static Customer someCustomer2(){
        return Customer.builder()
                .name("Franek")
                .surname("Kimono")
                .phone("+48 987 654 321")
                .email("franek.kimono@zajavka.pl")
                .address(someAddress2())
                .build();
    }
}
