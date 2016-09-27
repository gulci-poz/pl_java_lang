package com.gulci.java;

public class CargoFlight extends FlightAdv {
    private float maxCargoSpace = 1000.0f;
    private float usedCargoSpace;
    // private fields are not inherited, we cannot hide them
    // we can define them one more time in derived class
    // we have to override getters/setters to fetch proper values outside the class
    // we have to use getters/setters (not direct access) in base class, to fetch private fields from derived class
    private int seats = 12;

    // private fields and methods are not inherited
    // by default all methods are overrideable and all classes can be extended
    // we can change it by using final (with class or method)
    // final class means that all methods are final

    // we can require inheritance or override with abstract
    // class may be abstract
    // if we have an abstract method, the class must be marked as abstract

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

    // @Override checks the signature, information for the compiler
    @Override
    public int getSeats() {
        return seats;
    }

    @Override
    public void setSeats(int seats) {
        this.seats = seats;
    }

    // constructors are not inherited
    // a base class constructor must always be called
    // by default, no argument constructor is called, but we may call the specific one
    // if no argument constructor is not defined in a base class and we try super(), we we'll have an error
    // we have to have a constructor with parameter, where we call super(id),
    // because we have to call it explicitly, it won't we called implicitly as the no argument constructor

    // here we have to call super(id) because we initialize fields in this constructor
    // similar to "this", "super" treats the object as if it's an instance of a base class
    // with super we can use fields and methods that are overriden in derived class
    // we can use base class constructors with super() - must be in the first line of a new constructor

    public CargoFlight(String id) {
        super(id);
    }

    // final may be put before access modifier
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
