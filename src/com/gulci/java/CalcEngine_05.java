package com.gulci.java;

public class CalcEngine_05 {
    public static void main(String[] args) {
        double[] leftVals = {100.0d, 25.0d, 225.0d, 11.0d};
        double[] rightVals = {50.0d, 92.0d, 17.0d, 3.0d};

        CalculateBase[] calculators = {new Adder(), new Subtracter(), new Multiplier(), new Divider()};
        CalculateHelper ch = new CalculateHelper();

        for (int i = 0; i < leftVals.length; i++) {
            for (CalculateBase calculator : calculators) {
                //System.out.println(ch.process(calculator, leftVals[i], rightVals[i]));
                //System.out.println(ch.process(calculator, leftVals[i], rightVals[i], (i + 1)));
                //System.out.println(ch.processExt(calculator, leftVals[i], rightVals[i]));
                System.out.println(ch.processExt(calculator, leftVals[i], rightVals[i], (i + 1)));
            }

            System.out.println();
        }
    }
}
