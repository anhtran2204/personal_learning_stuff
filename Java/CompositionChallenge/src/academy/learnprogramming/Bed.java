package academy.learnprogramming;

public class Bed {
    private int width;
    private int length;
    private int height;
    private String color;
    private String patterns;

    public Bed(int width, int length, int height, String color, String patterns) {
        this.width = width;
        this.length = length;
        this.height = height;
        this.color = color;
        this.patterns = patterns;
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

    public String getColor() {
        return color;
    }

    public String getPatterns() {
        return patterns;
    }
}
