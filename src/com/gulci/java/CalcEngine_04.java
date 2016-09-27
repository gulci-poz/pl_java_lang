package com.gulci.java;

public class CalcEngine_04 {
    public static void main(String[] args) {
        double[] leftVals = {100.0d, 25.0d, 225.0d, 11.0d};
        double[] rightVals = {50.0d, 92.0d, 17.0d, 3.0d};

        CalculateBase[] calculators = {new Adder(), new Subtracter(), new Multiplier(), new Divider()};

        for (int i = 0; i < leftVals.length; i++) {
            for (CalculateBase calculator : calculators) {
                calculator.setLeftVal(leftVals[i]);
                calculator.setRightVal(rightVals[i]);
                calculator.calculate();
                System.out.println(calculator.toString() + " " + (i + 1) + ": " + calculator.getResult());
            }

            System.out.println();
        }
    }
}
