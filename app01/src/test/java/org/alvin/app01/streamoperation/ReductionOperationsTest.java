package org.alvin.app01.streamoperation;

import org.alvin.app01.lambdaexpression.Person;
import org.alvin.app01.lambdaexpression.RosterHelper;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * A difference between the accumulator in the reduce method and the accumulator in the collect method is having a return value or not.
 * @author Alvin Liu
 * @date 2021.7.21
 */
public class ReductionOperationsTest {
    private Collection<Person> roster;

    @Before
    public void init() {
        roster = new ArrayList<>();
        new RosterHelper().init(roster);
    }

    @Test
    public void totalAge() {
        int totalAgeSum = roster.stream().mapToInt(Person::getAge).sum();
        System.out.println("totalAgeSum: " + totalAgeSum);

        int totalAgeReduce = roster.stream().map(Person::getAge).reduce(0, Integer::sum);
        System.out.println("totalAgeReduce: " + totalAgeReduce);

        Averager averager = roster.stream().map(Person::getAge).collect(Averager::new, Averager::accept, Averager::combine);
        System.out.println("totalAgeCollect: " + averager.getTotal());
    }

    @Test
    public void averageAge() {
        double averageAge = roster.stream().mapToInt(Person::getAge).average().getAsDouble();
        System.out.println("averageAge: " + averageAge);

        Averager averagerReduce = roster.stream()
                .map(p -> {
                    Averager ave = new Averager();
                    ave.accept(p.getAge());
                    return ave;
                })
                .reduce(new Averager(), (a, b) -> {
                    a.combine(b);
                    return a;
                });

        System.out.println("averageAgeReduce: " + averagerReduce.average());

        Averager averagerCollect = roster.stream().map(Person::getAge).collect(Averager::new, Averager::accept, Averager::combine);
        System.out.println("averageAgeCollect: " + averagerCollect.average());
    }

    @Test
    public void namesOfMembers() {
        List<String> namesOfMembersReduce = roster.stream()
                .map(Person::getName)
                .reduce(new ArrayList<>(),
                        (a, b) -> { a.add(b); return a; },
                        (a, b) -> { a.addAll(b); return a; });
        System.out.println("namesOfMembersReduce: " + namesOfMembersReduce);

        List<String> namesOfMembersCollect = roster.stream().map(Person::getName).collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
        System.out.println("namesOfMembersCollect: " + namesOfMembersCollect);

        List<String> namesOfMembersCollect2 = roster.stream().map(Person::getName).collect(Collectors.toList());
        System.out.println("namesOfMembersCollect2: " + namesOfMembersCollect2);

        List<String> namesOfMembersCollect3 = roster.stream().collect(Collectors.mapping(Person::getName, Collectors.toList()));
        System.out.println("namesOfMembersCollect3: " + namesOfMembersCollect3);
    }

    @Test
    public void groupMembersByGender() {
        Map<Person.Sex, List<Person>> membersByGender = roster.stream().collect(Collectors.groupingBy(Person::getGender));
        System.out.println("membersByGender: " + membersByGender);

        Map<Person.Sex, List<String>> namesByGender = roster.stream().collect(Collectors.groupingBy(Person::getGender, Collectors.mapping(Person::getName, Collectors.toList())));
        System.out.println("namesByGender: " + namesByGender);
    }

    @Test
    public void totalAgeByGender() {
        // Map<Person.Sex, Integer> totalAgeByGender = roster.stream().collect(Collectors.groupingBy(Person::getGender, Collectors.mapping(Person::getAge, Collectors.reducing(0, Integer::sum))));
        Map<Person.Sex, Integer> totalAgeByGender = roster.stream().collect(Collectors.groupingBy(Person::getGender, Collectors.reducing(0, Person::getAge, Integer::sum)));
        System.out.println("totalAgeByGender: " + totalAgeByGender);
    }

    @Test
    public void averageAgeByGender() {
        Map<Person.Sex, Double> averageAgeByGender = roster.stream().collect(Collectors.groupingBy(Person::getGender, Collectors.averagingDouble(Person::getAge)));
        System.out.println("averageAgeByGender: " + averageAgeByGender);
    }
}
