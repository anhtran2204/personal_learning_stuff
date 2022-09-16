import java.util.Scanner;
import java.io.*;

public class GasCost {
    static int numStations = 0; //# of gas stations
    static double distances[]; //index 0 is the starting position
    static double prices[];
    static double range; //range of the car, distance it can go with full tank of gas

    // WRITE YOUR CODE HERE
    public static double minGasCost(int currentIndex) {

        return 0;
    }

    public static int gasStops(int currentIndex, double destDistance) {

        return 0;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String line = input.nextLine();
        String pieces[] = line.split(" ");
        numStations = pieces.length;
        distances = new double [numStations+1];
        distances[0] = 0;
        for(int i=0; i<numStations; i++)
            distances[i+1] = Double.parseDouble(pieces[i]);

        line = input.nextLine();
        pieces = line.split(" ");
        prices = new double [numStations+1];
        prices[0] = 100;
        for(int i=0; i<numStations; i++)
            prices[i+1] = Double.parseDouble(pieces[i]);

        range = input.nextDouble();
        double distToDestination = input.nextDouble();

        System.out.println(gasStops(0, distToDestination));
    }
}
