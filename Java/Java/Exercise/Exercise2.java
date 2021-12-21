import java.util.Random;

public class Exercise2 {

    public static void main(final String[] args) {
        // String myString = "My name is Jason Tran";
        // System.out.println(myString);

        // myString = myString + " and I'm 18 years old";
        // System.out.println(myString);

        // String lastString = "95";
        // int myNumber = 10;
        // lastString = lastString + myNumber;

        // System.out.println(lastString);
        // double myNewNumber = 120.55;
        // lastString = lastString + myNewNumber;
        // System.out.println(lastString);

        // int result = 1 + 2;
        // System.out.println("1 + 2 = " + result);

        // result++;
        // System.out.println(result);
        // result--;
        // System.out.println(result);
        // result *= 2;
        // System.out.println(result);
        // result += 10;
        // System.out.println(result);

        // double lastResult = result + (result * 4/3);
        // System.out.println("The last result is " + lastResult);

        // if (lastResult == result) {
        // System.out.println("The result is right!!!");
        // } else {
        // System.out.println("The result is wrong!!!");
        // }

        // double testScore = 87;
        // double finalScore = testScore * 1.5;
        // if (finalScore >= 90) {
        // System.out.println("You are accepted into Harvard!!!!");
        // } else {
        // System.out.println("You are not accepted!!!");
        // }

        // double secondTopScore = 99.0;
        // if (finalScore >= 140 || finalScore < secondTopScore) {
        // System.out.println("You got the highest score!!!");
        // } else {
        // System.out.println("You're the second top score!!");
        // }

        // double newValue = 20.00;
        // double newValue2 = 80.00;
        // double total = 100*(newValue + newValue2);
        // System.out.println(total);
        // double remainder = total % 40.00;
        // System.out.println(remainder);
        // boolean valid = (remainder == 0) ? true : false;
        // System.out.println(valid);

        // if (!valid) {
        // System.out.println("Got some remainders!");
        // }

        // int highScore = calculateScore(800, true, 100, 5);
        // System.out.println("Your final score was " + highScore);

        // highScore = calculateScore(10000, true, 200, 8);
        // System.out.println("Your final score was " + highScore);

        final Random rand = new Random();
        final int rand_int1 = rand.nextInt(2000);
        System.out.println(rand_int1);
        final int rand_int2 = rand.nextInt(2000);
        System.out.println(rand_int2);
        final int rand_int3 = rand.nextInt(2000);
        System.out.println(rand_int3);
        final int rand_int4 = rand.nextInt(2000);
        System.out.println(rand_int4);

        int highScorePosition = calculateHighScorePosition(rand_int1);
        displayHighScorePosition("Jason Tran", highScorePosition);
        highScorePosition = calculateHighScorePosition(rand_int2);
        displayHighScorePosition("John Smith", highScorePosition);
        highScorePosition = calculateHighScorePosition(rand_int3);
        displayHighScorePosition("Elizabeth Lightwalker", highScorePosition);
        highScorePosition = calculateHighScorePosition(rand_int4);
        displayHighScorePosition("Kyle Blacksmith", highScorePosition);

    }

    // public static int calculateScore(int score, boolean gameOver, int bonus, int
    // levelCompleted) {

    // if (gameOver) {
    // int finalPoint = score + (levelCompleted*bonus);
    // finalPoint += 1000;
    // return finalPoint;
    // } else {
    // return -1;
    // }
    // }

    public static void displayHighScorePosition(final String playerName, final int highScorePosition) {
        System.out.println(playerName + " your position on the table is number " + highScorePosition);
    }

    public static int calculateHighScorePosition(final int playerScore) {
        if (playerScore >= 1000) {
            return 1;
        } else if (playerScore >= 500) {
            return 2;
        } else if (playerScore >= 100) {
            return 3;
        } else {
            return 4;
        }
    }
 }
