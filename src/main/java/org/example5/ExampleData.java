package org.example5;


import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

public class ExampleData {

    static Employee someEmployee1() {
        return Employee.builder()
                .name("Agnieszka")
                .surname("Wolna")
                .salary(new BigDecimal("5910.73"))
                .since(OffsetDateTime.of(2020, 1, 1, 10, 10, 10, 0, ZoneOffset.UTC))
                .build();
    }

    static Employee someEmployee2() {
        return Employee.builder()
                .name("Stefan")
                .surname("Nowak")
                .salary(new BigDecimal("3455.73"))
                .since(OffsetDateTime.of(2021, 2, 2, 10, 10, 10, 0, ZoneOffset.UTC))
                .build();
    }

    static Employee someEmployee3() {
        return Employee.builder()
                .name("Tomasz")
                .surname("Paproch")
                .salary(new BigDecimal("6112.73"))
                .since(OffsetDateTime.of(2022, 3, 3, 10, 10, 10, 0, ZoneOffset.UTC))
                .build();
    }

    static Project project1() {
        return Project.builder()
                .name("Database migration")
                .description("Lorem ipsum dolor sit amet, consectetur adipiscing elit")
                .deadline(OffsetDateTime.of(2027, 10, 3, 12, 0, 0, 0, ZoneOffset.UTC))
                .build();
    }

    static Project project2() {
        return Project.builder()
                .name("Some external system integration")
                .description("sed do eiusmod tempor incididunt ut labore et dolore magna aliqua")
                .deadline(OffsetDateTime.of(2025, 10, 2, 12, 0, 0, 0, ZoneOffset.UTC))
                .build();
    }

    static Project project3() {
        return Project.builder()
                .name("Email sending refactoring")
                .description("Nulla maximus ac tellus nec elementum")
                .deadline(OffsetDateTime.of(2024, 4, 2, 12, 0, 0, 0, ZoneOffset.UTC))
                .build();
    }
}
