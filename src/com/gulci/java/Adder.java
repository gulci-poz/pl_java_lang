package com.gulci.java;

public class Adder extends CalculateBase {
    public Adder() {

    };

    public Adder(double leftVal, double rightVal) {
        super(leftVal, rightVal);
    }

    @Override
    public String toString() {
        return "Addition";
    }

    @Override
    public void calculate() {
        setResult(getLeftVal() + getRightVal());
    }
}
