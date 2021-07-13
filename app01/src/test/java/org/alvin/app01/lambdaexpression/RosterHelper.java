package org.alvin.app01.lambdaexpression;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Collection;

/**
 * A helper class which can simplify the initialization process of the roster required by test classes related to lambda expressions.
 * @author Alvin Liu
 * @date 2021.7.8
 */
public class RosterHelper {
    public void init(Collection<Person> roster) {
        roster.add(new Person("liuqifeng", Person.Sex.MALE, LocalDate.of(1991, Month.JANUARY, 19)));
        roster.add(new Person("liangchunzhao", Person.Sex.MALE, LocalDate.of(1997, Month.FEBRUARY, 2)));
        roster.add(new Person("simaxueke", Person.Sex.FEMALE, LocalDate.of(1995, Month.SEPTEMBER, 14)));
    }
}
