package com.gulci.java;

public class Adder extends CalculateBase {
    public Adder() {

    }

    public Adder(double leftVal, double rightVal) {
        super(leftVal, rightVal);
    }

    public String operator() {
        return "+";
    }

    @Override
    public String toString() {
        return MathCommand.Addition.toString();
    }

    @Override
    public void calculate() {
        setResult(getLeftVal() + getRightVal());
    }
}
