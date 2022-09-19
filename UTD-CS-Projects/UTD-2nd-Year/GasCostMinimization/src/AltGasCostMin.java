package GasCostMinimization.src;

import java.util.Scanner;

public class AltGasCostMin {
    static int numStations = 0; //# of gas stations
    static double distances[]; //index 0 is the starting position
    static double prices[];
    static double range; //range of the car, distance it can go with full tank of gas

    public static int minGasCostIndex(int currIndex, int stopIndex) {
        double minCost = prices[currIndex];
        int minIndex = currIndex;
        for (int i = currIndex; i < stopIndex; i++) {
            if (minCost < prices[i]) {
                minCost = prices[i];
                minIndex = i;
            }
        }
        return minIndex;
    }

    public static int findStopIndex(double destination) {
        int index = numStations;
        while (distances[index] >= destination) {
            index--;
        }
        return index;
    }

    public static int gasStops(int currentIndex, int stopIndex) {
        if (distances[stopIndex] - distances[currentIndex] <= range) {
            return 0;
        }
        int cheapIndex = minGasCostIndex(currentIndex+1, stopIndex);
        return gasStops(currentIndex+1, cheapIndex) + 1 + gasStops(cheapIndex+1, stopIndex);
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

        int stopIndex = findStopIndex(distToDestination);
        System.out.println(gasStops(0, stopIndex));
    }
}
