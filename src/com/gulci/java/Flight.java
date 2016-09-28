package com.gulci.java;

public class Flight {
    static final int MAX_FAA_SEATS = 550;

    private int passengers;
    private int seats;
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

    public Flight(String id) {
        seats = 150;
        passengers = 0;
        this.id = id;
    }

    public void addOnePassenger() {
        if (passengers < seats) {
            passengers += 1;
        }
        else {
            // function return type is void, but we can enforce exit, control goes back to the caller
            //return;
            handleTooMany();
        }
    }

    public boolean hasRoom(Flight f2) {
        return passengers + f2.passengers <= seats;
    }

    public Flight createNewWithBoth(Flight f2, String newId) {
        Flight newFlight = new Flight(newId);
        newFlight.seats = seats;
        newFlight.passengers = passengers + f2.passengers;
        System.out.println("New flight " + newFlight.id + " created.");
        return newFlight;
    }

    private void handleTooMany() {
        System.out.println("To many passengers.");
    }
}
