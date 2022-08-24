import java.util.Arrays;

class TransitCalc {
    String[] options = {"Pay-per-ride", "7-day Unlimited", "30-day Unlimited"};
    double[] prices = {2.75, 33.00,127.00};

    int numDays;
    int numRides;

    public TransitCalc(final int days, final int rides) {
        numDays = days;
        numRides = rides;
    }

    public double unlimited7Price() {
        int numOfWeeks;
        if (numDays % 7 != 0) {
            numOfWeeks = numDays/7 + 1;
        } else {
            numOfWeeks = numDays/7;
        }
        double totalCost = numOfWeeks*prices[1];
        double pricePerRide = totalCost/numRides;
        return pricePerRide;
    }

    public double[] getRidePrices() {
        double[] optionsPrices = {prices[0], unlimited7Price(), prices[2]/numRides};
        return optionsPrices;
    }

    public String getBestFare() {
        double[] ridePrices = getRidePrices();
        int bestOption = 0;
        for (int i = 0; i < prices.length; i++) {
           if (prices[i] > prices[bestOption]) {
               prices[i] = prices[bestOption];
           }
        }
        return "You should get the " + options[bestOption] + " at $" + prices[bestOption] + " per ride.";
    }
    public static void main(final String[] args) {
        TransitCalc transitA = new TransitCalc(27, 120);
        System.out.println(transitA.getBestFare());
    }
}