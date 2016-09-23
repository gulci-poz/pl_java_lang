package com.gulci.java;

public abstract class Pilot {
    private FlightAdv currentFlight;

    public void fly(FlightAdv f) {
        if (canAccept(f)) {
            currentFlight = f;
        } else {
            handleCantAccept();
        }
    }

    private void handleCantAccept() {
        System.out.println("can't accept");
    }

    // can't be private
    public abstract boolean canAccept(FlightAdv f);
}
