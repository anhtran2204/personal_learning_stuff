package sample.NumberData;

import java.util.Arrays;

public class Numbers {
    private static double[] array = new double[3];
    private String num1;
    private int type;
    private static int index = 0;

    public Numbers(String input, int type) {
        this.num1 = getNumber(input);
        this.type = type;

        if (this.type == 1) {
            int solution = Integer.parseInt(this.num1);
            array[index] = solution;
            System.out.println("The number in index " + index + " is " + array[index]);
            index++;
        } else if (this.type == 2){
            int solution = Integer.parseInt(this.num1);
            array[index] = solution;
            System.out.println("The number in index " + index + " is " + array[index]);
            index++;
        }
    }

    public static double[] getArray() {
        return array;
    }

    private String getNumber(String input) {
        if (input.equals("") || input.equals(" ") || input.isEmpty()) {
            return "0";
        }
        return input.replaceAll("-[^0-9.]", "");
    }

    public void clearArray() {
        if (array[0] != 0 && array[1] != 0) {
            Arrays.fill(array, 0);
            index = 0;
        }
    }
}
