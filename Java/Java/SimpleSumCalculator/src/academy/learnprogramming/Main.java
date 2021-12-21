package academy.learnprogramming;

public class Main {

    public static void main(String[] args) {
	    SimpleCalculator calculator = new SimpleCalculator();
	    calculator.setFirstNumber(5.0);
	    calculator.setSecondNumber(4.0);
        System.out.println("add= " + calculator.getAdditionResult());
        System.out.println("subtract= " + calculator.getSubtractionResult());
        System.out.println("multiply= " + calculator.getMultiplyingResult());
        System.out.println("divide= " + calculator.getDivisionResult());
    }
}
