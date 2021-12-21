package academy.learnprogramming;

public class Ceiling {
    private int width;
    private int length;
    private Fan fan;
    private String color;

    public Ceiling(int width, int length, Fan fan, String color) {
        this.width = width;
        this.length = length;
        this.fan = fan;
        this.color = color;
    }

    public int getWidth() {
        return width;
    }

    public int getLength() {
        return length;
    }

    public Fan getFan() {
        return fan;
    }

    public String getColor() {
        return color;
    }
}
