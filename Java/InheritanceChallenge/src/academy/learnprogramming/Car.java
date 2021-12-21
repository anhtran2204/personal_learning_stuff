package academy.learnprogramming;

import java.util.Scanner;

public class Car extends Vehicle {
    private String handSteering;
    private int gears;
    private int speed;

    public Car(String fuel, String size, String color, int doors, int wheels, boolean isManual, String handSteering, int gears, int speed) {
        super(fuel, size, color, doors, wheels, isManual);
        this.handSteering = handSteering;
        this.gears = gears;
        this.speed = speed;
    }

    public String getHandSteering() {
        return handSteering;
    }

    public int getGears() {
        return gears;
    }

    public int getSpeed() {
        return speed;
    }

    public void handSteering() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the steering direction:");
        boolean hasNextLine = scanner.hasNextLine();

        if (hasNextLine) {
            String steeringDirection = scanner.nextLine();
            System.out.println("Steering to the " + steeringDirection);
        } else {
            System.out.println("Invalid Steering");
        }
    }

    public void theGears() {
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i <= 0; i++) {
            i--;
            System.out.println("Enter the gear shift:");
            boolean hasNextInt = scanner.hasNextInt();

            if (hasNextInt) {
                int gear = scanner.nextInt();
                switch (gear) {
                    case 1:
                        System.out.println("Switch to 1st gear");
                        break;

                    case 2:
                        System.out.println("Switch to 2nd gear");
                        break;

                    case 3:
                        System.out.println("Switch to 3rd gear");
                        break;

                    case 4:
                        System.out.println("Switch to 4th gear");
                        break;

                    case 5:
                        System.out.println("Switch to 5th gear");
                        break;

                    case 0:
                        System.out.println("Switch to Normal");
                        break;

                    case -1:
                        System.out.println("Switch to Reverse");
                        break;

                    default:
                        System.out.println("Invalid Gear");
                        break;
                }
            } else {
                System.out.println("Invalid Gear");
                System.out.println("Stop the car");
                break;
            }
        }
    }

    public void carSpeed() {
        Scanner scanner = new Scanner(System.in);

        int carSpeed = 0;
        int temp;

        for (int i = 0; i <= 0; i++) {
            i--;
            temp = carSpeed;
            System.out.println("Enter the car's speed: ");
            boolean hasNextInt = scanner.hasNextInt();

            if (hasNextInt) {
                carSpeed = scanner.nextInt();
                System.out.println("The car is moving at: " + carSpeed + " mph");
            } else {
                System.out.println("Invalid Speed");
                System.out.println("Stop the car");
                break;
            }

            if (carSpeed == 0) {
                System.out.println("The car has stopped");
                break;
            }

            if (temp < carSpeed) {
                System.out.println("The car's increasing speed");
                System.out.println("The car is moving at high speed !!!");
            } else if (temp > carSpeed){
                System.out.println("The car's is decreasing speed");
            }
            scanner.nextLine();
        }
    }
}
