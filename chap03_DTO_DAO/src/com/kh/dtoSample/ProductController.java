package com.kh.dtoSample;

import java.sql.Connection;
import java.util.List;

public class ProductController {
	private ProductModel model;
	private ProductView view;
	
	public ProductController(Connection con, ProductView view) {
		this.model = new ProductModel(con);
		this.view = view;
	}
	
	public void displayAllGoods() {
		List<ProductsDTO> products = model.getProducts();
		view.displayProducts(products);
	}
}