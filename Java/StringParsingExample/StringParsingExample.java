public class StringParsingExample {
    public static void main(String[] args) {
        String numberAsString = "2018";
        String numberAsString1 = "2018.1251";
        System.out.println("number = " + numberAsString);

        int number = Integer.parseInt(numberAsString);
        double number2 = Double.parseDouble(numberAsString1);
        System.out.println("Number is " + number);
        System.out.println("Number = " + number2);

        numberAsString += 1;
        number += 1;

        System.out.println(numberAsString);
        System.out.println(number);
    }
}