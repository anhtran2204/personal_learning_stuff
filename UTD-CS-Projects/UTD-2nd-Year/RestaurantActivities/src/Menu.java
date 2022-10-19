package RestaurantActivities.src;

public class Menu {
    private Menu[] items;
    private int numItems;

    public Menu() {
        this.numItems = 1;
        items = new Menu[numItems];
    }

    public Menu(int num) {
        this.numItems = num;
        items = new Menu[this.numItems];
    }
}
