package com.coffeebreak;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class OrderTest {

	@Test
	@DisplayName("Deve criar um pedido e adicionar 3 itens")
	public void createOrderAndAddItens() throws OrderException {
		Order order = new Order("011.157.739-09");
		order.addItem(new OrderItem(new Item("Café expresso", 18.50), 1));
		order.addItem(new OrderItem(new Item("Danut's morango", 3.90), 4));
		order.addItem(new OrderItem(new Item("Torta de frango", 7.30), 1));
		assertEquals(6, order.getCart());
	}

	@Test
	@DisplayName("Deve criar com cupom de desconto")
	public void createOrderAndapplyCoupon() throws OrderException {
		Order order = new Order("011.157.739-09");
		order.addItem(new OrderItem(new Item("Café expresso", 18.50), 1));
		order.addItem(new OrderItem(new Item("Danut's morango", 3.90), 4));
		order.addItem(new OrderItem(new Item("Torta de frango", 7.30), 1));
		order.applyCoupon(new Coupon("VALE10", 10));
		assertEquals(41.40, order.getTotalItems());
		assertEquals(37.26, order.getTotalItemsWithDiscount());
	}
	
	@Test
	@DisplayName("Não deve criar um pedido com Cpf inválido")
	public void isValidCpf() {
		Exception exception = assertThrows(OrderException.class, () -> {
			new Order("011.157.739-0002");
		});
		String expectedMessagem = "Invalid CPF";
		String actualMessagem = exception.getMessage();
		assertTrue(actualMessagem.contains(expectedMessagem));
	}	
}
