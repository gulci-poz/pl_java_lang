package com.gulci.java;

public class Ex06_inheritance {
    public static void main(String[] args) {
        CargoFlight cf1 = new CargoFlight("cf1");
        cf1.addOnePackage(1.0f, 2.5f, 3.0f);

        Passenger p1 = new Passenger();
        cf1.addOnePassenger(p1);

        // we can assign to base class typed reference
        FlightAdv f1 = new CargoFlight("f1");
        f1.addOnePassenger(p1);

        // we don't have access to methods from CargoFlight class
        //f1.addOnePackage(1.0f, 2.5f, 3.0f);

        // we can mix different objects with no attention to details of specific objects
        FlightAdv[] squadron = new FlightAdv[5];
        squadron[0] = new FlightAdv("sqF1");
        squadron[1] = new CargoFlight("sqF1");
        squadron[2] = new CargoFlight("sqF1");
        squadron[3] = new FlightAdv("sqF1");
        squadron[4] = new CargoFlight("sqF1");

        // we cannot assign a specific class to base class
        //CargoFlight cf2 = new Flight("cf2");
    }
}
