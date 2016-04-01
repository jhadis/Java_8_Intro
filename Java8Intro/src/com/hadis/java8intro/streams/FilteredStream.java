package com.hadis.java8intro.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * Created by Jonathan on 3/29/2016.
 */
public class FilteredStream {

    public static void main(String... args) {
        String[] namesArr = {"Adam","Bill","Jonathan","Randy","Zed"};
        List<String> names = Arrays.asList(namesArr);

        System.out.println("list before filtering: "+ names);
        Stream<String> namesStream = names.stream();
        Stream<String> filteredNamesStream =
                namesStream.filter(name -> name.length() > 4);
        System.out.print("list after filtering: ");
        filteredNamesStream.forEach(s -> System.out.print(s+ " "));

        System.out.println();
        //Use Stream static method and Predicate
        Stream<String> stream = Stream.of("one","two","three","four","five");

        Predicate<String> p1 = s -> s.length() > 3;

        Predicate<String> p2 = Predicate.isEqual("two");
        Predicate<String> p3 = Predicate.isEqual("three");

        stream.filter(p2.or(p3))
            .forEach(s -> System.out.println(s));

        System.out.println("New example: ");
        stream = Stream.of("one","two","three","four","five");

        stream.filter(p1)
                .forEach(s -> System.out.println(s));

        System.out.println("New example to show diff between intermediary " +
                " and final operations: ");
        System.out.println("Since we're using intermediary operations, the list should never be populated.");
        stream = Stream.of("one","two","three","four","five");

        List<String> list = new ArrayList<>();

        stream
                .peek(System.out::println)
                .filter(p2.or(p3))
                .peek(list::add);

        System.out.println("Done");
        System.out.println("size = " +list.size());

        System.out.println("New example where peek is replaced with forEach.  " +
                "This now uses a final operation and the list will be populated.");
        stream = Stream.of("one","two","three","four","five");

        List<String> list2 = new ArrayList<>();

        stream
                .peek(System.out::println)
                .filter(p2.or(p3))
                .forEach(list2::add);

        System.out.println("Done");
        System.out.println("size = " +list2.size());
    }
}
