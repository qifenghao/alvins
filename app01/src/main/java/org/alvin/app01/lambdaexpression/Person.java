package org.alvin.app01.lambdaexpression;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Person {
    public enum Sex {
        MALE, FEMALE
    }

    private String name;
    private Sex gender;
    private LocalDate birthday;

    public Person() {
    }

    public Person(String name, Sex gender, LocalDate birthday) {
        this.name = name;
        this.gender = gender;
        this.birthday = birthday;
    }

    public int getAge() {
        return (int) ChronoUnit.YEARS.between(birthday, LocalDate.now());
    }

    public static int compareByAge(Person a, Person b) {
        return -a.birthday.compareTo(b.birthday);
    }

    public int compareOtherByAge(Person other) {
        return -birthday.compareTo(other.birthday);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Sex getGender() {
        return gender;
    }

    public void setGender(Sex gender) {
        this.gender = gender;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", gender=" + gender +
                ", birthday=" + birthday +
                '}';
    }
}
