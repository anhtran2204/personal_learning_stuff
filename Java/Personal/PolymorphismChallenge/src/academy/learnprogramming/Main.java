package academy.learnprogramming;

class Car {
    private final String model;
    private final boolean engine;
    private final int cylinders;
    private final String type;
    private final int doors;
    private final int wheels;
    private final String color;
    private final String interior;
    private int initialSpeed;

    public Car(String model, int cylinders, String type, int doors, String color, String interior, int initialSpeed) {
        this.model = model;
        this.engine = true;
        this.cylinders = cylinders;
        this.type = type;
        this.doors = doors;
        this.wheels = 4;
        this.color = color;
        this.interior = interior;
        this.initialSpeed = initialSpeed;
    }

    public String getModel() {
        return model;
    }

    public boolean isEngine() {
        return engine;
    }

    public int getCylinders() {
        return cylinders;
    }

    public String getType() {
        return type;
    }

    public int getDoors() {
        return doors;
    }

    public int getWheels() {
        return wheels;
    }

    public String getColor() {
        return color;
    }

    public String getInterior() {
        return interior;
    }

    public int getInitialSpeed() {
        return initialSpeed;
    }

    public String startEngine() {
        return "Start the engine of the car...";
    }

    public void accelerate(int speed) {
        if (speed < 0) {
            System.out.println("Invalid speed");
        }
        this.initialSpeed += speed;
        System.out.println("Accelerating by " + speed + " mph");
        System.out.println("Current velocity is: " + this.initialSpeed + " mph");
    }

    public void decelerate(int speed) {
        if (speed < 0) {
            System.out.println("Invalid speed");
        }

        this.initialSpeed -= speed;
        System.out.println("Decelerating by " + speed + " mph");
        System.out.println("Current velocity is: " + this.initialSpeed + " mph");
        if (initialSpeed <= 0) {
            System.out.println("The car has stopped");
            this.initialSpeed = 0;
            System.out.println("Current velocity is: " + this.initialSpeed + " mph");
        }
    }

    public void drift() {
        System.out.println("The car is drifting at " + this.initialSpeed + " mph");
    }

    public String brake() {
        return "Braking the car";
    }
}

class Ferrari extends Car {
    // This is polymorphism in Java
    // We make an empty constructor in subclasses but
    // override it with the subclass's own parameters
    public Ferrari() {
        super("SF90-Stradale", 8, "Sports car", 2, "Red", "Leather",0);
    }

    // Or we do this
    // We override a method in the base class to do unique stuff
    @Override
    public String startEngine() {
        return "Start the engine of the Ferrari...";
    }
}

class BMW extends Car {
    public BMW() {
        super("M8 Gran Coupé", 8, "Sedan-Coupe hybrid", 4, "Maroon", "Fur", 0);
    }

    @Override
    public String startEngine() {
        // We could do getClass().getName() + " start engine";
        // to get the name of this class's car
        return "Start the engine of the BMW...";
    }
}

class MercedesBenz extends Car {
    public MercedesBenz() {
        super("Maybach", 12, "Sedan", 4, "Black", "Leather-Fur",0);
    }

    @Override
    public String startEngine() {
        return "Start the engine of the Mercedes...";
    }
}

class Lamborghini extends Car {
    public Lamborghini() {
        super("Terzo Millennio", 4, "Electric-sports car", 2, "Gray-Orange", "Leather", 0);
    }

    @Override
    public String startEngine() {
        return "Start the engine of the Lamborghini...";
    }
}

class McLaren extends Car {
    public McLaren() {
        super("New GT", 8, "Sports car", 2, "Burnished Copper", "Racing leather",0);
    }

    @Override
    public String startEngine() {
        return "Start the engine of the McLaren...";
    }
}

class Jaguar extends Car {
    public Jaguar() {
        super("XJ", 8, "Luxury Sedan", 4, "Dark moss green", "Leather",0);
    }

    @Override
    public String startEngine() {
        return "Start the engine of the Jaguar...";
    }
}

class NoCar extends Car {
    public NoCar() {
        super("Unknown model", 0, "Unknown type", 0, "Unknown color","Unknown interior",0);
    }

    @Override
    public String startEngine() {
        return "No engine to start...";
    }
}

public class Main {

    public static void main(String[] args) {
        // We use this for-loop to assign the random numbers to each instance objects
        // so if in randomCar() we get a number 1 then the switch() case would create a new instance
        // that is assign to the case 1, in this case is a Ferrari
        for (int i = 1; i < 10; i++) {
            Car car = randomCar();
            System.out.println("The car's specifications are: " + "\n" + "+ Model name: " + car.getModel() + "\n"
                            + "+ Cylinders: " + "V" + car.getCylinders() + "\n" + "+ Car type: " + car.getType() + "\n"
                            + "+ Doors: " + car.getDoors() + "\n" + "+ Exterior color: " + car.getColor() + "\n"
                            + "+ Interior: " + car.getInterior() + "\n");
            System.out.println("Do you want to do a test drive...");
            System.out.println(car.startEngine());
            System.out.println("Initial speed is: " + car.getInitialSpeed());
            System.out.println("\n");
            car.accelerate(120);
            System.out.println("\n" + "....");
            car.decelerate(50);
            System.out.println("\n" + "....");
            car.drift();
            System.out.println("\n" + "....");
            System.out.println(car.brake());
            System.out.println("\n");
        }
    }

    public static Car randomCar() {
        // Use a switch statement to randomly create and assign instances of the car
        int randomNum = (int) (Math.random()*5) + 2;
        switch (randomNum) {
            case 1:
                return new Ferrari();

            case 2:
                return new BMW();

            case 3:
                return new MercedesBenz();

            case 4:
                return new Lamborghini();

            case 5:
                return new McLaren();

            case 6:
                return new Jaguar();
        }
        return new NoCar();
    }
}
