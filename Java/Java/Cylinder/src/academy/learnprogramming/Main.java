package academy.learnprogramming;

public class Main {

    public static void main(String[] args) {
	    Circle circle = new Circle(3.75);
	    Cylinder cylinder = new Cylinder(5.55, 7.25);

        System.out.println("The circle's radius is: " + circle.getRadius());
        System.out.println("The circle's area is: " + circle.getArea());

        System.out.println("The cylinder's base's radius: " + cylinder.getRadius());
        System.out.println("The cylinder's height: " + cylinder.getHeight());
        System.out.println("The cylinder's base area: " + cylinder.getArea());
        System.out.println("The cylinder's volume: " + cylinder.getVolume());
    }
}
