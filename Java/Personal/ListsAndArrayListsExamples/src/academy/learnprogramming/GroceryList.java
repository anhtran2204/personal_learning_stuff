package academy.learnprogramming;

import java.util.ArrayList;

public class GroceryList {
    private ArrayList<String> groceryList = new ArrayList<String>();

    public void addGroceryItem(String item) {
        groceryList.add(item);
    }

    public ArrayList<String> getGroceryList() {
        return groceryList;
    }

    public void printGroceryList() {
        System.out.println("You have " + groceryList.size() + " items in your grocery list");
        for (int i = 0; i < groceryList.size(); i++) {
            System.out.println((i+1) + ". " + groceryList.get(i));
        }
    }

    public void modifyGroceryItem(String currentItem, String newItem) {
        int position = findItems(currentItem);
        if (position >= 0) {
            modifyGroceryItem(position, newItem);
        }
    }

    private void modifyGroceryItem(int position, String newItem) {
        groceryList.set(position, newItem);
        System.out.println("Grocery item " + (position + 1) + " has been modified.");
    }

    public void removeGroceryItems(String item) {
        int position = findItems(item);
        if (position >= 0) {
            removeGroceryItems(position);
        }
    }

    private void removeGroceryItems(int position) {
        groceryList.remove(position);
    }

    private int findItems(String searchItem) {
//        boolean exist = groceryList.contains(searchItem);
//        if (exist) {
//            return "The item found is: " + searchItem;
//        }
//        return "Nothing found.";
        return groceryList.indexOf(searchItem);
    }

    public boolean onFile(String searchItem) {
        int position = findItems(searchItem);
        if (position >= 0) {
            return true;
        } else {
            return false;
        }
    }
}
