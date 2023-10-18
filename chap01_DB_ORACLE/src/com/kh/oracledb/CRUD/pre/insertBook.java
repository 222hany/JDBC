package com.kh.oracledb.CRUD.pre;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class insertBook {

	public static void main(String[] args) {
		String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:XE";
		String user = "kh_cafe";
		String password = "1234";
		
		try {
			Connection con = DriverManager.getConnection(jdbcUrl, user, password);
			String insertSQL = "INSERT INTO BOOK(BOOK_ID, TITLE, AUTHOR, PUBLICATION_YEAR, ISBN, GENRE, DESCRIPTION, PRICE, PUBLICATION_DATE, CREATED_DATE, UPDATED_DATE, IS_AVAILABLE)"
							 + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(insertSQL);
			
			//insertBook(ps, 23, "신기한 책", "신기한 작가", 1995, "111-8937460148", "Fantasy", "한 사람의 신기한 이야기", 19.99, Date.valueOf("1995-07-11"), Date.valueOf("2002-11-20"), null, "Y");
			//insertBook(ps, 24, "지루한 책", "지루한 작가", 1999, "811-8937460148", "Poetry", "눈물나게 지루한 이야기", 19.99, Date.valueOf("1999-12-11"), Date.valueOf("2002-11-20"), null, "Y");
			//insertBook(ps, 25, "지루한 책2", "지루한 작가", 2001, "771-8937460148", "Poetry", "눈물나게 지루한 이야기 그 2편", 19.99, Date.valueOf("2001-12-11"), Date.valueOf("2004-11-20"), null, "Y");
			insertBook(ps, 26, "지루한 책3", "지루한 작가", 2003, "781-8937460148", "Poetry", "눈물나게 지루한 이야기 그 마지막편", 19.99, Date.valueOf("2003-12-11"), Date.valueOf("2005-11-20"), null, "Y");
			
			ps.close();
			
			String selectQuery = "SELECT * FROM BOOK WHERE BOOK_ID = ?";
			PreparedStatement selectPs = con.prepareStatement(selectQuery);
			selectPs.setInt(1, 50);
			ResultSet rs = selectPs.executeQuery();
			
			while(rs.next()) {
				
			}
			
		}catch (SQLException e){
			e.printStackTrace();
		}
		
	}
	
	static void insertBook(PreparedStatement ps, int BOOK_ID, String TITLE, String AUTHOR, int PUBLICATION_YEAR, String ISBN, String GENRE, String DESCRIPTION, double PRICE, Date PUBLICATION_DATE, Date CREATED_DATE, Date UPDATED_DATE, String IS_AVAILABLE) throws SQLException{
		ps.setInt(1, BOOK_ID);
		ps.setString(2, TITLE);
		ps.setString(3, AUTHOR);
		ps.setInt(4, PUBLICATION_YEAR);
		ps.setString(5, ISBN);
		ps.setString(6, GENRE);
		ps.setString(7, DESCRIPTION);
		ps.setDouble(8, PRICE);
		ps.setDate(9, PUBLICATION_DATE);
		ps.setDate(10, CREATED_DATE);
		ps.setDate(11, null);
		ps.setString(12, IS_AVAILABLE);
		ps.executeUpdate();
		int rowsInsert = ps.executeUpdate();
		System.out.println(rowsInsert + "행 을 추가.");
	}

}
