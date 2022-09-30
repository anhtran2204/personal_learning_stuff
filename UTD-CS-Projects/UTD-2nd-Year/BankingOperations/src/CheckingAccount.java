import java.util.Scanner;

public class CheckingAccount {
    private static int ID = 5000001;
    private static Scanner input = new Scanner(System.in);
    private int accountID;
    private String customerName;
    private double balance;

    public CheckingAccount(String name) {
        balance = 0;
        accountID = ID;
        ID++;
    }

    public CheckingAccount(String name, double initialBalance) {
        this.customerName = name;
        this.balance = initialBalance;
        accountID = ID;
        ID++;
        System.out.println("Account ID: " + this.accountID);
    }

    public double getBalance() {
        return balance;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public int getAccountID() {
        return accountID;
    }

    public boolean checkAccountID(String accountID) {
        return getAccountID() == Integer.parseInt(accountID);
    }

    public void deposit(String accountID, double amount) {
        if (checkAccountID(accountID)) {
            this.balance += amount;
            System.out.printf("New balance: %.2f", this.balance);
        }
    }

    public void withdrawal(String accountID, double amount) {
        if (checkAccountID(accountID)) {
            if (balance <= 0) {
                System.out.println("Withdrawal rejected to avoid negative balance.");
            } else {
                this.balance -= amount;
            }
            System.out.printf("New balance: %.2f", this.balance);
        }
    }
}
