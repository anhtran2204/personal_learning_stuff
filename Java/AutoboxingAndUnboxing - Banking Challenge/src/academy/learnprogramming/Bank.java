package academy.learnprogramming;

import java.util.ArrayList;

// This is the solution by Tim Buchalka
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
public class Bank {
    private String name;
    private ArrayList<Branches> branches;

    public Bank(String name) {
        this.name = name;
        this.branches = new ArrayList<Branches>();
    }

    public boolean addBranch(String name) {
        if (findBranchName(name) == null) {
            this.branches.add(new Branches(name));
            return true;
        }
        return false;
    }

    public boolean addNewCustomer(String branchName, String customerName, double initialAmount) {
        Branches branch = findBranchName(branchName);
        if (branch != null) {
            return branch.addNewCustomer(customerName, initialAmount);
        }
        return false;
    }

    public boolean addNewTransactions(String branchName, String customerName, double amount) {
        Branches branch = findBranchName(branchName);
        if (branch != null) {
            return branch.addCustomerTransactions(customerName, amount);
        }
        return false;
    }

    private Branches findBranchName(String name) {
        for (int i =  0; i < branches.size(); i++) {
            Branches checkBranch = branches.get(i);
            if (checkBranch.getName().equals(name)) {
                return checkBranch;
            }
        }
        return null;
    }

    public boolean listCustomer(String branchName, boolean showTransactions) {
        Branches branch = findBranchName(branchName);
        if (branch != null) {
            System.out.println("Customer detail for branch " + branch.getName());

            ArrayList<Customer> branchCustomers = branch.getCustomers();
            for (int i = 0; i < branchCustomers.size(); i++) {
                Customer branchCustomer = branchCustomers.get(i);
                System.out.println("Customer: " + branchCustomer.getName() + "[" + (i+1) + "]");
                if (showTransactions) {
                    System.out.println("Transactions");
                    ArrayList<Double> transactions = branchCustomer.getTransactions();
                    for (int j = 0; j < transactions.size(); j++) {
                        System.out.println("[" + (j+1) + "] Amount " + transactions.get(j));
                    }
                }
            }
            return true;
        } else {
            return false;
        }
    }
}
