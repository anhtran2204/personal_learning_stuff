public class WhileAndDoWhileChallenge {
    public static void main(String[] args) {
        System.out.println(isEvenNumber(100));
        
        int number = 4;
        int finishNumber = 20;
        int count = 0;
        int sum = 0;

        while (number <= finishNumber) {
            number++;
            if (!isEvenNumber(number)) {
                continue;
            }
            System.out.println(number + " is an even number");
            count++;
            sum += number;
            if (count == 5) {
                break;
            }
        } 
        System.out.println("The sum of even numbers: " + sum);
    }   
    
    public static boolean isEvenNumber(int number) {
        if (number % 2 == 0) {
            return true;
        } return false;
    }
}