package org.example10;



import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

public class CachedExampleData {

    static CachedEmployee someEmployee1(){
        return CachedEmployee.builder()
                .name("Agnieszka")
                .surname("Wolna")
                .salary(new BigDecimal("5910.73"))
                .since(OffsetDateTime.of(2020,1,1,10,10,10,0, ZoneOffset.UTC))
                .build();
    }

    static CachedEmployee someEmployee2(){
        return CachedEmployee.builder()
                .name("Stefan")
                .surname("Nowak")
                .salary(new BigDecimal("3455.73"))
                .since(OffsetDateTime.of(2021,2,2,10,10,10,0, ZoneOffset.UTC))
                .build();
    }

    static CachedEmployee someEmployee3(){
        return CachedEmployee.builder()
                .name("Tomasz")
                .surname("Paproch")
                .salary(new BigDecimal("6112.73"))
                .since(OffsetDateTime.of(2022,3,3,10,10,10,0, ZoneOffset.UTC))
                .build();
    }
}
