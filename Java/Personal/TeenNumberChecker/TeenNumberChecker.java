public class TeenNumberChecker {
    
    public static void main(String[] args) {
        System.out.println(hasTeen(10, 25, 15));
        System.out.println(hasTeen(29, 34, 25));

        System.out.println(isTeen(17));
    }

    public static boolean hasTeen(int firstNum, int secondNum, int thirdNum) {
        if ((13 <= firstNum && firstNum <= 19) || (13 <= secondNum && secondNum <= 19) || (13 <= thirdNum && thirdNum <= 19)) {
            return true;
        } return false;
    }

    public static boolean isTeen(int fourthNum) {
        if (13 <= fourthNum && fourthNum <= 19) {
            return true;
        } return false;
    }
}