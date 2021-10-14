package ru.mephi.seminar3.classwork;

public class Accountant {
    public void paySalary(Employee employee) {
        System.out.println(employee.getGivenName() + " " + employee.getSurName() + " GET SALARY!\n");
    }

    public void payPremium(Employee employee) {
        System.out.println(employee.getGivenName() + " " + employee.getSurName() + " GET PREMIUM " + employee.getRole().getValue() * 10 + "% !!!\n");
    }

}
