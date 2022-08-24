package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class Main {
    
    public static void main(String[] args) {
        
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                String myString = "Let's split this up into an array";
                String[] parts = myString.split(" ");
                for (String part : parts) {
                    System.out.println(part);
                }
            }
        };
        
        /*
         * Challenge #1: Convert the code above into lambda expression
         * */
        
        // Solution to challenge #1
        Runnable runnable1 = () -> {
            String myString = "Let's split this up into an array";
            String[] parts = myString.split(" ");
            for (String part : parts) {
                System.out.println(part);
            }
        };
        System.out.println("-------------------------------");
        
        
        /*
         * Challenge #2: Convert the method everySecondVal() below into lambda expression
         * */
        
        // Solution to challenge #2
        Function<String, String> everySecondChar = s -> {
            StringBuilder returnVal = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                if (i % 2 == 1) {
                    returnVal.append(s.charAt(i));
                }
            }
            return returnVal.toString();
        };
        System.out.println("-------------------------------");
        
        
        /*
         * Challenge #3: Write the code that will execute the function with
         * an argument of "1234567890"
         * */
        Function<String, String> lambdaFunction = s -> {
            StringBuilder returnVal = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                if (i % 2 == 1) {
                    returnVal.append(s.charAt(i));
                }
            }
            return returnVal.toString();
        };
        
        // Solution to challenge #3
        System.out.println(lambdaFunction.apply("1234567890"));
        System.out.println("-------------------------------");
        
        
        /*
         * Challenge #4: Write a method called everySecondCharacter that accepts the function
         * as a parameter and executes it with the argument "1234567890"
         * */
        
        // Solution to challenge #4 is below
        
        
        /*
         * Challenge #5: Call the method everySecondCharacter() with the lambdaFunction
         * we created earlier and the string "1234567890".
         * Print the result returned from the method.
         * */
        
        // Solution to challenge #5
        System.out.println(everySecondCharacter(lambdaFunction, "1234567890"));
        System.out.println("-------------------------------");
        
        
        /*
         * Challenge #6: Now write a lambda expression that maps to the java.util.Supplier
         * interface. This lambda should return the string "I love Java!" Assign it to a
         * variable called iLoveJava.
         * */
        
        // Solution to challenge #6
        Supplier<String> iLoveJava = () -> "I love Java!";
        
        
        /*
         * Challenge #7: Use the supplier above to assign the string "I love Java!" to
         * a variable called supplierResult. Then print the variable to the console.
         * */
        
        // Solution to challenge #7
        String supplierResult = iLoveJava.get();
        System.out.println(supplierResult);
        System.out.println("-------------------------------");
        
        
        /*
         * Challenge #8: Given a specific interface, how can we tell whether we can map
         * a lambda expression to it? What's the criteria that has to be met?
         *
         * Can we use a lambda expression to represent an instance
         * of the java.util.concurrent.Callable interface?
         *
         * Is the java.util.Comparator interface a functional interface?
         *
         *
         * */
        
        // Solution to challenge #8
        /*
         * The interface has to be a functional interface meaning it has only one
         * default method that is needed to be implemented.
         *
         * Yes we can use a lambda expression to represent an instance of
         * the java.util.concurrent.Callable interface because the interface
         * has only one method that is needed to be implemented - call().
         *
         * Yes, the java.util.Comparator interface is a functional interface because it only
         * technically has one method that has to be implemented - compare(), even though
         * there is another method - equals(), but it's an abstract method overriding
         * one of the public methods of java.lang.Object, this doesn't count as an abstract method.
         * */
        
        
        /*
         * Challenge #9: Write code to print the items in the list in sorted order,
         * and with the first letter in each name upper-cased. The name "harry"
         * should be printed as "Harry" and should be printed after "Emily" and before
         * "Isla". USe lambda expressions wherever possible.
         * */
        List<String> topNames2015 = Arrays.asList(
                "Amelia",
                "Olivia",
                "emily",
                "Isla",
                "Ava",
                "oliver",
                "Jack",
                "Charlie",
                "harry",
                "Jacob"
        );
        
        // Solution to challenge #9
        List<String> firstUpperCaseList = new ArrayList<>();
        topNames2015.forEach(name ->
                                     firstUpperCaseList.add(name.substring(0, 1).toUpperCase()
                                                                    + name.substring(1)));
        firstUpperCaseList.sort((s1, s2) -> s1.compareTo(s2));
        firstUpperCaseList.forEach(s -> System.out.println(s));
        System.out.println("-------------------------------");
        
        
        /*
         * Challenge #10 & #11: Change the code so that it uses method references
         * */
        
        // Solution to challenge #10 & #11
        topNames2015
                .stream()
                .map(s -> s.replaceFirst(s.substring(0, 1), s.substring(0, 1).toUpperCase()))
                .sorted()
                .forEach(System.out::println);
        System.out.println("-------------------------------");
        
        
        /*
         * Challenge #12: Print out how many names being with the letter 'A' instead
         * */
        
        // Solution to challenge #12
        System.out.println(topNames2015
                                   .stream()
                                   .map(name -> name.replaceFirst(
                                           name.substring(0, 1), name.substring(0, 1).toUpperCase()))
                                   .filter(name -> name.startsWith("A"))
                                   .count());
        System.out.println("-------------------------------");
    
    
        /*
         * Challenge #13: Use peek() to print out the names after the map() method
         * has executed. What will the following code print to the console?
         * */
        topNames2015
                .stream()
                .map(name -> name.replaceFirst(
                        name.substring(0, 1), name.substring(0, 1).toUpperCase()))
                .peek(System.out::println)
                .sorted(String::compareTo);
        
        // Solution to challenge #13
        /*
        * Nothing is printed out because the chain doesn't have a terminal operation
        * */
    
    
        /*
         * Challenge #14: Add a terminal operation to this chain so that the peek call
         * will execute
         * */
    
        // Solution to challenge #14
        topNames2015
                .stream()
                .map(name -> name.replaceFirst(
                        name.substring(0, 1), name.substring(0, 1).toUpperCase()))
                .peek(System.out::println)
                .sorted(String::compareTo)
                .collect(Collectors.toList());
    }
    
    public static String everySecondCharacter(Function<String, String> function, String s) {
        return function.apply(s);
    }
}
