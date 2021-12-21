package academy.learnprogramming;

public class Point {
    private int x;
    private int y;
    private Point point;

    public Point() {
        this(0,0);
    }

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    // methods
    // Used this page for some formulae:
    // https://orion.math.iastate.edu/dept/links/formulas/form2.pdf

    //return distance from origin
    //math: (square root of (x^2 + y^2) )

    public double distance() {
        return distance(0,0);
    }

    //return distance from this.point and another coordinate pair as a parameter
    //math: (square root of ((x - this.x)^2) + ((y - this.y)^2))

    public double distance(int x, int y) {
        return Math.sqrt((x-getX())*(x-getX()) + (y-getY())*(y-getY()));
    }

    // return distance from this.point and another point as a parameter
    // passing parameter to distance(int, int) method for processing

    public double distance(Point point) {
        this.point = point;
        return distance(point.x, point.y);
    }
}
