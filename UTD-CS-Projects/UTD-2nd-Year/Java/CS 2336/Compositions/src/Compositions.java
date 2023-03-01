package Compositions.src;

import java.util.Arrays;
import java.util.Scanner;

public class Compositions {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int[] mem = new int[27000];

        int tc = s.nextInt();
        int c,n,m,k;
        while (tc > 0) {
            c = s.nextInt();
            n = s.nextInt();
            m = s.nextInt();
            k = s.nextInt();
            System.out.println(c + " " + compositions(n,m,k,mem[tc]));
            tc--;
        }
    }

    public static int compositions(int n, int m, int k, int mem) {
        if (n == 0) {
            return 1;
        }

        int offset = (30 * (n - 1) + m) * 30 + k;
        mem = mem + offset;
        if (mem == -1) {
            int total = 0;
            for (int i = n; i > 0; i--) {
                if (i % k != m) {
                    total += compositions(n-i, m, k, mem);
                }
            }
            mem = total;
        }
        return mem+offset;
    }
}
