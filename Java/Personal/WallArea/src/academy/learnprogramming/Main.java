package academy.learnprogramming;

public class Main {

    public static void main(String[] args) {
	    Wall wall = new Wall(0.0, 1.25);

        System.out.println("width= " + wall.getWidth());
        System.out.println("height= " + wall.getHeight());
        System.out.println("area= " + wall.getArea());
    }
}
