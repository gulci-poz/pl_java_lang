package com.gulci.java;

import java.util.regex.PatternSyntaxException;

public class Ex05_params {
    public static void main(String[] args) {
        Flight f1 = new Flight("pozToWaw");
        Flight f2 = new Flight("wawToPoz");

        System.out.println("flight 1: " + f1.getId());
        System.out.println("flight 2: " + f2.getId());
        System.out.println();

        swapFlights(f1, f2);

        System.out.println("flight 1: " + f1.getId());
        System.out.println("flight 2: " + f2.getId());
        System.out.println();

        swapIds(f1, f2);

        System.out.println("flight 1: " + f1.getId());
        System.out.println("flight 2: " + f2.getId());
        System.out.println();

        // overloading - multiple versions of the same method (constructor)
        // signature - number of parameters, type of parameters, name (constructor name matches class name)
        // return type is not part of a signature
        // constructor cannot return anything

        // testing FlightAdv class
        Passenger p1 = new Passenger(2);
        Passenger p2 = new Passenger(2);
        Passenger p3 = new Passenger(2);
        Passenger p4 = new Passenger(2);

        FlightAdv pozToNy = new FlightAdv("pozToNy");

        pozToNy.addOnePassenger();
        pozToNy.addOnePassenger(2);
        pozToNy.addOnePassenger(2, 3);
        pozToNy.addOnePassenger(p1);
        pozToNy.addOnePassenger(p2, 3);

        // notation of a new array creation with initialization values
        //pozToNy.addPassengers(new Passenger[]{p3, p4});

        // Passenger... argument, also works with an array above
        pozToNy.addPassengers(p3, p4);

        System.out.println("passengers: " + pozToNy.getPassengers());
        System.out.println("checked bags: " + pozToNy.getTotalCheckedBags());
        System.out.println("carry ons: " + pozToNy.getTotalCarryOns());
        System.out.println("passenger 1 checked bags: " + p1.getCheckedBags());
        System.out.println("passenger 2 checked bags: " + p2.getCheckedBags());
    }

    // we pass copies of references, they still reference to the same objects

    public static void swapFlights(Flight i, Flight j) {
        Flight k;
        // we only swap references between two variables (they are copies of original references),
        // objects they refer to stay untouched
        k = i;
        i = j;
        j = k;
        System.out.println("flight i: " + i.getId());
        System.out.println("flight j: " + j.getId());
        System.out.println();
    }

    // we make changes in referenced objects

    public static void swapIds(Flight i, Flight j) {
        String k = i.getId();
        i.setId(j.getId());
        j.setId(k);
    }
}
