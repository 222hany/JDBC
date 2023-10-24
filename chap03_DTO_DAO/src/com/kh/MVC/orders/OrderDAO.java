package com.kh.MVC.orders;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderDAO {
	//DB연결
	private Connection connection;
	String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:XE";
	String dbUserName = "kh_cafe";
	String dbPassword = "1234";
	
	public OrderDAO() {
		try {
			connection = DriverManager.getConnection(jdbcUrl, dbUserName, dbPassword);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	//select문 작성
	public List<OrderDTO> shoppingCart(){
		List<OrderDTO> orders = new ArrayList<>();
		try {
			PreparedStatement st = connection.prepareStatement("SELECT * FROM PRODUCTS WHERE PRODUCT_ID = ?");
			int targetPID = 4;
			st.setInt(1, targetPID);
			ResultSet result = st.executeQuery();
			
			if(result.next()) {
				int productId = result.getInt("PRODUCT_ID");
				String productName = result.getNString("PRODUCT_NAME");
				String category = result.getNString("CATEGORY");
				double price = result.getDouble("PRICE");
				int stockQuantity = result.getInt("STOCK_QUANTITY");
				
				OrderDTO order = new OrderDTO(productId, productName, category, price, stockQuantity);
				orders.add(order);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return orders;
	}
}
