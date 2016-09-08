package com.basket.vo;

import java.sql.Date;

public class BasketVo {
	private String productName;
	private String color;
	private int numbers;
	private int price;
	private Date buydate;
	
	public Date getBuydate() {
		return buydate;
	}
	public void setBuydate(Date buydate) {
		this.buydate = buydate;
	}
	
	public String getProductName() {
		return productName == null ? "" : productName.trim();
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getColor() {
		return color == null ? "" : color.trim();
	}
	public void setColor(String color) {
		this.color = color;
	}
	public int getNumbers() {
		return numbers;
	}
	public void setNumbers(int numbers) {
		this.numbers = numbers;
	}
	public long getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
}
