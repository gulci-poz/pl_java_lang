package com.gulci.java;

public class CargoFlight extends FlightAdv {
    private float maxCargoSpace = 1000.0f;
    private float usedCargoSpace;

    public float getMaxCargoSpace() {
        return maxCargoSpace;
    }

    public void setMaxCargoSpace(float maxCargoSpace) {
        this.maxCargoSpace = maxCargoSpace;
    }

    public float getUsedCargoSpace() {
        return usedCargoSpace;
    }

    public void setUsedCargoSpace(float usedCargoSpace) {
        this.usedCargoSpace = usedCargoSpace;
    }

    public CargoFlight(String id) {
        super(id);
    }

    public void addOnePackage(float width, float height, float depth) {
        float size = height * width * depth;

        if (hasCargoSpace(size)) {
            usedCargoSpace += size;
        } else {
            handleNoSpace();
        }
    }

    private boolean hasCargoSpace(float size) {
        return usedCargoSpace + size <= maxCargoSpace;
    }

    private void handleNoSpace() {
        System.out.println("Not enough space.");
    }
}
