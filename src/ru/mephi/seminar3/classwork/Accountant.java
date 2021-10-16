package ru.mephi.seminar3.classwork;

public class Accountant {
    public static void paySalary(Employee employee) {
        System.out.println(employee.getGivenName() + " " + employee.getSurName() + " GOT SALARY!\n");
    }

    public static void payPremium(Employee employee) {
        System.out.println(employee.getGivenName() + " " + employee.getSurName() + " GOT PREMIUM " + employee.getRole().getValue() * 100 + "% !!!\n");
    }

}
