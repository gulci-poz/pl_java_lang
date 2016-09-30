package com.gulci.java;

public class Passenger extends Person implements Comparable<Passenger> {
    private int bags;
    private int checkedBags;
    // 1-silver, 2-gold, 3-platinum
    private int memberLevel;
    private int memberDays;

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

    public int getMemberLevel() {
        return memberLevel;
    }

    public void setMemberLevel(int memberLevel) {
        this.memberLevel = memberLevel;
    }

    public int getMemberDays() {
        return memberDays;
    }

    public void setMemberDays(int memberDays) {
        this.memberDays = memberDays;
    }

    public Passenger() {
        bags = 0;
        checkedBags = 0;
    }

    public Passenger(int bags) {
        this.bags = bags;
        checkedBags = 0;
    }

    public int compareTo(Passenger p) {
        if (memberLevel > p.memberLevel) {
            return -1;
        } else if (memberLevel < p.memberLevel) {
            return 1;
        } else {
            if (memberDays > p.memberDays) {
                return -1;
            } else if (memberDays < p.memberDays) {
                return 1;
            } else {
                return 0;
            }
        }
    }

    public boolean bagsChecked() {
        if (bags == checkedBags) {
            return true;
        } else {
            return false;
        }
    }
}
