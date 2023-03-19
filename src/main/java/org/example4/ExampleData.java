package org.example4;

public class ExampleData {

    static Owner someOwner1() {
        return Owner.builder()
                .name("Stefan")
                .surname("Nowacki")
                .phone("+48 123 456 789")
                .email("stefan@zajavka.pl")
                .build();
    }

    static Owner someOwner2() {
        return Owner.builder()
                .name("Adrian")
                .surname("Paczkomat")
                .phone("+48 789 456 123")
                .email("adrian@zajavka.pl")
                .build();
    }
    static Owner someOwner3() {
        return Owner.builder()
                .name("Piotr")
                .surname("Dorszyk")
                .phone("+48 123 999 566")
                .email("piotr@zajavka.pl")
                .build();
    }

    static Pet somePet1() {
        return Pet.builder()
                .name("Fafik")
                .breed(Breed.DOG)
                .build();
    }

    static Pet somePet2() {
        return Pet.builder()
                .name("Kiciek")
                .breed(Breed.CAT)
                .build();
    }

    static Pet somePet3() {
        return Pet.builder()
                .name("Szymek")
                .breed(Breed.MONKEY)
                .build();
    }

    static Pet somePet4() {
        return Pet.builder()
                .name("Gucio")
                .breed(Breed.DOG)
                .build();
    }
}
