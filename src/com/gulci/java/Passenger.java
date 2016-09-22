package com.gulci.java;

public class Passenger {
    private int bags;
    private int checkedBags;

    public int getBags() {
        return bags;
    }

    public void setBags(int bags) {
        this.bags = bags;
    }

    public int getCheckedBags() {
        return checkedBags;
    }

    public void setCheckedBags(int checkedBags) {
        this.checkedBags = checkedBags;
    }

    public Passenger() {
        bags = 0;
        checkedBags = 0;
    }

    public Passenger(int bags) {
        this.bags = bags;
        checkedBags = 0;
    }

    public boolean bagsChecked() {
        if (bags == checkedBags) {
            return true;
        } else {
            return false;
        }
    }
}
