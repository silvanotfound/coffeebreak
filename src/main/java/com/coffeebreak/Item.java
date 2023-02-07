package com.coffeebreak;

public class Item {
	private String description;
	private double price;

	Item(String description, double price) {
		this.description = description;
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public double getPrice() {
		return price;
	}
}
