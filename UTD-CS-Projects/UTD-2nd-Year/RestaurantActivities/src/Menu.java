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

    public void addItem(int index, MenuItem item) {
        if (index < numItems) {
            items[index] = item;
        }
    }

    @Override
    public String toString() {
        System.out.println("---* MENU *---");
        for (int i = 0; i < this.numItems; i++) {
            System.out.println(items[i]);
        }
        return "";
    }
}
