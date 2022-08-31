package Demo;

import java.util.Objects;
import java.util.Scanner;

public class Demo {

    // "A+" --> 4.0, "A" --> 4.0, "A-" --> 3.7, ... so on.
    static double letterToPoints(String grade) {
        if (grade.equals("A+") || grade.equals("A"))
            return 4;
        if (grade.equals("A-"))
            return 3.7;
        if (grade.equals("B+"))
            return 3.3;
        if (grade.equals("B"))
            return 3;
        if (grade.equals("B-"))
            return 2.7;
        if (grade.equals("C+"))
            return 2.3;
        if (grade.equals("C"))
            return 2;
        if (grade.equals("C-"))
            return 1.7;
        if (grade.equals("D+"))
            return 1.3;
        if (grade.equals("D"))
            return 1;

        return 0;
    }

    static double gpa(double totalPoints, int totalCredits) {
        if (totalCredits == 0) {
            return 0;
        }
        return totalPoints / totalCredits;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        //CODE HERE
        //use following formatted print mechanism to get exactly 2 decimal digits in the output: 
        //System.out.printf("Cumulative GPA: %.2f", ...);
        double totalPoints = 0;
        double totalCorePts = 0;
        int totalCredits = 0;
        int totalCoreCredits = 0;

        int credit = input.nextInt();
        String letterGrade = input.next();
        String core = input.next();
        input.nextLine();
        while(true) {
            totalPoints += (credit * letterToPoints(letterGrade));
            totalCredits += credit;
            if (core.equals("Y")) {
                totalCorePts += (credit * letterToPoints(letterGrade));
                totalCoreCredits += credit;
            }
            
            credit = input.nextInt();
            if (credit == 0) {
                break;
            }
            letterGrade = input.next();
            core = input.next();
        }
        System.out.printf("Cumulative GPA: %.2f", gpa(totalPoints, totalCredits));
        if (totalCoreCredits == 0) {
            System.out.printf(" Core GPA: NA");
        } else {
            System.out.printf(" Core GPA: %.2f", gpa(totalCorePts, totalCoreCredits));
        }
    }
}