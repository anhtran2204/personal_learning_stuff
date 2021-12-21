package academy.learnprogramming;

public class Main {

    public static void main(String[] args) {

        Floor floor = new Floor(2.75,4.0);
        Carpet carpet = new Carpet(12);
        Calculator calculator = new Calculator(floor, carpet);

        System.out.println("area= " + floor.getArea());
        System.out.println("cost= " + carpet.getCost());
        System.out.println("total cost= " + calculator.getTotalCost());

    }
}
