package academy.learnprogramming;

public class Main {

    public static void main(String[] args) {
        Car porsche = new Car();
        Car ferrari = new Car();
        porsche.setCar("Carrera");
        System.out.println("Model is " + porsche.getModel());
    }
}
