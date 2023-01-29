import java.util.Arrays;
import java.util.Scanner;

public class Modulo {
    private static Scanner s = new Scanner(System.in);
    private static boolean[] flags = new boolean[42];

    public static void main(String[] args) {
        int[] arr = new int[10];
        System.out.println(moduloNums1(arr));
        System.out.println(moduloNums2(arr));
    }

    public static void input(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = s.nextInt();
        }
    }

    public static int moduloNums1(int[] arr) {
        input(arr);

        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            int mod = arr[i] % 42;
            if (!flags[mod]) {
                count++;
                flags[mod] = true;
            }
        }
        return count;
    }

    public static int moduloNums2(int[] arr) {
        input(arr);
        Arrays.sort(arr);

        int count = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[i-1]) {
                count++;
            }
        }
        return count;
    }
}