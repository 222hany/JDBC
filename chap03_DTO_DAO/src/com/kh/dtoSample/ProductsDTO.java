package com.kh.dtoSample;
 // ProductsDTO : 데이터 전송 객체
public class ProductsDTO {
	private int productID;
	private String productName;
	private String category;
	private double price;
	private int quantity;
	

	public ProductsDTO() {
	}
	
	
	public ProductsDTO(int productID, String productName, String category, double price, int quantity) {
		this.productID = productID;
		this.productName = productName;
		this.category = category;
		this.price = price;
		this.quantity = quantity;
	}
	
		
	
	public int getProductID() {
		return productID;
	}

	public void setProductID(int productID) {
		this.productID = productID;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	@Override
	public String toString() {
		return "ProductsDTO";
	}
	
}