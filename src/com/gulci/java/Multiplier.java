package com.gulci.java;

public class Multiplier extends CalculateBase {
    public Multiplier() {

    };

    public Multiplier(double leftVal, double rightVal) {
        super(leftVal, rightVal);
    }

    @Override
    public String toString() {
        return "Multiplication";
    }

    @Override
    public void calculate() {
        setResult(getLeftVal() * getRightVal());
    }
}
