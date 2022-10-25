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
        String option = s.next();
        String[] inputs = option.split(" ");

        switch (inputs[0]) {
            case "P":
                Table table = getTable(Integer.parseInt(tableNum));
                table.assignCustomer(Integer.parseInt(inputs[1]));
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
        for (int i = 0; i < tables.length; i++) {
            Table table = tables[i];
            if (table.getTableNum() == tableNum && !table.isOccupied()) {
                return true;
            }
        }
        return false;
    }

    public static Table getTable(int tableNum) {
        Table table = null;
        for (Table value : tables) {
            if (tableAvailable(tableNum)) {
                table = value;
            }
        }
        return table;
    }
}
