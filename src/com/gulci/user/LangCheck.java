package com.gulci.user;

public class LangCheck {
    public static void main(String[] args) {
        // class Polish just extends the Language class
        // it doesn't implement or re-implement any method
        // the Language class is marked as abstract, no method is abstract
        Polish pol = new Polish();
        System.out.println(pol.isAbstract());

        // by marking class as abstract we can provide a default implementation of our class
        // we can provide not-doing-anything method implementations from interfaces

        // Java 8 introduces default methods in interfaces
        // abstract classes without abstract methods do not make sense anymore

        // abstract class cannot be instantiated
        //Language lang = new Language();
    }
}
