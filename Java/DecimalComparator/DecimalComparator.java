public class DecimalComparator {
    
    public static void main(String[] args) {
        System.out.println(areEqualByThreeDecimalPlaces(3.125, 3.126));
        System.out.println(areEqualByThreeDecimalPlaces(2.0315, 9.3568));
    }

    public static boolean areEqualByThreeDecimalPlaces(double number1, double number2) {
        double newNumber = (int) (number1 * 1000);
        double newNumber1 = (int) (number2 * 1000);

        if (newNumber == newNumber1) {
            return true;
        } return false;
    }
}