package com.company;

import java.io.*;
import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        System.out.print("Enter the filename: ");
        String fileName = scanner.nextLine();
        FileWriter fileWriter = new FileWriter(fileName);
        PrintWriter outputFile = new PrintWriter(fileWriter);

        System.out.print("How many friends do you have? ");
        int numFriends = scanner.nextInt();

        scanner.nextLine();

        // Get data and write it to the file.
        for (int i = 1; i <= numFriends; i++) {
            // Get the name of a friend.
            System.out.print("Enter the name of friend "+
                    "number " + i + ": ");
            String friendName = scanner.nextLine();
            // Write the name to the file.
            outputFile.println(friendName);
        }
        outputFile.close();
        System.out.println("Data written to the file.");
    }
}
