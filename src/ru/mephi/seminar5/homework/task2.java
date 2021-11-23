package ru.mephi.seminar5.homework;

import java.time.*;
import java.time.temporal.TemporalAdjusters;

public class task2 {

    /**
     * Примеры использования ZoneId
     */
    public static void useZoneIdExample() {
        ZoneId SFO = ZoneId.of("America/Los_Angeles");
        ZoneId BOS = ZoneId.of("America/New_York");
        ZoneId BLR = ZoneId.of("Asia/Calcutta");

        System.out.println("\n#1");
        LocalDateTime startSanFr = LocalDate.of(2014, Month.JUNE, 13).atTime(22, 30);
        ZonedDateTime flightStart = ZonedDateTime.of(startSanFr, SFO);
        LocalTime flightTime = LocalTime.of(5, 30);

        System.out.println("What is the local time in Boston when the flight takes off?     " +
                flightStart
                        .toOffsetDateTime()
                        .atZoneSameInstant(BOS)
                        .toLocalTime() +
                "\nWhat is the local time at Boston Logan airport when the flight arrives?    " +
                (flightStart.plusHours(flightTime.getHour()).plusMinutes(flightTime.getMinute()))
                        .toOffsetDateTime()
                        .atZoneSameInstant(BOS)
                        .toLocalTime() +
                "\nWhat is the local time in San Francisco when the flight arrives?    " +
                startSanFr.plusHours(flightTime.getHour()).plusMinutes(flightTime.getMinute())
        );

        System.out.println("\n#2");
        startSanFr = startSanFr.plusDays(15);
        flightStart = ZonedDateTime.of(startSanFr, SFO);
        flightTime = LocalTime.of(22, 0);
        LocalDateTime meeting = LocalDate.of(startSanFr.getYear(), startSanFr.getMonth(), startSanFr.with(TemporalAdjusters.next(DayOfWeek.MONDAY)).getDayOfMonth()).atTime(9, 0);
        ZonedDateTime meetingBLR = ZonedDateTime.of(meeting, BLR);

        System.out.println("Will the traveler make a meeting in Bangalore Monday at 9 AM local time?    " +
                flightStart.plusHours(flightTime.getHour()).toOffsetDateTime().atZoneSameInstant(BLR).isBefore(meetingBLR) +
                "\nCan the traveler call her husband at a reasonable time when she arrives?    " +
                "\nShe:" + flightStart.plusHours(flightTime.getHour()).toOffsetDateTime().atZoneSameInstant(BLR).toLocalTime() +
                "\nHe:" + flightStart.plusHours(flightTime.getHour()).toOffsetDateTime().toLocalTime()
        );

        System.out.println("\n#3");
        startSanFr = LocalDate.of(2014, Month.NOVEMBER, 1).atTime(22, 30);
        flightStart = ZonedDateTime.of(startSanFr, SFO);
        flightTime = LocalTime.of(5, 30);

        System.out.println("What day and time does the flight arrive in Boston?     " +
                flightStart.plusHours(flightTime.getHour()).plusMinutes(flightTime.getMinute()).toOffsetDateTime().atZoneSameInstant(BOS).toLocalDateTime()
        );
    }

    public static void main(String[] arg) {

        useZoneIdExample();

    }

}
