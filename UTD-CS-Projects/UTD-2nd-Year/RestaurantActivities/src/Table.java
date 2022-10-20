package RestaurantActivities.src;

public class Table {
    private boolean occupied = false;
    private int maxSeats;
    private int seatsOccupied;
    private boolean ordered = false;
    private Order order;

    public Table(int maxSeats, int seatsOccupied) {
        this.maxSeats = maxSeats;
        this.seatsOccupied = seatsOccupied;
    }


}
