package com.gulci.java;

public class Power extends CalculateBase implements MathProcessing {
    public Power() {

    }

    public Power(double leftVal, double rightVal) {
        super(leftVal, rightVal);
    }

    public String operator() {
        return "^";
    }

    @Override
    public String toString() {
        return MathCommand.Power.toString();
    }

    @Override
    public void calculate() {
//        int exp = (int) getRightVal();
//        double result = 1;
//
//        for (int i = 0; i < exp; i++) {
//            result *= getLeftVal();
//        }
//
//        setResult(result);

        setResult(Math.pow(getLeftVal(), getRightVal()));
    }

    @Override
    public double doCalculation(double leftVal, double rightVal) {
        // in CalculateHelper we have a method for doing this
        // we don't externalize it to Adder, Subtracter etc.
        setLeftVal(leftVal);
        setRightVal(rightVal);
        calculate();
        return getResult();
    }

    // CalculateBase could implement MathProcessing
    // we could then mark abstract all methods from the interface
    // and implement them in Adder, Subtracter, Multiplier and Divider classes
}
