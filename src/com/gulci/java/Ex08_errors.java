package com.gulci.java;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Ex08_errors {
    public static void main(String[] args) {
        int i = 12;
        int j = 2;

        try {
            int result = i / (j - 2);
            System.out.println("result: " + result);
        } catch (ArithmeticException e) {
            // RuntimeException <- ArithmeticException
            System.out.println("division by zero: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("error: " + e.getMessage());
        } finally {
            System.out.println("finally, math done or not");
        }

        System.out.println();

        BufferedReader reader = null;
        int total = 0;

        try {
            reader = new BufferedReader(new FileReader("C:\\projects\\java\\pl_java_lang\\src\\numbers.txt"));
            // initialization to null is not necessary, since while will be executed at least once
            String line;
            while ((line = reader.readLine()) != null) {
                total += Integer.valueOf(line);
            }
            System.out.println("total: " + total);
        } catch (NumberFormatException e) {
            // RuntimeException <- IllegalArgumentException <- NumberFormatException
            // unseccessful conversion to numeric format
            System.out.println("invalid value: " + e.getMessage());
        } catch (FileNotFoundException e) {
            // Exception <- IOException <- FileNotFoundException
            System.out.println("file not found: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("error interacting with file: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("error: " + e.getMessage());
        } finally {
            // we can catch exceptions in finally block
            try {
                if (reader != null) {
                    reader.close();
                    System.out.println("file closed");
                } else {
                    System.out.println("null file");
                }
            } catch (IOException e) {
                System.out.println("error interacting with file: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("error: " + e.getMessage());
            } finally {
                System.out.println("finally, file read done or not");
            }
        }

        System.out.println();

        // Exception Class Hierarchy
        // Object <- Throwable <- Error (JVM related errors, for example LinkageError; treated as unchecked exceptions)
        // Object <- Throwable <- Exception:
        // <- RuntimeException (in most cases they're errors in our programs, for example Null Pointer Exception)
        // every exception that inherits from RuntimeException is an unchecked exception
        // <- IOException (and others) - checked excpetions - compiler checks if we handle these exceptions
        // every exception that inherits from Exception but not from RuntimeException is a checked exception

        // we can have seperate catch blocks for different exceptions
        // each catch is tested in order from top to bottom
        // first assignable catch is selected
        // exceptions may be catched based on a base class
        // we start with the most specific exception type

        // Java searches the call stack (up direction) for a catch (that puts a marker on the stack)
        // if it finds the marker, it cleans the stack and passes the control to the found catch
        // exceptions propagate up the call stack, can cross method boundaries
        // method is responsible for any checked exceptions that might occur (exceptions are part of a method's contract)
        // method can catch exception or document that the exception might occur
        // using throws we list any checked exceptions that can occur but are not handled in a method
        // then exceptions propagate to the caller
        // in such method we can use try and finally, without using catch
        // if we don't use finally, we don't need try
        // code in finally will be executed even if exception occurs, exception will call up the call stack

        // method overriding - throws clauses must be compatible
        // we can exclude exceptions from the base class
        // we can have the same exception
        // we can have a derived exception, for example FileNotFoundException for initial IOException (important with polymorphism)

        FlightAdv fa = new FlightAdv("fa");

        try {
            fa.addPassengers("C:\\projects\\java\\pl_java_lang\\src\\PassengerList.txt");
        } catch (IOException e) {
            System.out.println("IOException: " + e.getMessage());
        }

        System.out.println("passengers: " + fa.getPassengers());

        System.out.println();

        // many exceptions provide a constructor that accepts string message
        // when we throw an exception caused by another exception, we have to include originating exception
        // all exception classes support initCause method
        // many exceptions provide a constructor that accepts the originating exception
        // custom exceptions inherit from Exception class (if not RuntimeExcpetion, they'll be checked exceptions)
        // we must provide at least two constructors: message + details and the same with the originating exception
    }
}
