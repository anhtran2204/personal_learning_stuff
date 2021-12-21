public class DigitSumChallenge {
    public static void main(String[] args) {
        System.out.println("The sum of digits is " + sumDigits(32123));
    }

    public static int sumDigits(int number) {
        int sum = 0;

        if (number < 10 || number < 0) {
            System.out.println("Invalid Value");
            return -1;
        } 

        while (number > 0) {
            int digits = number % 10;
            number = number / 10;
            sum += digits ;
        } 
        return sum;
    }
}