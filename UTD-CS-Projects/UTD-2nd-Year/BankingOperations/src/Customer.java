package BankingOperations.src;

import java.util.Scanner;

public class Customer {
    private static int ID = 1000001;
    private static final int ACCOUNTS_LIMIT = 5;
    private static int numAccounts = ACCOUNTS_LIMIT;
    private static CheckingAccount checkingAccounts[] = new CheckingAccount[ACCOUNTS_LIMIT];
    private static Scanner input = new Scanner(System.in);
    private CheckingAccount account;
    private String customerName;
    private int customerID;

    public Customer(String name) {
        if (numAccounts > 0) {
            this.customerName = name;
            customerID = ID;
            System.out.println("Customer ID: " + this.customerID);
            this.account = new CheckingAccount(name);
            checkingAccounts[ACCOUNTS_LIMIT - numAccounts] = account;
            numAccounts--;
            ID++;
        } else {
            System.out.println("MAX 5 accounts per customer!");
        }
    }

    public Customer(String num, String name) {
        if (numAccounts > 0) {
            this.customerName = name;
            customerID = ID;
            ID++;
            System.out.println("Customer ID: " + this.customerID);

            String[] initialBalance = input.nextLine().split(" ");
            for (int i = 0; i < Integer.parseInt(num); i++) {
                account = new CheckingAccount(name, Double.parseDouble(initialBalance[i]));
                checkingAccounts[ACCOUNTS_LIMIT - numAccounts] = account;
                numAccounts--;
            }
        } else {
            System.out.println("MAX 5 accounts per customer!");
        }
    }

    public static int getCustomerID() {
        return ID;
    }

    public String getCustomerName() {
        return customerName;
    }

    public static int getNumAccounts() {
        return numAccounts;
    }

    public boolean checkCustomer(String input) {
        return getCustomerName().equals(input) || Integer.toString(getCustomerID()).equals(input);
    }

    public void addNewAccount(String name) {
        if (numAccounts > 0) {
            double initialBalance  = input.nextDouble();
            account = new CheckingAccount(name, initialBalance);
            checkingAccounts[ACCOUNTS_LIMIT - numAccounts] = account;
            numAccounts--;
        } else {
            System.out.println("Error: Customer already has 5 accounts.");
        }
    }
}
