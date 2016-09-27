package com.gulci.java;

public class Subtracter extends CalculateBase {
    public Subtracter() {

    };

    public Subtracter(double leftVal, double rightVal) {
        super(leftVal, rightVal);
    }

    @Override
    public String toString() {
        return "Subtracion";
    }

    @Override
    public void calculate() {
        setResult(getLeftVal() - getRightVal());
    }
}
