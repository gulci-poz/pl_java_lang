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
        // for String representation of a class we use overriden toString() method
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

        // StringBuilder provides mutable string buffer
        // for best performance pre-size buffer
        // will grow automatically if needed (overhead)
        StringBuilder sb = new StringBuilder(40);
        System.out.println("sb capacity: " + sb.capacity());
        sb.append("StringBuilder append");
        System.out.println("sb length: " + sb.length());
        sb.insert(13, " -=32 inserted=- ");
        sb.insert(30, 32);
        // we can use sb or sb.toString()
        System.out.println(sb.toString() + " " + sb.length());
        sb.append(" extending beyond the length");
        System.out.println(sb.toString() + " " + sb.length());

        // classes vs. primitives
        // class: iteration through Object class, fields and methods specific to the type, overhead
        // primitive: cannot be treated as Object, cannot expose fields or methods, lightweight

        // primitives wrapper classes (inherit from the Object)
        // capabilities and overhead + primitive values
        // each of primitive types has a corresponding wrapper class
        // Boolean, Character, Number (abstract): Byte, Short, Integer, Long, Float, Double
        // all wrapper class instances are immutable
        // common conversions are handled automatically

        // a is a reference, 100 is a primitive, a points to the object that contains 100 as its value
        Integer a = 100;

        // Java extracts value from the object that a points to
        int b = a;

        // Java creates a new object and puts the value of b into it, c refers to that object
        Integer c = b;

        System.out.println(a.equals(c));

        Character cha = 'G';
        char chb = cha;
        Character chc = chb;

        System.out.println(cha.equals(chc));

        // in both cases we use the same literal/object of a wrapper class
        // explanation below

        Integer i1000A = 10 * 10 * 10;
        Integer i1000B = 100 * 10;

        System.out.println("different objects using ==: " + (i1000A == i1000B));
        System.out.println("different objects using equals: " + i1000A.equals(i1000B));

        Integer i8A = 2 * 2 * 2;
        Integer i8B = 4 * 2;
        System.out.println("different objects using ==: " + (i8A == i8B));
        // boxing conversions that always return the same wrapper class instance
        // Integer, Short, Byte: -128 to 127
        // Character: codepoints u0000 to u00ff
        // Boolean: true, false

        // primitive -> wrapper - boxing, static xxxWrapper.valueOf()
        // exactly the same as assigning the value
        // compiler injects the value to Integer.valueOf()
        // from Java 5 inference is the default behaviour
        Integer conv1 = Integer.valueOf(32);

        // wrapper to primitive - unboxing, xxxValue()
        int val1 = conv1.intValue();

        // String -> primitive, parsing the string through specific class
        String age = "32";
        int ageInt = Integer.parseInt(age);

        // String -> wrapper
        Integer ageInteger = Integer.valueOf(age);

        // testing if we assigned a value to the variable
        // instead of checking nullInteger > 0 (even if we didn't assign a value, it may be <= 0)
        Integer nullInteger = null;
        if (nullInteger == null) {
            System.out.println("null");
        } else {
            System.out.println("not null");
        }

        // wrapper class members
        // Byte, Short, Integer, Long: MIN_VALUE, MAX_VALUE, bitCount, toBinaryString
        // Float, Double: MIN_VALUE, MAX_VALUE, infinite, isNaN
        // Character: MIN_VALUE, MAX_VALUE, isDigit, isLetter
        // Boolean: TRUE, FALSE
        System.out.println(cha + " isDigit: " + Character.isDigit(cha));
        System.out.println(cha + " isLetter: " + Character.isLetter(cha));

        // final fields
        // a simple one - must be set during creatio of an object instance (field initializer, initialization block, constructor)
        // static modifier - makes a final field a named constant
        // tight to the class, cannot be set by any object instance; we use all caps in the name
        // good for magic numbers
        // we can also use static fields - they can be changed later, but they are bound to the class (not the instance)
        // static methods are also bound to the class
        // example from Flight class
        //static final int MAX_FAA_SEATS = 550;

        // enumeration types
        // a finite list of valid values
        // enum must not be local

        CrewMember gulci = new CrewMember(CrewMember.FlightCrewJob.CoPilot);
        System.out.println(gulci.getJob());
        gulci.setJob(CrewMember.FlightCrewJob.Pilot);
        System.out.println(gulci.getJob());
    }
}
