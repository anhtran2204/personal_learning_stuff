package academy.learnprogramming;

public class Main {

    public static void main(String[] args) {
        ComplexNumber one = new ComplexNumber(1.0, 1.0);
        ComplexNumber number = new ComplexNumber(2.5, -1.5);
        number.subtract(-1,-1);
        System.out.println("one.real= " + one.getReal());
        number.subtract(one);
        System.out.println(number.getReal());
    }
}
