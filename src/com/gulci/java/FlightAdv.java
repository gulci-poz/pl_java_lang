package com.gulci.java;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FlightAdv {
    // default for boolean is false
    private int passengers;
    private int seats;
    private int totalCheckedBags;
    private int maxCarryOns;
    private int totalCarryOns;
    private String id;
    public int control;
    private int flightNumber;
    private char flightClass;

    public int getPassengers() {
        return passengers;
    }

    public void setPassengers(int passengers) {
        this.passengers = passengers;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getTotalCheckedBags() {
        return totalCheckedBags;
    }

    public void setTotalCheckedBags(int totalCheckedBags) {
        this.totalCheckedBags = totalCheckedBags;
    }

    public int getMaxCarryOns() {
        return maxCarryOns;
    }

    public void setMaxCarryOns(int maxCarryOns) {
        this.maxCarryOns = maxCarryOns;
    }

    public int getTotalCarryOns() {
        return totalCarryOns;
    }

    public void setTotalCarryOns(int totalCarryOns) {
        this.totalCarryOns = totalCarryOns;
    }

    public int getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(int flightNumber) {
        this.flightNumber = flightNumber;
    }

    public char getFlightClass() {
        return flightClass;
    }

    public void setFlightClass(char flightClass) {
        this.flightClass = flightClass;
    }

//    public FlightAdv() {
//
//    }

    public FlightAdv(String id) {
        seats = 150;
        passengers = 0;
        totalCheckedBags = 0;
        maxCarryOns = seats * 2;
        totalCarryOns = 0;
        control = 32;
        this.id = id;
    }

    // we can define what object equality means for us
    @Override
    public boolean equals(Object o) {
        // we may have the same object, further comparisons are not necessary
        // if it's not the case, we compare specific fields
        if (super.equals(o)) {
            return true;
        }

        // we can only compare FlightAdv objects
        if (!(o instanceof FlightAdv)) {
            return false;
        }

        // we need access to flightNumber and flightClass, we have to cast Object to FlightAdv
        FlightAdv other = (FlightAdv) o;
        return
                getFlightNumber() == other.getFlightNumber()
                        && getFlightClass() == other.getFlightClass();

    }

    public boolean addOnePassenger() {
        if (hasSeating()) {
            passengers += 1;
            return true;
        } else {
            // function return type is void, but we can enforce exit, control goes back to the caller
            //return;
            handleTooMany();
            return false;
        }
    }

    public int addOnePassenger(int bags) {
        if (addOnePassenger()) {
            totalCheckedBags += bags;
            return bags;
        } else {
            // implies that we didn't add a passenger (there's no seats, no bags added)
            return 0;
        }
    }

    // convenience method
    public int addOnePassenger(Passenger p) {
        // we don't have to add all bags
        // there may be a difference between reservation and actual state
        int bagsAdded = addOnePassenger(p.getBags());

        if (bagsAdded > 0) {
            p.setCheckedBags(bagsAdded);
            return bagsAdded;
        } else {
            // implies that we didn't add a passenger (there's no seats, no bags added)
            return 0;
        }
    }

    public int addOnePassenger(int bags, int carryOns) {
        // we have to check seat first,
        // because there may be a situation,
        // when we add a passenger with his bag,
        // but there's no space left for carry ons
        if (hasSeating() && hasCarryOnSpace(carryOns)) {
            if (addOnePassenger(bags) > 0) {
                totalCarryOns += carryOns;
                return carryOns;
            } else {
                // implies that we didn't add a passenger (there's no seats, no bags added)
                return 0;
            }
        } else {
            // implies that we didn't add a passenger (lack of carry on space)
            return 0;
        }
    }

    // convenience method
    public int addOnePassenger(Passenger p, int carryOns) {
        // we don't register passenger's carry ons

        int carryOnsAdded = addOnePassenger(p.getBags(), carryOns);

        if (carryOnsAdded > 0) {
            // we added carry ons, so bugs are also added
            p.setCheckedBags(p.getBags());
            return carryOnsAdded;
        } else {
            // implies that we didn't add a passenger (lack of carry on space)
            return 0;
        }
    }

    /*
    public void addPassengers(Passenger[] passengersList) {
        if (hasSeating(passengersList.length)) {
            passengers += passengersList.length;

            for (Passenger passenger : passengersList) {
                totalCheckedBags += passenger.getBags();
                passenger.setCheckedBags(passenger.getBags());
            }
        } else {
            handleTooMany();
        }
    }
    */

    // list of values must be the last argument
    // now we can pass an array or separate Passenger variables (method receives an array)
    public void addPassengers(Passenger... passengersList) {
        if (hasSeating(passengersList.length)) {
            passengers += passengersList.length;

            for (Passenger passenger : passengersList) {
                totalCheckedBags += passenger.getBags();
                passenger.setCheckedBags(passenger.getBags());
            }
        } else {
            handleTooMany();
        }
    }

    public void addPassengers(String filename) throws IOException {
        BufferedReader reader = null;

        try {
            reader = new BufferedReader(new FileReader(filename));
            String line;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" ");
                passengers += Integer.valueOf(parts[0]);
            }
        } finally {
            if (reader != null) {
                reader.close();
            }
        }
    }

    public boolean hasRoom(FlightAdv f2) {
        return getPassengers() + f2.getPassengers() <= getSeats();
    }

    // we have to use getters/setters to fetch values of new private fields for derived class
    // private fields are not inherited, so using direct access we'll be using base class private fields
    // we have to use getters/setters for accessing all private fields if we plan to define them one more time in derived class

    private boolean hasSeating() {
        return getPassengers() < getSeats();
    }

    private boolean hasSeating(int count) {
        return getPassengers() + count <= getSeats();
    }

    private boolean hasCarryOnSpace(int carryOns) {
        return getTotalCarryOns() + carryOns <= getMaxCarryOns();
    }

    public FlightAdv createNewWithBoth(FlightAdv f2, String newId) {
        FlightAdv newFlight = new FlightAdv(newId);
        newFlight.seats = getSeats();
        newFlight.passengers = getPassengers() + f2.getPassengers();
        System.out.println("New flight " + newFlight.id + " created.");
        return newFlight;
    }

    private void handleTooMany() {
        System.out.println("To many passengers.");
    }
}
