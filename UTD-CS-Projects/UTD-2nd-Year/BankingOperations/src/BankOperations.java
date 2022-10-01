package BankingOperations.src;

import java.util.Scanner;

public class BankOperations {
    public static Customer customer;
    public static CheckingAccount account;
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
                    break;

                case "add":
                    customer.addNewAccount(name);
                    break;

                case "deposit":
                    customer.getAccount(infos[1]).deposit(infos[1], Double.parseDouble(infos[2]));
                    break;

                case "withdrawal":
                    customer.getAccount(infos[1]).withdrawal(infos[1], Double.parseDouble(infos[2]));
                    break;
            }
            input = kb.nextLine();
            infos = input.split(" ");
        }
    }
}
