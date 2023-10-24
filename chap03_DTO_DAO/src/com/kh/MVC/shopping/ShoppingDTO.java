package com.kh.MVC.shopping;

public class ShoppingDTO {
	//멤버변수
	private int productId;
	private String productName;
	private String category;
	private double price;
	private int stockQuantity;
	//생성자
	public ShoppingDTO(int productId, String productName, String category, double price, int stockQuantity) {
		this.productId = productId;
		this.productName = productName;
		this.category = category;
		this.price = price;
		this.stockQuantity = stockQuantity;
	}
	//세터
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public void setStockQuantity(int stockQuantity) {
		this.stockQuantity = stockQuantity;
	}
	//게터
	public int getProductId() {
		return productId;
	}
	public String getProductName() {
		return productName;
	}
	public String getCategory() {
		return category;
	}
	public double getPrice() {
		return price;
	}
	public int getStockQuantity() {
		return stockQuantity;
	}
}
