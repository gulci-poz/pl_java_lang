package com.gulci.java;

public class FlightAdv {
    private int passengers;
    private int seats;
    private int totalCheckedBags;
    private int maxCarryOns;
    private int totalCarryOns;
    private String id;

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

    public FlightAdv(String id) {
        seats = 150;
        passengers = 0;
        totalCheckedBags = 0;
        maxCarryOns = seats * 2;
        totalCarryOns = 0;
        this.id = id;
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

    public boolean hasRoom(FlightAdv f2) {
        return passengers + f2.passengers < seats;
    }

    private boolean hasSeating() {
        return passengers < seats;
    }

    private boolean hasSeating(int count) {
        return passengers + count <= seats;
    }

    private boolean hasCarryOnSpace(int carryOns) {
        return totalCarryOns + carryOns <= maxCarryOns;
    }

    public FlightAdv createNewWithBoth(FlightAdv f2, String newId) {
        FlightAdv newFlight = new FlightAdv(newId);
        newFlight.seats = seats;
        newFlight.passengers = passengers + f2.passengers;
        System.out.println("New flight " + newFlight.id + " created.");
        return newFlight;
    }

    private void handleTooMany() {
        System.out.println("To many passengers.");
    }
}
