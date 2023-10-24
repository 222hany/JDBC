package com.kh.MVC.shopping;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ShoppingDAO {
	//DB¿¬°á
	private Connection connection;
	String jdbcurl = "jdbc:oracle:thin:@localhost:1521:XE";
	String dbUser = "kh_cafe";
	String dbPassword = "1234";
	
	public ShoppingDAO() {
		try {
			connection = DriverManager.getConnection(jdbcurl, dbUser, dbPassword);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	//¼¿·º¹®
	public List<ShoppingDTO> getAllProducts(){
		List<ShoppingDTO> products = new ArrayList<>();
		try {
			PreparedStatement st = connection.prepareStatement("SELECT * FROM PRODUCTS");
			ResultSet result = st.executeQuery();
			
			while(result.next()) {
				int productId = result.getInt("PRODUCT_ID");
				String productName = result.getNString("PRODUCT_NAME");
				String category = result.getNString("CATEGORY");
				double price = result.getDouble("PRICE");
				int stockQuantity = result.getInt("STOCK_QUANTITY");
				
				ShoppingDTO product = new ShoppingDTO(productId, productName, category, price, stockQuantity);
				products.add(product);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}return products;
	}
	
}
