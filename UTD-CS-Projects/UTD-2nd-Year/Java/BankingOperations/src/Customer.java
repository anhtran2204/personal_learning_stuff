package BankingOperations.src;

import java.util.Scanner;

public class Customer {
    private static int ID = 1000001;
    private static final int ACCOUNTS_LIMIT = 5;
    private CheckingAccount checkingAccounts[] = new CheckingAccount[ACCOUNTS_LIMIT];
    private String customerName;
    private int customerID;
    private int numAccounts = 0;

    public Customer(String name) {
        this.customerName = name;
        customerID = ID;
        ID++;
        System.out.println("Customer ID: " + this.customerID);
    }

    public int getCustomerID() {
        return this.customerID;
    }

    public String getCustomerName() {
        return this.customerName;
    }

    public int getNumAccounts() {
        return this.numAccounts;
    }

    public void addNewAccount(double initialBalance) {
        if (numAccounts < 5) {
            CheckingAccount newAccount = new CheckingAccount(initialBalance);
            checkingAccounts[numAccounts] = newAccount;
            numAccounts++;
        } else {
            System.out.println("Error: Customer already has 5 accounts.");
        }
    }

    public CheckingAccount getCheckingAccount(String name) {
        CheckingAccount acc = null;
        for (int i = 0; i < getNumAccounts(); i++) {
            if (Integer.toString(checkingAccounts[i].getAccountID()).equals(name)) {
                acc = checkingAccounts[i];
            }
        }
        return acc;
    }
}
