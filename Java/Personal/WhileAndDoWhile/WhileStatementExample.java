public class WhileStatementExample {
    public static void main(String[] args) {
        int count = 0;

        while (count != 5) {
            count++;
            System.out.println("The count is " + count);
        }
        
        count = 1;
        while (true) {
            if (count == 6) {
                break;
            }
            System.out.println("The new count is " + count);
            count++;
        }

        count = 1;
        do {
            System.out.println("The count: " + count);
            count++;
        } while (count != 6);
    }
}