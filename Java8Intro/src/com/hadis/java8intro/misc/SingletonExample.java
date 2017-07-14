package com.hadis.java8intro.misc;

/**
 * Created by Jonathan on 7/12/2017.
 */
public enum SingletonExample {
    INSTANCE;

    private String configFile = "c:\\config.txt";
    private String name = "mysingleton";

    public void doStuff() {
        System.out.println("config file: " +configFile);
        System.out.println("name:" +name);
    }
}
