package com.gulci.java;

public class Ex03_classes {
    public static void main(String[] args) {
        // object consumer - what it is doing, not how
        // Pascal case - object name
        // no access modifier - package private
        // top level classes - cannot use private, only nested classes
        // public classes have to be inside of a source file of the same name (package private - no)
        // arrays are objects
        // object can pass reference to itself as a parameter using this
        // null - reference literal, refers to an uncreated object, can be assigned to any reference variable
        // accessor/mutator pattern - to control field access - getter/setter

        // in declaration we allocate memory to store reference to the object
        Flight nycToSf;

        // object creation, memory allocation for the object, returns reference to the object
        // nycToSf is a reference to the object, not the object itself
        nycToSf = new Flight("nycToSf");

        nycToSf.addOnePassenger();

        System.out.println("number of passengers nycToSf: " + nycToSf.getPassengers());

        // in one line
        Flight slcToDallas = new Flight("slcToDallas");

        int reservations = 17;

        for (int i = 0; i < reservations; i++) {
            slcToDallas.addOnePassenger();
        }

        System.out.println("number of passengers slcToDallas: " + slcToDallas.getPassengers());

        // asign reference to the object

        Flight currentFlight = slcToDallas;
        System.out.println("current flight is: " + currentFlight.getId());

        currentFlight.addOnePassenger();
        System.out.println("passengers slcToDallas: " + slcToDallas.getPassengers());
        System.out.println("passengers current flight: " + currentFlight.getPassengers());

        // creating new flight from two others

        Flight laxToSf_01 = new Flight("laxToSf_01");
        Flight laxToSf_02 = new Flight("laxToSf_02");
        laxToSf_01.setPassengers(15);
        laxToSf_02.setPassengers(39);

        Flight laxToSf_03 = null;

        if (laxToSf_01.hasRoom(laxToSf_02)) {
            laxToSf_03 = laxToSf_01.createNewWithBoth(laxToSf_02, "laxToSf_03");
        }

        if(laxToSf_03 != null) {
            System.out.println("new flight id: " + laxToSf_03.getId());
            System.out.println("new flight number of seats: " + laxToSf_03.getSeats());
            System.out.println("new flight number of passengers: " + laxToSf_03.getPassengers());
        }
    }
}
