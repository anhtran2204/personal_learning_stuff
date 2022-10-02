package BankingOperations.src;
import java.util.ArrayList;
import java.util.Scanner;

public class BankOperations {
    public static ArrayList<Customer> customers = new ArrayList<>();
    private static Customer customer;

    public boolean checkCustomer(String name) {
        for (Customer person : customers) {
            if (name.equals(person.getCustomerName())) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        String input = kb.nextLine();

        String[] infos = input.split(" ");

        while (!infos[0].equals("close")) {
            String name = "";
            for (int i = 2; i < infos.length; i++) {
                if (i == infos.length - 1) {
                    name += infos[i];
                } else {
                    name += infos[i] + " ";
                }
            }

            switch (infos[0]) {
                case "new":
                    customer = new Customer(infos[1], name);
                    customers.add(customer);
                    break;

                case "add":
                    customer.addNewAccount(name);
                    break;

                case "deposit":

                    break;

                case "withdrawal":

                    break;
            }
            input = kb.nextLine();
            infos = input.split(" ");
        }
    }
}
