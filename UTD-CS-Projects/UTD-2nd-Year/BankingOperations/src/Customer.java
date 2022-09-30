import java.util.Scanner;

public class Customer {
    private static int customerID = 1000001;
    private static int NUM_ACCOUNTS = 5;
    private static Scanner input = new Scanner(System.in);
    private CheckingAccount account;
    private String customerName;

    public Customer(String name) {
        NUM_ACCOUNTS--;
        this.customerName = name;
        this.account = new CheckingAccount(name);
    }

    public Customer(String numAccounts, String name) {
        NUM_ACCOUNTS -= Integer.parseInt(numAccounts);
        this.customerName = name;

        String[] initialBalance = input.nextLine().split(" ");
        for (int i = 0; i < Integer.parseInt(numAccounts); i++) {
            account = new CheckingAccount(name, Double.parseDouble(initialBalance[i]));
        }
    }

    public static int getCustomerID() {
        return customerID;
    }

    public String getCustomerName() {
        return customerName;
    }

    public static int getNumAccounts() {
        return NUM_ACCOUNTS;
    }

    public boolean checkCustomer(String input) {
        return getCustomerName().equals(input) || Integer.toString(getCustomerID()).equals(input);
    }

    public void addNewAccount(String name, double initialBalance) {
        if (checkCustomer(name)) {
            if (NUM_ACCOUNTS > 0) {
                account = new CheckingAccount(name, initialBalance);
            }
        }
    }
}
