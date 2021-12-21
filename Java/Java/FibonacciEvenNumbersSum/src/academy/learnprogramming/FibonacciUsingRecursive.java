package academy.learnprogramming;

import java.util.Scanner;

public class FibonacciUsingRecursive {

    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//
//        System.out.println("Enter the number of Fibonacci's numbers: ");
//        boolean hasNextInt = scanner.hasNextInt();
//        if (hasNextInt) {
//            int fibo = scanner.nextInt();
//            System.out.print(fibonacci(fibo));
//        }

        int index = 0;
        while (index < 20)
        {
            System.out.println(fibonacci(index));
            index++;
        }
    }

    public static long fibonacci(int i) {
        // This recursive method only shows the Fibonacci number in the n-th position
        // in the sequence not the whole sequence

//        if(i == 0)
//            return 0;
//        else if(i == 1)
//            return 1;
//        else
//            return fibonacci(i - 1) + fibonacci(i - 2);



        // This method uses recursive too, but in the main method, it also uses
        // a while loop to increase the n-th position input to show the whole sequence
        // we can replace that with a for-loop.
        if (i == 0) return 0;
        if (i<= 2) return 1;

        return fibonacci(i - 1) + fibonacci(i - 2);
    }
}
