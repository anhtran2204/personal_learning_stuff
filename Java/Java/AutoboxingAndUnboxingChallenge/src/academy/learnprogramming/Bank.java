package academy.learnprogramming;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Bank {
    private String name;
    private ArrayList<Branches> branchesList;

    private static Scanner scanner = new Scanner(System.in);

    public Bank() {
        this.branchesList  = new ArrayList<Branches>();
    }

    public void setBankName(String name) {
        this.name = name;
    }

    public Branches getBranch(int index) {
        return this.branchesList.get(index);
    }

    public void setBranchesList(Branches branches, String name) {
        this.branchesList.add(branches);
        branches.setBranchName(name);
    }

    public void showBranchesList() {
        for (int i = 0; i < branchesList.size(); i++) {
            int index = i + 1;
            Branches temp = branchesList.get(i);
            System.out.println(index + ". " + temp.getBranchName());
        }
    }

    public void sortBranchesName(Branches branch) {
        branchesList.sort(new NameComparator());
    }

    public int findBranch(String name) {
        for (int i = 0; i < branchesList.size(); i++) {
            Branches branchCheck = branchesList.get(i);
            if (branchCheck.getBranchName().equals(name)) {
                return i;
            }
        }
        return -1;
    }

    public void bankMenuList() {
        System.out.println("~~~~~ What would you like to do ~~~~~");
        System.out.println("\t1. Create a new bank branch.");
        System.out.println("\t2. Select an existing branch.");
        System.out.println("\t3. Exit.");
    }

    public boolean createCustomer(String branchName, String customerName, double initialBalance) {
        if(findBranch(branchName) >= 0) {
            Branches temp =  branchesList.get(findBranch(branchName));
            Customers newCustomer = new Customers(customerName,initialBalance);
            temp.setCustomersList(newCustomer);

            System.out.println(branchName + ": account by the name of " + customerName + " with an initial balance" +
                    " of " + initialBalance + " was created successfully");
            return true;
        }else{
            System.out.println("Invalid bank branch, will exit now!");
            return false;
        }
    }
}


class NameComparator implements Comparator<Branches> {

    @Override
    public int compare(Branches o1, Branches o2) {
        return o1.getBranchName().compareTo(o2.getBranchName());
    }
}
