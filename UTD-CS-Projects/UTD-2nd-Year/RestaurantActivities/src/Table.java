package RestaurantActivities.src;

public class Table {
    private int tableNum;
    private boolean occupied = false;
    private int maxSeats;
    private int seatsOccupied;
    private boolean ordered = false;
    private Order order;

    public Table(int num, int maxSeats) {
        this.tableNum = num;
        this.maxSeats = maxSeats;
    }

    public void assignCustomer(int seats) {
        if (seatsOccupied < maxSeats) {
            this.seatsOccupied = seats;
            System.out.println("Party of " + this.seatsOccupied + " assigned to Table " + this.tableNum);
        } else {
            System.out.println("Sorry, max " + maxSeats + " seats in Table " + tableNum + " !");
        }
    }

    public int getTableNum() {
        return tableNum;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public int getMaxSeats() {
        return maxSeats;
    }

    public int getSeatsOccupied() {
        return seatsOccupied;
    }

    public boolean isOrdered() {
        return ordered;
    }

    @Override
    public String toString() {
        return tableNum + " " + maxSeats;
    }
}
