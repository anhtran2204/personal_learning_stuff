import java.util.Random;

public class ForStatementExample {
    public static void main(String[] args) {
        // for (int i = 2; i < 9; i++) {
        //     System.out.println("10,000 at " + i + "% interest = " + String.format("%.2f",calculateInterest(10000, i)));
        // }

        // for (int i = 8; i >= 2; i--) {
        //     System.out.println("10,000 at " + i + "% interest = " + String.format("%.2f",calculateInterest(10000, i)));
        // }
        
        Random rand = new Random();
        int n = rand.nextInt(100);
        System.out.println(n);
        System.out.println(isPrime(2));

        int count = 0;
        for (int i = 2; i < 50; i++) {
            if (isPrime(i)) {
                count ++;
                System.out.println("Number " + i + " is a prime number");
                if (count == 10) {
                    System.out.println(" Exiting for loop");
                    break;
                }
            }
        }
    }

    public static boolean isPrime(int n) {
        if (n == 1) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        } return true;
    }

    public static double calculateInterest(double amount, double interestRate) {
        return (amount * (interestRate / 100));
    }
}