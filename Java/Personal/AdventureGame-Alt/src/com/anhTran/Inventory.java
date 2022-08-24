package com.anhTran;

import java.util.HashMap;
import java.util.Map;

public class Inventory {

	public enum ItemType {
		MELEE,
		GUN,
		GRENADE,
		FIRST_AID
	}

	private Map<String, Item> inventory;

	public Inventory() {
		this.inventory = new HashMap<>();
	}

	public boolean addToInventory(String newItem) {
		for (Map.Entry<String, Item> item : inventory.entrySet()) {
			if (item.getKey().equals(newItem)) {
				inventory.put(newItem, new Item(newItem));
				item.getValue().quantityInStock ++;
				return true;
			}
		}
		return false;
	}

	public boolean containsItem(String item) {
		for (Map.Entry<String, Item> check : inventory.entrySet()) {
			if (check.getKey().equals(item)) {
				return true;
			}
		}
		return false;
	}

	public static class Item implements Comparable<Item> {
		private final String name;
		private int quantityInStock;

		public Item(String name) {
			this.name = name;
			this.quantityInStock = 0;
		}

		public String getName() {
			return name;
		}

		public int getQuantity() {
			return quantityInStock;
		}

		public void adjustQuantity(int quantity) {
			int newQuantiy = quantityInStock - quantity;
			if (newQuantiy >= 0) {
				this.quantityInStock = newQuantiy;
			} else {
				System.out.println("Insufficient Amount!");
			}
		}

		@Override
		public boolean equals(Object obj) {
			if (obj == this) {
				return true;
			}

			if ((obj == null) || (obj.getClass() != this.getClass())) {
				return false;
			}

			String objName= ((Item) obj).getName();
			return this.name.equals(objName);
		}

		@Override
		public int hashCode() {
			return this.name.hashCode() + 24;
		}

		@Override
		public int compareTo(Item o) {
			if (this == o) {
				return 0;
			}

			if (o != null) {
				return this.name.compareTo(o.getName());
			}

			throw new NullPointerException();
		}

		@Override
		public String toString() {
			return this.name.toUpperCase() + ", Quantity: " + this.quantityInStock;
		}
	}
}
