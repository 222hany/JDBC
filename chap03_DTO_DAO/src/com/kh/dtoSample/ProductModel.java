package com.kh.dtoSample;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductModel {
	private Connection connection;
	
	public ProductModel(Connection connection) { // 생성자
		this.connection = connection;
	}
	
	public List<ProductsDTO> getProducts(){
		List<ProductsDTO> products = new ArrayList<>();
		String query = "SELECT * FROM products";
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ResultSet result = ps.executeQuery();
			while(result.next()) {
				ProductsDTO product = new ProductsDTO();
				product.setProductID(result.getInt("PRODUCT_ID"));
				product.setProductName(result.getString("PRODUCT_NAME"));
				product.setCategory(result.getString("CATEGORY"));
				product.setPrice(result.getDouble("PRICE"));
				product.setQuantity(result.getInt("STOCK_QUANTITY"));
				products.add(product);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return products;	
	}
}