package com.gulci.java;

public class Person {
    private String name;
    private Helper helper;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

// additional class in the file, package private
// it cannot be private, nor protected, nor public (nested classes can)
class Helper {

}
