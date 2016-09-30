package com.gulci.java;

import static com.gulci.java.FlightAdv.getAllPassengers;

public class Ex11_static {
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

        // static initialization block performs one-time type initialization
        // it's executed before type's first use
        // cannot access instance members (just like static members)
        // must handle all checked exceptions

        CrewMember cm1 = CrewManager.FindAvailable(CrewMember.FlightCrewJob.Pilot);
        System.out.println("available pilot: " + cm1.getName());

        CrewMember cm2 = CrewManager.FindAvailable(CrewMember.FlightCrewJob.AirMarshal);
        System.out.println("available air marshal: " + cm2.getName());

        CrewMember cm3 = CrewManager.FindAvailable(CrewMember.FlightCrewJob.Pilot);
        System.out.println("available pilot: " + cm3.getName());

        // we have initialized array in CrewManager with available people
        // some elements may be null after finding specialists earlier
    }
}
