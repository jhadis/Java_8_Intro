package com.hadis.java8intro.bean;

/**
 * Created by Jonathan on 3/29/2016.
 */
public class Person {

    Integer age = null;
    private String name;

    public Integer getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;

    }

    public Person(Integer inputAge) {
        this.age = inputAge;
    }

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public Person() {}

    @Override
    public String toString() {
        return "Person [" +this.name + ", " +this.age+ "]";
    }
}
