package com.company;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    
    public static void main(String[] args) {
	    final BankAccount account = new BankAccount("12345-678", 1000.00);
	    
        /* *
         * Challenge #1: Make 2 threads to run using the same BankAccount instance
         *
         * #Solution below#
         * */
	    new Thread(new Runnable() {
            @Override
            public void run() {
                account.deposit(300.00);
                account.withdraw(50.00);
                System.out.println(account.getBalance());
            }
        }).start();
    
        new Thread(new Runnable() {
            @Override
            public void run() {
                account.deposit(203.75);
                account.withdraw(100.00);
                System.out.println(account.getBalance());
            }
        }).start();
    
        /*
         * Challenge #2: Make the BankAccount class ThreadSafe using the synchronize keyword
         *
         * # Solution below in BankAccount class #
         * */
        
    
        /*
         * Challenge #3: Make the BankAccount class ThreadSafe again using the synchronize keyword
         * for the 2 newly added methods getAccountNumber() and printAccountNumber()
         *
         * # Solution below #
         * Don't need any changes because both threads only read the account number, so thread
         * interference isn't an issue. We'd be over-synchronizing the code, which would be
         * negatively impact on applications with large multiple threads
         * */
    
        
        /*
         * Challenge #4: Use Reentrant lock
         *
         * # Solution below in BankAccount class #
         * */
    
        
        /*
         * Challenge #5: Use tryLock with a timeout value
         *
         * # Solution below in BankAccount class #
         * */
    
    
        /*
         * Challenge #6: Update the code so that the status variable is thread safe
         *
         * # Solution #
         * Since the status variable is a local variable
         * */
    }
}

class BankAccount {
    
    private String accountNumber;
    private double balance;
    private ReentrantLock lock;
    
    public BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.lock = new ReentrantLock();
    }
    
    public void deposit(double amount) {
        synchronized (this) {
            boolean status = false;
            try {
                if (lock.tryLock(1000, TimeUnit.MILLISECONDS)) {
                    try {
                        balance += amount;
                        status = true;
                    } finally {
                        lock.unlock();
                    }
                } else {
                    System.out.println("Could not get the lock");
                }
            } catch (InterruptedException e){
                e.printStackTrace();
            }
            System.out.println("Transaction status = " + status);
        }
    }
    
    public void withdraw(double amount) {
        synchronized (this) {
            boolean status = false;
            try {
                if (lock.tryLock(1000, TimeUnit.MILLISECONDS)) {
                    try {
                        balance -= amount;
                        status = true;
                    } finally {
                        lock.unlock();
                    }
                } else {
                    System.out.println("Could not get the lock");
                }
            } catch (InterruptedException e){
                e.printStackTrace();
            }
            System.out.println("Transaction status = " + status);
        }
    }
    
    public double getBalance() {
        return balance;
    }
    
    public String getAccountNumber() {
        return accountNumber;
    }
    
    public void printAccountNumber() {
        System.out.println("Account number = " + accountNumber);
    }
}


