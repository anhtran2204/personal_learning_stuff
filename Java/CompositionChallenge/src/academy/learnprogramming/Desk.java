package academy.learnprogramming;

public class Desk {
    private int width;
    private int length;
    private int height;
    private String patterns;
    private String color;
    private PC pc;

    public Desk(int width, int length, int height, String patterns, String color) {
        this.width = width;
        this.length = length;
        this.height = height;
        this.patterns = patterns;
        this.color = color;
    }

    public int getWidth() {
        return width;
    }

    public int getLength() {
        return length;
    }

    public int getHeight() {
        return height;
    }

    public String getPatterns() {
        return patterns;
    }

    public String getColor() {
        return color;
    }
}
