package com.gulci.java;

public class Ex12_nested {
    public static void main(String[] args) {
        // classes can be declared within classes and interfaces
        // interfaces can be declared within classes and interfaces
        // enums can be declared within classes
        // nested types are members of the enclosing type
        // private members of the enclosing type are visible to the nested type
        // nested types support all member access modifiers

        // purposes:
        // * structure and scoping (static)
        // no relationship between instances of nested and enclosing type:
        // - static classes nested within classes
        // - all classes nested within interfaces
        // - all nested interfaces
        // * inner classes
        // each instance of the nested class is associated with an instance of the enclosing class
        // - non-static classes nested within classes

        Passenger2 steve = new Passenger2();
        steve.setName("steve");
        steve.getRewardProgram().setMemberLevel(3);
        steve.getRewardProgram().setMemberDays(180);

        // because RewardProgram is static, we can instantiate it, not having Passenger2 instance
        // RewardProgram is scoped to Passenger2
        Passenger2.RewardProgram rp = new Passenger2.RewardProgram();
        rp.setMemberLevel(2);
        rp.setMemberDays(185);

        // we can add static nested classes RewardProgram to the classes that extend the Passenger class
        // this way we can provide specific RewardProgram functionality for these classes

        // anonymous classes are declared as part of their creation
        // useful for simple iterface implementations or class extensions (base class)
        // to provide specific solution, we're not gonna use it throughout our application, to solve a particular problem
        // anonymous classes are inner classes, they're associated with containing class instance
        // we create them as if we're constructing an instance of the interface or base class (we can use any constructor provided by this class)
        // we put implementation within brackets
    }
}
