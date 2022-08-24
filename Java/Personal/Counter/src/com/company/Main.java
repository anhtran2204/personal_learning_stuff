package com.company;

public class Main {

    public static void main(String[] args) {
        CountDown countDown = new CountDown();
        
        CountDownThread t1 = new CountDownThread(countDown);
        t1.setName("Thread 1");
    
        CountDownThread t2 = new CountDownThread(countDown);
        t2.setName("Thread 2");
        
        t1.start();
        t2.start();
        
    }
}

class CountDown {
    
    private int i;
    
    public void doCountDown() {
        String color;
        
        switch (Thread.currentThread().getName()) {
            case "Thread 1":
                color = com.company.ThreadColor.ANSI_CYAN;
                break;
            case "Thread 2":
                color = com.company.ThreadColor.ANSI_PURPLE;
                break;
            default:
                color = com.company.ThreadColor.ANSI_GREEN;
        }
        
        synchronized (this) {
            for (i = 10; i > 0; i--) {
                System.out.println(color + Thread.currentThread().getName() + ": i = " + i);
            }
        }
    
    }
}

class CountDownThread extends Thread {
    
    private CountDown threadCountDown;
    
    public CountDownThread(CountDown threadCountDown) {
        this.threadCountDown = threadCountDown;
    }
    
    @Override
    public void run() {
        threadCountDown.doCountDown();
    }
}
