package com.gulci.java;

public class Ex_07_strings {
    public static void main(String[] args) {
        // sequence of unicode characters, stored using utf-16 encoding
        // String objects are immutable

        // greeting is a reference to the object containing "hello" string
        String greeting = "Hello";

        // a new String object is created, greeting variable now points to that object
        greeting += ", World";

        System.out.println("length: " + greeting.length());
        System.out.println("valueOf: " + String.valueOf(32));
        greeting = greeting.concat("!");
        System.out.println("concat: " + greeting);
        greeting = greeting.replace('!', '?');
        System.out.println("replace: " + greeting);
        greeting = greeting.toLowerCase();
        System.out.println("toLowerCase: " + greeting);
        greeting = greeting.toUpperCase();
        System.out.println("toUpperCase: " + greeting);
        greeting = "   " + greeting;
        System.out.println("before trim: " + greeting);
        greeting = greeting.trim();
        System.out.println("after trim: " + greeting);
        String[] words = greeting.split(" ");
        for (String word: words) {
            System.out.println("split by space: " + word);
        }
        // we may specify locale
        System.out.println("format: " + String.format("One: %1$03d Two: %2$03d Three: %3$03d", 10, 20, 30));
        // String.format()
        System.out.println("charAt: " + greeting.charAt(5));
        System.out.println("substring: " + greeting.substring(1));
        // end - exclusive
        System.out.println("substring: " + greeting.substring(1, 4));
        System.out.println("contains L: " + greeting.contains("L"));
        System.out.println("endsWith: " + greeting.endsWith("?"));
        System.out.println("startsWith: " + greeting.startsWith("H"));
        // there are versions with char and String, and versions with fromIndex
        System.out.println("indexOf: " + greeting.indexOf("LL"));
        System.out.println("lastIndexOf: " + greeting.lastIndexOf("LL"));
        // 0 - equality
        // < 0 - lexicographically less than the string argument
        // > 0 - lexicographically greater than the string argument
        System.out.println("compareTo: " + greeting.compareTo("HELLO, WORLD!"));
        System.out.println("compareToIgnoreCase: " + greeting.compareToIgnoreCase("hello, world?"));
        System.out.println("isEmpty: " + greeting.isEmpty());
        System.out.println("equals: " + greeting.equals("hello, world?"));
        System.out.println("equalsIgnoreCase: " + greeting.equalsIgnoreCase("hello, world?"));

        String s1 = "I Love Java";
        String s2 = "I Love Java";

        // the same instance (object - literal)
        // == reference comparison - cheap
        // equals - character by character, may be expensive
        System.out.println("== String comparison (the same string literals): " + (s1 == s2));
        System.out.println("equals: " + s1.equals(s2));

        s1 = "I Love";
        s1 += " Java";

        s2 = "I";
        s2 += " Love Java";

        // different literals (different objects)
        System.out.println("== String comparison (different literals): " + (s1 == s2));
        System.out.println("equals: " + s1.equals(s2));

        // canonicalized reference of a String value
        // intern() returns the same String object for a given String value
        // intern() creates some overhead
        // useful when doing a lot of comparisons, intern() + ==
        String s3 = s1.intern();
        String s4 = s2.intern();

        System.out.println("== after intern: " + (s3 == s4));
        System.out.println("equals after intern: " + s3.equals(s4));
    }
}
