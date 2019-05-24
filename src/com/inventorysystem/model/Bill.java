package com.inventorysystem.model;

import java.sql.Date;
import java.util.List;

public class Bill {
	private int billNo;
	
	private int cashierId;
	private String customerName;
	private Date billingDate;
	private float billAmount;
	private List<Product> productList;//= new ArrayList<Product>();
	private float aDiscount;
	
	
	public int getCashierId() {
		return cashierId;
	}
	public void setCashierId(int cashierId) {
		this.cashierId = cashierId;
	}
	
	public int getBillNo() {
		return billNo;
	}
	public void setBillNo(int billNo) {
		this.billNo = billNo;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public Date getBillingDate() {
		return billingDate;
	}
	public void setBillingDate(Date billingDate) {
		this.billingDate = billingDate;
	}
	public float getBillAmount() {
		return billAmount;
	}
	public void setBillAmount(float billAmount) {
		this.billAmount = billAmount;
	}
	public List<Product> getProductList() {
		return productList;
	}
	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}
	public float getaDiscount() {
		return aDiscount;
	}
	public void setaDiscount(float aDiscount) {
		this.aDiscount = aDiscount;
	}
	

}
