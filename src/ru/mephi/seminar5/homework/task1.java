package ru.mephi.seminar5.homework;

import java.time.*;
import java.time.temporal.TemporalAdjusters;

public class task1 {

    /**
     * Решение с использованием LocalDate
     */
    public static void localDateExample() {
        System.out.println("\n#2");
        LocalDate BennedictBorn = LocalDate.of(1976, Month.JULY, 19);

        boolean leap = BennedictBorn.isLeapYear();
        System.out.println("Born in a leap year?    " + BennedictBorn.isLeapYear() +
                "\nHow many days in the year he was born?   " + (leap ? 366 : 365) +
                "\nHow many decades old is he?    " + (LocalDate.now().getYear() - BennedictBorn.getYear()) / 10 +
                "\nWhat was the day of the week on his 21st birthday?   " + LocalDate.of(BennedictBorn.getYear() + 21, BennedictBorn.getMonth(), BennedictBorn.getDayOfMonth()).getDayOfWeek()
        );

    }

    /**
     * Решение с использованием LocalTime
     */
    public static void localTimeExample() {
        System.out.println("\n#3");
        LocalTime trainDeparts = LocalTime.of(13, 45);
        LocalTime trainArrives = LocalTime.of(19, 25);

        System.out.println("How many minutes long is the train ride?    " + Duration.between(trainDeparts, trainArrives).toMinutes() +
                "\nIf the train was delayed 1 hour 19 minutes, what is the actual arrival time?     " +
                trainArrives
                        .plusHours(1)
                        .plusMinutes(19)
        );

    }

    /**
     * Решение с использованием LocalDateTime
     */
    public static void localDateTimeExample() {

        System.out.println("\n#1");
        LocalDateTime LincolnBorn = LocalDate.of(1809, Month.FEBRUARY, 12).atStartOfDay();
        LocalDateTime LincolnDied = LocalDate.of(1855, Month.APRIL, 15).atStartOfDay();

        System.out.println("How old when he died?     " +
                LocalDate.now()
                        .minusYears(LincolnDied.getYear())
                        .minusMonths(LincolnDied.getMonthValue())
                        .minusDays(LincolnDied.getDayOfMonth()) +

                "\nHow many days did he live?    " + Duration.between(LincolnBorn.atOffset(ZoneOffset.UTC), LincolnDied.atOffset(ZoneOffset.UTC)).toDays()
        );

        System.out.println("\n#4");
        LocalDateTime flightStart = LocalDate.of(LocalDate.now().getYear(), Month.MARCH, 24).atTime(21, 15);
        LocalTime flightTime = LocalTime.of(4, 15);

        System.out.println("When does it arrive in Miami?    " + flightStart.plusHours(flightTime.getHour()).plusMinutes(flightTime.getMinute()) +
                "\n When does it arrive if the flight is delays 4 hours 27 minutes?     " + flightStart.plusHours(flightTime.getHour() + 4).plusMinutes(flightTime.getMinute() + 27)
        );

    }

    /**
     * Решение с использованием TemporalAdjusters
     */
    public static void temporalAdjustersExample() {
        System.out.println("\n#5");
        LocalDateTime startSchool = LocalDate.of(LocalDate.now().getYear(), Month.SEPTEMBER, 1).atStartOfDay();
        long num = startSchool.with(TemporalAdjusters.firstInMonth(DayOfWeek.MONDAY)).getDayOfMonth() - startSchool.getDayOfMonth();
        if (num < 2) {
            startSchool = startSchool.plusDays(num);
        }

        LocalDateTime finishSemester = LocalDate.of(LocalDate.now().getYear() + 1, Month.JUNE, 25).atStartOfDay();


        long daysInSchool = Duration.between(startSchool.atOffset(ZoneOffset.UTC), finishSemester.atOffset(ZoneOffset.UTC)).toDays();
        System.out.println("What is the date?   " + startSchool.with(TemporalAdjusters.dayOfWeekInMonth(2, DayOfWeek.TUESDAY)) +
                "\nHow many days of school are there?   " + ((daysInSchool / 7) - 4) * 5
        );
    }

    public static void main(String[] arg) {
        localDateExample();
        localTimeExample();
        localDateTimeExample();
        temporalAdjustersExample();
        System.out.println("\n#6\nWhat is the time of the week's meetings?    Not at all. Meeting next week at 1:30 PM");
    }

}
