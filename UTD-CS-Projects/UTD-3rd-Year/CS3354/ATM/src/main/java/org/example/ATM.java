package org.example;

public class ATM {
    private String bankAccountNumber;
    private double funds;

    public ATM(String bankAccountNumber, double funds) {
        this.bankAccountNumber = bankAccountNumber;
        this.funds = funds;
    }

    public void setBankAccountNumber(String bankAccountNumber) {
        this.bankAccountNumber = bankAccountNumber;
    }

    public void setFunds(double funds) {
        this.funds -= funds;
    }

    public String getBankAccountNumber() {
        return bankAccountNumber;
    }

    public double getFunds() {
        return funds;
    }

    public boolean transfer(String bankAccountNumber, double amount) {
        // Validate the bank account number.
        if (!isBankAccountNumberValid(bankAccountNumber)) {
            System.out.println("Invalid bank account number");
            return false;
        }

        // Validate the amount.
        if (amount < 0) {
            System.out.println("Invalid amount");
            return false;
        }

        if (this.getFunds() - amount < 0) {
            System.out.println("Insufficient Funds");
            return false;
        }

        // Transfer the money to the bank account.
        ATM receiver = new ATM(bankAccountNumber, amount);
        setFunds(amount);

        // Display a confirmation message to the customer.
        System.out.println("The amount has been transferred to the bank account.");
        return true;
    }

    private boolean isBankAccountNumberValid(String bankAccountNumber) {
        return getBankAccountNumber().matches("[0-9]+$");
    }
}