package com.anhtran;

public class StockItem implements Comparable<StockItem> {
	private final String name;
	private double price;
	private int quantityStock;	// can be initialize later
	private int reserved = 0;
	
	public StockItem(String name, double price) {
		this.name = name;
		this.price = price;
		this.quantityStock = 0;	// or here (but you wouldn't normally do both)
	}

	public StockItem(String name, double price, int quantityStock) {
		this.name = name;
		this.price = price;
		this.quantityStock = quantityStock;
	}

	public String getName() {
		return name;
	}

	public double getPrice() {
		return price;
	}

	public int availableQuantity() {
		return quantityStock - reserved;
	}

	public void setPrice(double price) {
		if (price > 0.0) {
			this.price = price;		
		}
	}
	
	public void adjustStock(int quantity) {
		int newQuantity = this.quantityStock + quantity;
		if (newQuantity >= 0) {
			this.quantityStock = newQuantity;
		}
	}
	
	public int reserveStock(int quantity) {
		if (quantity <= availableQuantity()) { // use the method, not the field
			reserved += quantity;
			return quantity;
		}
		return 0;
	}
	
	public int unreserveStock(int quantity) {
		if (quantity <= reserved) {
			reserved -= quantity;
			return quantity;
		}
		return 0;
	}
	
	public int finalizeStock(int quantity) {
		if (quantity <= reserved) {
			quantityStock -= quantity;
			reserved -= quantity;
			return quantity;
		}
		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}
		
		if ((obj == null) || (obj.getClass() != this.getClass())) {
			return false;
		}
		
		String objName= ((StockItem) obj).getName();
		return this.name.equals(objName);
	}

	@Override
	public int hashCode() {
		return this.name.hashCode() + 31;
	}

	@Override
	public int compareTo(StockItem o) {
		if (this == o) {
			return 0;
		}
		
		if (o != null ) {
			return this.name.compareTo(o.getName());
		}
		
		throw new NullPointerException();
	}

	@Override
	public String toString() {
		return this.name + ": price " + this.price + ". Reserved: " + this.reserved;
	}
	
}
