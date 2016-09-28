package com.gulci.java;

public class CalculateHelper {
    public String process(CalculateBase calculator, double leftVal, double rightVal) {
        calculate(calculator, leftVal, rightVal);
        return buildResult(calculator, leftVal, rightVal);
    }

    public String process(CalculateBase calculator, double leftVal, double rightVal, int order) {
        calculate(calculator, leftVal, rightVal);
        return buildResult(calculator, leftVal, rightVal, order);
    }

    public String processExt(CalculateBase calculator, double leftVal, double rightVal) {
        calculate(calculator, leftVal, rightVal);
        return buildResult(calculator, leftVal, rightVal);
    }

    // StringBuilder version
    public String processExt(CalculateBase calculator, double leftVal, double rightVal, int order) {
        calculate(calculator, leftVal, rightVal);
        return buildResult(calculator, leftVal, rightVal, order);
    }

    private void calculate(CalculateBase calculator, double leftVal, double rightVal) {
        calculator.setLeftVal(leftVal);
        calculator.setRightVal(rightVal);
        calculator.calculate();
    }

    private String buildResult(CalculateBase calculator, double leftVal, double rightVal) {
        StringBuilder result = new StringBuilder();
        result.append(calculator);
        result.append(": ");
        result.append(leftVal);
        result.append(" ");
        result.append(calculator.operator());
        result.append(" ");
        result.append(rightVal);
        result.append(" = ");
        result.append(calculator.getResult());
        return result.toString();
    }

    private String buildResult(CalculateBase calculator, double leftVal, double rightVal, int order) {
        StringBuilder result = new StringBuilder();
        result.append(calculator);
        result.append(" ");
        result.append(order);
        result.append(": ");
        result.append(leftVal);
        result.append(" ");
        result.append(calculator.operator());
        result.append(" ");
        result.append(rightVal);
        result.append(" = ");
        result.append(calculator.getResult());
        return result.toString();
    }
}
