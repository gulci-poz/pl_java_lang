package com.gulci.java;

public class InvalidCalculationElementException extends Exception {
    public InvalidCalculationElementException(String reason, String element) {
        super(reason + ": " + element);
    }

    public InvalidCalculationElementException(String reason, String element, Throwable cause) {
        super(reason + ": " + element, cause);
    }
}
