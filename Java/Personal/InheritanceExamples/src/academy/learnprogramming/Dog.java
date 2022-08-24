package academy.learnprogramming;

public class Dog extends Animal {
    private int eyes;
    private int legs;
    private int tail;
    private int teeth;
    private String coat;

    public Dog(String name, int size, int weight, int eyes, int legs, int tail, int teeth, String coat) {
        super(name, 1, 1, size, weight);
        this.eyes = eyes;
        this.legs = legs;
        this.tail = tail;
        this.teeth = teeth;
        this.coat = coat;
    }

    public void chew() {
        System.out.println("The dog is chewing");
    }

    @Override
    public void eat() {
        System.out.println("The dog is eating");
        chew();
        super.eat();
    }

    public void walk() {
        System.out.println("Dog is walking");
        super.move(5);
    }

    public void moveLegs(int speed) {
        System.out.println("The dog's legs are moving");
    }

    @Override
    public void move(int speed) {
        System.out.println("The dog is moving");
        moveLegs(speed);
        super.move(speed);
    }

    public void run() {
        System.out.println("The dog is running");
        move(10);
    }
}
