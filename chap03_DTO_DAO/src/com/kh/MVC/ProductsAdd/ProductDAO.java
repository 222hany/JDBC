package com.kh.MVC.ProductsAdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {
	private Connection connection;
	
	String url = "jdbc:oracle:thin:@localhost:1521:XE";
	String user = "kh_cafe";
	String password = "1234";
	
	public ProductDAO() {
		try {
			connection = DriverManager.getConnection(url, user, password);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<ProductDTO> getAllProducts(){
		List<ProductDTO> products = new ArrayList<>();
		try {
			PreparedStatement st = connection.prepareStatement("SELECT * FROM PRODUCTS");
			ResultSet result = st.executeQuery();
			
			while(result.next()) {
				int productId = result.getInt("PRODUCT_ID");
				String productName = result.getString("PRODUCT_NAME");
				String category = result.getNString("CATEGORY");
				double price = result.getDouble("PRICE");
				int stockQuantity =  result.getInt("STOCK_QUANTITY");
				
				ProductDTO product = new ProductDTO(productId, productName, category, price, stockQuantity);
				products.add(product);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return products;
	}
	
}
