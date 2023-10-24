package com.kh.MVC.shopping;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserPay {
	String url = "jdbc:oracle:thin:@localhost:1521:XE";
	String user = "khbank";
	String password = "1234";
	
	ShoppingCart cart;
	
	public UserPay(ShoppingCart cart) {
		this.cart = cart;
	}
	
	public boolean payment() {
		Connection connection = null;
		double cartTotalPrice = cart.cartTotalPrice();
		
		try {
			connection = DriverManager.getConnection(url, user, password);
			//가나다씨의 계좌 잔액 가져오기
			String userBalance = "SELECT BALANCE FROM BANK WHERE ACCOUNT_NAME = '가나다'";
			PreparedStatement st = connection.prepareStatement(userBalance);
			ResultSet result = st.executeQuery();
			
			if(result.next()) {
				double balance = result.getDouble("BALANCE");
				//내가 가지고있는 잔액에서 장바구니 총액을 빼줘야 함.
				double newBalance = balance - cartTotalPrice;
				//잔액이 장바구니 총액보다 적다면
				if(balance < cartTotalPrice) {
					System.out.println("잔액이 부족합니다.");
					return false;
				}
				//잔액 업데이트하기
				String updateBalance = "UPDATE BANK SET BALANCE = ? WHERE ACCOUNT_NAME = '가나다'";
				PreparedStatement upst = connection.prepareStatement(updateBalance);
				upst.setDouble(1, newBalance);
				upst.executeUpdate();
				
				System.out.println("결제 완료! 남은 잔액 : " + newBalance);
				return true;
			}else {
				System.out.println("계좌를 찾을 수 없습니다.");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}
}
