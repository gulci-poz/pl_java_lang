package com.gulci.java;

public class Adder2 extends CalculateBase implements MathProcessing {
    public Adder2() {

    }

    public Adder2(double leftVal, double rightVal) {
        super(leftVal, rightVal);
    }

    @Override
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

    // we implement abstract operator and calculate methods (but without interfaces, they're just abstract methods in the base class)
    // we implement doCalculation directly from the interface MathProcessing
}
