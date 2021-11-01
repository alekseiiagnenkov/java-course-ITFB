package ru.mephi.seminar4.classwork;

import ru.mephi.seminar3.classwork.Employee;
import ru.mephi.seminar3.classwork.Role;
import ru.mephi.seminar3.homework.HoursTable;

import java.time.LocalTime;
import java.util.*;
import java.util.function.*;

import static ru.mephi.seminar3.classwork.Employee.createShortList;

public class Task4 {

    public static void log(Object... objects) {
        String s = LocalTime.now().toString();
        for (Object object : objects) {
            s += " - " + object.toString();
        }
        System.out.println(s);
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void firstExample(List<Employee> list) {
        Predicate<Employee> checkStaff =
                e -> e.getRole().equals(Role.STAFF);

        Consumer<Employee> printEmployee =
                e -> System.out.print(e.getGivenName() + " " + e.getSurName() + ":  ");

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
    }

    static int totalHours = 0;
    static int totalEmployees = 0;

    public static void secondExample(List<Employee> list) {

        HoursTable hoursTable = new HoursTable(list);

        Random random = new Random();
        for (Employee employee : list) {
            hoursTable.addHours(employee, Math.abs(random.nextInt() % 100) + 100);
        }


        /**
         * Выводим все часы, при этом подсчитываем их количество через peek
         * Считаем сколько человек отработало 150 часов
         */
        System.out.println("List of hours > 150:");
        hoursTable.getHours().values().stream()
                .peek(i -> totalHours += i)
                .filter(i -> i > 150)
                .peek(i -> totalEmployees += 1)
                .forEach(System.out::println);

        System.out.println(
                "Total hours(peek): " + totalHours
                        + "\nCount employees: " + totalEmployees
        );

        /**
         * Найдем большее и меньшее количество отработанных часов
         */
        System.out.println("\nMin:"
                + hoursTable
                .getHours()
                .values()
                .stream()
                .min(Integer::compareTo)
                + "\nMax:"
                + hoursTable
                .getHours()
                .values()
                .stream()
                .max(Integer::compareTo)
        );


        /**
         * Подсчитаем среднее количество часов
         */
        System.out.println("\nAverage:"
                + hoursTable
                .getHours()
                .values()
                .stream()
                .mapToInt(i -> i)
                .average()
        );

        /**
         * Снова подсчитаем сумму часов, но теперь через sum
         */
        System.out.println("\nTotal hours(sum):"
                + hoursTable
                .getHours()
                .values()
                .stream()
                .mapToInt(i -> i)
                .sum()
        );

        /**
         * Найдем первое кличество часов, которое > 190
         */
        System.out.println("\nHours > 190:"
                + hoursTable
                .getHours()
                .values()
                .stream()
                .filter(i -> i > 190)
                .findFirst()
        );

    }

    public static void main(String[] args) {

        List<Employee> list = createShortList();

        firstExample(list);
        secondExample(list);

    }
}
