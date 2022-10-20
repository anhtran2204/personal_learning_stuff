package RestaurantActivities.src;

public class Order {
    private MenuItem[] orders;
    private int tableNum;

    public Order(String order, int tableNum) {
        int numOrders = processOrder(order);
        this.orders = new MenuItem[numOrders];
        this.tableNum = tableNum;
    }

    private int processOrder(String order) {
        String[] numOrders = order.split(" ");
        for (int i = 0; i < numOrders.length; i++) {

        }
        return 0;
    }

//    private boolean checkMenuItem(String item) {
//
//    }

}
