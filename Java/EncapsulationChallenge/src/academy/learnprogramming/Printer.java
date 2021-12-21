package academy.learnprogramming;

public class Printer {
    private int tonerLevel = 100;
    private int numOfPages;
    private boolean duplex;
    private boolean working;

    public Printer(int tonerLevel, int numOfPages, boolean duplex, boolean working) {
        if (tonerLevel > 0 && tonerLevel <= 100) {
            this.tonerLevel = tonerLevel;
        }
        this.numOfPages = numOfPages;
        this.duplex = duplex;
        this.working = working;
    }

    public int getTonerLevel() {
        return tonerLevel;
    }

    public int getNumOfPages() {
        return numOfPages;
    }

    public boolean isDuplex() {
        return duplex;
    }

    public boolean isWorking() {
        return working;
    }

    public void turnOn() {
        if (working) {
            System.out.println("Printer is turned on....");
        } else {
            System.out.println("Printer is offline...");
            System.out.println("Push start button to turn on!");
        }
    }

    public void loseTonerLevel(int amount) {
        this.tonerLevel -= amount;
        System.out.println(amount + "% toner have been used.");
        System.out.println("Current toner level: " + amount);
        if (tonerLevel < 0) {
            System.out.println("Insufficient Toner!!!");
            System.out.println("Add more toner to continue using...");
            this.tonerLevel = 0;
        }
    }
    public void addTonerLevel(int amount) {
        this.tonerLevel += amount;
        System.out.println(amount + "% toner have been added.");
        if (this.tonerLevel > 100) {
            System.out.println("Maximum toner level reached!!!");
            this.tonerLevel = 100;
            System.out.println("Current toner level: " + this.tonerLevel);
        }
    }

    public void addNumOfPages(int amount) {
        if (tonerLevel < 10) {
            System.out.println("Insufficient toner level to print!!!");
        }
        int printed = amount;
        if (isDuplex()) {
            System.out.println("This is a duplex printer.");
            printed = (amount/2);
            int remainingPages = amount % 2;
            System.out.println(amount + " pages have been printed.");
            System.out.println(printed + " paper(s) have been printed with " + remainingPages + " page(s) extra");
        } else {
            System.out.println("This is a normal printer.");
            this.numOfPages += amount;
            System.out.println(numOfPages + " pages have been printed.");
        }
    }
}
