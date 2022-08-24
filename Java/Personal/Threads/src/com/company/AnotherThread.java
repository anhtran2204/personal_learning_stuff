package com.company;

import static com.company.ThreadColor.ANSI_BLUE;
import static com.company.ThreadColor.ANSI_RED;

public class AnotherThread extends Thread {
    
    @Override
    public void run() {
        System.out.println(ANSI_RED + "Hello from " + currentThread().getName());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            System.out.println(ANSI_BLUE + "Another thread woke me up");
            return;
        }
        System.out.println(ANSI_BLUE + "Five seconds have passed and I'm awake.");
    }
}
