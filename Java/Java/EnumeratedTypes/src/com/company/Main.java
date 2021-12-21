package com.company;

public class Main {

    public static void main(String[] args) {
        SportsCar newCar = new SportsCar(CarType.FERRARI, CarColor.RED, 100000);

        switch (newCar.getMake()) {
            case JAGUAR:

            case MCLAREN:
                System.out.println("Your car was made in England.");
                break;

            case FERRARI:

            case LAMBORGHINI:

            case MASERATI:
                System.out.println("Your car was made in Italy.");
                break;

            case PORSCHE:
                System.out.println("Your car was made in Germany");
                break;

            default:
                System.out.println("I'm not sure where your car was made.");
        }
    }
}
