package com.gulci.java;

public class CalculateHelper {
    public String process(CalculateBase calculator, double leftVal, double rightVal) throws InvalidCalculationElementException {
        // we don't check equality of floats and doubles, but here we assume we have literals and Infinity
        if (leftVal == rightVal && calculator instanceof Divider) {
            throw new InvalidCalculationElementException("same number division", calculator.toString());
        }

        calculate(calculator, leftVal, rightVal);
        try {
            if (calculator.getResult() == Double.POSITIVE_INFINITY || calculator.getResult() == Double.NEGATIVE_INFINITY) {
                // we don't need throws for ArithmeticException (unckecked exception)
                // but we need catch for ArithmeticException in every method up in the chain call
                throw new ArithmeticException("ArithmeticException division by zero");
            }
        } catch (ArithmeticException e) {
            throw new InvalidCalculationElementException("division by zero", calculator.toString(), e);
        }

        return buildResult(calculator, leftVal, rightVal);
    }

    public String process(CalculateBase calculator, double leftVal, double rightVal, int order) {
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
