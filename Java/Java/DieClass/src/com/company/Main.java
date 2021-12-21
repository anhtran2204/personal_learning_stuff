package com.company;

public class Main {

    public static void main(String[] args) {
        Die a = new Die();
        Die b = new Die();

        int count = 0;

        for (int i = 0; i < 10; i++) {
            a.roll();
            b.roll();
            int faceA = a.printFace();
            System.out.println(faceA);
            int faceB = b.printFace();
            System.out.println(faceB + "\n");
            if (faceA == faceB) {
                count++;
            }
        }
        System.out.println(count);
    }
}

class Die {
    private int face;

    public Die() {
        roll();
    }

    public void roll() {
        face = (int)((Math.random() * 6) + 1);
    }

    public int printFace() {
        return face;
    }
}
