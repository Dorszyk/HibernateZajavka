package org.example11;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class EventRunnerOptimisticLocking {
    public static void main(String[] args) {

        EventRepository eventRepository = new EventRepository();

        eventRepository.deleteAll();

        EventEntity event1 = eventRepository.createEmptyEvent(EventEntityData.someEvent1());
        EventEntity event2 = eventRepository.createEmptyEvent(EventEntityData.someEvent2());

        ExecutorService executor = Executors.newFixedThreadPool(2);
        executor.execute(() -> {
            eventRepository.changeDateTime(
                    OffsetDateTime.of(
                            LocalDate.of(2030, 10, 2), LocalTime.of(11, 0, 0),
                            ZoneOffset.ofHours(2)
                    ),
                    event2.getEventId()
            );
            try {
                Thread.sleep(1_000);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
        executor.execute(() -> {
            eventRepository.changeDateTime(
                    OffsetDateTime.of(
                            LocalDate.of(2024, 10, 2), LocalTime.of(11, 0, 0),
                            ZoneOffset.ofHours(2)
                    ),
                    event2.getEventId()
            );
            try {
                Thread.sleep(1_000);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
        executor.shutdown();
    }
}

