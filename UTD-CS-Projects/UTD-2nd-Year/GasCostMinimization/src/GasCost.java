package GasCostMinimization.src;

import java.util.Scanner;
import java.io.*;

public class GasCost {
    static int numStations = 0; //# of gas stations
    static double distances[]; //index 0 is the starting position
    static double prices[];
    static double range; //range of the car, distance it can go with full tank of gas

    // WRITE YOUR CODE HERE
    public static int minGasCostIndex(int currIndex, int lastStation) {
        double minCost = prices[currIndex];
        int minIndex = currIndex;
        for (int i = currIndex; i < lastStation; i++) {
            if (minCost < prices[i]) {
                minCost = prices[i];
                minIndex = i;
            }
        }
        return minIndex;
    }

    public static int getLastStation(double destDistance) {
        int index = numStations;
        while (distances[index] >= destDistance) {
            index--;
        }
        return index;
    }

    public static int priceTrend() {
        double diff = 0;
        for (int i = 1; i < prices.length - 1; i++) {
            if (prices[i+1] - prices[i] < 0) {
                diff++;
            }
        }
        if (diff % numStations == 0) {
            return 0; // decreasing
        }
        return 1; // increasing or fluctuate
    }

    public static int gasStops(int currentIndex, double destDistance) {
        int stops;
        int lastStation = getLastStation(destDistance);
        if (priceTrend() == 1) {
            stops = 0;
            while (destDistance - distances[currentIndex] >= range) {
                stops++;
                int minIndex = minGasCostIndex(currentIndex + 1, lastStation);
                if (distances[minIndex] - distances[currentIndex] > range) {
                    currentIndex++;
                }
                else {
                    currentIndex = minIndex;
                }
            }
        }
        else {
            stops = 0;
            while (destDistance - distances[currentIndex] >= range) {
                currentIndex++;
                stops++;
            }
        }
        return stops;
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
