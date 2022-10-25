package RestaurantActivities.src;

public class Table {
    private enum TableStatus {
        OPEN,
        SEATED,
        ORDERED,
        SERVED
    }
    private int tableNum;
    private int maxSeats;
    private int seatsOccupied;
    private TableStatus status;

    public Table(int num, int maxSeats) {
        this.tableNum = num;
        this.maxSeats = maxSeats;
        status = TableStatus.OPEN;
    }

    public void assignCustomer(int seats) {
        if (seats <= maxSeats) {
            this.seatsOccupied = seats;
            System.out.println("Party of " + this.seatsOccupied + " assigned to Table " + this.tableNum);
        } else {
            System.out.println("Sorry, max " + maxSeats + " seats in Table " + tableNum + "!");
        }
    }

    public int getTableNum() {
        return tableNum;
    }

    public int getMaxSeats() {
        return maxSeats;
    }

    public int getSeatsOccupied() {
        return seatsOccupied;
    }

    public String getTableStatus() {
        return status.toString();
    }

    public void setTableStatus(int newStatus) {
        if (newStatus < TableStatus.values().length) {
            switch (newStatus) {
                case 0:
                    break;

                case 1:
                    status = TableStatus.SEATED;
                    break;

                case 2:
                    status = TableStatus.ORDERED;
                    break;

                case 3:
                    status = TableStatus.SERVED;
                    break;
            }
        }
    }
}
