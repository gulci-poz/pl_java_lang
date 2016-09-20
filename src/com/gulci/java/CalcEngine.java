package com.gulci.java;

public class CalcEngine {
    public static void main(String[] args) {
        System.out.println("CalcEngine.");

        double val1 = 100.0d;
        double val2 = 30.0d;
        double result;
        char opCode = 'd';

        if (opCode == 'a') {
            result = val1 + val2;
        } else if (opCode == 's') {
            result = val1 - val2;
        } else if (opCode == 'd' && val2 != 0) {
            // solution 1 - with &&
            result = val1 / val2;

            // solution 2
            //result = val2 != 0.0d ? val1 / val2 : 0.0d;

            // solution 3
            /*
            if (val2 != 0.0d) {
                result = val1 / val2;
            } else {
                result = 0.0d;
            }
            */
        } else if (opCode == 'm') {
            result = val1 * val2;
        } else {
            // or val2 equals 0
            // System.out.println("invalid opCode");
            result = 0.0d;
        }

        System.out.println("result: " + result);
    }
}
