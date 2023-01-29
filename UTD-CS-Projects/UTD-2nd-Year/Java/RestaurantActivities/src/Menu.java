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

    public boolean contains(String order) {
        for (MenuItem item : items) {
            if (order.equals(item.getItemCode())) {
                return true;
            }
        }
        return false;
    }

    public void addItem(int index, MenuItem item) {
        if (index < numItems) {
            items[index] = item;
        }
    }

    public MenuItem getItem(String itemCode) {
        for (MenuItem item : items) {
            if (item.getItemCode().equals(itemCode)) {
                return item;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        String s = "---* MENU *---";
        for (int i = 0; i < this.numItems; i++) {
            s += items[i] + "\n";
        }
        return s;
    }
}
