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
        int bestTotal = 0;

        for (int i = 0; i < weights.length; i++) {
            for (int j = 0; j < weights.length; j++) {
                if (i != j) {
                    if (weights[i] + weights[j] > bestTotal && weights[i] + weights[j] <= target) {
                        bestTotal = weights[i] + weights[j];
                    }
                }
            }
        }

        return bestTotal;
    }

    public static void main(String[] args) {
        for (int i = 0; i <= 100; i++) {
            System.out.println("bestTwo(" + i + "):" + bestTwo(i));
        } 
    }
}
