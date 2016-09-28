package com.gulci.java;

public class Subtracter extends CalculateBase {
    public Subtracter() {

    }

    public Subtracter(double leftVal, double rightVal) {
        super(leftVal, rightVal);
    }

    public String operator() {
        return "-";
    }

    @Override
    public String toString() {
        return MathCommand.Subtraction.toString();
    }

    @Override
    public void calculate() {
        setResult(getLeftVal() - getRightVal());
    }
}
