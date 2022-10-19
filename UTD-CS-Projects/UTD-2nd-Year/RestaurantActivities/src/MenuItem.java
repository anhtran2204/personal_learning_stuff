package RestaurantActivities.src;

public class MenuItem {
    private static int ITEM_CODE;
    private int itemCode;
    private String name;
    private double price;

    public MenuItem() {
        this.itemCode = ITEM_CODE;
        this.name = "";
        this.price = 0;
        ITEM_CODE++;
    }

    public MenuItem(String newName, double newPrice) {
        this.itemCode = ITEM_CODE;
        this.name = newName;
        this.price = newPrice;
        ITEM_CODE++;
    }

    public int getItemCode() {
        return itemCode;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}
