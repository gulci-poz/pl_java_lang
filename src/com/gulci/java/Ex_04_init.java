package com.gulci.java;

public class Ex_04_init {
    public static void main(String[] args) {
        // field basic (zero) state - based on field type

        // mechanisms for establishing initial state
        // - field initializers - assignment in declaration
        // - constructors - signature: number of parameters of a method (constructor)
        //      we can override initialized fields
        //      we can chain constructors to avoid logic duplication (using this, must be in first line)
        //      we can call basic constructor using this()
        //      constructor may be private, to hide the initialization logic that's not based on user input
        // - initialization blocks - code shared across constructors; code block in class
        //      executed at the beginning of a constructor
        //      we may have multiple initialization blocks - they are executed in order - from the top

        Earth newEarth = new Earth();

        System.out.println("circumference in kilometers: " + newEarth.getCircumferenceInKilometers());

        // in this case we have to explicitly define the default constructor (empty) in class definition,
        // if not, we won't be able to use default constructor anymore
        Earth newPolitics = new Earth(300);

        System.out.println("new political order, number of countries: " + newPolitics.getCountries());
        System.out.println("new political order, circumference in km: " + newPolitics.getCircumferenceInKilometers());

        //Earth newMan = new Earth(300, 32);

        // testing private constructor
        Earth newMan = new Earth(300);

        System.out.println("new world order, number of countries: " + newMan.getCountries());
        System.out.println("new world order, circumference in km: " + newMan.getCircumferenceInKilometers());
        System.out.println("new world order, population: " + newMan.getPopulation());
    }
}
