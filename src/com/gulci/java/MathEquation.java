package com.gulci.java;

public class MathEquation {
    private double leftVal = 0.0d;
    private double rightVal = 0.0d;
    private char opCode = 'a';
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

    public char getOpCode() {
        return opCode;
    }

    public void setOpCode(char opCode) {
        this.opCode = opCode;
    }

    public double getResult() {
        return result;
    }

    public MathEquation() {

    }

    public MathEquation(char opCode) {
        this.opCode = opCode;
    }

    public MathEquation(double leftVal, double rightVal, char opCode) {
        this.leftVal = leftVal;
        this.rightVal = rightVal;
        this.opCode = opCode;
        // result is always initialized in field initialization
    }

    public void execute() {
        switch (opCode) {
            case 'd':
                if (rightVal != 0.0d) {
                    result = leftVal / rightVal;
                } else {
                    result = 0.0d;
                    System.out.println("division by 0 error");
                }
                break;
            case 'a':
                result = leftVal + rightVal;
                break;
            case 's':
                result = leftVal - rightVal;
                break;
            case 'm':
                result = leftVal * rightVal;
                break;
            default:
                result = 0.0d;
                System.out.println("unknown operator error");
                break;
        }
    }

    public void execute(double leftVal, double rightVal) {
        this.leftVal = leftVal;
        this.rightVal = rightVal;

        execute();
    }

    public void execute(int leftVal, int rightVal) {
        this.leftVal = leftVal;
        this.rightVal = rightVal;

        execute();

        result = (int) result;
    }
}
