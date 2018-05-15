package com.inrhythm.domain;

import javax.persistence.*;

@Entity
public class Product {
	@Id
	private Integer id;
	private String name;
	private Boolean isElectronic;
	private Float price;
	
	public Product() {
		super();
	}
	
	public Product(Integer id, String name, Boolean isElectronic, Float price) {
		super();
		this.id = id;
		this.name = name;
		this.isElectronic = isElectronic;
		this.price = price;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Boolean getIsElectronic() {
		return isElectronic;
	}
	public void setIsElectronic(Boolean isElectronic) {
		this.isElectronic = isElectronic;
	}
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", isElectronic=" + isElectronic + ", price=" + price + "]";
	}
	

}
