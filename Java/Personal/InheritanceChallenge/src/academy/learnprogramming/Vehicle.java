package academy.learnprogramming;

public class Vehicle {
    private String fuel;
    private String size;
    private String color;
    private int doors;
    private int wheels;
    private boolean isManual;

    public Vehicle() {
        this("Petrol", "Medium", "Black", 4, 4, true);
    }

    public Vehicle(String fuel, String size, String color, int doors, int wheels, boolean isManual) {
        this.fuel = fuel;
        this.size = size;
        this.color = color;
        this.doors = doors;
        this.wheels = wheels;
        this.isManual = isManual;
    }

    public String getFuel() {
        return fuel;
    }

    public String getSize() {
        return size;
    }

    public String getColor() {
        return color;
    }

    public int getDoors() {
        return doors;
    }

    public int getWheels() {
        return wheels;
    }

    public boolean isManual() {
        return isManual;
    }
}
