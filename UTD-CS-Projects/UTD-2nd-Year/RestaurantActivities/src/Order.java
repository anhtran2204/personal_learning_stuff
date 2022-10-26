package RestaurantActivities.src;

import java.util.Arrays;

public class Order {
    private MenuItem[] orders;
    private int numItems;
    private int tableNum;

    public Order(Menu menu, String[] order, int tableNum) {
        this.numItems = processOrder(menu, order);
        this.orders = new MenuItem[numItems];
        this.tableNum = tableNum;
    }

    public int getTableNum() {
        return tableNum;
    }

    public void setOrders(MenuItem[] newOrders) {
        MenuItem[] temp = new MenuItem[this.orders.length + newOrders.length];
        System.arraycopy(this.orders, 0, temp, 0, this.orders.length);
        System.arraycopy(newOrders, 0, temp, this.orders.length, newOrders.length);
        orders = temp.clone();
        System.out.printf("%d additional items ordered for Table %s%n", newOrders.length, getTableNum());
    }

    public MenuItem[] getOrders() {
        return orders;
    }

    private int processOrder(Menu menu, String[] order) {
        int numItems = 0;
        for (int i = 0; i < menu.getItems().length; i++) {
            for (int j = 0; j < order.length; j++) {
                String itemCode = menu.getItems()[i].getItemCode();
                if (order[j].equals(itemCode)) {
                    numItems++;
                }
            }
        }
        return numItems;
    }

    public void addItem(int index, MenuItem item) {
        this.orders[index] = item;
    }

    public int longestItemName() {
        int maxLength = 0;
        for (MenuItem item : orders) {
            int length = item.getName().length();
            if (length > maxLength) {
                maxLength = length;
            }
        }
        return maxLength;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orders=" + Arrays.toString(orders) +
                ", numItems=" + numItems +
                ", tableNum=" + tableNum +
                '}';
    }
}
