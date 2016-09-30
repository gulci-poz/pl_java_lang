package com.gulci.java;

public class CalcEngine_06 {
    public static void main(String[] args) {
        CalculateHelper ch = new CalculateHelper();

        double[] leftVals = {32.0d, 32.0d};
        double[] rightVals = {32.0d, 0.0d};

        for (int i = 0; i < leftVals.length; i++) {
            try {
                System.out.println(ch.process(new Divider(), leftVals[i], rightVals[i]));
            } catch (InvalidCalculationElementException e) {
                System.out.println(e.getMessage());

                Throwable cause = e.getCause();

                if (cause != null) {
                    System.out.println("cause: " + cause.getMessage());
                }
            }

            System.out.println();
        }
    }
}
