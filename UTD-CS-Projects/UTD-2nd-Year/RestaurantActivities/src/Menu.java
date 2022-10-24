package RestaurantActivities.src;

public class Menu {
    private MenuItem[] items;
    private int numItems;

    public Menu() {
        this.numItems = 1;
        items = new MenuItem[numItems];
    }

    public Menu(int num) {
        this.numItems = num;
        items = new MenuItem[this.numItems];
    }

    public MenuItem[] getItems() {
        return items;
    }
}
