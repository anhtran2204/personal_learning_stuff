package academy.learnprogramming;

public class Room {
    private Wall wall;
    private Ceiling ceiling;
    private Lights lights;
    private Fan fan;
    private Bed bed;
    private Sofa sofa;
    private Wardrobe wardrobe;
    private Desk desk;

    public Room(Wall wall, Ceiling ceiling, Lights lights, Fan fan, Bed bed, Sofa sofa, Wardrobe wardrobe, Desk desk) {
        this.wall = wall;
        this.ceiling = ceiling;
        this.lights = lights;
        this.fan = fan;
        this.bed = bed;
        this.sofa = sofa;
        this.wardrobe = wardrobe;
        this.desk = desk;
    }

    public Wall getWall() {
        return wall;
    }

    public Ceiling getCeiling() {
        return ceiling;
    }

    public Lights getLights() {
        return lights;
    }

    public Fan getFan() {
        return fan;
    }

    public Bed getBed() {
        return bed;
    }

    public Sofa getSofa() {
        return sofa;
    }

    public Wardrobe getWardrobe() {
        return wardrobe;
    }

    public Desk getDesk() {
        return desk;
    }
}
