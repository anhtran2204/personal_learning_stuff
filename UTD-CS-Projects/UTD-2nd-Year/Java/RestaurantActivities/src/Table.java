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
    private Order order;

    public Table(int num, int maxSeats) {
        this.tableNum = num;
        this.maxSeats = maxSeats;
        status = TableStatus.OPEN;
    }

    public boolean assignCustomer(int seats) {
        if (seats <= maxSeats) {
            this.seatsOccupied = seats;
            System.out.printf("Party of %s assigned to Table %d%n", getSeatsOccupied(), getTableNum());
            return true;
        } else {
            System.out.printf("Sorry, max %s seats in Table %d!%n", getMaxSeats(), getTableNum());
            return false;
        }
    }

    public void setSeatsOccupied(int seatsOccupied) {
        this.seatsOccupied = seatsOccupied;
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
                    status = TableStatus.OPEN;
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

    public Order getOrder() {
        return this.order;
    }


    public void addOrder(Menu menu, String[] newOrder, int tableNum) {
        if (order == null) {
            this.order = new Order(menu, newOrder, tableNum);

            int orders = 0;
            for (String s : newOrder) {
                if (!menu.contains(s)) {
                    System.out.printf("No item with code %s%n", s);
                } else {
                    order.addItem(orders, new MenuItem(s, menu.getItem(s).getName(), menu.getItem(s).getPrice()));
                    orders++;
                }
            }
            System.out.printf("%d items ordered for Table %s%n", orders, tableNum);
        } else {
            MenuItem[] checks = menu.getItems();

            int size1 = 0;
            for (String s : newOrder) {
                if (menu.contains(s)) {
                    size1++;
                }
            }

            MenuItem[] newOrders = new MenuItem[size1];
            for (MenuItem menuItem : checks) {
                for (int j = 0; j < size1; j++) {
                    if (newOrder[j].equals(menuItem.getItemCode())) {
                        newOrders[j] = menuItem;
                    }
                }
            }

            int size2 = newOrder.length - size1;
            MenuItem[] none = new MenuItem[size2];
            for (MenuItem check : checks) {
                for (int j = 0; j < size2; j++) {
                    if (!menu.contains(newOrder[j])) {
                        none[j] = check;
                    }
                }
            }

            for (MenuItem notExist : none) {
                System.out.printf("No item with code %s", notExist.getItemCode());
            }
            order.setOrders(newOrders);
        }

    }

    @Override
    public String toString() {
        return "Table{" +
                "tableNum=" + tableNum +
                ", maxSeats=" + maxSeats +
                ", seatsOccupied=" + seatsOccupied +
                '}';
    }
}
