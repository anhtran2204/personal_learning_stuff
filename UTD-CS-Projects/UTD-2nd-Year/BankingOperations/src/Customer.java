package BankingOperations.src;

import java.util.Scanner;

public class Customer {
    private static int ID = 1000001;
    private static final int ACCOUNTS_LIMIT = 5;
    private static CheckingAccount checkingAccounts[] = new CheckingAccount[ACCOUNTS_LIMIT];
    private static Scanner input = new Scanner(System.in);
    private CheckingAccount account;
    private String customerName;
    private int customerID;
    private int numAccounts;

    public Customer(String num, String name) {
        this.numAccounts = ACCOUNTS_LIMIT;
        if (checkCredentials(Integer.parseInt(num))) {
            this.customerName = name;
            customerID = ID;
            ID++;
            System.out.println("Customer ID: " + this.customerID);
            String[] initialBalance = input.nextLine().split(" ");
            for (int i = 0; i < Integer.parseInt(num); i++) {
                if (numAccounts > 0) {
                    account = new CheckingAccount(name, Double.parseDouble(initialBalance[i]));
                    checkingAccounts[ACCOUNTS_LIMIT - numAccounts] = account;
                    numAccounts--;
                } else {
                    System.out.println("Error: Customer already has 5 accounts.");
                }
            }
        } else {
            System.out.println("MAX 5 accounts per customer!");
        }
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

    public boolean checkCredentials(int num) {
        return this.numAccounts >= num;
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

    public CheckingAccount getCheckingAccount(String name) {
        CheckingAccount acc = null;
        for (CheckingAccount checkingAccount : checkingAccounts) {
            if (Integer.toString(checkingAccount.getAccountID()).equals(name)) {
                acc = checkingAccount;
            }
        }
        return acc;
    }
}
