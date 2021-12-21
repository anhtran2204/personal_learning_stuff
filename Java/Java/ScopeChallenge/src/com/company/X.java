package com.company;

import java.util.Scanner;

public class X {
    private int x;

    public X(Scanner x) {
        System.out.print("Enter the number: ");
        this.x = x.nextInt();
    }

    public void x() {
        for (int x = 1; x <= 10; x++) {
            System.out.println(this.x + " times " + x + " is " + (this.x * x));
        }
    }
}
