package com.gulci.java;

public class Divider extends CalculateBase {
    public Divider() {

    }

    public Divider(double leftVal, double rightVal) {
        super(leftVal, rightVal);
    }

    public String operator() {
        return "/";
    }

    @Override
    public String toString() {
        return MathCommand.Division.toString();
    }

    @Override
    public void calculate () {
        setResult(getLeftVal() / getRightVal());
    }
}
