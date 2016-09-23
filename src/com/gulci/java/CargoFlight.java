package com.gulci.java;

public class CargoFlight extends FlightAdv {
    private float maxCargoSpace = 1000.0f;
    private float usedCargoSpace;
    // private fields are not inherited, we cannot hide them
    // we can define them one more time in derived class
    // we have to override getters/setters to fetch proper values outside the class
    // we have to use getters/setters (not direct access) in base class, to fetch private fields from derived class
    private int seats = 12;

    // by default all methods are overrideable and all classes can be extended
    // we can change it by using final (with class or method)
    // final class means that all methods are final

    // we can require inheritance with abstract

    // we can use a method getSeats() with return value, no field and no getter/setter
    // it's only usable when we have a fixed value

    // we are hiding public field control
    // we have initialization in super(id), but later we have field initialization in derived class
    public int control = 23;

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

    // @Override checks the signature
    @Override
    public int getSeats() {
        return seats;
    }

    @Override
    public void setSeats(int seats) {
        this.seats = seats;
    }

    // we don't use @Override with constructors
    // we use super with id parameter, otherwise we will run the default one (we initialize fields in other constructor)
    // or, when the default constructor is not defined in the base class, we'll have an error
    // similar to "this", super() treats the object as if it is an instance of its base class
    // we can use fields and methods that are overriden in derived class
    public CargoFlight(String id) {
        super(id);
    }

    public final void addOnePackage(float width, float height, float depth) {
        float size = height * width * depth;

        if (hasCargoSpace(size)) {
            usedCargoSpace += size;
        } else {
            handleNoSpace();
        }
    }

    // private methods cannot be overriden, protected can
    private boolean hasCargoSpace(float size) {
        return usedCargoSpace + size <= maxCargoSpace;
    }

    private void handleNoSpace() {
        System.out.println("Not enough space.");
    }
}
