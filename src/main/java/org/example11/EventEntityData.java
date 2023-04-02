package org.example11;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

public class EventEntityData {

    static  EventEntity someEvent1(){
        return EventEntity.builder()
                .eventName("StandUp")
                .capacity(5)
                .dateTime(OffsetDateTime.of(LocalDate.of(2024,10,2), LocalTime.of(18,0,0), ZoneOffset.ofHours(2)))
                .build();
    }

    static  EventEntity someEvent2(){
        return EventEntity.builder()
                .eventName("Koncert")
                .capacity(2)
                .dateTime(OffsetDateTime.of(LocalDate.of(2026,10,2), LocalTime.of(22,0,0), ZoneOffset.ofHours(2)))
                .build();
    }
}
