package com.hadis.java8intro.streams;

import com.hadis.java8intro.bean.Person;

import java.util.*;
import java.util.stream.Stream;

/**
 * Created by Jonathan on 3/29/2016.
 */
public class ReductionExample {

    public static void main(String... args) {

        List<Integer> ages = Arrays.asList(1, 4, 2, 5);
        System.out.println("Ages: " +ages);
        Stream<Integer> stream = ages.stream();
        Integer sum = stream.reduce(0, (age1, age2)
            -> age1 + age2);

        System.out.println("Sum of ages: " +sum);

        Person p = new Person(4);
        Person p2 = new Person(31);
        Person p3 = new Person(21);
        List<Person> persons = Arrays.asList(p, p2, p3);

        Optional<Integer> minAge =
                persons.stream()
                .map(person -> person.getAge())
                .filter(age -> age > 20)
                .min(Comparator.<Integer>naturalOrder());

        System.out.println("Minimum age (should be 21): " +minAge);

        System.out.println("Example of using Optional with max: ");
        List<Integer> ages2 = Arrays.asList(-10, 4, 2, 5);
        System.out.println("Ages: " +ages2);
        Optional<Integer> maxAge = ages2.stream()
                .reduce(Integer::max);
        System.out.println("optional maxAge: " +maxAge);
        if (maxAge.isPresent()) {
            System.out.println(maxAge.get());
        }
        maxAge.ifPresent(a -> System.out.println(a.intValue()));

    }
}
