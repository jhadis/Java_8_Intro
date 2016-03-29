package com.hadis.java8intro.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

/**
 * Created by Jonathan on 3/25/2016.
 */
public class FirstStream {

    public static void main(String... args) {
        List<String> strings = new ArrayList<>();
        strings.add("Zeke");
        strings.add("Bill");

        Stream<String> stream = strings.stream();
        stream.forEach(s -> System.out.println(s));

        List<String> strings2 = new ArrayList<>();
        //Define 2 consumers
        Consumer<String> c1 = s -> strings2.add(s);
        Consumer<String> c2 = s-> System.out.println(s);

        stream = strings.stream();
        //Tell the stream's forEach method to use the linked consumers
        stream.forEach(c1.andThen(c2));
        System.out.println("strings2: " +strings2);
    }
}
