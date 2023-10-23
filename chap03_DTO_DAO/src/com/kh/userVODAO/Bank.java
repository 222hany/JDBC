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
			
			System.out.println("������ ID�� �Է��ϼ���.");
			int fromAccountId = sc.nextInt();
			
			System.out.println("���۹��� ID�� �Է��ϼ���.");
			int toAccountId = sc.nextInt();
			
			System.out.println("������ �ݾ��� �Է��ϼ���.");
			double amount = sc.nextDouble();
			
			PreparedStatement a = connection.prepareStatement("UPDATE BANK SET BALANCE = BALANCE - ? WHERE ACCOUNT_ID = ?");
			a.setDouble(1, amount);
			a.setInt(2, fromAccountId);
			a.executeUpdate();
			
			System.out.println(fromAccountId + "�� ���� " + toAccountId + "���� " + amount + "�� �۱ݵǾ����ϴ�.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
