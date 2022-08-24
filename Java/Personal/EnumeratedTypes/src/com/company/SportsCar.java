package com.company;

import java.text.DecimalFormat;

public class SportsCar {
    private CarType make;
    private CarColor color;
    private double price;

    public SportsCar(CarType make, CarColor color, double price) {
        this.make = make;
        this.color = color;
        this.price = price;
    }

    public CarType getMake() {
        return make;
    }

    public CarColor getColor() {
        return color;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        DecimalFormat dollar = new DecimalFormat("#,##0.00");
        return "Make: " + make +
                "\nColor: " + color +
                "\nPrice: $" + dollar.format(price);
    }
}
