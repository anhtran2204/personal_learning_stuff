public class SharedDigit {
    public static void main(String[] args) {
        System.out.println(hasSharedDigit(12, 13));
    }

    public static boolean hasSharedDigit(int firstNum, int secondNum) {
        if ((firstNum < 10 || firstNum > 99) || (secondNum < 10 || secondNum > 99)) {
            return false;
        }

        int digit1 = 0;
        int digit2 = 0;
        int num2;
        while (firstNum > 0) {
            digit1 = firstNum % 10;
            num2 = secondNum;                       // I'm not sure why i have to create variable num2 to use 
            while (num2 > 0) {                      // to calculate digit2 instead of using secondNum directly ??? 
                digit2 = num2 % 10;
                if (digit1 == digit2) {
                    return true;
                } num2 /= 10;
            } firstNum /= 10;
        } return false;
    }
}