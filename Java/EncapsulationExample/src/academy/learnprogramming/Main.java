package academy.learnprogramming;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
//        Player player = new Player();
//
//        player.name = "Tim";
//        player.health = 100;
//        player.weapon = "M4A1";
//
//        int damage = 10;
//        player.loseHealth(damage);
//        System.out.println("Remaining health: " + player.healthRemain());

        Scanner scanner = new Scanner(System.in);

        String name = "";
        String weaponChoice = "";
        EnhancedPlayer player = new EnhancedPlayer(name, 100, weaponChoice);

        System.out.println("Choose your name...");
        boolean hasNextLine = scanner.hasNextLine();

        if (hasNextLine) {
            name = scanner.nextLine();
        }
        System.out.println("Player's name is: " + player.getName(name));
        scanner.nextLine();

        System.out.println("Pick a weapon: ");
        if (hasNextLine) {
            weaponChoice = scanner.nextLine();
        }
        System.out.println("Player's weapon is: " + player.getWeapon(weaponChoice));

        boolean hasNextInt = scanner.hasNextInt();

        System.out.println("Initial health: " + player.getHealth());

        int damage = 0;
        if (hasNextInt) {
            damage = scanner.nextInt();
        }

        player.loseHealth(damage);
        System.out.println("Remaining health: " + player.healthRemain());

        int recovery = 0;
        if (hasNextInt) {
            recovery = scanner.nextInt();
        }

        System.out.println("Recovered " + recovery + " health");
        player.addHealth(recovery);
        System.out.println("Remaining health: " + player.healthRemain());
    }
}
