package RestaurantActivities.src;

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

    private int processOrder(Menu menu, String[] order) {
        int numItems = 0;
        for (int i = 0; i < order.length; i++) {
            for (int j = 0; j < menu.getItems().length; j++) {
                if (order[j].equals(menu.getItems()[i].getItemCode())) {
                    numItems++;
                }
            }
        }
        return numItems;
    }
}
