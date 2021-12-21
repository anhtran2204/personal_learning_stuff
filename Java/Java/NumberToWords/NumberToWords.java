public class NumberToWords {
    public static void main(String[] args) {
        numberToWords(1450);
    }

    public static void numberToWords(int number) {
        if (number < 0) {
            System.out.println("Invalid Value");
        }

        int digit = 0;
        int reverseNumber = reverse(number);
        int difference = getDigitCount(number) - getDigitCount(reverseNumber);

        if (reverseNumber == 0) {
            System.out.println("Zero");
        }

        while (reverseNumber > 0) {
            digit = reverseNumber % 10;
            switch (digit) {
                case 0:
                    System.out.println("Zero");
                    break;

                case 1:
                    System.out.println("One"); 
                    break;

                case 2:
                    System.out.println("Two");
                    break;

                case 3:
                    System.out.println("Three");
                    break;

                case 4:
                    System.out.println("Four");
                    break;

                case 5:
                    System.out.println("Five");
                    break;

                case 6:
                    System.out.println("Six");
                    break;

                case 7:
                    System.out.println("Seven");
                    break;

                case 8:
                    System.out.println("Eight");
                    break;

            
                default:
                    System.out.println("Nine");
                    break;
                    
            }
            reverseNumber /= 10;
        } 

        if (difference != 0) {
            for (int i = 0; i < difference; i++) {
                System.out.println("Zero");
            }
        }
    }

    public static int reverse(int num) {
        int reverse = 0;

        while (num != 0) {
            reverse = (reverse * 10) + (num % 10);
            num = num / 10;
        }
        return reverse; 
    }

    public static int getDigitCount(int number) {
        if (number < 0) {
            return -1;
        }

        int count = 0;
        
        if (number == 0) {
            count = 1;
            return count;
        }

        while (number >= 1) {
            number /= 10;
            count++;
        }
        return count;
    }
}