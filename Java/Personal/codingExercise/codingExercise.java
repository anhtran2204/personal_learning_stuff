import java.util.Random;

public class codingExercise {
    
    public static void main(String[] args) {
        Random random = new Random();
        int randomNumber = (random.nextInt(65536)-32768);
        System.out.println(randomNumber);
        checkNumber(randomNumber);
    }

    public static void checkNumber(int number) {
        if (number > 0) {
            System.out.println("This is a positive number");
        } else if (number < 0) {
            System.out.println("This is a negative number");
        } else if (number == 0) {
            System.out.println("This is zero");
        }
    }
}