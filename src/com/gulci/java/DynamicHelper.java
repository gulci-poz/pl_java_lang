package com.gulci.java;

public class DynamicHelper {
    // in this example we return a string with result instead of building a formated string
    public String process(MathProcessing handler, double leftVal, double rightVal) {
        return String.valueOf(handler.doCalculation(leftVal, rightVal));
    }
}
