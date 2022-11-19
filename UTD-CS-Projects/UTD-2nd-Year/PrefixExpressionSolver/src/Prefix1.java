package PrefixExpressionSolver.src;

import java.util.Scanner;
import java.util.Stack;

public class Prefix1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Stack<Double> stack = new Stack<Double>();
        String line = input.nextLine().trim();
        String tokens[] = line.split(" ");

        double total = 0;
        for (int i = tokens.length - 1; i >= 0; i--) {
            if (tokens[i].matches("(\\d+(?:\\.\\d+)?)")) {
                stack.push(Double.parseDouble(tokens[i]));
            }
            if (tokens[i].matches("[*+/\\-^]")) {
                switch (tokens[i]) {
                    case "+":
                        total = stack.pop() + stack.pop();
                        stack.push(total);
                        break;

                    case "-":
                        double num1 = stack.pop();
                        double num2 = stack.pop();
                        total = num1 - num2;
                        stack.push(total);
                        break;

                    case "*":
                        total = stack.pop() * stack.pop();
                        stack.push(total);
                        break;

                    case "/":
                        double numerator = stack.pop();
                        double denominator = stack.pop();
                        total = numerator / denominator;
                        stack.push(total);
                        break;

                    case "^":
                        double base = stack.pop();
                        double exp = stack.pop();
                        total = Math.pow(base, exp);
                        stack.push(total);
                        break;
                }
            }
        }
        System.out.printf("%.1f", stack.pop());
    }
}
