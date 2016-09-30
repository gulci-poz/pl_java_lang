package com.gulci.java;

import static com.gulci.java.FlightAdv.getAllPassengers;

public class Ex11_additional {
    public static void main(String[] args) {
        FlightAdv.resetAllPassengers();
        // static import - provides short hand for accessing static members
        System.out.println("all passengers: " + getAllPassengers());

        // static members are stored in different part of the memory than the members of the instances
        FlightAdv fa1 = new FlightAdv("fa1");
        fa1.addOnePassenger();
        System.out.println("all passengers: " + getAllPassengers());

        FlightAdv fa2 = new FlightAdv("fa2");
        fa2.addOnePassenger();
        System.out.println("all passengers: " + getAllPassengers());
    }
}
