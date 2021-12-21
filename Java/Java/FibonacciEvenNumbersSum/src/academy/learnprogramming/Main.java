package academy.learnprogramming;

public class Main {

    public static void main(String[] args) {
        int evenSum = 0;
        int a = 0;
        int b = 1;

        for (int i = 1; ; i++) {
            System.out.print(a + " ");
            int fiboNum = a + b;
            a = b;
            b = fiboNum;

            if (fiboNum % 2 == 0) {
                evenSum += fiboNum;
            }

            if (fiboNum >= 4000000) {
                break;
            }
        }
        System.out.println(" ");
        System.out.println("Sum of even numbers in Fibonacci sequence: " + evenSum);
    }
}

