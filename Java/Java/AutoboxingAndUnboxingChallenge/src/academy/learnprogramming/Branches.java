package academy.learnprogramming;

import java.util.ArrayList;
import java.util.Scanner;

public class Branches {
    private String name;
    private ArrayList<Customers> customersList;


    private static Scanner scanner = new Scanner(System.in);

    public Branches(String name) {
        this.name = name;
        this.customersList = new ArrayList<Customers>();
    }

    public String getBranchName() {
        return name;
    }

    public void setBranchName(String name) {
        this.name = name;
    }

    public void setCustomersList(Customers customers) {
        customersList.add(customers);
    }

    public Customers convertIndexToCustomer(int index) {
        Customers customer = customersList.get(index);
        return customer;
    }

    public ArrayList<Customers> getCustomersList() {
        return this.customersList;
    }

    public void depositBalance(Customers customers, double money) {
        double currentBalance = customers.getInitialTransactions();
        double calculations = currentBalance + money;
        customers.setTransactions(calculations);
    }

    public void withdrawBalance(Customers customers, double money) {
        double currentBalance = customers.getInitialTransactions();
        double calculations = currentBalance - money;
        if (calculations < 0) {
            System.out.println("Error: Insufficient balance amount!");
        }
        customers.setTransactions(calculations);
    }

    public void balance(String name) {
        if (findUser(name) > 0) {
            Customers temp = customersList.get(findUser(name));
            System.out.println(temp.getInitialTransactions());
        } else {
            System.out.println("Error: " + name + " cannot be found!");
        }
    }

    public void getUserMenu(){
        System.out.println("What would you like to do?");
        System.out.println("1. To deposit money");
        System.out.println("2. To withdraw money");
        System.out.println("3. To show past transactions");
        System.out.println("4. To exit");
    }

    public int findUser(String name) {
        for (int i = 0; i < customersList.size(); i++) {
            Customers customerCheck = customersList.get(i);
            if (customerCheck.getName().equals(name)) {
                return i;
            }
        }
        return -1;
    }
}