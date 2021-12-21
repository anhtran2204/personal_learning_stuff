public class EqualSumChecker {
    
    public static void main(String[] args) {
        System.out.println(hasEqualSum(1, 1, 1));
        System.out.println(hasEqualSum(1, 1, 2));
        System.out.println(hasEqualSum(1, -1, 0));
    }

    public static boolean hasEqualSum(int firstNum, int secondNum, int totalNum) {
        if (firstNum + secondNum == totalNum) {
            return true;
        } return false;
    }
}