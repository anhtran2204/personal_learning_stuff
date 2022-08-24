package com.company;

public class Main {
    
    public static void main(String[] args) {
        String string = "I am a string. Yes, I am";
        System.out.println(string);
        
        String yourString = string.replaceAll("I", "You");
        System.out.println(yourString);
        
        String alphaNumeric = "abcDeeeF12Ghhiiiijkl99z";
        System.out.println(alphaNumeric.replaceAll(".","Y"));
    
        System.out.println(alphaNumeric.replaceAll("^abcDeee","YYY"));
    
        String secondString = "abcDeeeF12GhhabcDeeeiiiijkl99z";
        System.out.println(secondString.replaceAll("^abcDeee","YYY"));
    
        System.out.println(alphaNumeric.matches("^hello"));
        System.out.println(alphaNumeric.matches("^abcDeee"));
        System.out.println(alphaNumeric.matches("^abcDeeeF12Ghhiiiijkl99z"));
    
        System.out.println(alphaNumeric.replaceAll("ijkl99z$", "THE END"));
        System.out.println(alphaNumeric.replaceAll("[aei]", "X"));
        System.out.println(alphaNumeric.replaceAll("[aei]", "I replaced a letter here"));
        System.out.println(alphaNumeric.replaceAll("[aei][Fj]", "X"));
    
        System.out.println("harry".replaceAll("[Hh]arry", "Harry"));
    
        String newAlphaNumeric = "abcDeeeF12Ghhiiiijkl99z";
        System.out.println(newAlphaNumeric.replaceAll("[^ej]", "X"));
    
        System.out.println(newAlphaNumeric.replaceAll("[abcdef345678]", "X"));
        System.out.println(newAlphaNumeric.replaceAll("[a-fA-F3-8]", "X"));
        System.out.println(newAlphaNumeric.replaceAll("(?i)[a-f3-8]", "X"));
        System.out.println(newAlphaNumeric.replaceAll("[0-9]", "X"));
        System.out.println(newAlphaNumeric.replaceAll("\\d", "X"));
        System.out.println(newAlphaNumeric.replaceAll("\\D", "X"));
    
        String hasWhiteSpace = "I have blanks and\ta tab, and also a newline\n";
        System.out.println(hasWhiteSpace);
        System.out.println(hasWhiteSpace.replaceAll("\\s", ""));
        System.out.println(hasWhiteSpace.replaceAll("\\t", "X"));
        System.out.println(hasWhiteSpace.replaceAll("\\S", ""));
        System.out.println(newAlphaNumeric.replaceAll("\\w", "X"));
        System.out.println(hasWhiteSpace.replaceAll("\\w", "X"));
        System.out.println(hasWhiteSpace.replaceAll("\\b", "X"));
    
        String thirdAlphaNumericString = "abcDeeeF12Ghhiiiijkl99z";
        System.out.println(thirdAlphaNumericString.replaceAll("^abcDeee","YYY"));
        
        
        
    
    }
}
