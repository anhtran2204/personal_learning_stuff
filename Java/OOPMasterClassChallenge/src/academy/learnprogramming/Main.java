package academy.learnprogramming;

import java.util.Scanner;

class Hamburger {
    private final String name;
    private final String rollType;
    private final String meat;
    private final double basePrice;
    private double additionalPrice;

    private boolean wantLettuce;
    private boolean wantTomato;
    private boolean wantOnion;
    private boolean wantExtraSauce;
    private boolean wantCheese;
    private boolean wantPickles;
    private boolean wantCarrot;
    private boolean wantMushroom;
    private boolean wantBacon;
    private boolean wantChiliPeppers;

    public Hamburger(String name, String rollType, String meat, double basePrice) {
        this.name = name;
        this.rollType = rollType;
        this.meat = meat;
        this.basePrice = basePrice;
    }

    public String getName() {
        return name;
    }

    public String getRollType() {
        return rollType;
    }

    public String getMeat() {
        return meat;
    }

    public double getPrice() {
        return basePrice;
    }

    public void setAdditionalPrice(double additionalPrice) {
        this.additionalPrice = additionalPrice;
    }

    public double getAdditionalPrice() {
        return Math.round(this.additionalPrice * 100.0) / 100.0;
    }

    public boolean isWantLettuce() {
        return wantLettuce;
    }

    public boolean isWantTomato() {
        return wantTomato;
    }

    public boolean isWantOnion() {
        return wantOnion;
    }

    public boolean isWantExtraSauce() {
        return wantExtraSauce;
    }

    public boolean isWantCheese() {
        return wantCheese;
    }

    public boolean isWantPickles() {
        return wantPickles;
    }

    public boolean isWantCarrot() {
        return wantCarrot;
    }

    public boolean isWantMushroom() {
        return wantMushroom;
    }

    public boolean isWantBacon() {
        return wantBacon;
    }

    public boolean isWantChiliPeppers() {
        return wantChiliPeppers;
    }

    public void printMenu() {
        System.out.println("============== BILLS BURGER MENU ==============");
        System.out.println("1. Beef Patty");
        System.out.println("2. Chicken Patty");
        System.out.println("3. Egg Patty");
        System.out.println("4. Combo Patty(Beef, Chicken, Egg)" + "\n");
        System.out.println("              * ADDITIONAL ITEMS *             ");
        System.out.println("1. Lettuce 	           ||   Base price: $0.12");
        System.out.println("2. Tomato  	           ||   Base price: $0.07");
        System.out.println("3. Onion  	           ||   Base price: $0.01");
        System.out.println("4. Extra Sauce         ||   Base price: $0.03");
        System.out.println("5. Cheese	           ||   Base price: $0.03");
        System.out.println("6. Pickles	           ||   Base price: $0.02");
        System.out.println("7. Carrot	           ||   Base price: $0.02");
        System.out.println("8. Mushroom	           ||   Base price: $0.05");
        System.out.println("9. Bacon	           ||   Base price: $0.10");
        System.out.println("10. Chili Peppers	   ||   Base price: $0.03");
    }

    public void getAdditional() {
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < 10; i++) {
            if (i == 0) {
                System.out.println("Do you want some Lettuce? Y/N.");
                while (true) {
                    char c = scanner.next(".").charAt(0);
                    if (c == 'Y' || c == 'y') {
                        this.wantLettuce = true;
                        break;
                    } else if (c == 'N' || c == 'n') {
                        this.wantLettuce = false;
                        break;
                    } else {
                        System.out.println("Please insert a valid answer!!!" + "\n \"Do you want some Lettuce? Y/N.\"");
                    }
                }
            }

            if (i == 1) {
                 System.out.println("Do you want some Tomato? Y/N.");
                while (true) {
                    char c = scanner.next(".").charAt(0);
                    if (c == 'Y' || c == 'y') {
                        this.wantTomato = true;
                        break;
                    } else if (c == 'N' || c == 'n') {
                        this.wantTomato = false;
                        break;
                    } else {
                        System.out.println("Please insert a valid answer!!!" + "\n \"Do you want some Tomato? Y/N.\"");
                    }
                }
            }

            if (i == 2) {
                System.out.println("Do you want some Onion? Y/N.");
                while (true) {
                    char c = scanner.next(".").charAt(0);
                    if (c == 'Y' || c == 'y') {
                        this.wantOnion = true;
                        break;
                    } else if (c == 'N' || c == 'n') {
                        this.wantOnion = false;
                        break;
                    } else {
                        System.out.println("Please insert a valid answer!!!" + "\n \"Do you want some Onion? Y/N.\"");
                    }
                }
            }

            if (i == 3) {
                System.out.println("Do you want some Extra Sauce? Y/N.");
                while (true) {
                    char c = scanner.next(".").charAt(0);
                    if (c == 'Y' || c == 'y') {
                        this.wantExtraSauce = true;
                        break;
                    } else if (c == 'N' || c == 'n') {
                        this.wantExtraSauce = false;
                        break;
                    } else {
                        System.out.println("Please insert a valid answer!!!" + "\n \"Do you want some Extra Sauce? Y/N.\"");
                    }
                }
            }

            if (i == 4) {
                System.out.println("Do you want some Cheese? Y/N.");
                while (true) {
                    char c = scanner.next(".").charAt(0);
                    if (c == 'Y' || c == 'y') {
                        this.wantCheese = true;
                        break;
                    } else if (c == 'N' || c == 'n') {
                        this.wantCheese = false;
                        break;
                    } else {
                        System.out.println("Please insert a valid answer!!!" + "\n \"Do you want some Cheese? Y/N.\"");
                    }
                }
            }

            if (i == 5) {
                System.out.println("Do you want some Pickles? Y/N.");
                while (true) {
                    char c = scanner.next(".").charAt(0);
                    if (c == 'Y' || c == 'y') {
                        this.wantPickles = true;
                        break;
                    } else if (c == 'N' || c == 'n') {
                        this.wantPickles = false;
                        break;
                    } else {
                        System.out.println("Please insert a valid answer!!!" + "\n \"Do you want some Pickles? Y/N.\"");
                    }
                }
            }

            if (i == 6) {
                System.out.println("Do you want some Carrot? Y/N.");
                while (true) {
                    char c = scanner.next(".").charAt(0);
                    if (c == 'Y' || c == 'y') {
                        this.wantCarrot = true;
                        break;
                    } else if (c == 'N' || c == 'n') {
                        this.wantCarrot = false;
                        break;
                    } else {
                        System.out.println("Please insert a valid answer!!!" + "\n \"Do you want some Carrot? Y/N.\"");
                    }
                }
            }

            if (i == 7) {
                System.out.println("Do you want some Mushroom? Y/N.");
                while (true) {
                    char c = scanner.next(".").charAt(0);
                    if (c == 'Y' || c == 'y') {
                        this.wantMushroom = true;
                        break;
                    } else if (c == 'N' || c == 'n') {
                        this.wantMushroom = false;
                        break;
                    } else {
                        System.out.println("Please insert a valid answer!!!" + "\n \"Do you want some Mushroom? Y/N.\"");
                    }
                }
            }

            if (i == 8) {
                System.out.println("Do you want some Bacon? Y/N.");
                while (true) {
                    char c = scanner.next(".").charAt(0);
                    if (c == 'Y' || c == 'y') {
                        this.wantBacon = true;
                        break;
                    } else if (c == 'N' || c == 'n') {
                        this.wantBacon = false;
                        break;
                    } else {
                        System.out.println("Please insert a valid answer!!!" + "\n \"Do you want some Bacon? Y/N.\"");
                    }
                }
            }

            if (i == 9) {
                System.out.println("Do you want some Chili Peppers? Y/N.");
                while (true) {
                    char c = scanner.next(".").charAt(0);
                    if (c == 'Y' || c == 'y') {
                        this.wantChiliPeppers = true;
                        break;
                    } else if (c == 'N' || c == 'n') {
                        this.wantChiliPeppers = false;
                        break;
                    } else {
                        System.out.println("Please insert a valid answer!!!" + "\n \"Do you want some Chili Peppers? Y/N.\"");
                    }
                }
            }
        }

        if (isWantLettuce()) {
            double lettucePrice = 0.12;
            this.setAdditionalPrice(getAdditionalPrice() + lettucePrice);
            System.out.println("\nAdded: Lettuce");
        }

        if (isWantTomato()) {
            double tomatoPrice = 0.07;
            this.setAdditionalPrice(getAdditionalPrice() + tomatoPrice);
            System.out.println("\nAdded: Tomato");
        }

        if (isWantOnion()) {
            double onionPrice = 0.01;
            this.setAdditionalPrice(getAdditionalPrice() + onionPrice);
            System.out.println("\nAdded: Onion");
        }

        if (isWantExtraSauce()) {
            double extraSaucePrice = 0.03;
            this.setAdditionalPrice(getAdditionalPrice() + extraSaucePrice);
            System.out.println("\nAdded: Extra Sauce");
        }

        if (isWantCheese()) {
            double cheesePrice = 0.03;
            this.setAdditionalPrice(getAdditionalPrice() + cheesePrice);
            System.out.println("\nAdded: Cheese");
        }

        if (isWantPickles()) {
            double picklesPrice = 0.03;
            this.setAdditionalPrice(getAdditionalPrice() + picklesPrice);
            System.out.println("\nAdded: Pickles");
        }

        if (isWantCarrot()) {
            double carrotPrice = 0.03;
            this.setAdditionalPrice(getAdditionalPrice() + carrotPrice);
            System.out.println("\nAdded: Carrot");
        }

        if (isWantMushroom()) {
            double mushroomPrice = 0.03;
            this.setAdditionalPrice(getAdditionalPrice() + mushroomPrice);
            System.out.println("\nAdded: Mushroom");
        }

        if (isWantBacon()) {
            double baconPrice = 0.03;
            this.setAdditionalPrice(getAdditionalPrice() + baconPrice);
            System.out.println("\nAdded: Bacon");
        }

        if (isWantChiliPeppers()) {
            double chiliPeppersPrice = 0.03;
            this.setAdditionalPrice(getAdditionalPrice() + chiliPeppersPrice);
            System.out.println("\nAdded: Chili Peppers");
        }

        if (!isWantLettuce() && !isWantTomato() && !isWantOnion() && !isWantExtraSauce() &&
            !isWantCheese() && !isWantPickles() && !isWantCarrot() && !isWantMushroom() &&
            !isWantBacon() && !isWantChiliPeppers()) {
            System.out.println("No additional items ordered.");
        }
    }

    public void checkOutOrder() {
        System.out.println("\n==================== CHECK OUT ORDER ====================");
        System.out.println("Burger Type: " + getName() + "		Price: $ " + getPrice());
        System.out.println("Additions: " + 			     "				Price: $ " + getAdditionalPrice());
        System.out.println("----------------------------------------TOTAL: $ " + getFinalPrice());
        System.out.println("          ~~~~~~~ THANK YOU FOR BUYING ~~~~~~~             " + "\n");
    }

    public double getFinalPrice() {
        return this.basePrice + this.getAdditionalPrice();
    }
}

class HealthyBurger extends Hamburger {
    private boolean wantChickenBreast;
    private boolean wantCeasarSalad;
    private boolean wantFrenchFries;
    private boolean wantSteakAndMash;

    public HealthyBurger() {
        super("Healthy Burger", "Brown rye bread roll", "Beef and chicken mix", 12.00);
    }

    public boolean isWantChickenBreast() {
        return wantChickenBreast;
    }

    public boolean isWantCeasarSalad() {
        return wantCeasarSalad;
    }

    public boolean isWantFrenchFries() {
        return wantFrenchFries;
    }

    public boolean isWantSteakAndMash() {
        return wantSteakAndMash;
    }

    @Override
    public double getPrice() {
        return super.getPrice();
    }

    @Override
    public double getAdditionalPrice() {
        return super.getAdditionalPrice();
    }

    @Override
    public void printMenu() {
        super.printMenu();
        System.out.println("------------- EXTRA DISHES ------------");
        System.out.println("1. Chicken Breast  ||  Base price: $4");
        System.out.println("2. Ceasar's Salad  ||  Base price: $3");
        System.out.println("3. French Fries    ||  Base price: $2");
        System.out.println("4. Steak & Mash    ||  Base price: $6");
    }


    @Override
    public void getAdditional() {
        super.getAdditional();
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < 4; i++) {
            if (i == 0) {
                System.out.println("Do you want some Chicken Breast? Y/N.");
                while (true) {
                    char c = scanner.next(".").charAt(0);
                    if (c == 'Y' || c == 'y') {
                        this.wantChickenBreast = true;
                        break;
                    } else if (c == 'N' || c == 'n') {
                        this.wantChickenBreast = false;
                        break;
                    } else {
                        System.out.println("Please insert a valid answer!!!" + "\n \"Do you want some Chicken Breast? Y/N.\"");
                    }
                }
            }

            if (i == 1) {
                System.out.println("Do you want some Ceasar's Salad? Y/N.");
                while (true) {
                    char c = scanner.next(".").charAt(0);
                    if (c == 'Y' || c == 'y') {
                        this.wantCeasarSalad = true;
                        break;
                    } else if (c == 'N' || c == 'n') {
                        this.wantCeasarSalad = false;
                        break;
                    } else {
                        System.out.println("Please insert a valid answer!!!" + "\n \"Do you want some Ceasar's Salad? Y/N.\"");
                    }
                }
            }

            if (i == 2) {
                System.out.println("Do you want some French Fries? Y/N.");
                while (true) {
                    char c = scanner.next(".").charAt(0);
                    if (c == 'Y' || c == 'y') {
                        this.wantFrenchFries = true;
                        break;
                    } else if (c == 'N' || c == 'n') {
                        this.wantFrenchFries = false;
                        break;
                    } else {
                        System.out.println("Please insert a valid answer!!!" + "\n \"Do you want some French Fries? Y/N.\"");
                    }
                }
            }

            if (i == 3) {
                System.out.println("Do you want some Steak & Mash? Y/N.");
                while (true) {
                    char c = scanner.next(".").charAt(0);
                    if (c == 'Y' || c == 'y') {
                        this.wantSteakAndMash = true;
                        break;
                    } else if (c == 'N' || c == 'n') {
                        this.wantSteakAndMash = false;
                        break;
                    } else {
                        System.out.println("Please insert a valid answer!!!" + "\n \"Do you want some Steak & Mash? Y/N.\"");
                    }
                }
            }
        }

        if (isWantChickenBreast()) {
            double chickenBreastPrice = 4;
            this.setAdditionalPrice(getAdditionalPrice() + chickenBreastPrice);
            System.out.println("\nAdded: Chicken Breast.");
        } else

        if (isWantCeasarSalad()) {
            double ceasarSaladPrice = 4;
            this.setAdditionalPrice(getAdditionalPrice() + ceasarSaladPrice);
            System.out.println("\nAdded: Ceasar's Salad.");
        } else

        if (isWantFrenchFries()) {
            double frenchfriesPrice = 4;
            this.setAdditionalPrice(getAdditionalPrice() + frenchfriesPrice);
            System.out.println("\nAdded: French Fries.");
        } else

        if (isWantSteakAndMash()) {
            double steakAndMashPrice = 4;
            this.setAdditionalPrice(getAdditionalPrice() + steakAndMashPrice);
            System.out.println("\nAdded: Steak & Mash.");
        } else
        System.out.println("No extra dishes ordered.");
    }

    @Override
    public void checkOutOrder() {
        super.checkOutOrder();
    }

    @Override
    public double getFinalPrice() {
        return super.getFinalPrice();
    }
}

class DeluxeBurger extends Hamburger {
    private boolean wantCocaCola;
    private boolean wantSprite;
    private boolean wantMilkShakes;
    private boolean wantStrawberryShakes;
    private boolean wantCoffee;
    private boolean wantAppleJuice;
    private boolean wantOrangeJuice;

    public DeluxeBurger() {
        super("Deluxe Burger", "Brioche bun", "Beef, chicken, and bacon combo", 15.00);
    }

    public boolean isWantCocaCola() {
        return wantCocaCola;
    }

    public boolean isWantSprite() {
        return wantSprite;
    }

    public boolean isWantMilkShakes() {
        return wantMilkShakes;
    }

    public boolean isWantStrawberryShakes() {
        return wantStrawberryShakes;
    }

    public boolean isWantCoffee() {
        return wantCoffee;
    }

    public boolean isWantAppleJuice() {
        return wantAppleJuice;
    }

    public boolean isWantOrangeJuice() {
        return wantOrangeJuice;
    }

    @Override
    public double getPrice() {
        return super.getPrice();
    }

    @Override
    public double getAdditionalPrice() {
        return super.getAdditionalPrice();
    }

    @Override
    public void printMenu() {
        super.printMenu();
        System.out.println("~~~~~~~~~~~~~~~~~ DRINKS ~~~~~~~~~~~~~~~~~~");
        System.out.println("1. Coca Cola         ||   Base price: $2");
        System.out.println("2. Sprite            ||   Base price: $2");
        System.out.println("3. Milk Shakes       ||   Base price: $3");
        System.out.println("4. Strawberry Shakes ||   Base price: $3");
        System.out.println("5. Coffee            ||   Base price: $4");
        System.out.println("6. Apple Juice       ||   Base price: $2");
        System.out.println("7. Orange Juice      ||   Base price: $3");
    }

    @Override
    public void getAdditional() {
        super.getAdditional();
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < 10; i++) {
            if (i == 0) {
                System.out.println("Do you want some Coca Cola? Y/N.");
                while (true) {
                    char c = scanner.next(".").charAt(0);
                    if (c == 'Y' || c == 'y') {
                        this.wantCocaCola = true;
                        break;
                    } else if (c == 'N' || c == 'n') {
                        this.wantCocaCola = false;
                        break;
                    } else {
                        System.out.println("Please insert a valid answer!!!" + "\n \"Do you want some Coca Cola? Y/N.\"");
                    }
                }
            }

            if (i == 1) {
                System.out.println("Do you want some Sprite? Y/N.");
                while (true) {
                    char c = scanner.next(".").charAt(0);
                    if (c == 'Y' || c == 'y') {
                        this.wantSprite = true;
                        break;
                    } else if (c == 'N' || c == 'n') {
                        this.wantSprite = false;
                        break;
                    } else {
                        System.out.println("Please insert a valid answer!!!" + "\n \"Do you want some Sprite? Y/N.\"");
                    }
                }
            }

            if (i == 2) {
                System.out.println("Do you want some Milk Shakes? Y/N.");
                while (true) {
                    char c = scanner.next(".").charAt(0);
                    if (c == 'Y' || c == 'y') {
                        this.wantMilkShakes = true;
                        break;
                    } else if (c == 'N' || c == 'n') {
                        this.wantMilkShakes = false;
                        break;
                    } else {
                        System.out.println("Please insert a valid answer!!!" + "\n \"Do you want some Milk Shakes? Y/N.\"");
                    }
                }
            }

            if (i == 3) {
                System.out.println("Do you want some Strawberry Shakes? Y/N.");
                while (true) {
                    char c = scanner.next(".").charAt(0);
                    if (c == 'Y' || c == 'y') {
                        this.wantStrawberryShakes = true;
                        break;
                    } else if (c == 'N' || c == 'n') {
                        this.wantStrawberryShakes = false;
                        break;
                    } else {
                        System.out.println("Please insert a valid answer!!!" + "\n \"Do you want some Strawberry Shakes? Y/N.\"");
                    }
                }
            }

            if (i == 4) {
                System.out.println("Do you want some Coffee? Y/N.");
                while (true) {
                    char c = scanner.next(".").charAt(0);
                    if (c == 'Y' || c == 'y') {
                        this.wantCoffee = true;
                        break;
                    } else if (c == 'N' || c == 'n') {
                        this.wantCoffee = false;
                        break;
                    } else {
                        System.out.println("Please insert a valid answer!!!" + "\n \"Do you want some Coffee? Y/N.\"");
                    }
                }
            }

            if (i == 5) {
                System.out.println("Do you want some Apple Juice? Y/N.");
                while (true) {
                    char c = scanner.next(".").charAt(0);
                    if (c == 'Y' || c == 'y') {
                        this.wantAppleJuice = true;
                        break;
                    } else if (c == 'N' || c == 'n') {
                        this.wantAppleJuice = false;
                        break;
                    } else {
                        System.out.println("Please insert a valid answer!!!" + "\n \"Do you want some Apple Juice? Y/N.\"");
                    }
                }
            }

            if (i == 6) {
                System.out.println("Do you want some Orange Juice? Y/N.");
                while (true) {
                    char c = scanner.next(".").charAt(0);
                    if (c == 'Y' || c == 'y') {
                        this.wantOrangeJuice = true;
                        break;
                    } else if (c == 'N' || c == 'n') {
                        this.wantOrangeJuice = false;
                        break;
                    } else {
                        System.out.println("Please insert a valid answer!!!" + "\n \"Do you want some Orange Juice? Y/N.\"");
                    }
                }
            }
        }

        if (isWantCocaCola()) {
            double cokePrice = 2;
            this.setAdditionalPrice(getAdditionalPrice() + cokePrice);
            System.out.println("\nAdded: Coca Cola.");
        } else

        if (isWantSprite()) {
            double spritePrice = 2;
            this.setAdditionalPrice(getAdditionalPrice() + spritePrice);
            System.out.println("\nAdded: Sprite.");
        } else

        if (isWantMilkShakes()) {
            double milkShakesPrice = 3;
            this.setAdditionalPrice(getAdditionalPrice() + milkShakesPrice);
            System.out.println("\nAdded: Milk Shakes.");
        } else

        if (isWantStrawberryShakes()) {
            double strawberryShakes = 3;
            this.setAdditionalPrice(getAdditionalPrice() + strawberryShakes);
            System.out.println("\nAdded: Strawberry Shakes.");
        } else

        if (isWantCoffee()) {
            double coffeePrice = 4;
            this.setAdditionalPrice(getAdditionalPrice() + coffeePrice);
            System.out.println("\nAdded: Coffee.");
        } else

       if (isWantAppleJuice()) {
           double appleJuicePrice = 2;
           this.setAdditionalPrice(getAdditionalPrice() + appleJuicePrice);
           System.out.println("\nAdded: Apple Juice.");
       } else

       if (isWantOrangeJuice()) {
           double orangeJuicePrice = 3;
           this.setAdditionalPrice(getAdditionalPrice() + orangeJuicePrice);
           System.out.println("\nAdded: Orange Juice.");
       } else
       System.out.println("No drinks ordered");
    }

    @Override
    public void checkOutOrder() {
        super.checkOutOrder();
    }

    @Override
    public double getFinalPrice() {
        return super.getFinalPrice();
    }
}

class NoHamburger extends Hamburger {
    public NoHamburger() {
        super("Out of hamburger", "Unknown roll type", "Unknown meat type"
                , 0.00);
    }

    @Override
    public double getPrice() {
        return 0;
    }

    @Override
    public double getFinalPrice() {
        return 0;
    }

    @Override
    public double getAdditionalPrice() {
        return 0;
    }

    @Override
    public void getAdditional() {
        System.out.println("We ran out of food =((((");
    }

    @Override
    public void checkOutOrder() {
        System.out.println("Please come back at another time");
    }
}

public class Main {

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            System.out.println("********** ~ Welcome to Bill's Burgers ~ **********" + "\n");
            System.out.println("++++ Please choose your order from the menu! ++++" + "\n - " + "Bill's Burgers." + "\n - "
                                + "Healthy Burger." + "\n - " + "Deluxe Burger." + "\n");
            Hamburger hamburger = getHamburger();
            hamburger.printMenu();
            System.out.println( "\n" + "You chose: " + hamburger.getName() + "\n" + "The basic components are: " +
                                    "\n - " + hamburger.getRollType() + "\n - " + hamburger.getMeat());
            System.out.println("The base price is: $" + hamburger.getPrice() + "\n");
            System.out.println("Would you like to choose some additional items?" +
                                "\n");
            hamburger.getAdditional();
            hamburger.checkOutOrder();
        }
    }

    public static Hamburger getHamburger() {
        Scanner scanner = new Scanner(System.in);
        boolean hasNextInt = scanner.hasNextInt();

        if (hasNextInt) {
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    return new Hamburger("Bill's Burgers", "Regular", "Beef patty",
                            9.00);

                case 2:
                    return new HealthyBurger();

                case 3:
                    return new DeluxeBurger();
            }
        }
        scanner.close();
        return new NoHamburger();
    }
}