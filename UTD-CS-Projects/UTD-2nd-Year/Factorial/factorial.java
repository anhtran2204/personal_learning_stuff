public class factorial {
    public static void main(String[] args) {
        for (int i = 0; i <= 10; i++) {
            System.out.println("f(" + i + "): " +recursiveFactorial(i));
        }
    }

    public static long recursiveFactorial(int num) {
        if (num == 0) {
            return 1;
        }
        return num * recursiveFactorial(num - 1);
    }
}
