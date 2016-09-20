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
        // char (8) - single Unicode character, we can use code point - backslash uxxxx - in single quotes
        // boolean - true, false

        // operators
        // result of integer division is floor
        // result of float modulus is float remainder

        int postAdd = 5;
        System.out.println(++postAdd);
        System.out.println(postAdd);
        System.out.println(postAdd++);
        System.out.println(postAdd);

        // precedence: post, pre, mult, add

        // implicit type conversion
        // widening conversions are automatic
        // mixed inegers in expression - uses largest
        // float and double in expression - uses double
        // integers and floats - uses largest float
        int iVal = 50;
        long lVal = iVal;
        System.out.println("lVal: " + lVal);

        // explicit type conversion - with cast operator
        // widening and narrowing
        // float -> int - fraction drop
        // int -> float - possible loss of precision (large integers)
        long lValExpl = 50;
        int iValExpl = (int) lValExpl;
        System.out.println("iValExpl: " + iValExpl);
    }
}
