package com.kh.userVODAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Bank {

	public static void main(String[] args) {
		String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:XE";
		String dbUserName = "khbank";
		String dbPassword = "1234";
	
		try {
			Connection connection = DriverManager.getConnection(jdbcUrl, dbUserName, dbPassword);
			Scanner sc = new Scanner(System.in);
			
			System.out.println("전송할 ID를 입력하세요.");
			int fromAccountId = sc.nextInt();
			
			System.out.println("전송받을 ID를 입력하세요.");
			int toAccountId = sc.nextInt();
			
			System.out.println("전송할 금액을 입력하세요.");
			double amount = sc.nextDouble();
			
			PreparedStatement a = connection.prepareStatement("UPDATE BANK SET BALANCE = BALANCE - ? WHERE ACCOUNT_ID = ?");
			a.setDouble(1, amount);
			a.setInt(2, fromAccountId);
			a.executeUpdate();
			
			System.out.println(fromAccountId + "로 부터 " + toAccountId + "에게 " + amount + "원 송금되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
