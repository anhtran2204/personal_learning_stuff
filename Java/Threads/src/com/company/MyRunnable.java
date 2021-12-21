package com.company;

import static com.company.ThreadColor.ANSI_BLUE;

public class MyRunnable implements Runnable {
    
    @Override
    public void run() {
        System.out.println(ANSI_BLUE + "Hello from MyRunnable's implementation of run()");
    }
}
