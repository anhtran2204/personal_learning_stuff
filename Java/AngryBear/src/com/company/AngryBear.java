package com.company;

public class AngryBear {
    private int days;
    private int teeth;

    public AngryBear(int days, int teeth) {
        this.days = days;
        this.teeth = teeth;
    }

    public boolean isAngry() {
        return ((days >= 3 && teeth <= 10) || (teeth == 0) || days >= 5);
    }
}
