package academy.learnprogramming;

import javax.management.monitor.Monitor;

public class Main {

    public static void main(String[] args) {
        Switch aSwitch = new Switch(true);
        Wall wall = new Wall(20, 20, "Gray", aSwitch, aSwitch);
        Fan fan = new Fan(aSwitch, true);
        Ceiling ceiling = new Ceiling(20,20, fan, "Black");
        Lights lights = new Lights(aSwitch, true);
        Bed bed = new Bed(4, 3, 1, "Beige", "Plain");
        Sofa sofa = new Sofa(6, 3, 2, "Stripes", "White");
        Desk desk = new Desk(3, 2, 2, "Plain", "Beige");
        Wardrobe wardrobe = new Wardrobe(4, 2,5, "Plain", "Beige");
        Dimensions dimensions = new Dimensions(20, 20, 5);
        Case theCase = new Case("220B", "Dell", "500", dimensions);
        Motherboard motherboard = new Motherboard("310L", "ASUS", 4, 2, "v2.44");
        theMonitor monitors = new theMonitor("32 inch T55", "Samsung", 32, new Resolution(3440, 1440));
        PC pc = new PC(theCase, monitors, motherboard);
        Room room = new Room(wall,ceiling, lights, fan, bed, sofa, wardrobe,desk);

        System.out.println("The wall's dimensions are: ");
        System.out.println(room.getWall().getWidth());
        System.out.println(room.getWall().getHeight());
        System.out.println(room.getWall().getColor());
        System.out.println(room.getWall().getfanSwitch());
        System.out.println(room.getWall().getLightSwitch());

        System.out.println("The PC's monitor's specs are: ");
        System.out.println("Model: " + pc.getMonitor().getModel());
        System.out.println("Manufacturer: " + pc.getMonitor().getManufacturer());
        System.out.println("Size: " + pc.getMonitor().getSize());
        System.out.print("Resolution: " + pc.getMonitor().getResolution().getWidth());
        System.out.print("x");
        System.out.println(pc.getMonitor().getResolution().getHeight());

        System.out.println("The PC's case's specs are: ");
        System.out.println("Model: " + pc.getTheCase().getModel());
        System.out.println("Manufacturer: " + pc.getTheCase().getManufacturer());
        System.out.println("Power supply: " + pc.getTheCase().getPowerSupply());
        System.out.println("Width: " + pc.getTheCase().getDimensions().getWidth() + " cm");
        System.out.println("Height: " + pc.getTheCase().getDimensions().getHeight() + " cm");
        System.out.println("Depth: " + pc.getTheCase().getDimensions().getDepth() + " cm");

        System.out.println("The PC's motherboard's specs are: ");
        System.out.println("Model: " + pc.getMotherboard().getModel());
        System.out.println("Manufacturer: " + pc.getMotherboard().getManufacturer());
        System.out.println("Ram slots: " + pc.getMotherboard().getRamSlots());
        System.out.println("Card slots: " + pc.getMotherboard().getCardSlots());
        System.out.print("Bios: " + pc.getMotherboard().getBios());
    }
}
