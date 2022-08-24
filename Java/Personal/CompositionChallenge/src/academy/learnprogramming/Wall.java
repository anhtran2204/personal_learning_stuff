package academy.learnprogramming;

public class Wall {
    private int width;
    private int height;
    private String color;
    private Switch fanSwitch;
    private Switch lightSwitch;

    public Wall(int width, int height, String color, Switch fanSwitch, Switch lightSwitch) {
        this.width = width;
        this.height = height;
        this.color = color;
        this.fanSwitch = fanSwitch;
        this.lightSwitch = lightSwitch;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public String getColor() {
        return color;
    }

    public Switch getfanSwitch() {
        return fanSwitch;
    }

    public Switch getLightSwitch() {
        return lightSwitch;
    }
}
