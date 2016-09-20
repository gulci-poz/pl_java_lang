package com.gulci.java;

import java.util.stream.IntStream;

public class Ex02_2_loops_arrays_switch {
    public static void main(String[] args) {
        System.out.println("Loops, arrays, switch.");

        int cond = 5;

        // may never execute
        while (cond > 0) {
            System.out.println(cond + " > 0");
            cond--;
        }

        // executes at least once
        do {
            // wrong result 0 > 0
            System.out.println(cond + " > 0");
        } while (cond > 0);

        // for - a form of while loop
        int factorial = 1;

        for (int i = 5; i > 0; i--) {
            factorial *= i;
        }

        System.out.println("factorial 5: " + factorial);

        // be careful!
        System.out.println(cond++ * 2);
        System.out.println(cond * 2);

        // array - ordered collection of elements of specific type
        /*
        float[] theVals = new float[3];
        theVals[0] = 0.0f;
        theVals[1] = 1.0f;
        theVals[2] = 2.0f;
        */

        // short form
        float[] theVals = {5.0f, 10.0f, 15.0f};

        float sum = 0.0f;

        for (int i = 0; i < theVals.length; i++) {
            sum += theVals[i];
        }

        System.out.println("theVals sum: " + sum);

        // for-each
        int iFactorial = 1;

        // Java 8 IntStream (or we can use Guava)
        // simple example without direct iteration in IntStream and lambdas
        for (int i : IntStream.rangeClosed(1, 9).toArray()) {
            iFactorial *= i;
        }

        System.out.println("iFactorial 10: " + iFactorial);

        // switch - works for ints and chars (considering primitive types)
        int iVal = 10;

        switch (iVal % 2) {
            case 0:
                System.out.println(iVal + " even");
                break;
            case 1:
                System.out.println(iVal + " odd");
                break;
            default:
                System.out.println("error");
                break;
        }
    }
}
