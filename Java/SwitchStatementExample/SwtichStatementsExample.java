import java.util.Random;

public class SwtichStatementsExample {
    public static void main(String[] args) {
        Random random = new Random();
        int switchValue = random.nextInt(5);
        System.out.println(switchValue);

        switch (switchValue) {
            case 1:
                System.out.println("Value was 1");
                break;
    
            case 2:
                System.out.println("Value was 2");
                break;

            case 3: case 4: case 5:
                System.out.println("Value was 3, or 4, or 5");
                System.out.println("Actually it was a " + switchValue);
                break;

            default:
                System.out.println("Was not a 1 or 2");
                break;
        }

        Random rand = new Random();
        char randChar = (char) (65 + rand.nextInt(26));
        char newChar = randChar;
        System.out.println(newChar);

        switch (newChar) {
            case 'A':
                System.out.println("It was A");
                break;

            case 'B':
                System.out.println("It was B");
                break;

            case 'C':
                System.out.println("It was C");
                break;

            case 'D':
                System.out.println("It was D");
                break;
            
            case 'E':
                System.out.println("It was E");
                break;

            default:
                System.out.println("Nothing was found");
                break;
        }
    }
}