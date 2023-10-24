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
			//�����پ��� ���� �ܾ� ��������
			String userBalance = "SELECT BALANCE FROM BANK WHERE ACCOUNT_NAME = '������'";
			PreparedStatement st = connection.prepareStatement(userBalance);
			ResultSet result = st.executeQuery();
			
			if(result.next()) {
				double balance = result.getDouble("BALANCE");
				//���� �������ִ� �ܾ׿��� ��ٱ��� �Ѿ��� ����� ��.
				double newBalance = balance - cartTotalPrice;
				//�ܾ��� ��ٱ��� �Ѿ׺��� ���ٸ�
				if(balance < cartTotalPrice) {
					System.out.println("�ܾ��� �����մϴ�.");
					return false;
				}
				//�ܾ� ������Ʈ�ϱ�
				String updateBalance = "UPDATE BANK SET BALANCE = ? WHERE ACCOUNT_NAME = '������'";
				PreparedStatement upst = connection.prepareStatement(updateBalance);
				upst.setDouble(1, newBalance);
				upst.executeUpdate();
				
				System.out.println("���� �Ϸ�! ���� �ܾ� : " + newBalance);
				return true;
			}else {
				System.out.println("���¸� ã�� �� �����ϴ�.");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}
}
