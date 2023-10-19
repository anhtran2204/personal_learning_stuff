package Demo;

import java.util.Scanner;

public class CalculateArea {
    private static Scanner kb = new Scanner(System.in);

    public static void main(String[] args) {
        calculation();
    }

    private static void menu() {
        System.out.println("***Area Calculator***\n" +
                "S - Square\n" +
                "R - Rectangle\n" +
                "C - Circle");
    }

    private static void calculation() {
        menu();
        String input = kb.nextLine();
        while (!input.equals("X".toLowerCase())) {
            if (input.equalsIgnoreCase("s")) {
                System.out.printf("Area of your square is: %d\n", squareArea());
            } else if (input.equalsIgnoreCase("r")) {
                System.out.printf("Area of your rectangle is: %d\n", rectangleArea());
            } else if (input.equalsIgnoreCase("c")) {
                System.out.printf("Area of your circle is: %.2f\n", circleArea());
            } else {
                System.out.println("Invalid input! Please try again!");
            }
            menu();
            input = kb.nextLine();
        }
        System.out.println("Exiting program...");
    }

    private static int squareArea() {
        System.out.println("Please enter length of the square:");
        int length = kb.nextInt();
        kb.nextLine();
        return length * length;
    }

    private static int rectangleArea() {
        System.out.println("Please enter length of the rectangle:");
        int length = kb.nextInt();
        System.out.println("Please enter width of the rectangle:");
        int width = kb.nextInt();
        kb.nextLine();
        return length * width;
    }

    private static double circleArea() {
        System.out.println("Please enter the radius of the circle:");
        double radius = kb.nextDouble();
        kb.nextLine();
        return Math.PI * Math.pow(radius, 2);
    }
}
