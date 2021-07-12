package org.alvin.app01.methodreference;

import org.alvin.app01.lambdaexpression.Person;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Learn how to use method references and do some exercises.
 * @author Alvin Liu
 * @date 2021.7.8
 */
public class MethodReferencesTest {
    private Collection<Person> roster;

    @Before
    public void init() {
        roster = new ArrayList<>();
        roster.add(new Person("liuqifeng", Person.Sex.MALE, LocalDate.of(1991, Month.JANUARY, 19)));
        roster.add(new Person("liangchunzhao", Person.Sex.MALE, LocalDate.of(1997, Month.FEBRUARY, 2)));
        roster.add(new Person("simaxueke", Person.Sex.FEMALE, LocalDate.of(1995, Month.SEPTEMBER, 14)));
    }

    @Test
    public void rankByAge() {
        // Collections.sort((List<Person>) roster, (a, b) -> Person.compareByAge(a, b));
        // Sometimes, a lambda expression does nothing but call an existing method
        // Collections.sort((List<Person>) roster, Person::compareByAge);

        // Collections.sort((List<Person>) roster, (a, b) -> a.compareOtherByAge(b));
        // Reference to an instance method of an arbitrary object of a particular type
        Collections.sort((List<Person>) roster, Person::compareOtherByAge);

        roster.forEach(p -> System.out.println(p.getName() + ", " + p.getAge()));
 }
}
