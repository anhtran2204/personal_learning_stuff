package academy.learnprogramming;

import java.util.ArrayList;

public class Customer {
    private String name;
    private ArrayList<Double> transactions = new ArrayList<Double>();

    public Customer(String name, double initialBalance) {
        this.name = name;
        this.transactions.add(initialBalance);
    }

    public String getName() {
        return name;
    }

    public ArrayList<Double> getTransactions() {
        return transactions;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTransactions(double transactions) {
        this.transactions.add(transactions);
    }

    public double getInitialTransactions() {
        double customerTransactions = 0;
        for (int i = 0; i < transactions.size(); i++) {
            customerTransactions = transactions.get(i);
        }
        return customerTransactions;
    }

    public void addTransactions(double amount) {
        this.transactions.add(amount);
    }

    public void removeTransactions(double amount) {
        this.transactions.remove(amount);
    }
}