package com.gulci.java;

public class CargoOnlyPilot extends Pilot {
    @Override
    public boolean canAccept(FlightAdv f) {
        return f.getPassengers() == 0;
    }
}
