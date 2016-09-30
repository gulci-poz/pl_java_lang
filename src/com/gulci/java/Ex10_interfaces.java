package com.gulci.java;

import java.util.Arrays;

public class Ex10_interfaces {
    public static void main(String[] args) {
        // an interface is a type that defines a contract
        // provides no implementation, only a contract
        // implementing class conforms to that contract

        Passenger bob = new Passenger();
        bob.setMemberLevel(3);
        bob.setMemberDays(90);

        Passenger jane = new Passenger();
        jane.setMemberLevel(2);
        jane.setMemberDays(180);

        Passenger steve = new Passenger();
        steve.setMemberLevel(1);
        steve.setMemberDays(305);

        Passenger lisa = new Passenger();
        lisa.setMemberLevel(2);
        lisa.setMemberDays(181);

        Passenger[] passengers = {bob, jane, steve, lisa};
        Arrays.sort(passengers);

        for (Passenger p : passengers) {
            System.out.println(p.getMemberLevel() + " " + p.getMemberDays());
        }

        System.out.println();

        FlightAdv poz01 = new FlightAdv("poz01");
        poz01.setFlightTime(30);

        FlightAdv war01 = new FlightAdv("war01");
        war01.setFlightTime(76);

        FlightAdv kat01 = new FlightAdv("kat01");
        kat01.setFlightTime(99);

        FlightAdv gda01 = new FlightAdv("gda01");
        gda01.setFlightTime(51);

        FlightAdv[] flights = {poz01, war01, kat01, gda01};
        Arrays.sort(flights);

        for (FlightAdv fa : flights) {
            System.out.println(fa.getFlightTime());
        }

        System.out.println();

        CrewMember patty = new CrewMember(CrewMember.FlightCrewJob.Pilot);
        CrewMember karl = new CrewMember(CrewMember.FlightCrewJob.CoPilot);
        CrewMember mary = new CrewMember(CrewMember.FlightCrewJob.AirMarshal);

        patty.setName("patty");
        karl.setName("karl");
        mary.setName("mary");

        CrewMember[] crew = {patty, karl, mary};

        bob.setName("bob");
        jane.setName("jane");
        steve.setName("steve");
        lisa.setName("lisa");

        // we assign a reference
        Passenger[] roster = passengers;

        FlightAdv lax01 = new FlightAdv("lax01");
        lax01.setCrew(crew);
        lax01.setRoster(roster);

        for (Person p : lax01) {
            System.out.println(p.getName());
        }

        // declaring an interface
        // methods - name, parameters and return type, implicitly public
        // constants - typed named values, implicitly public, final, static
        // extending interfaces - we can extend another interface
        // implementing extended interface implies implementation of base

        // interfaces provide more intuitive polymorphism

        System.out.println();

        // version with inner class FlightIterator

        FlightAdv2 bar01 = new FlightAdv2("bar01");
        bar01.setCrew(crew);
        bar01.setRoster(roster);

        for (Person p : bar01) {
            System.out.println(p.getName());
        }
    }
}
