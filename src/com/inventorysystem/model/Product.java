package com.inventorysystem.model;

public class Product {
	private int id;
	private String Name;
	private float MRP;
	private int quantity;
	private float discount;
	
	
	public float getDiscount() {
		return discount;
	}
	public void setDiscount(float discount) {
		this.discount = discount;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public float getMRP() {
		return MRP;
	}
	public void setMRP(float mRP) {
		MRP = mRP;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int stocQuantity) {
		this.quantity = stocQuantity;
	}
	
	

}
