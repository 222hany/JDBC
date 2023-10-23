package com.kh.MVC.Singleton.Product;
 // ProductsDTO : 데이터 전송 객체
public class ProductDTO {
	private int product_id;
	private String productName;
	private String category;
	private double price;
	private int stock_quantity;
	
	
	//생성자
	public ProductDTO() {
		
	}
	
	//파라미터를 추가한 생성자
	public ProductDTO(String category, int productId) { // INSERT는 (int productId, String productName, String category, double price, int stockQuantity)
		this.product_id = productId;
		// this.productName = productName;
		this.category = category;
		// this.price = price;
		// this.stock_quantity = stock_quantity;
	}

	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
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
	public int getStock_quantity() {
		return stock_quantity;
	}
	public void setStock_quantity(int stock_quantity) {
		this.stock_quantity = stock_quantity;
	}
	
	
}