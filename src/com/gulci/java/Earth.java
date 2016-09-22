package com.gulci.java;

public class Earth {
    private double circumferenceInMiles = 24901.0d;
    private double circumferenceInKilometers = circumferenceInMiles * 1.6d;
    private int countries;
    private long population;

    public double getCircumferenceInMiles() {
        return circumferenceInMiles;
    }

    public void setCircumferenceInMiles(double circumferenceInMiles) {
        this.circumferenceInMiles = circumferenceInMiles;
    }

    public double getCircumferenceInKilometers() {
        return circumferenceInKilometers;
    }

    public void setCircumferenceInKilometers(double circumferenceInKilometers) {
        this.circumferenceInKilometers = circumferenceInKilometers;
    }

    public int getCountries() {
        return countries;
    }

    public void setCountries(int countries) {
        this.countries = countries;
    }

    public long getPopulation() {
        return population;
    }

    public void setPopulation(long population) {
        this.population = population;
    }

    {
        System.out.println("new planet creation...");
    }

    {
        System.out.println("another brand new world...");
    }

    public Earth() {

    }

    public Earth(int countries) {
        // private contructor call based on coutries parameter value
        this(countries > 100 ? 1000l : 0l);
        this.countries = countries;
        circumferenceInKilometers = 32.0d;
    }

    public Earth(int countries, long population) {
        // other constructor call must be in the first line
        this(countries);
        this.population = population;
    }

    private Earth(long morePeople) {
        this.population += morePeople;
    }
}
