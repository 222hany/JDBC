package com.kh.dtoSample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ProductMain {

	public static void main(String[] args) {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String userName = "khcafe";
		String password = "khcafe";
		try {
			Connection con = DriverManager.getConnection(url, userName, password);
			ProductView view = new ProductView();
			ProductController controller = new ProductController(con, view);
			controller.displayAllGoods();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
	}

}