package academy.learnprogramming;

public class Car {
    protected int doors;
    protected int wheels;
    protected String model;
    protected String engine;
    protected String color;

    public void setCar(String model) {
        String validModel = model.toLowerCase();
        if (validModel.equals("carrera") || validModel.equals("commodore")) {
            this.model = model;
        } else {
            this.model = "Unknown";
        }

    }

    public String getModel() {
        return this.model;
    }
}
