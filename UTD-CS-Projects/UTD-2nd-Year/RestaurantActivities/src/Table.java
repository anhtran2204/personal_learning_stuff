package RestaurantActivities.src;

public class Table {
    private static int TABLE_NUM = 1;
    private int tableNum;
    private boolean occupied = false;
    private int maxSeats;
    private int seatsOccupied;
    private boolean ordered = false;
    private Order order;

    public Table(int maxSeats, int seatsOccupied) {
        this.tableNum = TABLE_NUM;
        this.maxSeats = maxSeats;
        this.seatsOccupied = seatsOccupied;
        TABLE_NUM++;
    }


}
