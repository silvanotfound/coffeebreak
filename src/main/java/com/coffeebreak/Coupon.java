package com.coffeebreak;

public class Coupon {
	private String name;
	private int percent;

	Coupon(String name, int percent) {
		this.name = name;
		this.percent = percent;
	}

	public String getName() {
		return name;
	}

	public int getPercent() {
		return percent;
	}
}
