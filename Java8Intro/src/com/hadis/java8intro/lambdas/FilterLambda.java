package com.hadis.java8intro.lambdas;

import java.io.File;
import java.io.FileFilter;

/**
 * Created by Jonathan on 3/21/2016.
 */
public class FilterLambda {

    public static void main(String... args) {

        FileFilter filter = (File file) -> file.getName().endsWith(".java");

        File f = new File(("C:\\Temp"));

        File[] javaFiles = f.listFiles(filter);

        for (File t : javaFiles) {
            System.out.println(t);
        }
    }
}
