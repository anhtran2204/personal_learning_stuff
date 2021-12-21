package academy.learnprogramming;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Branch {
    private String name;
    private ArrayList<Customer> customers;

    private static Scanner scanner = new Scanner(System.in);

    public Branch(String name) {
        this.name = name;
        this.customers = new ArrayList<Customer>();
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name.toUpperCase();
    }

    public Customer getCustomers(int index) {
        return this.customers.get(index);
    }

    public void addNewCustomer(Customer newCustomer, String customerName, double initialTransaction) {
        String customer = newCustomer.getName();
        int index = findCustomer(customer);

        if (customer.equals(" ") || customer.isEmpty()) {
            System.out.println("Error: No characters were found!!!");
            System.out.println("Please put in at least one character.\n");
        } else if (index >= 0) {
            System.out.println("Error: Customer already exists in customer's list.\n");
        } else {
            newCustomer = new Customer(customerName, initialTransaction);
            customers.add(newCustomer);
            System.out.println("Customer " + newCustomer.getName() + " is successfully added" +
                    " to the branch's customer's list.\n");
        }
    }

    public void removeCustomer(Customer removeCustomer) {
        String customer = removeCustomer.getName();
        int index = findCustomer(customer);

        if (customer.equals(" ") || customer.isEmpty()) {
            System.out.println("Error: No characters were found!!!");
            System.out.println("Please put in at least one character.\n");
        } else if (index >= 0) {
            customers.remove(index);
        }
    }

    public int findCustomer(String customerName) {
        for (int i = 0; i < customers.size(); i++) {
            Customer customer = customers.get(i);
            if (customer.getName().equals(customerName)) {
                return i;
            }
        }
        return -1;
    }

    public Customer existingCustomer(String customerName) {
        int index = findCustomer(customerName);
        if (index >= 0) {
            return customers.get(index);
        }
        return null;
    }

    public void depositBalance(Customer customer, double amount) {
        double currentBalance = customer.getInitialTransactions();
        double deposit = currentBalance + amount;
        customer.setTransactions(deposit);
        System.out.println("You deposited: $" + amount);
        System.out.println("Current balance is: $" + deposit);
    }

    public void withdrawBalance(Customer customer, double amount) {
        double currentBalance = customer.getInitialTransactions();
        double withdrawal = currentBalance - amount;
        if (currentBalance < 0) {
            System.out.println("Error: Insufficient Balance!!!");
            customer.setTransactions(0);
            System.out.println("Current balance: $" + withdrawal);
        }
        customer.setTransactions(withdrawal);
        System.out.println("You withdrew: $" + amount);
        System.out.println("Current balance is: $" + withdrawal);
    }

    public void printCustomerList() {
        if (customers.size() > 0) {
            System.out.println("List of customers that are in this branch:");
            for (int i = 0; i < customers.size(); i++) {
                DecimalFormat df = new DecimalFormat("00");
                System.out.println(df.format((i+1)) + ". " + customers.get(i).getName());
            }
        } else {
            System.out.println("Error: No customers were found!!!");
        }
    }

    public void sortCustomerList(Customer customer) {
        customers.sort(new NameComparator());
    }
}

class NameComparator implements Comparator<Customer> {

    @Override
    public int compare(Customer o1, Customer o2) {
        return o1.getName().compareTo(o2.getName());
    }
}