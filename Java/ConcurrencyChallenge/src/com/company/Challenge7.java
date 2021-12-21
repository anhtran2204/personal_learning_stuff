package com.company;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Challenge7 {
    
    public static void main(String[] args) {
        NewBankAccount account1 = new NewBankAccount("12345-678", 500.00);
        NewBankAccount account2 = new NewBankAccount("98765-432", 1000.00);
        
        new Thread(new Transfer(account1, account2, 10.00), "Transfer1").start();
        new Thread(new Transfer(account2, account1, 55.88), "Transfer2").start();
        
        
        /*
         * Challenge #7: Spot and fix the problem
         *
         * # Solution below in Challenge7 class #
         * Add a finally block after the catch block in the deposit() and withdraw()
         * method to unlock() the lock to solve the livelock situation.
         * */
    }
}

class NewBankAccount {
    private double balance;
    private String accountNumber;
    private Lock lock = new ReentrantLock();
    
    NewBankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }
    
    public boolean withdraw(double amount) {
        if (lock.tryLock()) {
            try {
                try {
                    // Simulate database access
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                }
                balance -= amount;
                System.out.printf("%s: Withdrew %f\n", Thread.currentThread().getName(), amount);
                return true;
            } finally {
                lock.unlock();
            }
        }
        return false;
    }
    
    public boolean deposit(double amount) {
        if (lock.tryLock()) {
            try {
                try {
                    // Simulate database access
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                }
                balance += amount;
                System.out.printf("%s: Deposited %f\n", Thread.currentThread().getName(), amount);
                return true;
            } finally {
                lock.unlock();
            }
        }
        return false;
    }
    
    public boolean transfer(NewBankAccount destinationAccount, double amount) {
        if (withdraw(amount)) {
            if (destinationAccount.deposit(amount)) {
                return true;
            } else {
                // The deposit failed. Refund the money back into the account.
                System.out.printf("%s: Destination account busy. Refunding money\n",
                        Thread.currentThread().getName());
                deposit(amount);
            }
        }
        
        return false;
    }
}

class Transfer implements Runnable {
    private NewBankAccount sourceAccount, destinationAccount;
    private double amount;
    
    Transfer(NewBankAccount sourceAccount, NewBankAccount destinationAccount, double amount) {
        this.sourceAccount = sourceAccount;
        this.destinationAccount = destinationAccount;
        this.amount = amount;
    }
    
    public void run() {
        synchronized (this) {
            try {
                while (!sourceAccount.transfer(destinationAccount, amount)) {
                    continue;
                }
                Thread.sleep(100);
                System.out.printf("%s completed\n", Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
