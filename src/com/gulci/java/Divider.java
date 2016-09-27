package com.gulci.java;

public class Divider extends CalculateBase {
    public Divider() {

    };

    public Divider(double leftVal, double rightVal) {
        super(leftVal, rightVal);
    }

    @Override
    public String toString() {
        return "Division";
    }

    @Override
    public void calculate() {
        setResult(getLeftVal() / getRightVal());
    }
}
