package com.hadis.java8intro.lambdas;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Jonathan on 3/21/2016.
 */
public class ParameterizedLambda {

    public static void main(String... args) {

        Comparator<String> c = (String s1, String s2) ->
            Integer.compare(s1.length(), s2.length());

        //Comparator<String> cStr = Integer::compare(s1.length(), s2.length());

        List<String> strings = Arrays.asList("$$$$", "$", "$$$");

        System.out.println(strings);

        System.out.println("After sorting: ");

        strings.sort(c);
        System.out.println(strings);

        Comparator<Integer> intComp = (i1, i2) -> Integer.compare(i1, i2);
        Comparator<Integer> intComp2 = Integer::compare;
    }
}
