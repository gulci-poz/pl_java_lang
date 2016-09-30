package com.gulci.java;

public class CrewMember extends Person {
    enum FlightCrewJob {
        Pilot,
        CoPilot,
        FlightAttendant,
        AirMarshal
    }

    private FlightCrewJob job;

    public FlightCrewJob getJob() {
        return job;
    }

    public void setJob(FlightCrewJob job) {
        this.job = job;
    }

    public CrewMember(FlightCrewJob job) {
        this.job = job;
    }
}
