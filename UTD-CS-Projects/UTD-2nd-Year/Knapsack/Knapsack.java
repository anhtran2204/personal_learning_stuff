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

    public static int knapsack(int index, int totalSoFar, int target) {
        // Terminations cases
        if (totalSoFar > target) { // reched invalid combinations
            return 0;
        }
        if (totalSoFar == target) { // got perfect solution
            return totalSoFar;
        }
        if (index == weights.length) { // reached last level, return what we have
            return totalSoFar;
        }
        return Math.max(
                knapsack(index+1, totalSoFar, target),
                knapsack(index+1, totalSoFar + weights[index], target)
        );
    }

    // allow using duplicates for calculations
    public static int knapsack2(int index, int totalSoFar, int target) {
        // Terminations cases
        if (totalSoFar > target) { // reched invalid combinations
            return 0;
        }
        if (totalSoFar == target) { // got perfect solution
            return totalSoFar;
        }
        if (index == weights.length) { // reached last level, return what we have
            return totalSoFar;
        }
        return Math.max(
                knapsack(index+1, totalSoFar, target),
                knapsack(index, totalSoFar + weights[index], target)
        );
    }

    public static void main(String[] args) {
        int selectedItems[] = new int[2];
        for (int goal = 1; goal <= 100; goal++) {
            System.out.println("knapsack(" + goal + "): " + knapsack(0, 0, goal));
        }
    }
}
