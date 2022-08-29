import java.util.Scanner;

public class Knapsack {
    static int[] weights = {40, 10, 46, 23, 22, 16, 27, 6};

    static int bestOne(int target) {
        int bestWeight = 0;
        for (int i = 0; i < weights.length; i++) {
            if (weights[i] > bestWeight && weights[i] <= target) {
                bestWeight = weights[i];
            }
        }
        return bestWeight;
    }

    static int bestTwo(int target) {
        return 0;
    }

    public static void main(String[] args) {
        for (int i = 0; i <= 100; i++) {
            System.out.println("bestOne(" + i + "):" + bestOne(i));
        } 
    }
}
