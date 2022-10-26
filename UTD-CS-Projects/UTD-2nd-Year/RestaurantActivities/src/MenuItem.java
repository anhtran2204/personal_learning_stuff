package RestaurantActivities.src;

public class MenuItem {
    private String itemCode;
    private String name;
    private double price;

    public MenuItem(String code, String newName, double newPrice) {
        this.itemCode = code;
        this.name = newName;
        this.price = newPrice;
    }

    public String getItemCode() {
        return itemCode;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return this.itemCode + " " + this.name + " " + this.price;
    }
}
