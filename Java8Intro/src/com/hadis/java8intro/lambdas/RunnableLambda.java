package com.hadis.java8intro.lambdas;

/**
 * Created by Jonathan on 3/21/2016.
 */
public class RunnableLambda {

    public static void main(String... args) throws InterruptedException {

        Runnable r = () -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("Hello world!");
            }
        };

        Thread t = new Thread(r);
        t.start();
        t.join();

    }
}
