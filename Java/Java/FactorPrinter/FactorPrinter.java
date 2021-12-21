public class FactorPrinter {
    public static void main(String[] args) {
        printFactors(10);
    }

    public static void printFactors(int number) {
        if (number < 0) {
            System.out.println("Invalid Value");
        }

        System.out.println("The factors of " + number + " are ");
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                System.out.println(i);
            }
        }
    }
}