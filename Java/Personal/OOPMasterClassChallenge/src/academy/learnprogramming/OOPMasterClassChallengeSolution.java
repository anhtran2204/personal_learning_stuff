package academy.learnprogramming;

import java.util.Scanner;

class hamburger {

    private String name;
    private String breadRollType;
    private String meat;
    private double basePrice;
    private double additionalPrice;

    public hamburger(String name, String breadRollType, String meat, double price) {
        this.name = name;
        this.breadRollType = breadRollType;
        this.meat = meat;
        this.basePrice = price;
    }

    public void printMenu() {
        System.out.println("======== BILLS BURGER MENU =======");
        System.out.println("1. Lettuce 	  || Base price: $3");
        System.out.println("2. Tomato  	  || Base price: $2");
        System.out.println("3. Cheese  	  || Base price: $3");
        System.out.println("4. Onions	  || Base price: $1");
    }

    public void addAdditional(int choice) {
        if(choice > 0 && choice < 5 ) {
            switch(choice) {
                case 1: //letuce
                    double lettucePrice = 3;
                    this.setAdditionalPrice(this.getAdditionalPrice() + lettucePrice);
                    System.out.println("\nAdded: Lettuce");
                    break;
                case 2:
                    double tomatoPrice = 2;
                    this.setAdditionalPrice(this.getAdditionalPrice() + tomatoPrice);
                    System.out.println("\nAdded: Tomato");
                    break;
                case 3:
                    double cheesePrice = 3;
                    this.setAdditionalPrice(this.getAdditionalPrice() + cheesePrice);
                    System.out.println("\nAdded: Cheese");
                    break;
                case 4:
                    double onionPrice = 1;
                    this.setAdditionalPrice(this.getAdditionalPrice() + onionPrice);
                    System.out.println("\nAdded: Onion");
                    break;
            }
        }
    }

    public void checkOutOrder() {
        System.out.println("\n==================== CHECK OUT ORDER ====================");
        System.out.println("Burger Type: " + getName() + "		Price: $ " + getBasePrice());
        System.out.println("Additions: " + 			     "				Price: $ " + getAdditionalPrice());
        System.out.println("----------------------------------------TOTAL: $ " + getTotalPrice());
        System.out.println("");
    }

    public String getName() {
        return name;
    }

    public String getBreadRollType() {
        return breadRollType;
    }

    public String getMeat() {
        return meat;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public double getAdditionalPrice() {
        return additionalPrice;
    }

    public double getTotalPrice() {
        return this.basePrice + this.getAdditionalPrice();
    }

    public void setAdditionalPrice(double additionalPrice) {
        this.additionalPrice = additionalPrice;
    }
}

class healthyBurger extends hamburger{

    public healthyBurger() {
        super("Healthy Burger", "Brown Rye Bread Roll", "Soy based meat", 10);
    }

    @Override
    public void addAdditional(int choice) {
        super.addAdditional(choice);
        switch(choice) {
            case 5:
                double chickenBreastPrice = 4;
                this.setAdditionalPrice(this.getAdditionalPrice() + chickenBreastPrice);
                System.out.println("\nAdded: Chicken Breast");
                break;
            case 6:
                double ceaserSaladPrice = 5;
                this.setAdditionalPrice(this.getAdditionalPrice() + ceaserSaladPrice);
                System.out.println("\nAdded: Ceaser Salad");
                break;
        }
    }

    @Override
    public void checkOutOrder() {
        // TODO Auto-generated method stub
        super.checkOutOrder();
    }

    @Override
    public void printMenu() {
        super.printMenu();
        System.out.println("5. Chicken Breast || Base price: $4");
        System.out.println("6. Ceaser Salad   || Base price: $5");
    }
}

class deluxeBurger extends hamburger {

    public deluxeBurger() {
        super("Deluxe Burger", "Truffle Bread", "Kobe Beef", 30);
    }

    @Override
    public void addAdditional(int choice) {
        switch(choice) {
            case 1:
                double chipsPrice = 7;
                this.setAdditionalPrice(this.getAdditionalPrice() + chipsPrice);
                System.out.println("\nAdded: Chips");
                break;
            case 2:
                double cokePrice = 4;
                this.setAdditionalPrice(this.getAdditionalPrice() + cokePrice);
                System.out.println("\nAdded: Coke");
                break;
        }
    }

    @Override
    public void checkOutOrder() {
        super.checkOutOrder();
    }

    @Override
    public void printMenu() {
        System.out.println("======== BILLS BURGER MENU =======");
        System.out.println("1. Chips	  || Base price: $1");
        System.out.println("2. Coke 	  || Base price: $1");
    }
}
public class OOPMasterClassChallengeSolution {
    public static void main(String[] args) {
        hamburger hamburgers = new hamburger("Base Burger","Italian Bread","Beef Patty",15);
        hamburgers.printMenu();
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; true; i++) {
            boolean hasNextInt = scanner.hasNextInt();
            if (hasNextInt) {
                int choice = scanner.nextInt();
                hamburgers.addAdditional(choice);
            } else {
                break;
            }
        }
        hamburgers.checkOutOrder();

        healthyBurger healthyBurgers = new healthyBurger();
        healthyBurgers.printMenu();
        healthyBurgers.addAdditional(5);
        healthyBurgers.addAdditional(6);
        healthyBurgers.addAdditional(1);
        healthyBurgers.addAdditional(2);
        healthyBurgers.checkOutOrder();

        deluxeBurger deluxeBurgers = new deluxeBurger();
        deluxeBurgers.printMenu();
        deluxeBurgers.addAdditional(1);
        deluxeBurgers.addAdditional(1);
        deluxeBurgers.addAdditional(2);
        deluxeBurgers.checkOutOrder();
    }
}
