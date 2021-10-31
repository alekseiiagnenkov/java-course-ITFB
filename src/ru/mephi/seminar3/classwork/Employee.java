package ru.mephi.seminar3.classwork;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * @author https://github.com/alekseiiagnenkov<br><br>
 * Company employee class.
 */
public class Employee {

    private String givenName;
    private String surName;
    private int age;
    private Gender gender;
    private Role role;
    private int dept;
    private String eMail;
    private String phone;
    private String address;
    private String city;
    private String state;
    private int code;

    /**
     * Implementation of the @Builder pattern.
     */
    public static class Builder {

        private String givenName = "";
        private String surName = "";
        private int age = 0;
        private Gender gender = Gender.MALE;
        private Role role = Role.STAFF;
        private int dept = 0;
        private String eMail = "";
        private String phone = "";
        private String address = "";
        private String city = "";
        private String state = "";
        private int code = 0;

        public Builder GivenName(String givenName) {
            this.givenName = givenName;
            return this;
        }

        public Builder SurName(String surName) {
            this.surName = surName;
            return this;
        }

        public Builder Age(int age) {
            this.age = age;
            return this;
        }

        public Builder Gender(Gender gender) {
            this.gender = gender;
            return this;
        }

        public Builder Role(Role role) {
            this.role = role;
            return this;
        }

        public Builder eMail(String eMail) {
            this.eMail = eMail;
            return this;
        }

        public Builder Phone(String phone) {
            this.phone = phone;
            return this;
        }

        public Builder Dept(int dept) {
            this.dept = dept;
            return this;
        }

        public Builder Address(String address) {
            this.address = address;
            return this;
        }

        public Builder City(String city) {
            this.city = city;
            return this;
        }

        public Builder State(String state) {
            this.state = state;
            return this;
        }

        public Builder Code(int code) {
            this.code = code;
            return this;
        }

        public Employee build() {
            return new Employee(this);
        }
    }

    private Employee(Builder builder) {
        this.givenName = builder.givenName;
        this.surName = builder.surName;
        this.age = builder.age;
        this.gender = builder.gender;
        this.role = builder.role;
        this.dept = builder.dept;
        this.eMail = builder.eMail;
        this.phone = builder.phone;
        this.address = builder.address;
        this.city = builder.city;
        this.state = builder.state;
        this.code = builder.code;
    }

    /**
     * Get givenName.
     *
     * @return <b>givenName</b>.
     */
    public String getGivenName() {
        return givenName;
    }

    /**
     * Get surName.
     *
     * @return <b>surName</b>.
     */
    public String getSurName() {
        return surName;
    }

    /**
     * Get age.
     *
     * @return <b>age</b>.
     */
    public int getAge() {
        return age;
    }

    /**
     * Get gender.
     *
     * @return <b>gender</b>.
     */
    public Gender getGender() {
        return gender;
    }

    /**
     * Get role.
     *
     * @return <b>role</b>.
     */
    public Role getRole() {
        return role;
    }

    /**
     * Get dept.
     *
     * @return <b>dept</b>.
     */
    public int getDept() {
        return dept;
    }

    /**
     * Get eMail.
     *
     * @return <b>eMail</b>.
     */
    public String getEMail() {
        return eMail;
    }

    /**
     * Get phone.
     *
     * @return <b>phone</b>.
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Get address
     *
     * @return <b>address</b>.
     */
    public String getAddress() {
        return address;
    }

    /**
     * Get city.
     *
     * @return <b>city</b>.
     */
    public String getCity() {
        return city;
    }

    /**
     * Get state.
     *
     * @return <b>state</b>.
     */
    public String getState() {
        return state;
    }

    /**
     * Get code.
     *
     * @return <b>code</b>.
     */
    public int getCode() {
        return code;
    }

    @Override
    public String toString() {
        return "\nGivenName: " + givenName + '\n' +
                "SurName: " + surName + '\n' +
                "Age: " + age + '\n' +
                "Gender: " + gender + '\n' +
                "Role: " + role + '\n' +
                "Dept: " + dept + '\n' +
                "eMail: " + eMail + '\n' +
                "Phone: " + phone + '\n' +
                "Address: " + address + '\n' +
                "City: " + city + '\n' +
                "State: " + state + '\n' +
                "Code: " + code + '\n';
    }

    /**
     * Creating a list of random workers.
     *
     * @return list of {@link Employee} .
     */
    public static List<Employee> createShortList() {
        Random rand = new Random();

        String[] names = {
                "Aleksei", "Agata", "Denis",
                "Sasha", "Andrei", "Adelaida",
                "Danya", "Ida", "Oleg"
        };

        String[] surnames = {
                "Abramson", "Archibald", "Dutton",
                "Goodman", "Hamphrey", "Fraser"
        };

        String[] states = {
                "Alabama", "Alaska", "California", "Idaho",
                "Kansas", "Kentucky", "Minnesota", "Mississippi",
                "New Mexico", "New York", "Virginia", "Wyoming"
        };

        List<Employee> myList = new LinkedList<>();
        int a = Math.abs(rand.nextInt() % 20) + 7;
        for (int i = 0; i < a; i++) {
            int randName = Math.abs(rand.nextInt() % (names.length));
            myList.add(new Builder()
                    .GivenName(names[randName])
                    .SurName(surnames[Math.abs(rand.nextInt() % (surnames.length))])
                    .Age(Math.abs(rand.nextInt() % 65 + 15))
                    .Gender(randName % 2 == 0 ? Gender.MALE : Gender.FEMALE)
                    .Role(Role.values()[Math.abs(rand.nextInt() % 3)])
                    .Dept(Math.abs(rand.nextInt() % 5))
                    .eMail((rand.nextInt() % 10000 + 1000) + "@gmail.com")
                    .Phone("89" + (Math.abs(rand.nextInt() % 999) + 1000) + (Math.abs(rand.nextInt() % 9999) + 10000))
                    .Address(Math.abs(rand.nextInt() % 100) + " st." + Math.abs(rand.nextInt() % 90 + 10))
                    .City("SomeWhere")
                    .State(states[Math.abs(rand.nextInt() % (states.length))])
                    .Code(Math.abs(rand.nextInt() % 100))
                    .build()
            );
        }
        return myList;
    }

    public static void main(String[] args) {
        List<Employee> list = createShortList();

        list.stream()
                .parallel()
                .filter(p -> p.getGender() == Gender.FEMALE)
                .forEach(Accountant::payPremium);

        list.stream()
                .parallel()
                .filter(p -> p.getDept() == 4)
                .forEach(Accountant::paySalary);

        list.stream()
                .parallel()
                .filter(p -> p.getDept() == 1)
                .filter(p -> p.getAge() > 30)
                .forEach(Accountant::payPremium);

        list.stream()
                .parallel()
                .filter(p -> p.getRole().equals(Role.MANAGER))
                .forEach(Accountant::paySalary);

        list.stream()
                .parallel()
                .filter(p -> p.getRole().equals(Role.STAFF))
                .forEach(Accountant::payPremium);
    }

}
