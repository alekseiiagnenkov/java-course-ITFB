package ru.mephi.seminar3.classwork;

import ru.mephi.seminar1.classwork.MyList;

import java.math.MathContext;
import java.util.Random;

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

    public String getGivenName() {
        return givenName;
    }

    public String getSurName() {
        return surName;
    }

    public int getAge() {
        return age;
    }

    public Gender getGender() {
        return gender;
    }

    public Role getRole() {
        return role;
    }

    public int getDept() {
        return dept;
    }

    public String getEMail() {
        return eMail;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public int getCode() {
        return code;
    }

    @Override
    public String toString() {
        return "givenName:" + givenName + '\n' +
                "surName:" + surName + '\n' +
                "age:" + age + '\n' +
                "gender:" + gender + '\n' +
                "role" + role + '\n' +
                "dept" + dept + '\n' +
                "eMail" + eMail + '\n' +
                "phone" + phone + '\n' +
                "address" + address + '\n' +
                "city" + city + '\n' +
                "state" + state + '\n' +
                "code" + code + '\n';
    }


    public static MyList<Employee> createShortList() {
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

        MyList<Employee> myList = new MyList<>();
        int a = Math.abs(rand.nextInt() % 40) + 7;
        for (int i = 0; i < a; i++) {
            int randName = Math.abs(rand.nextInt() % (names.length));
            myList.add(new Builder()
                    .GivenName(names[randName])
                    .SurName(surnames[Math.abs(rand.nextInt() % (surnames.length))])
                    .Age(Math.abs(rand.nextInt() % 65 + 15))
                    .Gender(randName % 2 == 0 ? Gender.MALE : Gender.FEMALE)
                    .Role(Role.values()[Math.abs(rand.nextInt() % 3)])
                    .Dept(rand.nextInt() % 5)
                    .eMail((rand.nextInt() % 10000 + 1000) + "@gmail.com")
                    .Phone("89" + Math.abs(rand.nextInt() % 1000 + 100) + Math.abs(rand.nextInt() % 10000 + 1000))
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

        System.out.println(createShortList());
    }

}
