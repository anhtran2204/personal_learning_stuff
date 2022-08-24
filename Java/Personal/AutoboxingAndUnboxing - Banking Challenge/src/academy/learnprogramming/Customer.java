package academy.learnprogramming;
// This is the solution by Tim Buchalka
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
import java.util.ArrayList;

public class Customer {
    private String name;
    private ArrayList<Double> transactions;

    // The constructor initialize the name and the array list of initial transaction
    // then call the addTransactions to add the initial transactions.
    public Customer(String name, double initialTransactions) {
        this.name = name;
        this.transactions = new ArrayList<Double>();
        addTransactions(initialTransactions);
    }

    // This add in the array list of transactions
    // the parameter amount.
    public void addTransactions(double amount) {
        this.transactions.add(amount);
    }

    public String getName() {
        return name;
    }

    public ArrayList<Double> getTransactions() {
        return transactions;
    }
}
