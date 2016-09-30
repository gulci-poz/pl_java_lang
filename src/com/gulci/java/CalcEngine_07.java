package com.gulci.java;

public class CalcEngine_07 {
    public static void main(String[] args) {
        double[] leftVals = {100.0d, 25.0d, 225.0d, 11.0d};
        double[] rightVals = {50.0d, 92.0d, 17.0d, 3.0d};

        DynamicHelper dh = new DynamicHelper();

        for (int i = 0; i < leftVals.length; i++) {
            System.out.println(dh.process(new Adder2(), leftVals[i], rightVals[i]));
        }

        System.out.println("power example: " + dh.process(new Power(), 5.0d, 2.0d));
    }
}
