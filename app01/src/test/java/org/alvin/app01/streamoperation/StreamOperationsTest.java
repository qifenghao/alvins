package org.alvin.app01.streamoperation;

import org.alvin.app01.lambdaexpression.Person;
import org.alvin.app01.lambdaexpression.RosterHelper;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Learn how to use stream operations and do some exercises.
 * 1. A source
 * 2. Zero or more intermediate operations
 * 3. A terminal operation
 * @author Alvin Liu
 * @date 2021.7.13
 */
public class StreamOperationsTest {
    private Collection<Person> roster;

    @Before
    public void init() {
        roster = new ArrayList<>();
        new RosterHelper().init(roster);
    }

    @Test
    public void averageAgeOfMales() {
        double average = roster.stream()
                .filter(p -> p.getGender() == Person.Sex.MALE)
                .mapToInt(Person::getAge)
                .average()
                .getAsDouble();

        System.out.println("The average age of males is " + average);
    }

    @Test
    public void basicReduction() {
        long total = roster.stream().count();
        System.out.println("The total persons in roster is " + total);

        Person eldest = roster.stream().max(Person::compareOtherByAge).get();
        System.out.println("The eldest is " + eldest.getName() + ", born on " + eldest.getBirthday());

        Person youngest = roster.stream().min(Person::compareByAge).get();
        System.out.println("The youngest is " + youngest.getName() + ", born on " + youngest.getBirthday());

        int totalAge = roster.stream().mapToInt(p -> p.getAge()).sum();
        System.out.println("The total age of persons in roster is " + totalAge);

        double averageAge = roster.stream().mapToInt(Person::getAge).average().getAsDouble();
        System.out.println("The average age of persons in roster is " + averageAge);
    }
}
