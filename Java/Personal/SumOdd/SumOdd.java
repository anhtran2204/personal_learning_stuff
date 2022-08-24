import java.util.Random;

public class SumOdd {
    public static void main(String[] args) {
        Random rand = new Random();
        int number = rand.nextInt(1000);
        System.out.println("The number is: " + number);
        System.out.println(isOdd(number));
        System.out.println("The sum of the odd numbers is: " + sumOdd(-4, 6));

    }

    public static boolean isOdd(int number) {
        if (number < 0) {
            return false;
        } else if (number % 2 == 1) {
            return true;
        } return false;
    }

    public static int sumOdd(int start, int end) {
        if (end < start || (start < 0 || end < 0)) {
            return -1;
        }
        
        int sum = 0;
        for (int i = start; i <= end; i++) {
            if (isOdd(i)) {
                sum += i;
            }
        }  return sum;       
    }
}