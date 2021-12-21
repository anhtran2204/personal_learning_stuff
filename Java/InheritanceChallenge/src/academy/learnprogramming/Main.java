package academy.learnprogramming;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Vehicle vehicle = new Vehicle("Electric", "Large", "Black", 4, 4, true);
        Car car = new Car("Petrol", "Large", "Red", 4, 4, true, "Constant", 1, 0);
        Ferrari laFerrari = new Ferrari("Petrol", "Large", "Red", 2, 4, true, "Constant", 1, 0, 0, "On");

        System.out.println("You just purchased a Ferrari laFerrari");
        System.out.println("Your new car's current state is: ");
        System.out.println("Fuel type: " + car.getFuel());
        System.out.println("Size: " + car.getSize());
        System.out.println("Color: " + car.getColor());
        System.out.println("Doors: " + car.getDoors());
        System.out.println("Wheels: " + car.isManual());

        System.out.println("Do you want to start your Ferrari ?");
        System.out.println("Say yes or no");
        String ans = scanner.nextLine();

        switch (ans) {
            case "Yes":
                System.out.println("Fuel: "  + car.getFuel());
                System.out.println("Size: " + car.getSize());
                System.out.println("Color: " + car.getColor());
                System.out.println("Doors: " + car.getDoors());
                System.out.println("Wheels: " + car.getWheels());
                System.out.println(car.isManual() + ", the car is manual");

                System.out.println("Start the test drive");
                System.out.println("Enter speed, Gear(1,2,3,4,5,6,R), Steering(left, constant, right)");

                car.handSteering();
                car.theGears();
                car.carSpeed();

                break;

            case "No":
                break;

            default:
                System.out.println("No appropriate found");
        }

        laFerrari.handSteering();
        laFerrari.theGears();
        laFerrari.carSpeed();
        laFerrari.drift(30);
        laFerrari.turbo("On");
    }
}
