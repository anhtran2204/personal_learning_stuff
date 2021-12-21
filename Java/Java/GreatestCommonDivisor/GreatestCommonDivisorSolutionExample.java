import java.util.Scanner;

public class GreatestCommonDivisorSolutionExample {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter the first integer:");
        int b = input.nextInt();
        System.out.println("Please enter the second integer:");
        int d = input.nextInt();

        System.out.println("The GCD of " + b + " and " + d + " is " +  getGcd(b,d) + ".");
    }


    public static int getGcd(int first, int second) {
        int gcd = 1;

        if(first>second) {
            for(int i = second; i >=1; i--) {
                if(first%i==0 && second%i ==0) {
                    return i;
                }
            }
        } else {
            for(int j = first; j >=1; j--) {
                if(first%j==0 && second% j==0) {
                    return j;
                }
            }
        }   
        return gcd;

    }
}