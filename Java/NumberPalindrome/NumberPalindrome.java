public class NumberPalindrome {
    public static void main(String[] args) {
    System.out.println(isPalindrome(-11));
    }

    public static boolean isPalindrome(int number) {
        int reverse = 0;                            
        int medium = number;

        while (number != 0) {                        
            int digits = number % 10;                   // We can shorten the statement by 
            reverse = reverse * 10;                     // doing reverse = (reverse * 10) + (number % 10);
            reverse += digits;                          //       number = number / 10;
            number = number / 10;
            System.out.println(reverse);
        }

        if (medium == reverse) {
            return true;
        } return false;
    }
}