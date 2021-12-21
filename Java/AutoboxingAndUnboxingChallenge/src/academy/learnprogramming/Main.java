package academy.learnprogramming;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    private String name;
    private Bank bank;

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Bank VIB = new Bank();
        boolean condition = true;
        System.out.println("Welcome to V.I.B Online Banking Application! \n");
        outer:

        while(condition) {
            VIB.bankMenuList();
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch(choice) {
                case 1:
                    System.out.println("What would you like the branch's name to be? \n");
                    String createBranchName = scanner.nextLine();
                    Branches createsBranch = new Branches(createBranchName);
                    VIB.setBranchesList(createsBranch, createBranchName);
                    continue outer;
                case 2:
                    System.out.println("Enter branch's name you want to access: \n");
                    VIB.showBranchesList();
                    String branchChoice = scanner.nextLine();
                    if (VIB.findBranch(branchChoice) >= 0) {
                        Branches temp = VIB.getBranch(VIB.findBranch(branchChoice));

                        System.out.println("Enter 1 if you're a new customer or 2 if you're an existing customer");
                        int newExist = scanner.nextInt();
                        scanner.nextLine();

                        switch (newExist) {
                            case 1:
                                System.out.println("Enter name for your account: \n");
                                String accountName = scanner.nextLine();
                                System.out.println("Enter amount you want to deposit initially: \n");
                                double initialDeposit = scanner.nextInt();

                                Customers newCustomer = new Customers(accountName, initialDeposit);
                                temp.setCustomersList(newCustomer);

                                boolean newCustomerBool = true;
                                outer1:
                                while (newCustomerBool) {
                                    temp.getUserMenu();
                                    int newUserInt = scanner.nextInt();

                                    switch (newUserInt) {
                                        case 1:
                                            System.out.println("How much would you like to deposit?");
                                            double depositAmount = scanner.nextInt();
                                            temp.depositBalance(newCustomer, depositAmount);
                                            System.out.println("You have deposited a total amount of " + depositAmount);
                                            System.out.println("Balance: " + newCustomer.getInitialTransactions());
                                            continue outer1;
                                        case 2:
                                            System.out.println("How much would you like to withdraw?");
                                            double withdrawAmount = scanner.nextInt();
                                            temp.withdrawBalance(newCustomer, withdrawAmount);
                                            System.out.println("You have withdrawn a total amount of " + withdrawAmount);
                                            System.out.println("Balance: " + newCustomer.getInitialTransactions());
                                            continue outer1;
                                        case 3:
                                            newCustomer.getTransactionHistory();
                                            continue outer1;
                                        default:
                                            newCustomerBool = false;
                                            break;

                                    }
                                }
                                continue outer;
                            case 2:
                                System.out.println("What is your account name?");
                                String existingCustomerName = scanner.nextLine();
                                if(temp.findUser(existingCustomerName) >= 0){
                                    Customers existingCustomer = temp.convertIndexToCustomer(temp.findUser(existingCustomerName));
                                    boolean existingAccount = true;
                                    outer2:
                                    while(existingAccount){
                                        temp.getUserMenu();
                                        int newUserInt = scanner.nextInt();

                                        switch (newUserInt) {
                                            case 1:
                                                System.out.println("How much would you like to deposit?");
                                                double depositAmount = scanner.nextInt();
                                                temp.depositBalance(existingCustomer, depositAmount);
                                                System.out.println("You have deposited a total amount of " + depositAmount);
                                                System.out.println("Balance: " + existingCustomer.getInitialTransactions());
                                                continue outer2;
                                            case 2:
                                                System.out.println("How much would you like to withdraw?");
                                                double withdrawAmount = scanner.nextInt();
                                                temp.withdrawBalance(existingCustomer, withdrawAmount);
                                                System.out.println("You have withdrawn a total amount of " + withdrawAmount);
                                                System.out.println("Balance: " + existingCustomer.getInitialTransactions());
                                                continue outer2;
                                            case 3:
                                                existingCustomer.getInitialTransactions();
                                                continue outer2;
                                            default:
                                                existingAccount = false;
                                                continue outer;
                                        }
                                    }
                                }else{
                                    System.out.println(existingCustomerName + " could not be found.");
                                    break;
                                }
                        }
                    } else {
                        System.out.println("Branch cannot be found!");
                        continue outer;
                    }
                default:
                    System.out.println("Thank you for using our app, bye bye!");
                    condition = false;
                    break;
            }
        }
    }
}