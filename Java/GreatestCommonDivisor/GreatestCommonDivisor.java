public class GreatestCommonDivisor {
    public static void main(String[] args) {
        System.out.println(getGreatestCommonDivisor(12, 30));
    }

    public static int getGreatestCommonDivisor(int first, int second) {
        int common = 1;

        if (first < 10 || second < 10) {
            return -1;
        }
        
        if (first > second) {
            for (int i = second; i >= 1; i--) {
                if (first % i == 0 && second % i == 0) {
                    return i;
                }
            }
        } else {
            for (int j = first; j >= 1; j--) {
                if (first % j == 0 && second % j == 0) {
                    return j;
                }
            } 
        } return common;
    }
}