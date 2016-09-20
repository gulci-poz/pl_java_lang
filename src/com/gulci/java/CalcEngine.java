package com.gulci.java;

public class CalcEngine {
    public static void main(String[] args) {
        System.out.println("CalcEngine.");

        // version 1
        /*
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
//            if (val2 != 0.0d) {
//                result = val1 / val2;
//            } else {
//                result = 0.0d;
//            }
        } else if (opCode == 'm') {
            result = val1 * val2;
        } else {
            // or val2 equals 0
            // System.out.println("invalid opCode");
            result = 0.0d;
        }

        System.out.println("result: " + result);
        */

        // version 2
        // parallel arrays
        double[] leftVals = {100.0d, 25.0d, 225.0d, 11.0d};
        double[] rightVals = {50.0d, 92.0d, 17.0d, 3.0d};
        char[] opCodes = {'d', 'a', 's', 'm'};
        double[] results = new double[opCodes.length];

        for (int i = 0; i < opCodes.length; i++) {
            char operator;
            switch (opCodes[i]) {
                case 'd':
                    if (rightVals[i] != 0.0d) {
                        results[i] = leftVals[i] / rightVals[i];
                        operator = '/';
                    } else {
                        results[i] = 0.0d;
                        operator = '?';
                        System.out.println("division by 0 error");
                    }
                    break;
                case 'a':
                    results[i] = leftVals[i] + rightVals[i];
                    operator = '+';
                    break;
                case 's':
                    results[i] = leftVals[i] - rightVals[i];
                    operator = '-';
                    break;
                case 'm':
                    results[i] = leftVals[i] * rightVals[i];
                    operator = '*';
                    break;
                default:
                    results[i] = 0.0d;
                    operator = '?';
                    System.out.println("unknown operator");
                    break;
            }

            System.out.println(leftVals[i] + " " + operator + " " + rightVals[i] + " = " + results[i]);
        }

        for (double result: results) {
            System.out.println("result = " + result);
        }
    }
}
