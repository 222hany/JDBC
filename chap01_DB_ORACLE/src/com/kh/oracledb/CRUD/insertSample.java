package com.kh.oracledb.CRUD;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class insertSample {

	public static void main(String[] args) {
		//insertAll();
		insertOne();
	}

	static void insertAll() {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "khbank";
		String password = "1234";
		
		try {
			Connection con = DriverManager.getConnection(url, user, password);
			String insertQuery = "INSERT INTO BANK (account_id, account_number, account_name, balance, branch_name, last_transaction_date)"
							   + "VALUES (?,?,?,?,?,?)";
			PreparedStatement insertState = con.prepareStatement(insertQuery);
			
			insertState.setInt(1, 13);
			insertState.setString(2, "9876543219");
			insertState.setString(3, "�����");
			insertState.setDouble(4, 1500.00);
			insertState.setString(5, "kh");
			insertState.setDate(6, Date.valueOf("2023-10-16"));
			
			insertState.setInt(1, 12);
			insertState.setString(2, "5453216585");
			insertState.setString(3, "��īŸ");
			insertState.setDouble(4, 9500.50);
			insertState.setString(5, "��������");
			insertState.setDate(6, Date.valueOf("2023-10-04"));
			
			int rowsInsert = insertState.executeUpdate();
			System.out.println(rowsInsert + "row �߰� ��");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	static void insertOne() {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "kh_cafe";
		String password = "1234";
		
		try {
			Connection con = DriverManager.getConnection(url, user, password);
			//insert�� �ۼ��ϱ�
			String insertQuery = "INSERT INTO BOOK(BOOK_ID, TITLE, AUTHOR, PUBLICATION_YEAR, ISBN, GENRE, DESCRIPTION, PRICE, PUBLICATION_DATE, CREATED_DATE, UPDATED_DATE, IS_AVAILABLE)"
							   + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement insertState = con.prepareStatement(insertQuery);
			
			insertState.setInt(1, 21);
			insertState.setString(2, "��մ� å");
			insertState.setString(3, "��մ� �۰�");
			insertState.setInt(4, 2020);
			insertState.setString(5, "985-8930205551");
			insertState.setString(6, "Novel");
			insertState.setString(7, "�� ����� ��մ� �λ� �̾߱�");
			insertState.setDouble(8, 20.99);
			insertState.setDate(9, Date.valueOf("2020-08-09"));
			insertState.setDate(10, Date.valueOf("2023-08-11"));
			insertState.setDate(11, Date.valueOf("2023-10-18"));
			insertState.setString(12, "Y");
			
			insertState.setInt(1, 22);
			insertState.setString(2, "��̾��� å");
			insertState.setString(3, "��̾��� �۰�");
			insertState.setInt(4, 2020);
			insertState.setString(5, "984-8930205551");
			insertState.setString(6, "Novel");
			insertState.setString(7, "�� ����� ��̾��� �λ� �̾߱�");
			insertState.setDouble(8, 20.99);
			insertState.setDate(9, Date.valueOf("2020-08-09"));
			insertState.setDate(10, Date.valueOf("2023-08-11"));
			insertState.setDate(11, Date.valueOf("2023-10-18"));
			insertState.setString(12, "Y");
			
			insertState.setInt(1, 23);
			insertState.setString(2, "������ å");
			insertState.setString(3, "������ �۰�");
			insertState.setInt(4, 2020);
			insertState.setString(5, "977-8930205551");
			insertState.setString(6, "Novel");
			insertState.setString(7, "�� ����� ������ �λ� �̾߱�");
			insertState.setDouble(8, 20.99);
			insertState.setDate(9, Date.valueOf("2020-08-09"));
			insertState.setDate(10, Date.valueOf("2023-08-11"));
			insertState.setDate(11, null);
			insertState.setString(12, "N");
			
			int rowsInsert = insertState.executeUpdate();
			System.out.println(rowsInsert + " �� �߰���.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}