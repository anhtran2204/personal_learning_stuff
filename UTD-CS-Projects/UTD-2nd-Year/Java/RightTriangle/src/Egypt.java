import java.util.Scanner;

public class Egypt {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        String line = s.nextLine();
        String[] inputs = line.split(" ");

        while(!line.equals("0 0 0")) {
            double a = Math.pow(Integer.parseInt(inputs[0]), 2);
            double b = Math.pow(Integer.parseInt(inputs[1]), 2);
            double c = Math.pow(Integer.parseInt(inputs[2]), 2);
            if (a + b == c || a + c == b || b + c == a
                    || Math.abs(a - b) == c || Math.abs(a - c) == b || Math.abs(b - c) == a) {
                System.out.println("right");
            } else {
                System.out.println("wrong");
            }
            line = s.nextLine();
            inputs = line.split(" ");
        }
    }
}
