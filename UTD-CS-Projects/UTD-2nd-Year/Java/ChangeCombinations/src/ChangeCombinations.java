package ChangeCombinations.src;

import java.util.Scanner;

class ChangeCombinations {
    static int coinValues[] = {25, 10, 5, 1};

    //counter for all possible combinations to reach the total
    static int numCombinations = 0;

    //count all the coin combinations to reach remainingTotalCents
    //using the coins at coinIndex and beyond...
    static void change(int coinIndex, int remainingTotalCents) {
        //end conditions?
        //remainingTotalCents <= 0, coinValues.length == coinIndex
        if (remainingTotalCents == 0) {
            numCombinations++;
            return;
        }

        if (remainingTotalCents < 0 || coinValues.length == coinIndex)
            return;

        //recursive invocations of change()
        change(coinIndex+1, remainingTotalCents); //exclude case
        change(coinIndex, remainingTotalCents-coinValues[coinIndex]);
    }

    static int numInvocations = 0;
    static void enumerateChange(int coinIndex, int remainingTotalCents, String includedCoins) {
        numInvocations++;
        //end conditions?
        //remainingTotalCents <= 0, coinValues.length == coinIndex
        if (remainingTotalCents == 0) {
            System.out.println(includedCoins);
            numCombinations++;
            return;
        }

        if (remainingTotalCents < 0 || coinValues.length == coinIndex)
            return;

        //recursive invocations of change()
        enumerateChange(coinIndex+1, remainingTotalCents, includedCoins); //exclude case
        enumerateChange(coinIndex, remainingTotalCents-coinValues[coinIndex],
                includedCoins + " " +  coinValues[coinIndex]); //include change
    }

    //cut down recursion depth!
    static void enumerateChange2(int coinIndex, int remainingTotalCents, String includedCoins) {
        numInvocations++;
        //end conditions?
        //remainingTotalCents <= 0, coinValues.length == coinIndex
        if (remainingTotalCents == 0) {
            System.out.println(includedCoins);
            numCombinations++;
            return;
        }

        if (remainingTotalCents < 0 || coinValues.length == coinIndex)
            return;

        //recursive invocations of change()
        //enumerateChange2(coinIndex+1, remainingTotalCents, includedCoins); //exclude case
        //how many instances of coinValues[coinIndex] can be used?
        //total: 51, 25 cents --> 0, 1, 2
        //enumerateChange2(coinIndex, remainingTotalCents-coinValues[coinIndex],
        //               includedCoins + " " +  coinValues[coinIndex]); //include change
        //how many times current coin can be used meaningfully?
        int maxInstances = remainingTotalCents / coinValues[coinIndex];
        for(int i=0; i<=maxInstances; i++) {
            enumerateChange2(coinIndex+1, remainingTotalCents, includedCoins);

            //use current coin once.
            remainingTotalCents -= coinValues[coinIndex];
            includedCoins += " " + coinValues[coinIndex];
        }
    }

    //reflects the current state - how many each coin is being used
    static int coinUsage[] = {0, 0, 0, 0};

    //instead of using string for storing coin combination, use static array
    static void enumerateChange3(int coinIndex, int remainingTotalCents) {
        numInvocations++;
        //end conditions?
        //remainingTotalCents <= 0, coinValues.length == coinIndex
        if (remainingTotalCents == 0) {
            for(int i=0; i<coinUsage.length; i++)
                System.out.print(coinUsage[i]+ " ");
            System.out.println();
            numCombinations++;
            return;
        }

        if (remainingTotalCents < 0 || coinValues.length == coinIndex)
            return;

        int maxInstances = remainingTotalCents / coinValues[coinIndex];
        for(int i=0; i<=maxInstances; i++) {
            enumerateChange3(coinIndex+1, remainingTotalCents);

            //use current coin once.
            remainingTotalCents -= coinValues[coinIndex];
            coinUsage[coinIndex]++;
        }

        //done with all recursive invocations - time to return up
        coinUsage[coinIndex] = 0; //clean up since we are using static array to track
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int totalCents = input.nextInt();
        //enumerateChange2(0, totalCents, "");
        enumerateChange3(0, totalCents);
        System.out.println(numCombinations + " " + numInvocations);
    }
}
