package academy.learnprogramming;
// This is the solution by Tim Buchalka
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
public class Main {

    public static void main(String[] args) {
        Bank bank = new Bank("National Australia Bank");

//        bank.addBranch("Adelaide");
        if (bank.addBranch("Adelaide")) {
            System.out.println("Adelaide branch created");
        }

        bank.addNewCustomer("Adelaide", "Tim", 50.05);
        bank.addNewCustomer("Adelaide", "Mike", 175.34);
        bank.addNewCustomer("Adelaide", "Percy", 220.12);

        bank.addBranch("Sydney");

        bank.addNewCustomer("Sydney", "Bob", 150.54);

        bank.addNewTransactions("Adelaide", "Tim", 44.22);
        bank.addNewTransactions("Adelaide", "Tim", 12.44);
        bank.addNewTransactions("Adelaide", "Mike", 1.65);

        bank.listCustomer("Adelaide", true);
        bank.listCustomer("Sydney", true);

//        bank.addBranch("Melbourne");

        if (!bank.addNewCustomer("Melbourne", "Brian", 5.53)) {
            System.out.println("Error Melbourne branch does not exist");
        }

        if (!bank.addBranch("Adelaide")) {
            System.out.println("Adelaide branch already exist");
        }

        if (!bank.addNewTransactions("Adelaide", "Fergus", 52.33)) {
            System.out.println("Customer does not exist at branch");
        }

        if (!bank.addNewCustomer("Adelaide", "Tim", 12.21)) {
            System.out.println("Customer Tim already exists");
        }
    }
}
