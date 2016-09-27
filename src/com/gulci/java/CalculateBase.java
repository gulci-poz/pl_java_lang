package com.gulci.java;

public abstract class CalculateBase {
    private double leftVal = 0.0d;
    private double rightVal = 0.0d;
    private double result = 0.0d;

    public double getLeftVal() {
        return leftVal;
    }

    public void setLeftVal(double leftVal) {
        this.leftVal = leftVal;
    }

    public double getRightVal() {
        return rightVal;
    }

    public void setRightVal(double rightVal) {
        this.rightVal = rightVal;
    }

    public double getResult() {
        return result;
    }

    // package visibility
    // outside the package we cannot use it in user's class
    // outside the package we cannot override it in derived class
    // outside the package we cannot use it in derived class
    void setResult(double result) {
        this.result = result;
    }

    public CalculateBase() {
    }

    public CalculateBase(double leftVal, double rightVal) {
        this.leftVal = leftVal;
        this.rightVal = rightVal;
    }

    public abstract void calculate();
}
