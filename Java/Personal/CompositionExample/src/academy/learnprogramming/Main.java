package academy.learnprogramming;

public class Main {

    public static void main(String[] args) {
        Dimensions dimensions = new Dimensions(20, 20, 5);
        Case theCase = new Case("220B", "Dell", "500", dimensions);
        Motherboard motherboard = new Motherboard("310L", "ASUS", 4, 2, "v2.44");
        Monitor monitor = new Monitor("32 inch T55", "Samsung", 32, new Resolution(3440, 1440));

        PC pc = new PC(theCase, monitor, motherboard);
//        pc.getMonitor().drawPixelAt(1500, 1200, "Red");
//        pc.powerUp();


        System.out.println("The PC's monitor's specs are: ");
        System.out.print(pc.getMonitor().getModel() + " ");
        System.out.print(pc.getMonitor().getManufacturer() + " ");
        System.out.print(pc.getMonitor().getSize() + " ");
        System.out.print(pc.getMonitor().getResolution().getWidth() + " ");
        System.out.println(pc.getMonitor().getResolution().getHeight() + " ");

        System.out.println("The PC's case's specs are: ");
        System.out.print(pc.getTheCase().getModel() + " ");
        System.out.print(pc.getTheCase().getManufacturer() + " ");
        System.out.print(pc.getTheCase().getPowerSupply() + " ");
        System.out.print(pc.getTheCase().getDimensions().getWidth() + " ");
        System.out.print(pc.getTheCase().getDimensions().getHeight() + " ");
        System.out.println(pc.getTheCase().getDimensions().getDepth() + " ");

        System.out.println("The PC's motherboard's specs are: ");
        System.out.print(pc.getMotherboard().getModel() + " ");
        System.out.print(pc.getMotherboard().getManufacturer() + " ");
        System.out.print(pc.getMotherboard().getRamSlots() + " ");
        System.out.print(pc.getMotherboard().getCardSlots() + " ");
        System.out.print(pc.getMotherboard().getBios() + " ");

    }
}
