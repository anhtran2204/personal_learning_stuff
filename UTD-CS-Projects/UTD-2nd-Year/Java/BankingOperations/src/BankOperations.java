package BankingOperations.src;

import java.util.ArrayList;
import java.util.Scanner;

public class BankOperations {
    private static Scanner kb = new Scanner(System.in);
    public static ArrayList<Customer> customers = new ArrayList<>();
    private static Customer customer;

    public static void main(String[] args) {
        String input = kb.nextLine();
        String[] infos = input.split(" ");
        String name;
        String ID;
        while (!(infos[0].equals("close"))) {
            switch (infos[0]) {
                case "new":
                    name = getName(infos);
                    if (!checkCustomer(name)) {
                        int numAccounts = Integer.parseInt(infos[1]);
                        if (numAccounts > 5) {
                            System.out.println("MAX 5 accounts per customer!");
                        } else {
                            customer = new Customer(name);
                            customers.add(customer);
                            for (int i = 0; i < numAccounts; i++) {
                                double initialBalance = kb.nextDouble();
                                customer.addNewAccount(initialBalance);
                            }
                        }
                    }
                    kb.nextLine();
                    break;

                case "add":
                    name = getName(infos);
                    if (checkCustomer(name)) {
                        if (customer.getNumAccounts() >= 5) {
                            System.out.println("Error: Customer already has 5 accounts.");
                        } else {
                            double initialBalance = kb.nextDouble();
                            customer.addNewAccount(initialBalance);
                        }
                    }
                    kb.nextLine();
                    break;

                case "deposit":
                    ID = infos[1];
                    CheckingAccount account = getCheckingAccount(ID);
                    if (account != null) {
                        account.deposit(Double.parseDouble(infos[2]));
                    }
                    break;

                case "withdraw":
                    ID = infos[1];
                    account = getCheckingAccount(ID);
                    if (account != null) {
                        account.withdrawal(Double.parseDouble(infos[2]));
                    }
                    break;
            }
            input = kb.nextLine();
            infos = input.split(" ");
        }
    }

    public static boolean checkCustomer(String name) {
        for (Customer person : customers) {
            if (name.equals(person.getCustomerName()) || name.equals(Integer.toString(person.getCustomerID()))) {
                return true;
            }
        }
        return false;
    }

    public static CheckingAccount getCheckingAccount(String ID) {
        CheckingAccount acc;
        for (Customer customer : customers) {
            acc = customer.getCheckingAccount(ID);
            if (acc != null) {
                return acc;
            }
        }
        return null;
    }

    public static String getName(String[] infos) {
        String name = "";
        for (int i = 2; i < infos.length; i++) {
            if (i == infos.length - 1) {
                name += infos[i];
            } else {
                name += infos[i] + " ";
            }
        }
        return name;
    }
}
