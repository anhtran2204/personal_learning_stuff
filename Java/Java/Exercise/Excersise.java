
public class Excersise {

    public static void main(String[] args) {
        byte byteValue = 100;
        short shortValue = 10000;
        int intValue = 20000;
        long longValue = 50000 + 10*(byteValue + shortValue + intValue);
        System.out.println(longValue);

        short myNewShortValue = (short) (1000 * (byteValue + intValue + shortValue));
        System.out.println(myNewShortValue);

        float myMinFloatValue = Float.MIN_VALUE;
        float myMaxFloatValue = Float.MAX_VALUE;

        System.out.println(myMinFloatValue);
        System.out.println(myMaxFloatValue);

        double myMinDoubleValue = Double.MIN_VALUE;
        double myMaxDoubleValue = Double.MAX_VALUE;

        System.out.println(myMinDoubleValue);
        System.out.println(myMaxDoubleValue);
        
        int myNewIntValue = 5/3;
        float myNewFloatValue = (float) 5/3;
        double myNewDoubleValue = (double) 5/3;

        System.out.println(myNewIntValue);  
        System.out.println(myNewFloatValue);
        System.out.println(myNewDoubleValue);

        double pounds = 25;
        double kilograms = 0.45359237 * pounds;
        System.out.println(pounds + "lbs");
        System.out.println("Convert to kilograms : " + kilograms + " kg");

        char myChar = 'D';
        char myUnicodeChar = '\u0044';
        System.out.println(myChar);
        System.out.println(myUnicodeChar);
    }
}