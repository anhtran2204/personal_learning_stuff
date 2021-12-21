public class FirstLastDigitSum {
    public static void main(String[] args) {
        System.out.println(sumFirstAndLastDigit(5));
    }

    public static int sumFirstAndLastDigit(int number) {
        if (number < 0) {
            return -1;
        }

        if (number >=0 && number <= 9) {
            return number + number;
        } 
        
        int firstDigit = 0;
        int lastDigit = number % 10;
        while (number >= 10) {
            number /= 10;
            firstDigit = number;
        } return firstDigit + lastDigit;
    }
}