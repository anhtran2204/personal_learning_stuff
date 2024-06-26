package academy.learnprogramming;

public class theMonitor {
    private String model;
    private String manufacturer;
    private int size;
    private Resolution resolution;

    public theMonitor(String model, String manufacturer, int size, Resolution resolution) {
        this.model = model;
        this.manufacturer = manufacturer;
        this.size = size;
        this.resolution = resolution;
    }

    public String getModel() {
        return model;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public int getSize() {
        return size;
    }

    public Resolution getResolution() {
        return resolution;
    }

    public void drawPixelAt(int x, int y, String color) {
        System.out.println("Drawing color at " + x + "," + y + " in color " + color);
    }
}
