package com.gulci.java;

public class Ex06_inheritance {
    public static void main(String[] args) {
        CargoFlight cf1 = new CargoFlight("cf1");
        cf1.addOnePackage(1.0f, 2.5f, 3.0f);

        Passenger p1 = new Passenger();
        cf1.addOnePassenger(p1);

        // we can assign to base class typed reference
        // we specify the reference type for storing the reference for an object of specific type
        // we can start from general object and later detail it by casting to a specific type
        FlightAdv f1 = new CargoFlight("f1");
        f1.addOnePassenger(p1);

        // we don't have access to methods from CargoFlight class
        // we have access to overriden private fields with overriden getter (based on object created, not referenced type)
        //f1.addOnePackage(1.0f, 2.5f, 3.0f);

        // we can mix different objects with no attention to details of specific objects
        // later we can cast to a specific class
        FlightAdv[] squadron = new FlightAdv[5];
        squadron[0] = new FlightAdv("sqF1");
        squadron[1] = new CargoFlight("sqF1");
        squadron[2] = new CargoFlight("sqF1");
        squadron[3] = new FlightAdv("sqF1");
        squadron[4] = new CargoFlight("sqF1");

        // we cannot assign base class to specific class
        //CargoFlight cf2 = new Flight("cf2");

        // we can cast base class object to a specific class object
        CargoFlight cf2 = (CargoFlight) f1;
        // now we can use methods of a specific class
        cf2.addOnePackage(2.0f, 3.0f, 1.0f);

        System.out.println("seats cf1: " + cf1.getSeats() + ", control: " + cf1.control);
        System.out.println("seats f1: " + f1.getSeats() + ", control: " + f1.control);
        System.out.println("seats cf2: " + cf2.getSeats() + ", control: " + cf2.control);

        // Object - universal reference type
        // now we only have access to the Object's fields and methods
        // we can cast this object to a specific class
        Object objFlight = new CargoFlight("objFlight");

        if (objFlight instanceof CargoFlight) {
            CargoFlight cf3 = (CargoFlight) objFlight;
            cf3.addOnePackage(1.0f, 1.0f, 1.0f);
        }

        // clone - additional steps to perform cloning; duplication of the current instance resulting in a new object
        // (not only reference)
        System.out.println("objFlight hashCode: " + objFlight.hashCode());
        System.out.println("objFlight getClass: " + objFlight.getClass());
        // finalize - special resource cleanup scenarios
        System.out.println("objFlight toString: " + objFlight.toString());
        // equals - compare another object to the current instance for equality

        // comparing references - do the references point to the same object
        FlightAdv fa1 = new FlightAdv("fa1");
        FlightAdv fa2 = new FlightAdv("fa2");

        // assigning reference
        // we loose track of the object that fa2 was referencing to
        //fa2 = fa1;

        if (fa1 == fa2) {
            System.out.println("references are equal");
        } else {
            System.out.println("references aren't equal");
        }

        // comparing objects, equals() also performs reference equality test
        // we've changed the behaviour of equals()
        if (fa1.equals(fa2)) {
            System.out.println("objects are equal");
        } else {
            System.out.println("objects aren't equal");
        }

        // we secured equals() for this situation
        if (fa1.equals(p1)) {
            System.out.println("objects are equal (p1)");
        } else {
            System.out.println("objects aren't equal (p1)");
        }
    }
}
