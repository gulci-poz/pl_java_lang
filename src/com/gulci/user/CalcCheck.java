package com.gulci.user;

import com.gulci.java.CalculateBase;

public class CalcCheck extends CalculateBase {
    public void calculate() {
        // setResult() in CalculateBase has no modifier (package visibility), we dont't have access to it outside the package
        // if marked protected, we would
        //setResult(0.0d);
    }

    public String operator() {
        return "";
    }
}
