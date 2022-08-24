package academy.learnprogramming;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Comparator;

public class Bank {
    private String name;
    private ArrayList<Branch> branches;

    public Bank(String bankName) {
        this.name = bankName;
        this.branches = new ArrayList<Branch>();
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name.toUpperCase();
    }

    public Branch getBranches(int index) {
        return this.branches.get(index);
    }

    public void addNewBranch(Branch branches, String branchName) {
        int index = findBranch(branchName);
        if (index >= 0) {
            System.out.println("Error: This branch has already been added!!!");
        } else {
            this.branches.add(branches);
            branches.setName(branchName);
            System.out.println("Branch " + branches.getName() + " successfully added to your list.");
        }
    }

    public void addNewCustomer(String branchName, String customerName, double initialTransaction) {
        int index = findBranch(branchName);
        Branch temp = branches.get(index);
        Customer newCustomer = new Customer(customerName, initialTransaction);

        if (index >= 0) {
            System.out.println("Error: Already exists a customer with this name!!!");
            System.out.println("Please try again.");
        } else {
            temp.addNewCustomer(newCustomer, customerName, initialTransaction);
            System.out.println("New customer " + newCustomer.getName() + " successfully added " +
                    "to the customer's list.");
        }
    }

    public void removeBranch(String branchName) {
        int index = findBranch(branchName);

        if (index == -1) {
            System.out.println("Error: Branch not found!!!");
            System.out.println("Please enter another name.");
        } else {
            branches.remove(index);
            System.out.println("Branch " + branchName + " has been removed from your list.");
        }
    }

    public int findBranch(String name) {
        for (int i = 0; i < branches.size(); i++) {
            Branch branch = branches.get(i);
            if (branch.getName().equals(name)) {
                return i;
            }
        }
        return -1;
    }

    public void printBranchList() {
        if (branches.size() > 0) {
            System.out.println("List of branches that are present:");
            for (int i = 0; i < branches.size(); i++) {
                DecimalFormat df = new DecimalFormat("00");
                System.out.println(df.format((i+1)) + ". " + branches.get(i).getName());
            }
        } else {
            System.out.println("Error: No branches were found!!!");
        }
    }

    public void sortBranchList(Branch branch) {
        branches.sort(new NameComparator1());
    }
}

class NameComparator1 implements Comparator<Branch> {

    @Override
    public int compare(Branch o1, Branch o2) {
        return o1.getName().compareTo(o2.getName());
    }
}