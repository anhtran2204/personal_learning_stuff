package academy.learnprogramming;

import java.util.ArrayList;

// This is the solution by Tim Buchalka
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
public class Branches {
    private String name;
    private ArrayList<Customer> customers;

    // Initialize the name and a new array list for Customers.
    public Branches(String name) {
        this.name = name;
        this.customers = new ArrayList<Customer>();
    }

    public String getName() {
        return name;
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    // Return the boolean of a customer to know whether or not
    // there is an existing customer with the name given in the parameter.
    // If not (or found null), create a new Customer class with
    // new name and new initial amount.
    public boolean addNewCustomer(String customerName, double initialAmount) {
        if (findCustomer(customerName) == null) {
            this.customers.add(new Customer(customerName, initialAmount));
            return true;
        }
        return false;
    }

    // Return the boolean of a customer transaction to know whether or not there
    // was a customer under the same name, found by using a Customer type variable
    // called existing customer to find the indexOf() of
    // the parameter typed in, which calls the method findCustomer().
    // If there is a customer with that name, then add in the amount typed in the
    // parameter.
    public boolean addCustomerTransactions(String customerName, double amount) {
        Customer existingCustomer = findCustomer(customerName);
        if (existingCustomer != null) {
            existingCustomer.addTransactions(amount);
            return true;
        }
        return false;
    }

    // Return the customer's info (name) by using the
    // index of that customer, by using .get() method
    // then compare that name with the parameter's name.
    private Customer findCustomer(String customerName) {
        for (int i = 0; i < customers.size(); i++) {
            Customer checkCustomer = this.customers.get(i);
            if (checkCustomer.getName().equals(customerName)) {
                return checkCustomer;
            }
        }
        return null;
    }
}
