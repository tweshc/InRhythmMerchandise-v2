/*
 * 
 */
package com.inrhythm.domain;

import javax.persistence.*;

/**
 * The Class Product.
 */
@Entity
public class Product {
	
	/** The id. */
	@Id
	private Integer id;
	
	/** The name. */
	private String name;
	
	/** The is electronic. */
	private Boolean isElectronic;
	
	/** The price. */
	private Float price;
	
	/**
	 * Instantiates a new product.
	 */
	public Product() {
		super();
	}
	
	/**
	 * Instantiates a new product.
	 *
	 * @param id the id
	 * @param name the name
	 * @param isElectronic the is electronic
	 * @param price the price
	 */
	public Product(Integer id, String name, Boolean isElectronic, Float price) {
		super();
		this.id = id;
		this.name = name;
		this.isElectronic = isElectronic;
		this.price = price;
	}
	
	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	
	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	
	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Gets the checks if is electronic.
	 *
	 * @return the checks if is electronic
	 */
	public Boolean getIsElectronic() {
		return isElectronic;
	}
	
	/**
	 * Sets the checks if is electronic.
	 *
	 * @param isElectronic the new checks if is electronic
	 */
	public void setIsElectronic(Boolean isElectronic) {
		this.isElectronic = isElectronic;
	}
	
	/**
	 * Gets the price.
	 *
	 * @return the price
	 */
	public Float getPrice() {
		return price;
	}
	
	/**
	 * Sets the price.
	 *
	 * @param price the new price
	 */
	public void setPrice(Float price) {
		this.price = price;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", isElectronic=" + isElectronic + ", price=" + price + "]";
	}
	

}
