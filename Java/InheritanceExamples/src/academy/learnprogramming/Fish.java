package academy.learnprogramming;

public class Fish extends Animal {
    private int gills;
    private int eyes;
    private int fins;

    public Fish(String name, int size, int weight, int gills, int eyes, int fins) {
        super(name, 1, 1, size, weight);
        this.gills = gills;
        this.eyes = eyes;
        this.fins = fins;
    }

    private void rest() {
        System.out.println("The fish is resting");
    }

    private void moveMuscles() {

    }

    private void moveBackFin() {

    }

    public void swim(int speed) {
        System.out.println("The fish is swimming");
        moveMuscles();
        moveBackFin();
        super.move(speed);
    }


}
