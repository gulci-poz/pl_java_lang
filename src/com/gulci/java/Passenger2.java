package com.gulci.java;

public class Passenger2 extends Person implements Comparable<Passenger2> {
    private int bags;
    private int checkedBags;

    public static class RewardProgram {
        // 1-silver, 2-gold, 3-platinum
        private int memberLevel;
        private int memberDays;

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
    }

    private RewardProgram rewardProgram = new RewardProgram();

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

    public RewardProgram getRewardProgram() {
        return rewardProgram;
    }

    public Passenger2() {
        bags = 0;
        checkedBags = 0;
    }

    public Passenger2(int bags) {
        this.bags = bags;
        checkedBags = 0;
    }

    public int compareTo(Passenger2 p) {
        if (rewardProgram.memberLevel > p.rewardProgram.memberLevel) {
            return -1;
        } else if (rewardProgram.memberLevel < p.rewardProgram.memberLevel) {
            return 1;
        } else {
            if (rewardProgram.memberDays > p.rewardProgram.memberDays) {
                return -1;
            } else if (rewardProgram.memberDays < p.rewardProgram.memberDays) {
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
