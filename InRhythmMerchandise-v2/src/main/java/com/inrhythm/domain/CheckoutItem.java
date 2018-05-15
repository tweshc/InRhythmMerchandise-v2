package com.inrhythm.domain;

import java.util.Optional;

public class CheckoutItem {

	private Product product;
	private int quantity;
	
	public CheckoutItem() {
		super();
	}
	
	public CheckoutItem(Product product, int quantity) {
		super();
		this.product = product;
		this.quantity = quantity;
	}

	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	@Override
	public String toString() {
		return "CheckoutItem [product=" + product + ", quantity=" + quantity + "]";
	}
	
}
