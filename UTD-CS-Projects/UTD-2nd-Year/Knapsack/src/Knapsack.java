package Knapsack.src;

public class Knapsack {
    static int weights[] = { 40, 10, 46, 23, 22, 16, 27, 6 };

    static int bestOne(int target) {
        // select the heaviest item <= target
        int bestWeight = 0;

        for (int i = 0; i < weights.length; i++) {
            // is this better? is this valid?
            if (weights[i] > bestWeight && weights[i] <= target) {
                bestWeight = weights[i];
            }
        }

        return bestWeight;
    }

    static int bestTwo(int target, int returnItems[]) {
        int bestTotal = 0;

        for(int i = 0; i < weights.length; i++)
        {
            for(int j = i + 1; j < weights.length; j++)
            {
                int sumWeights = weights[i] + weights[j];
                if (sumWeights > bestTotal && sumWeights <= target)
                {
                    bestTotal = sumWeights;

                    //two selected items for sum
                    returnItems[0] = weights[i];
                    returnItems[1] = weights[j];
                }
            }
        }

        return bestTotal;
    }

    //best solution!
    static int knapsack(int index, int totalSoFar, int target)
    {
        //terminating cases?:
        //totalSoFar invalid
        //no solution found
        if (totalSoFar > target)
            return 0;
            //totalSoFar == target
            //perfect solution
        else if (totalSoFar == target)
            return totalSoFar;
            //index == weights.length
            //lowest level reached
            //subobtimal solution
        else if (index == weights.length)
            return totalSoFar;
        else
        {
            //calculate and collect results
            return Math.max(
                    //path 1: include weights[index]
                    knapsack(index + 1, totalSoFar, target),
                    //path 2: include weights[index]
                    knapsack(index + 1, totalSoFar + weights[index], target)
            );
        }
        //whichever path gives better solution, return it!
    }

    //allow taking multiple of the same item!
    static int knapsack2(int index, int totalSoFar, int target)
    {
        //terminating cases?:
        //totalSoFar invalid
        //no solution found
        if (totalSoFar > target)
            return 0;
            //totalSoFar == target
            //perfect solution
        else if (totalSoFar == target)
            return totalSoFar;
            //index == weights.length
            //lowest level reached
            //subobtimal solution
        else if (index == weights.length)
            return totalSoFar;
        else
        {
            //calculate and collect results
            return Math.max(
                    //path 1: include weights[index]
                    knapsack2(index + 1, totalSoFar, target),
                    //path 2: include weights[index]
                    knapsack2(index, totalSoFar + weights[index], target)
            );
        }
        //whichever path gives better solution, return it!
    }

    public static void main(String[] args) {
        int selectedItems[] = new int[2];
        for (int i = 1; i <= 100; i++)
        {
            //System.out.print("bestOne(" + i + "): " + bestOne(i) + "   ");
            //System.out.print("bestTwo(" + i + "): " + bestTwo(i, selectedItems) + "   ");
            //System.out.println("(" + selectedItems[0] + ", " + selectedItems[1] + ")");
            System.out.print("Knapsack(" + i + "): " + knapsack(0, 0, i) + "   ");
            System.out.println("Knapsack2(" + i + "): " + knapsack2(0, 0, i));
        }
    }
}