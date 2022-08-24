import java.util.Random;

public class SpeedConverter {

    public static void main(String[] args) {
        System.out.println(toMilesPerHour(100.0) + " kilometers per hour");
        printConversion(toMilesPerHour(100.0));
    }

    public static long toMilesPerHour (double kilometersPerHour) {
        if (kilometersPerHour < 0) {
            return -1;
        } 
        long milesPerHour = Math.round(kilometersPerHour / 1.609);
        return milesPerHour;
    }

    public static void printConversion (double kilometersPerHour) {
        if (kilometersPerHour < 0) {
            System.out.println("Invalid Value");
        } else {
            System.out.println(kilometersPerHour + " km/h = " + toMilesPerHour(kilometersPerHour) + " mi/h"  );
        }
        
    }
}
