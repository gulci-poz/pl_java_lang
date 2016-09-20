package com.gulci.java;

public class Ex02_1_conditions {
    public static void main(String[] args) {
        System.out.println("Conditions.");

        int v1 = 10;
        int v2 = 5;
        int vMax = v1 > v2 ? v1 : v2;
        System.out.println("vMax: " + vMax);

        // code block
        {
            int testInt = 32;
            System.out.println("local testInt: " + testInt);
        }

        int testInt = 33;
        System.out.println("global testInt: " + testInt);

        if (v1 > v2) {
            System.out.println(v1 + " > " + v2);
        } else if (v1 == v2) {
            System.out.println(v1 + " eq " + v2);
        } else {
            System.out.println(v1 + " < " + v2);
        }

        // nest if
        if (v1 > v2) {
            System.out.println(v1 + " > " + v2);
        } else {
            if (v1 == v2) {
                System.out.println(v1 + " eq " + v2);
            } else {
                System.out.println(v1 + " < " + v2);
            }
        }

        if (v1 != v2) {
            System.out.println(v1 + " is not equal " + v2);
        }

        // logical operators: &, |, ^ (XOR), !
        // true: false ^ true or true ^ false, only one side must be true
        // true: !false

        // conditional logical operators: &&, ||
        // && executes right side only if left side is true
        // || executes right side only if left side is false

        int students = 150;
        int rooms = 0;

        // using & will cause an error - right side will be executed
        if (rooms > 0 && students / rooms > 0) {
            System.out.println("Crowded room!");
        }
    }
}
