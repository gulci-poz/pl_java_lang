package com.gulci.java;

public class CalcEngine_02 {
    public static void main(String[] args) {
        System.out.println("CalcEngine_02.");

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
