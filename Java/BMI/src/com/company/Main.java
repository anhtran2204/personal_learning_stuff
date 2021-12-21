package com.company;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BMI bmi = new BMI();
        System.out.println("Enter your name:");
        String name = scanner.nextLine();
        System.out.println("Enter your weight:");
        double weight = scanner.nextDouble();
        System.out.println("Enter your height:");
        double height = scanner.nextDouble();
        scanner.nextLine();
        System.out.println("Enter your favorite quote:");
        String quote = scanner.nextLine();

        double bmiIndex = bmi.calcBMI(weight, height);
        String weightRange = bmi.weightRange(bmiIndex);
        System.out.printf("%s, your BMI is %.2f\nWeight range: %s\nQuote: \"%s\"",
                name, bmiIndex, weightRange, quote);
    }
}

class BMI {
    public BMI() {
    }

    public double calcBMI(double weight, double height) {
        return (703.0 * weight)/(height * weight);
    }

    public String weightRange(double bmi) {
        if (bmi < 18.5) {
            return "Underweight";
        } else if (bmi >= 18.5 && bmi <= 24.9) {
            return "Normal";
        } else if (bmi >= 25 && bmi <= 29.9) {
            return "Overweight";
        } else {
            return "Obese";
        }
    }
}
