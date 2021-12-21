public class AreaCalculator {
    public static void main(String[] args) {
        System.out.println(area(2.0));
        System.out.println(area(-1.0, 5.0));
    }

    public static double area (double radius) {
        if (radius < 0) {
            return -1;
        }
            double circleArea = Math.PI * Math.pow(radius, 2);
            return circleArea;
    }

    public static double area (double x, double y) {
        if ((x < 0) || (y < 0)) {
            return -1;
        }
            double rectangleArea = x * y;
            return rectangleArea;
    }
}