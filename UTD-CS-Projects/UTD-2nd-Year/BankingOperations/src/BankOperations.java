package BankingOperations.src;

import java.util.ArrayList;
import java.util.Scanner;

public class BankOperations {
    private static final Scanner kb = new Scanner(System.in);
    public static ArrayList<String> inputs = new ArrayList<>();
    public static ArrayList<Customer> customers = new ArrayList<>();
    private static Customer customer;

    public static void main(String[] args) throws Exception {
//        getInput();

//        int index = 0;

        String input = kb.nextLine();
        String[] infos = input.split(" ");
        String name;
        String ID;
        while (!(infos[0].equals("close"))) {
            switch (infos[0]) {
                case "new":
                    name = getName(infos);
                    if (!checkCustomer(name)) {
                        customer = new Customer(infos[1], name);
                        customers.add(customer);
                    }
                    break;

                case "add":
                    name = getName(infos);
                    if (checkCustomer(name)) {
                        customer.addNewAccount(name);
                    }
                    break;

                case "deposit":
                    ID = infos[1];
                    CheckingAccount account = customer.getCheckingAccount(ID);
                    if (account != null) {
                        account.deposit(Double.parseDouble(infos[2]));
                    }
                    break;

                case "withdrawal":
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
        CheckingAccount acc = null;
        for (Customer customer : customers) {
            acc = customer.getCheckingAccount(ID);
            if (acc != null) {
                return acc;
            }
        }
        return null;
    }

//    public static void getInput() {
//        while (kb.hasNextLine()) {
//            String line = kb.nextLine();
//            inputs.add(line);
//
//            if (line != null && line.equalsIgnoreCase("close")) {
//                break;
//            }
//        }
//    }

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
