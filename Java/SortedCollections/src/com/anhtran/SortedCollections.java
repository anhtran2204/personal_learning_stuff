package com.anhtran;

import java.util.Map;

public class SortedCollections {
	private static StockList stockList = new StockList();

	public static void main(String[] args) {
		StockItem temp = new StockItem("Bread", 0.86, 100);
		stockList.addStock(temp);
		
		temp = new StockItem("Cake", 1.10, 7);
		stockList.addStock(temp);
		
		temp = new StockItem("Car", 12.50, 2);
		stockList.addStock(temp);

		temp = new StockItem("Chair", 62.0, 10);
		stockList.addStock(temp);
		
		temp = new StockItem("Cup", 0.5, 200);
		stockList.addStock(temp);
		
		temp = new StockItem("Cup", 0.45, 7);
		stockList.addStock(temp);
		
		temp = new StockItem("Sneakers", 8.45, 50);
		stockList.addStock(temp);
		
		temp = new StockItem("Door", 72.95, 4);
		stockList.addStock(temp);
		
		temp = new StockItem("Juice", 2.50, 36);
		stockList.addStock(temp);
		
		temp = new StockItem("Phone", 96.99, 35);
		stockList.addStock(temp);
		
		temp = new StockItem("Towel", 2.40, 80);
		stockList.addStock(temp);
		
		temp = new StockItem("Vase", 8.76, 40);
		stockList.addStock(temp);
		
		System.out.println(stockList);
		
		for (String s : stockList.Items().keySet()) {
			System.out.println(s);
		}
		
		Basket anhsBasket = new Basket("Anh");
		
		sellItem(anhsBasket, "Car", 1);
		System.out.println(anhsBasket);
		
		sellItem(anhsBasket, "Car", 1);
		System.out.println(anhsBasket);
		
		if (sellItem(anhsBasket, "Car", 1) != 1) {
			System.out.println("There are no more cars in stock!");
		}
		
		sellItem(anhsBasket, "Spanner", 5);
//		System.out.println(anhsBasket);
		
		sellItem(anhsBasket, "Juice", 4);
		sellItem(anhsBasket, "Cup", 12); 
		sellItem(anhsBasket, "Bread", 1);
//		System.out.println(anhsBasket);
		
		Basket basket = new Basket("Customer");
		sellItem(basket, "Cup", 100);
		sellItem(basket, "Juice", 5);
		removeItem(basket, "Cup", 1);
		System.out.println(basket);
		
		removeItem(anhsBasket, "Car", 1);
		removeItem(anhsBasket, "Cup", 9);
		removeItem(anhsBasket, "Car", 1);
		System.out.println("Cars removed: " + removeItem(anhsBasket, "Car", 1)); // should not remove any
		
		System.out.println(anhsBasket);
		// remove all items from anhsBasket
		removeItem(anhsBasket, "Bread", 1);
		removeItem(anhsBasket, "Cup", 3);
		removeItem(anhsBasket, "Juice", 4);
		removeItem(anhsBasket, "Cup", 3);
		System.out.println(anhsBasket);
		
		System.out.println("\nDisplay stock list before and after checkout");
		System.out.println(basket);
		System.out.println(stockList);
		checkOut(basket);
		System.out.println(basket);;
		System.out.println(stockList);
		
		
//		temp = new StockItem("Pen", 1.12);
//		stockList.Items().put(temp.getName(), temp);
		
		StockItem car = stockList.Items().get("Car");
		if (car != null) {
			car.adjustStock(2000);
		}
		
		if (car != null) {
			stockList.get("Car").adjustStock(-1000);
		}
		System.out.println(stockList);
		System.out.println();
		
//		for (Map.Entry<String, Double> price : stockList.PriceList().entrySet()) {
//			System.out.println(price.getKey() + " costs " + price.getValue());
//		}
		
		checkOut(anhsBasket);
		System.out.println(anhsBasket);
		
	}

	public static int sellItem(Basket basket, String item, int quantity) {
		// retrieve the item from stock list
		StockItem stockItem = stockList.get(item);
		if (stockItem == null ) {
			System.out.println("We don't sell " + item);
			return 0;
		}
		
		if (stockList.reserveStock(item, quantity) != 0) {
			return basket.addToBasket(stockItem, quantity);
		}
		return 0;
	}
	
	public static int removeItem(Basket basket, String item, int quantity) {
		// retrieve the item from stock list
		StockItem stockItem = stockList.get(item);
		if (stockItem == null) {
			System.out.println("We don't sell " + item);
			return 0;
		}
		
		if (basket.removeFromBasket(stockItem, quantity) == quantity) {
			return stockList.unreserveStock(item, quantity);
		}
		return 0;
	}
	
	public static void checkOut(Basket basket) {
		for (Map.Entry<StockItem, Integer> item : basket.Items().entrySet()) {
			stockList.sellStock(item.getKey().getName(), item.getValue());
		}
		basket.clearBasket();
	}
}
