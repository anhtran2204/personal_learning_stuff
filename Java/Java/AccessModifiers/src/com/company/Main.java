package com.company;

public class Main {

    public static void main(String[] args) {
        Account anhsAccount = new Account("Anh Tran");
        anhsAccount.deposit(10000);
        anhsAccount.withdraw(5000);
        anhsAccount.withdraw(-2000);
        anhsAccount.deposit(-200);
        anhsAccount.calcBalance();

        System.out.println("Balance on account is " + anhsAccount.getBalance());
//        anhsAccount.transactions.add(4500);
        anhsAccount.calcBalance();
    }
}
