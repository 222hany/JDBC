package com.kh.oracledb.CRUD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class deleteSample {

	public static void main(String[] args) {
		String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:XE";
		String user = "khbank";
		String password = "1234";
		
		try {
			Connection con = DriverManager.getConnection(jdbcUrl, user, password);
			String deleteQuery = "DELETE FROM BANK WHERE ACCOUNT_ID = ?";
			PreparedStatement deletePs = con.prepareStatement(deleteQuery);
			deletePs.setDouble(1, 2);
			int rowsUpdate = deletePs.executeUpdate();
			System.out.println(rowsUpdate + " 삭제 되었습니다.");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
