package InfixExpressionSolver.src;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Infix1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Stack<Double> stack = new Stack<Double>();
        String line = input.nextLine().trim();

        double total = 0;
        String result = infixToPostfix(line);
        String[] tokens = result.split(" ");
        for (int i = 0; i < tokens.length; i++) {
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
        System.out.printf("%.1f", stack.pop());
    }

    public static int precedence(String ch) {
        switch (ch) {
            case "+":
            case "-":
                return 1;

            case "*":
            case "/":
                return 2;

            case "^":
                return 3;
        }
        return -1;
    }

    public static String infixToPostfix(String line) {
        Stack<String> stack = new Stack<>();
        String tokens[] = line.split(" ");
        String postfix = "";

        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i].matches("(\\d+(?:\\.\\d+)?)")) {
                postfix += tokens[i] + " ";
            }
            else if (tokens[i].equals("(")) {
                stack.push(tokens[i]);
            }
            else if (tokens[i].equals(")")) {
                while (!stack.isEmpty() && !stack.peek().equals("(")) {
                    postfix += stack.peek() + " ";
                    stack.pop();
                }
                stack.pop();
            }
            else {
                while (!stack.isEmpty() && (precedence(tokens[i]) <= precedence(stack.peek()))) {
                    postfix += stack.peek() + " ";
                    stack.pop();
                }
                stack.push(tokens[i]);
            }
        }
        while (!stack.isEmpty()) {
            postfix += stack.peek() + " ";
            stack.pop();
        }
        return postfix;
    }
}
