package Demo;


import java.io.IOException;
import java.util.Scanner;

public class Demo {
    public static void main(String[] args) throws IOException {
        Scanner sb = new Scanner(System.in);
        int n = sb.nextInt();
        for (int i = 0; i < n; i++) {
            for (int  j = 0; j < n; j++) {
                System.out.printf("j = %d\n", j);
            }
            for (int k = 0; k < i; k++) {
                System.out.printf("k = %d\n", k);
            }
            for (int m = 0; m < 100; m++) {
                System.out.printf("m = %d\n", m);
            }
        }
    }
}
