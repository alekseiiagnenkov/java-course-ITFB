package ru.mephi.seminar3.classwork;

/**
 * @author https://github.com/alekseiiagnenkov<br><br>
 * An accountant class that can issue salaries and bonuses.
 */
public class Accountant {
    /**
     * Issuing a salary to an {@link Employee}.
     *
     * @param employee employee who is given a salary
     */
    public static void paySalary(Employee employee) {
        System.out.println(employee.getGivenName() + " " + employee.getSurName() + " GOT SALARY!\n");
    }

    /**
     * Issuing a premium to an {@link Employee}.
     *
     * @param employee employee who is given a premium
     */
    public static void payPremium(Employee employee) {
        System.out.println(employee.getGivenName() + " " + employee.getSurName() + " GOT PREMIUM " + employee.getRole().getValue() * 100 + "% !!!\n");
    }

}
