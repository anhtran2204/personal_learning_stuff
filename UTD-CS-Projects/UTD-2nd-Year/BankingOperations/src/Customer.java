package BankingOperations.src;

import java.util.Scanner;

public class Customer {
    private static int ID = 1000001;
    private static int NUM_ACCOUNTS = 5;
    private static Scanner input = new Scanner(System.in);
    private CheckingAccount account;
    private String customerName;
    private int customerID;

    public Customer(String name) {
        if (NUM_ACCOUNTS > 0) {
            NUM_ACCOUNTS--;
            this.customerName = name;
            customerID = ID;
            ID++;
            System.out.println("Customer ID: " + this.customerID);
            this.account = new CheckingAccount(name);
        } else {
            System.out.println("MAX 5 accounts per customer!");
        }
    }

    public Customer(String numAccounts, String name) {
        if (NUM_ACCOUNTS > 0) {
            NUM_ACCOUNTS -= Integer.parseInt(numAccounts);
            this.customerName = name;
            customerID = ID;
            ID++;
            System.out.println("Customer ID: " + this.customerID);

            String[] initialBalance = input.nextLine().split(" ");
            for (int i = 0; i < Integer.parseInt(numAccounts); i++) {
                account = new CheckingAccount(name, Double.parseDouble(initialBalance[i]));
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
        return NUM_ACCOUNTS;
    }

    public boolean checkCustomer(String input) {
        return getCustomerName().equals(input) || Integer.toString(getCustomerID()).equals(input);
    }

    public CheckingAccount getAccount(String ID) {
        return account.getAccount(ID);
    }

    public void addNewAccount(String name) {
        if (checkCustomer(name)) {
            if (NUM_ACCOUNTS > 0) {
                double initialBalance  = input.nextDouble();
                account = new CheckingAccount(name, initialBalance);
            }
        } else {
            System.out.println("Error: Customer already has 5 accounts.");
        }
    }
}
