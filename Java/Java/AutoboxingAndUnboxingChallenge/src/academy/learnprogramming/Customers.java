package academy.learnprogramming;

import java.util.ArrayList;
import java.util.Scanner;

public class Customers {
    private String name;
    private ArrayList<Double> transactions = new ArrayList<Double>();

    private static Scanner scanner = new Scanner(System.in);

    public Customers(String name, double initialTransactions) {
        this.name = name;
        this.transactions.add(initialTransactions);
    }

    public void setTransactions(double value) {
        this.transactions.add(value);
    }

    public String getName() {
        return name;
    }

    public double getInitialTransactions() {
        double customerTransactions = 0;
        for (int i = 0; i < transactions.size(); i++) {
            customerTransactions = transactions.get(i);
        }
        return customerTransactions;
    }

    public void getTransactionHistory() {
        for (int i = 0; i < transactions.size(); i++) {
            System.out.println(i + ". " + transactions.get(i));
        }
    }
}
