package RestaurantActivities.src;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Restaurant {
    private static Menu menu;
    private static Table[] tables;

    public static void main(String[] args) {

    }

    public void config() throws IOException {
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
        for (int i = 0; i < numItems; i++) {

        }
    }

}
