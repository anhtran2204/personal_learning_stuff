package RestaurantActivities.src;

import java.io.File;
import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;

public class Restaurant {
    private static Menu menu;
    private static Table[] tables;

    public static void main(String[] args) throws IOException {
        config();

        Scanner s = new Scanner(System.in);

        String tableNum = s.next();
        Table table;

        while (!tableNum.equalsIgnoreCase("C")) {
            String option = s.next();
            if (option.matches("P\\d+")) {
                String seats = option.substring(1);
                if (tableAvailable(Integer.parseInt(tableNum))) {
                    table = getTable(Integer.parseInt(tableNum));
                    if (table.assignCustomer(Integer.parseInt(seats))) {
                        table.setTableStatus(1);
                    }
                } else {
                    System.out.printf("Table %s already occupied!%n", tableNum);
                }
            }

            if (option.equalsIgnoreCase("O")) {
                String items = s.nextLine();
                items = items.substring(1);
                String[] order = items.split(" ");
                table = getTable(Integer.parseInt(tableNum));
                table.addOrder(menu, order, Integer.parseInt(tableNum));
                table.setTableStatus(2);
            }

            if (option.equalsIgnoreCase("S")) {
                table = getTable(Integer.parseInt(tableNum));
                if (table.getTableStatus().equals("ORDERED")) {
                    System.out.printf("Food served in table %s%n", tableNum);
                    table.setTableStatus(3);
                } else {
                    System.out.printf("Order not placed at Table %s yet!%n", tableNum);
                }
            }

            if (option.equalsIgnoreCase("C")) {
                table = getTable(Integer.parseInt(tableNum));
                if (table.getTableStatus().equals("SERVED")) {
                    System.out.printf("Table %s is closed. Here is the bill.%n", tableNum);
                    printReceipt(table);
                    table.setSeatsOccupied(0);
                    table.setTableStatus(0);
                } else {
                    System.out.printf("Food not served for Table %s yet!%n", tableNum);
                }
            }
            tableNum = s.next();
        }
    }

    public static void config() throws IOException {
        Scanner s = new Scanner(new File("config.txt"));

        int numTables = Integer.parseInt(s.next());
        tables = new Table[numTables];
        s.nextLine();
        for (int i = 0; i < numTables; i++) {
            int tableNum = Integer.parseInt(s.next());
            int maxSeats = Integer.parseInt(s.next());
            tables[i] = new Table(tableNum, maxSeats);
        }

        s.nextLine();

        int numItems = Integer.parseInt(s.next());
        s.nextLine();
        menu = new Menu(numItems);
        for (int i = 0; i < numItems; i++) {
            String itemCode = s.next();
            String itemName = s.next();
            double itemPrice = Double.parseDouble(s.next());
            menu.addItem(i, new MenuItem(itemCode, itemName, itemPrice));
        }
    }

    public static boolean tableAvailable(int tableNum) {
        for (Table table : tables) {
            if (table.getTableNum() == tableNum && table.getTableStatus().equals("OPEN")) {
                return true;
            }
        }
        return false;
    }

    public static Table getTable(int tableNum) {
        Table table = null;
        for (Table value : tables) {
            if (value.getTableNum() == tableNum) {
                table = value;
                break;
            }
        }
        return table;
    }

    public static void printReceipt(Table table) {
        System.out.printf("Receipt Table# %s Party %d%n", table.getTableNum(), table.getSeatsOccupied());
        MenuItem[] order = table.getOrder().getOrders();
        int padLength = table.getOrder().longestItemName();
        double total = 0;
        for (MenuItem menuItem : order) {
            System.out.printf("%1s %" + padLength + "s   %3.2f%n", menuItem.getItemCode(), menuItem.getName(), menuItem.getPrice());
            total += menuItem.getPrice();
        }
        padLength+=3;
        System.out.printf("%" + padLength + "s  %4.2f%n", "Total", total);
    }
}
