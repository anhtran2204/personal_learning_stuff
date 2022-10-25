package RestaurantActivities.src;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Restaurant {
    private static Menu menu;
    private static Table[] tables;

    public static void main(String[] args) throws IOException {
        config();

        Scanner s = new Scanner(System.in);

        String tableNum = s.next();
        if (!tableNum.equals("C")) {
            System.out.println("Table num: " + tableNum);
            String option = s.next();
            if (option.matches("P*\\d")) {
                String seats = option.substring(1);
                System.out.println("Seats: " + seats);
                Table table = getTable(Integer.parseInt(tableNum));
                table.assignCustomer(Integer.parseInt(seats));
            }

            if (option.equals("O")) {
                System.out.println("hello");
            }

            if (option.equals("S")) {
                System.out.println("hello");
            }

            if (option.equals("C")) {
                System.out.println("hello");
            }
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
}
