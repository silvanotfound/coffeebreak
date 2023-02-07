package com.coffeebreak;

import java.util.ArrayList;
import java.util.List;

public class Order {
	private List<OrderItem> orderItems = new ArrayList<OrderItem>();
	private int cart;
	private Coupon coupon;

	Order(String cpf) throws OrderException{
		if(!new ValidateCpf().validate(cpf)) {
			throw new OrderException("Invalid CPF");
		}
	}
	
	public void addItem(OrderItem orderItem) {
		this.orderItems.add(orderItem);
	}

	public int getCart() {
		this.orderItems.forEach(orderitem -> {
			this.cart += orderitem.getQuantity();
		});
		return this.cart;
	}

	public void applyCoupon(Coupon coupon) {
		this.coupon = coupon;
	}

	public Double getTotalItems() {
		return this.calculateItems();
	}

	public Double getTotalItemsWithDiscount() {
		Double totalItem = this.calculateItems();
		return this.calculateDiscount(totalItem);
	}

	private Double calculateDiscount(Double value) {
		if (coupon != null) {
			value -= ((value * this.coupon.getPercent()) / 100);
		}
		return value;
	}

	private Double calculateItems() {
		Double total = 0.0;
		for (OrderItem orderitem : this.orderItems) {
			total += orderitem.getTotal();
		}
		return total;
	}	
}
