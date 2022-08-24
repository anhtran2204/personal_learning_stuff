package academy.learnprogramming;

import java.util.Scanner;

public class Main {
    private static Bank bank;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("======== Please choose your bank of choice ========");
        String bankName = scanner.nextLine();
        bank = new Bank(bankName);

        boolean quit = true;

        outer:
        while (quit) {
            printBankMenu();

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    bank.printBranchList();
                    scanner.nextLine();
                    System.out.println("Choose your branch from the list:");
                    String branchChoice = scanner.nextLine().toUpperCase();
                    if (bank.findBranch(branchChoice.toUpperCase()) >= 0) {
                        Branch temp = bank.getBranches(bank.findBranch(branchChoice));

                        boolean customerLoop = true;

                        outer1:
                        while (customerLoop) {
                            addCustomerMenu();
                            int customerChoice = scanner.nextInt();
                            switch (customerChoice) {
                                case 1:
                                    scanner.nextLine();
                                    System.out.println("\nEnter your name for new account:");
                                    String newCustomerName = scanner.nextLine().toUpperCase();
                                    System.out.println("Enter your initial deposit for new account:");
                                    boolean hasNextDouble = scanner.hasNextDouble();
                                    double newInitialDeposit = scanner.nextDouble();

                                    if (hasNextDouble) {
                                        Customer newCustomer = new Customer(newCustomerName, newInitialDeposit);
                                        temp.addNewCustomer(newCustomer, newCustomerName, newInitialDeposit);
                                        temp.sortCustomerList(newCustomer);

                                        boolean customerAction = true;

                                        inner1:
                                        while (customerAction) {
                                            printCustomerChoice();
                                            int actionChoice = scanner.nextInt();
                                            switch (actionChoice) {
                                                case 1:
                                                    System.out.println("\nHow much would you like to deposit?");
                                                    int depositAmount = scanner.nextInt();
                                                    temp.depositBalance(newCustomer, depositAmount);
                                                    break;

                                                case 2:
                                                    System.out.println("\nHow much would you like to withdraw?");
                                                    int withdrawAmount = scanner.nextInt();
                                                    temp.withdrawBalance(newCustomer, withdrawAmount);
                                                    break;

                                                default:
                                                    System.out.println("~~~~~~ THANK YOU FOR CHOOSING US ~~~~~~");
                                                    customerAction = false;
                                                    break;
                                            }
                                        }
                                        continue outer;
                                    } else {
                                        System.out.println("~~~~~~ THANK YOU FOR CHOOSING US ~~~~~~");
                                    }

                                case 2:
                                    scanner.nextLine();
                                    temp.printCustomerList();
                                    System.out.println("\nEnter your name from the list:");
                                    String existingCustomerName = scanner.nextLine().toUpperCase();
                                    Customer existingCustomer = temp.existingCustomer(existingCustomerName);
                                    if (existingCustomer == null) {
                                        System.out.println("Error: No customer found with that name!!!");
                                        System.out.println("Please create a new account with that name.");
                                        break;
                                    } else {
                                        System.out.println("\n======== WELCOME BACK " +
                                                temp.getCustomers(temp.findCustomer(existingCustomerName)).getName() +
                                                " ========\n");

                                        boolean customerAction = true;

                                        inner2:
                                        while (customerAction) {
                                            printCustomerChoice();
                                            int actionChoice = scanner.nextInt();
                                            switch (actionChoice) {
                                                case 1:
                                                    System.out.println("\nHow much would you like to deposit?");
                                                    int depositAmount = scanner.nextInt();
                                                    temp.depositBalance(existingCustomer, depositAmount);
                                                    break;

                                                case 2:
                                                    System.out.println("\nHow much would you like to withdraw?");
                                                    int withdrawAmount = scanner.nextInt();
                                                    temp.withdrawBalance(existingCustomer, withdrawAmount);
                                                    break;

                                                default:
                                                    System.out.println("~~~~~~ THANK YOU FOR CHOOSING US ~~~~~~");
                                                    customerAction = false;
                                                    break;
                                            }
                                        }
                                    }
                                    continue outer;

                                default:
                                    customerLoop = false;
                                    break;
                            }
                        }
                    } else {
                        System.out.println("\nError: Branch not found!!!");
                        System.out.println("Please create a new branch with that name.");
                        continue outer;
                    }

                case 2:
                    scanner.nextLine();
                    System.out.println("\nEnter the name for your new branch:");
                    String newBranchName = scanner.nextLine();
                    Branch newBranch = new Branch(newBranchName);
                    bank.addNewBranch(newBranch, newBranchName);
                    bank.sortBranchList(newBranch);

                    boolean customerLoop = true;

                    while (customerLoop) {
                        scanner.nextLine();
                        System.out.println("Enter your name to create a new bank account:");
                        String newCustomerName = scanner.nextLine().toUpperCase();
                        System.out.println("\nEnter your initial deposit amount for new bank account:");
                        boolean hasNextDouble = scanner.hasNextDouble();
                        double initialDepositAmount = scanner.nextDouble();

                        if (hasNextDouble) {
                            Customer newCustomer = new Customer(newBranchName, initialDepositAmount);
                            newBranch.addNewCustomer(newCustomer, newCustomerName, initialDepositAmount);

                            boolean customerAction = true;

                            inner3:
                            while (customerAction) {
                                printCustomerChoice();
                                int actionChoice = scanner.nextInt();
                                switch (actionChoice) {
                                    case 1:
                                        System.out.println("\nHow much would you like to deposit?");
                                        int depositAmount = scanner.nextInt();
                                        newBranch.depositBalance(newCustomer, depositAmount);
                                        break;

                                    case 2:
                                        System.out.println("\nHow much would you like to withdraw?");
                                        int withdrawAmount = scanner.nextInt();
                                        newBranch.withdrawBalance(newCustomer, withdrawAmount);
                                        break;

                                    default:
                                        System.out.println("~~~~~~ THANK YOU FOR CHOOSING US ~~~~~~");
                                        customerAction = false;
                                        break;
                                }
                            }
                            continue outer;
                        } else {
                            System.out.println("~~~~~~ THANK YOU FOR CHOOSING US ~~~~~~");
                            continue outer;
                        }
                    }

                default:
                    break;
            }
            System.out.println("~~~~~~ THANK YOU FOR CHOOSING US ~~~~~~");
        }
    }

    public static void printBankMenu() {
        System.out.println("\n~~~~~~~~~~~~~~~~~ WELCOME TO " + bank.getName() +" ~~~~~~~~~~~~~~~~");
        System.out.println("   ======== What would you like to do =========       ");
        System.out.println("\t1. Choose existing bank branch.");
        System.out.println("\t2. Create a new bank branch.");
        System.out.println("\t3. Exit menu.");
    }

    public static void addCustomerMenu() {
        System.out.println("\n* Enter #1 if you are a new customer or #2 if you are an existing customer *");
        System.out.println("\t 1. Create a new bank account.");
        System.out.println("\t 2. Access existing bank account.");
        System.out.println("\t 3. Exit application.");
    }

    public static void printCustomerChoice() {
        System.out.println("~ Choose what action you want to do.");
        System.out.println("\t 1. Deposit money.");
        System.out.println("\t 2. Withdraw money.");
        System.out.println("\t 3. Exit application.");
    }
}