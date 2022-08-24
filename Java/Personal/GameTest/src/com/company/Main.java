package com.company;

import com.example.game.ISaveable;
import com.example.game.Monster;
import com.example.game.Player;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        Player anh = new Player("Anh", 10, 15);
        System.out.println(anh.toString());
        saveObject(anh);

        anh.setHitPoints(8);
        System.out.println(anh);
        anh.setWeapon("Stormbringer");
        saveObject(anh);
//        loadObject(anh);
        System.out.println(anh);

        ISaveable werewolf = new Monster("Werewolf", 20, 40);
        System.out.println("Strength = " + ((Monster) werewolf).getStrength());
        System.out.println(werewolf);
        saveObject(werewolf);
    }

    public static ArrayList<String> readValues() {
        ArrayList<String> values = new ArrayList<String>();

        boolean quit = false;
        int index = 0;

        System.out.println("Choose: \n1 to enter a string\n0 to quit");

        while (!quit) {
            System.out.print("Choose an option:");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 0:
                    quit = true;
                    break;
                case 1:
                    System.out.print("Enter a string: ");
                    String stringInput = scanner.nextLine();
                    values.add(index, stringInput);
                    index++;
                    break;
            }
        }
        return values;
    }

    public static void saveObject(ISaveable object) {
        for (int i = 0; i < object.write().size(); i++) {
            System.out.println("Saving " + object.write().get(i) + " to storage device.");
        }
    }

    public static void loadObject(ISaveable object) {
        ArrayList<String> values = readValues();
        object.read(values);
    }
}
