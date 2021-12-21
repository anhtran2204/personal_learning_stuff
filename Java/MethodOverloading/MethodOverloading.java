public class MethodOverloading {
    
    public static void main(String[] args) {
        calcFeetAndInchestoCentimeters(10, 8);
    }

    public static double calcFeetAndInchestoCentimeters(double feet, double inches) {
        if ((0 > feet) || (0 > inches || inches > 12)) {
            System.out.println("Invalid input");
            return -1;
        }
            double centimeters = (feet * 12) * 2.54;
            centimeters += inches * 2.54;
            System.out.println(feet + " feet, " + inches + " inches = " + centimeters + " cm");
            return centimeters;
    }

    // Method Overloading is using one method for multiple times but the 
    // difference in each time is that we use a unique paremeter,
    // whether that parameter is new or same as one of the old parameter

    public static double calcFeetAndInchestoCentimeters(double inches) {
        if (inches < 0) {
            return -1; 
        } 
            double feet = (int) inches / 12;
            double remainingInches = (int) inches % 12;
            System.out.println(inches + " inches is equal to " + feet + " feet and " + remainingInches + " inches");
            return calcFeetAndInchestoCentimeters(feet, remainingInches);
    }
}