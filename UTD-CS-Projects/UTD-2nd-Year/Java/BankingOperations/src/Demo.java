package BankingOperations.src;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Demo {
    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        ArrayList<String> in = new ArrayList<String>();
        Scanner s = new Scanner(System.in);

        while (s.hasNextLine()) {
            String line = s.nextLine();
            in.add(line);

            if (line != null && line.equalsIgnoreCase("close")) {
                System.out.println("Output list : " + in);
                break;
            }

        }

        for (String info : in) {
            System.out.println(info);
        }
    }
}
