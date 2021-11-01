package ru.mephi.seminar4.classwork;

import ru.mephi.seminar3.classwork.Employee;
import ru.mephi.seminar3.classwork.Role;

import java.time.LocalTime;
import java.util.Comparator;
import java.util.List;
import java.util.function.*;
import java.util.stream.IntStream;

import static ru.mephi.seminar3.classwork.Employee.createShortList;

public class Task4 {

    public static void log(Object... objects) {
        String s = LocalTime.now().toString();
        for (Object object : objects) {
            s += " - " + object.toString();
        }
        System.out.println(s);
        // putting a little delay so that we can see a clear difference
        // with parallel stream.
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        List<Employee> list = createShortList();

        Predicate<Employee> checkStaff =
                e -> e.getRole().equals(Role.STAFF);

        Consumer<Employee> printEmployee =
                e -> System.out.print(e.getGivenName() + " " + e.getSurName() + ":  ");

        //System.out.println(list);

        /**
         * Получаем список возрастов
         */
        System.out.println("List of a employee's age:");
        list.stream()
                .peek(printEmployee)
                .map(Employee::getAge)
                .forEach(System.out::println);

        /**
         * Сумма возрастов работников
         */
        System.out.println("\nSum ages:"
                + list.stream()
                .mapToInt(Employee::getAge)
                .sum());

        /**
         * Средний возраст работников
         */
        System.out.println("Average age:"
                + list.stream()
                .mapToInt(Employee::getAge)
                .average());

        /**
         * Выводим максимальный возраст
         */
        System.out.println(
                "The oldest employee:\n"
                        + list.stream()
                        .max(Comparator.comparing(Employee::getAge))
                        + "\n\n"
        );

        /**
         * Выводим минимальный возраст
         */
        System.out.println(
                "The youngest employee:\n"
                        + list.stream()
                        .min(Comparator.comparing(Employee::getAge))
                        + "\n\n"
        );

        /**
         * Ищем последовательно первого STAFF в списке
         */
        System.out.println("\nNOT A PARALLEL\nThe first while STAFF:");
        System.out.println(list.stream()
                .peek(e -> log("Surname:", e.getSurName()))
                .filter(checkStaff)
                .peek(e -> log("Finished Surname:", e.getSurName()))
                .findFirst()
                + "\n\n"
        );

        /**
         * Ищем параллельно первого STAFF в списке
         */
        System.out.println("PARALLEL\nThe first while STAFF:");
        System.out.println(list.stream().parallel()
                .peek(e -> log("Surname:", e.getSurName()))
                .filter(checkStaff)
                .peek(e -> log("Finished Surname:", e.getSurName()))
                .findFirst()
                + "\n\n"
        );



        System.out.println("finished");

    }
}
