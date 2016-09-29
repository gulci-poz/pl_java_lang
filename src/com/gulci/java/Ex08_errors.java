package com.gulci.java;

import java.io.BufferedReader;
import java.io.FileReader;

public class Ex08_errors {
    public static void main(String[] args) {
        int i = 12;
        int j = 2;

        try {
            int result = i / (j - 2);
            System.out.println("result: " + result);
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
        } catch (Exception e) {
            System.out.println("error: " + e.getMessage());
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                    System.out.println("file closed");
                } else {
                    System.out.println("null file");
                }
            } catch (Exception e) {
                System.out.println("error: " + e.getMessage());
            } finally {
                System.out.println("finally, file read done or not");
            }
        }
    }
}
