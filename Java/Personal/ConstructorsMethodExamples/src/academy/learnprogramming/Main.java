package academy.learnprogramming;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Random random = new Random();
        int rand = random.nextInt(1000000000);

        BankAccount jason = new BankAccount("22042002",rand,"Jason Tran"
                ,"kaisertran02@gmail.com","214-892-1912");
        BankAccount john = new BankAccount();
        BankAccount james = new BankAccount("James Potter", "jamespotter@gmail.com", "098-316-4782");

        VipCustomer anh = new VipCustomer("Anh Tran", 1000000, "kaisertran02@gmail.com");
        VipCustomer anh1 = new VipCustomer();
        VipCustomer anh2 = new VipCustomer("Long Vuong", "longvuong@gmail.com");

//        System.out.println("The account number: " + jason.getAccountNumber());
//        System.out.println("The current balance is: $" + jason.getBalance());
//        System.out.println("The customer's full name is: " + jason.getCustomerName());
//        System.out.println("The customer's email is: " + jason.getEmail());
//        System.out.println("The customer's phone number is: " + jason.getPhoneNumber());
//
//        System.out.println("The account number: " + john.getAccountNumber());
//        System.out.println("The current balance is: $" + john.getBalance());
//        System.out.println("The customer's full name is: " + john.getCustomerName());
//        System.out.println("The customer's email is: " + john.getEmail());
//        System.out.println("The customer's phone number is: " + john.getPhoneNumber());
//
//        System.out.println("The account number: " + james.getAccountNumber());
//        System.out.println("The current balance is: $" + james.getBalance());
//        System.out.println("The customer's full name is: " + james.getCustomerName());
//        System.out.println("The customer's email is: " + james.getEmail());
//        System.out.println("The customer's phone number is: " + james.getPhoneNumber());

        System.out.println("The customer's full name is: " + anh.getName());
        System.out.println("The customer's email is: " + anh.getEmail());
        System.out.println("The customer's credit limit is: " + anh.getCreditLimit());

        System.out.println("The customer's full name is: " + anh1.getName());
        System.out.println("The customer's email is: " + anh1.getEmail());
        System.out.println("The customer's credit limit is: " + anh1.getCreditLimit());

        System.out.println("The customer's full name is: " + anh2.getName());
        System.out.println("The customer's email is: " + anh2.getEmail());
        System.out.println("The customer's credit limit is: " + anh2.getCreditLimit());

//        System.out.println("You deposited: " + jason.depositFunds());
//        System.out.println("The current balance is: $" + jason.getBalance());
//
//        System.out.println("You withdrew: " + jason.withdrawalFunds());
//        System.out.println("The current balance is: $" + jason.getBalance());
    }
}
