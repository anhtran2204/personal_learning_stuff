package PostfixExpressionSolver.src;

import java.util.Scanner;
import java.util.Stack;

public class PostFix {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Stack<Double> stack = new Stack<Double>();
        String line = input.nextLine().trim();
        String tokens[] = line.split(" ");

        double total = 0;
        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i].matches("(\\d+(?:\\.\\d+)?)")) {
                stack.push(Double.parseDouble(tokens[i]));
            }
            if (tokens[i].matches("[*+/-^]")) {
                switch (tokens[i]) {
                    case "+":
                        total = stack.pop() + stack.pop();
                        stack.push(total);
                        break;

                    case "-":
                        total = stack.pop() - stack.pop();
                        stack.push(total);
                        break;

                    case "*":
                        total = stack.pop() * stack.pop();
                        stack.push(total);
                        break;

                    case "/":
                        double denominator = stack.pop();
                        double numerator = stack.pop();
                        total = numerator / denominator;
                        stack.push(total);
                        break;

                    case "^":
                        double exp = stack.pop();
                        double base = stack.pop();
                        total = Math.pow(base, exp);
                        stack.push(total);
                        break;
                }
            }
        }
        System.out.printf("%.3f", stack.pop());
    }
}
