import java.util.Scanner;

public class ReadingUserInputChallenge {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int sum = 0;

        for (int i = 1; i <= 10; i++) {
            System.out.println("Enter number #" + i + ": ");

            boolean hasNextInt = scanner.hasNextInt();

            if (hasNextInt) {
                int number = scanner.nextInt();
                sum += number;
            } else {
                System.out.println("Invalid Number");
                i--;
            }
            scanner.nextLine();                    // The next line is put here because if we put in an invalid number
                                                   // that invalid number would be erased and no other content'd pop up at the same time
        }
        System.out.println("The sum is: " + sum);
        scanner.close();
    }
}
