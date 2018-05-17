/*
 * 
 */
package com.inrhythm.domain;

/**
 * The Class CheckoutItem.
 */
public class CheckoutItem {

	/** The product. */
	private Product product;
	
	/** The quantity. */
	private int quantity;
	
	/**
	 * Instantiates a new checkout item.
	 */
	public CheckoutItem() {
		super();
	}
	
	/**
	 * Instantiates a new checkout item.
	 *
	 * @param product the product
	 * @param quantity the quantity
	 */
	public CheckoutItem(Product product, int quantity) {
		super();
		this.product = product;
		this.quantity = quantity;
	}

	/**
	 * Gets the product.
	 *
	 * @return the product
	 */
	public Product getProduct() {
		return product;
	}
	
	/**
	 * Sets the product.
	 *
	 * @param product the new product
	 */
	public void setProduct(Product product) {
		this.product = product;
	}
	
	/**
	 * Gets the quantity.
	 *
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}
	
	/**
	 * Sets the quantity.
	 *
	 * @param quantity the new quantity
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CheckoutItem [product=" + product + ", quantity=" + quantity + "]";
	}
	
}
