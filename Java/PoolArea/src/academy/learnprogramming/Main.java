package academy.learnprogramming;

public class Main {

    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle(5, 10);
        Cuboid cuboid = new Cuboid(5, 10 ,5);

        System.out.println("The width of the rectangle: " + rectangle.getWidth());
        System.out.println("The length of the rectangle: " + rectangle.getLength());
        System.out.println("The area of the rectangle: " + rectangle.getArea());

        System.out.println("The width of the cuboid's base: " + cuboid.getWidth());
        System.out.println("The length of the cuboid's base: " + cuboid.getLength());
        System.out.println("The height of the cuboid: " + cuboid.getHeight());
        System.out.println("The area of the cuboid's base: " + cuboid.getArea());
        System.out.println("The volume of the cuboid: " + cuboid.getVolume());
    }
}
