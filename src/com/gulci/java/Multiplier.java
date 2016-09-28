package com.gulci.java;

public class Multiplier extends CalculateBase {
    public Multiplier() {

    }

    public Multiplier(double leftVal, double rightVal) {
        super(leftVal, rightVal);
    }

    public String operator() {
        return "*";
    }

    @Override
    public String toString() {
        return MathCommand.Multiplication.toString();
    }

    @Override
    public void calculate() {
        setResult(getLeftVal() * getRightVal());
    }
}
