package com.gulci.java;

public class Ex01_variables {
    public static void main(String[] args) {
        System.out.println("Variables.");

        int age = 32;
        System.out.println("Age: " + age);

        int newAge;
        newAge = age;
        System.out.println("New age: " + newAge);

        // copy by value
        newAge = 33;
        System.out.println("Age: " + age);
        System.out.println("New age: " + newAge);

        // primitive types: integer, floating point, character, boolean
        // integer: byte (8), short (16), int (32), long (64) - L suffix
        // floats - implements IEEE 754; float (32) - f suffix, double (64) - d or without suffix
        // char - single Unicode character, we can use code point '\uxxxx'
        // boolean - true, false
    }
}
