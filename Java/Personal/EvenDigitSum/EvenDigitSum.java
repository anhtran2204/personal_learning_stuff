public class EvenDigitSum {
    public static void main(String[] args) {
        System.out.println(getEvenDigitSum(2000));
    }

    public static int getEvenDigitSum(int number) {
        if (number < 0) {
            return -1;
        }
        
        int sum = 0;
        int digit = 0;
        while (number >= 1) {
            digit = number % 10;
            number = number / 10;
            if (digit % 2 == 0) {
                sum += digit;
            } continue;
        } return sum;
    }
}