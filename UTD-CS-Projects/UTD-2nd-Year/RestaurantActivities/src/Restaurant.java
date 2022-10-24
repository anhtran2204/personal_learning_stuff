package RestaurantActivities.src;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Restaurant {
    private static Menu menu;
    private static Table[] tables;

    public static void main(String[] args) throws IOException {
        config();
//        MenuItem item = new MenuItem("A1", "Wagyu Beef", 5.0);
//        System.out.println(item);
        for (Table table : tables) {
            System.out.println(table);
        }
        System.out.println(menu);
    }

    public static void config() throws IOException {
        Scanner s = new Scanner(new File("config.txt"));

        int numTables = Integer.parseInt(s.next());
        s.nextLine();
        for (int i = 0; i < numTables; i++) {
            int tableNum = Integer.parseInt(s.next());
            int maxSeats = Integer.parseInt(s.next());
            Table table = new Table(tableNum, maxSeats);
        }

        s.nextLine();

        int numItems = Integer.parseInt(s.next());
        s.nextLine();
        menu = new Menu(numItems);
        for (int i = 0; i < numItems; i++) {
            String itemCode = s.next();
            String itemName = s.next();
            double itemPrice = Double.parseDouble(s.next());
            MenuItem newItem = new MenuItem(itemCode, itemName, itemPrice);
            menu.addItem(i, newItem);
        }
    }

}
