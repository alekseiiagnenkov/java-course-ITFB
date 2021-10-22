package ru.mephi.seminar3.homework;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

import ru.mephi.seminar3.classwork.Employee;
import ru.mephi.seminar3.classwork.Gender;
import ru.mephi.seminar3.classwork.Role;
import ru.mephi.seminar3.homework.functionalInterfaces.*;

import static ru.mephi.seminar3.classwork.Employee.createShortList;

/**
 * Задание: создать функцию, которая выводит<br>
 * на экран зарплаты работников в зависимости<br>
 * от количества часов, которые они наработали<br>
 */
public class Case {

    /**
     * функция вывода зарплат на экран
     *
     * @param list       список работников
     * @param hoursTable таблица часов
     */
    public static void getToKnowSalaries(List<Employee> list, HoursTable hoursTable) {

        MyBiFunction<Employee, Integer, Integer> hoursToSalary =
                (e, h) -> (int) ((e.getRole().getValue() + 1) * 200 * h);

        MyFunction<Employee, String> fullNameEmployee =
                e -> e.getGivenName() + " " + e.getSurName();

        MyConsumer<Employee> printEmployee =
                e -> System.out.println(
                        "\nName: " + fullNameEmployee.apply(e)
                                + " Salary: " + hoursToSalary.apply(e, hoursTable.getHours(e)));

        MyBiPredicate<Employee, Role> checkRoleEmployee =
                (e, r) -> e.getRole().equals(r);


        System.out.println("\n\nSALARY EXECUTIVE:");
        list.stream()
                .filter(e -> checkRoleEmployee.test(e, Role.EXECUTIVE))
                .forEach(printEmployee);

        System.out.println("\n\nSALARY MANAGER:");
        list.stream()
                .filter(e -> checkRoleEmployee.test(e, Role.MANAGER))
                .forEach(printEmployee);

        System.out.println("\n\nSALARY STAFF:");
        list.stream()
                .filter(e -> checkRoleEmployee.test(e, Role.STAFF))
                .forEach(printEmployee);
    }

    /**
     * main для создания списка сотрудников и таблицы часов
     *
     * @param args введенные данные
     */
    public static void main(String[] args) {

        List<Employee> list = createShortList();

        /**
         * Cоздание работника ВРУЧНУЮ, если нужно добавить.<br>
         * Я бы использовал это в коде, но у меня есть рандомное создание)0))<br>
         */
        MySupplier<Employee> createdEmployee =
                () -> {
                    Scanner in = new Scanner(System.in);
                    System.out.print("Given Name: ");
                    String givenName = in.next();
                    System.out.print("Surname: ");
                    String surname = in.next();
                    System.out.print("Age: ");
                    int age = in.nextInt();

                    System.out.print("Gender [M or F]: ");
                    String genderS = in.next();
                    Gender gender;
                    if (genderS.equals("M")) {
                        gender = Gender.MALE;
                    } else {
                        gender = Gender.FEMALE;
                    }

                    System.out.print("Role [S or M or E]: ");
                    String roleS = in.next();
                    Role role;
                    if (roleS.equals("E")) {
                        role = Role.EXECUTIVE;
                    } else if (roleS.equals("M")) {
                        role = Role.MANAGER;
                    } else {
                        role = Role.STAFF;
                    }

                    System.out.print("Dept: ");
                    int dept = in.nextInt();
                    System.out.print("eMail: ");
                    String eMail = in.next();
                    System.out.print("Phone number: ");
                    String phone = in.next();
                    System.out.print("Address: ");
                    String address = in.next();
                    System.out.print("City: ");
                    String city = in.next();
                    System.out.print("State: ");
                    String state = in.next();
                    System.out.print("Code: ");
                    int code = in.nextInt();
                    return new Employee.Builder()
                            .GivenName(givenName)
                            .SurName(surname)
                            .Age(age)
                            .Gender(gender)
                            .Role(role)
                            .Dept(dept)
                            .eMail(eMail)
                            .Phone(phone)
                            .Address(address)
                            .City(city)
                            .State(state)
                            .Code(code)
                            .build();
                };


        HoursTable hoursTable = new HoursTable(list);

        Random random = new Random();
        for (Employee employee : list) {
            hoursTable.addHours(employee, Math.abs(random.nextInt() % 200) + 100);
        }
        getToKnowSalaries(list, hoursTable);

    }
}
