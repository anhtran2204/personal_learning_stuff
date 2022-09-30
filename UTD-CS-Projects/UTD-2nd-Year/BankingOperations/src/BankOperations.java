import java.util.Scanner;

public class BankOperations {

    public enum OPERATIONS {
        NEW,
        ADD,
        DEPOSIT,
        WITHDRAWAL,
        CLOSE
    }

    public static void main(String[] args) {
        Customer customer;
        CheckingAccount account;

        Scanner kb = new Scanner(System.in);
        String input = kb.nextLine();

        String[] infos = input.split(" ");

        switch (infos[0]) {
            case :
        }
    }
}
