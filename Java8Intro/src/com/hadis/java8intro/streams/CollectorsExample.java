package com.hadis.java8intro.streams;

import com.hadis.java8intro.bean.Person;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Jonathan on 3/29/2016.
 */
public class CollectorsExample {

    public static void main(String... args) {

        List<Person> persons = new ArrayList<>();

        try (
            BufferedReader reader =
                    new BufferedReader(new InputStreamReader(
                            CollectorsExample.class.getResourceAsStream("people.txt")));
            Stream<String> stream = reader.lines();
        ) {
            stream.map(line -> {
                String[] s = line.split(" ");
                Person p = new Person(s[0].trim(), Integer.parseInt(s[1]));
                persons.add(p);
                return p;
            })
                    .forEach(System.out::println);
        } catch (IOException ioe) {
            System.out.println(ioe);
        }

        Stream<Person> stream = persons.stream();

        Optional<Person> opt = stream.filter(p -> p.getAge() >= 20)
                .min(Comparator.comparing(Person::getAge));
        System.out.println("Min age: " +opt);

        //Get oldest person.  Can't use stream var since it's
        //already been operated on.
        Optional<Person> opt2 = persons.stream().filter(p -> p.getAge() >= 20)
                .max(Comparator.comparing(Person::getAge));
        System.out.println("Max age: " +opt2);

        //Usage of Collectors.  Creates a Map
        Map<Integer, List<Person>> map = persons.stream().collect(
                Collectors.groupingBy(
                        Person::getAge
                )
        );

        System.out.println(map);

        /**
         * Usage of Collectors.  Creates a Map that
         * counts how many people there are of the same age
         */


        Map<Integer, Long> mapOfAges = persons.stream().collect(
                Collectors.groupingBy(
                        Person::getAge, Collectors.counting()
                )
        );
        System.out.println(mapOfAges);

        /**
         * Usage of Collectors.  Create map of lists of people's names
         */
        Map<Integer, List<String>> mapOfNamesByAge =
                persons.stream().collect(
                        Collectors.groupingBy(
                                Person::getAge,
                                Collectors.mapping(
                                        Person::getName,
                                        Collectors.toList()
                                )
                        )
                );
        System.out.println("Map of names by age: " +mapOfNamesByAge);

    }
}
