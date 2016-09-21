package com.gulci.java;

public class CalcEngine_03 {
    public static void main(String[] args) {
        System.out.println("CalcEngine_03.");

        double[] leftVals = {100.0d, 25.0d, 225.0d, 11.0d};
        double[] rightVals = {50.0d, 92.0d, 17.0d, 3.0d};
        char[] opCodes = {'d', 'a', 's', 'm'};

        MathEquation[] equations = new MathEquation[4];

        for (int i = 0; i < equations.length; i++) {
            // we can use static function in main class,
            // but it's tedious and cause creation of a helper equation object
            equations[i] = new MathEquation(leftVals[i], rightVals[i], opCodes[i]);
            equations[i].execute();
            System.out.println("result " + (i + 1) + " = " + equations[i].getResult());
        }

        MathEquation testEquation = new MathEquation();
        System.out.println("test equation: " + testEquation.getResult());
    }
}
