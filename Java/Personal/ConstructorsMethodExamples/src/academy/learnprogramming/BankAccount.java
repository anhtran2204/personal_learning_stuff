package academy.learnprogramming;

import java.util.Scanner;

public class BankAccount {
    private final String accountNumber;
    private long balance;
    private final String customerName;
    private final String email;
    private final String phoneNumber;

    public BankAccount() {          // When calling an empty constructor, we use this () to pass in default parameters
        this("123456789", 1000, "Default Name", "Default Email", "Default Phone Number");
        System.out.println("Empty constructor was called");
    }
    public BankAccount(String accountNumber, long balance, String customerName, String email, String phoneNumber) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.customerName = customerName;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public BankAccount(String customerName, String email, String phoneNumber) {
        this ("99999", 10000, customerName, email, phoneNumber);
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public long getBalance() {
        return balance;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public long depositFunds() {
        Scanner scanner = new Scanner(System.in);

        int deposit = 0;

        for (int i = 0; i <= 0 ; i++) {
            System.out.println("Enter deposit amount: ");
            boolean hasNextInt = scanner.hasNextInt();

            if (hasNextInt) {
                deposit = scanner.nextInt();
                this.balance += deposit;
                i--;
            } else {
                System.out.println("Invalid Amount");
                break;
            }
            scanner.nextLine();
        }
        return deposit;
    }

    public long withdrawalFunds() {
        Scanner scanner = new Scanner(System.in);

        int withdrawal = 0;

        for (int i = 0; i <= 0 ; i++) {
            System.out.println("Enter withdrawal amount: ");
            boolean hasNextInt = scanner.hasNextInt();

            if (hasNextInt) {
                withdrawal = scanner.nextInt();
                this.balance -= withdrawal;
                if (this.balance < 0) {
                    System.out.println("Insufficient Funds");
                    System.out.println("You now owe: $" + this.balance);
                    break;
                }
                i--;
            } else {
                System.out.println("Invalid Amount");
                break;
            }
            scanner.nextLine();
        }
        scanner.close();
        return withdrawal;
    }
}
