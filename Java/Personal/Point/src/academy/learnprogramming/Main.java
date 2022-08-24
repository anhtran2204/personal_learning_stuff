package academy.learnprogramming;

public class Main {

    public static void main(String[] args) {
	    Point first = new Point(6,5);
	    Point second = new Point(3,1);
	    Point point = new Point();

        System.out.println("distance(0,0)= " + first.distance());
        System.out.println("distance(second)= " + first.distance(second));
        System.out.println("distance(2,2)= " + first.distance(2,2));
        System.out.println("distance= " + second.distance());
        System.out.println("distance= " + second.distance(2,2));
        System.out.println("distance= " + second.distance(first));
        System.out.println("distance= " + second.distance(point));
        System.out.println("distance()= " + point.distance());
        System.out.println("distance= " + point.distance(2,2));
    }
}
