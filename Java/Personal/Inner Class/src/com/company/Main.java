package com.company;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static Button btnPrint = new Button("Print");

    public static void main(String[] args) {
        /* * This is a local class - an inner class that is
             with in the block of the main method
         */
//        class ClickListener implements Button.OnClickListener {
//            public ClickListener() {
//                System.out.println("I've been attached");
//            }
//
//            @Override
//            public void onClick(String title) {
//                System.out.println(title + " was clicked.");
//            }
//        }
//        btnPrint.setOnClickListener(new ClickListener());

        /* * This is an anonymous inner class - a class that can
             be declare and instantiate at the same time, without
             having to subclass a class.
         */
        btnPrint.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(String title) {
                System.out.println(title +  " was clicked.");
            }
        });
        listen();
    }

    public static void listen() {
        boolean quit = false;

        while (!quit) {
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 0:
                    quit = true;
                    break;

                case 1:
                    btnPrint.onClick();
            }
        }
    }
}
