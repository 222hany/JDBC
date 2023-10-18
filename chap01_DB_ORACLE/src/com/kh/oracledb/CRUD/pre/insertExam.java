package com.kh.oracledb.CRUD.pre;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class insertExam {
	static void insertCafes(PreparedStatement preparedStatement, int C_ID, String C_NAME, String ADDRESS, String PHONE_NUMBER, String OPERATING_HOURS) throws SQLException{
		preparedStatement.setInt(1, C_ID);
		preparedStatement.setString(2, C_NAME);
		preparedStatement.setString(3, ADDRESS);
		preparedStatement.setString(4, PHONE_NUMBER);
		preparedStatement.setString(5, OPERATING_HOURS);
		preparedStatement.executeUpdate();
		int rowsInsert = preparedStatement.executeUpdate();
		System.out.println(rowsInsert + "���� �߰���.");
	}

	public static void main(String[] args) {
		// cafes insert �ۼ��ؼ� ���� ī�� �߰��ϱ�
		String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:XE";
		String userName = "kh_cafe";
		String password = "1234";
		
		try{
			Connection con = DriverManager.getConnection(jdbcUrl, userName, password);
			
			String insertSQL = "INSERT INTO CAFES(C_ID, C_NAME, ADDRESS, PHONE_NUMBER, OPERATING_HOURS)"
							 + "VALUES (?,?,?,?,?)";
			PreparedStatement preparedStatement = con.prepareStatement(insertSQL);
			
			insertCafes(preparedStatement, 21, "�̽���ٹ�", "����� ������ �̽��赿 1����", "02-444-7777", "��-��: 08:30-19:30, �ָ�: 09:00-18:00");
			
			preparedStatement.close();
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
