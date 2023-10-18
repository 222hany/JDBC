package com.kh.oracledb.CRUD.pre;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.PartialResultException;

public class queryExam {

	public static void main(String[] args) {
		//select();
		//insert();
		//update();
		//delete();
		selectOne();
	}
	
	static void select(){
		String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:XE";
		String user = "kh_cafe";
		String password = "1234";
		
		try {
			Connection con = DriverManager.getConnection(jdbcUrl, user, password);
			
			String selectQuery = "SELECT * FROM CAFES";
			Statement st1 = con.createStatement();
			ResultSet result1 = st1.executeQuery(selectQuery);
			
			while(result1.next()) {
				int cafeId = result1.getInt("C_ID");
				String cafeName = result1.getNString("C_NAME");
				String address = result1.getNString("ADDRESS");
				String phoneNumber = result1.getNString("PHONE_NUMBER");
				String operatingHours = result1.getNString("OPERATING_HOURS");
				
				System.out.println("카페ID : " + cafeId + " |카페이름 : " + cafeName + " |주소 : " + address + " |전화번호 : " + phoneNumber +
								   " |운영시간 : " + operatingHours);
			}
			st1.close();
			
			Connection con2 = DriverManager.getConnection(jdbcUrl, user, password);
			
			String selectQuery2 = "SELECT * FROM MENU WHERE C_ID = ?";
			PreparedStatement st2 = con2.prepareStatement(selectQuery2);
			int targetCId = 30;
			st2.setInt(1, targetCId);
			ResultSet result2 = st2.executeQuery();
			
			if(result2.next()) {
				int menuId = result2.getInt("MENU_ID");
				int cafeId = result2.getInt("C_ID");
				String menuName = result2.getNString("MENU_NAME");
				double price = result2.getDouble("PRICE");
				String description = result2.getNString("DESCRIPTION");
				
				System.out.println("메뉴ID : " +menuId+ " |카페ID : " +cafeId+ " |메뉴이름 : " +menuName+ " |가격 : " +price+ " |메뉴설명 : " +description);
			}else {
				System.out.println("없는 메뉴입니다.");
			}
			st2.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	static void insert() {
		String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:XE";
		String user = "kh_cafe";
		String password = "1234";
		
		try {
			Connection con = DriverManager.getConnection(jdbcUrl, user, password);
			String insertQuery = "INSERT INTO CAFES (C_ID, C_NAME, ADDRESS, PHONE_NUMBER, OPERATING_HOURS)"
							   + "VALUES(?,?,?,?,?)";
			PreparedStatement stateQuery = con.prepareStatement(insertQuery);
			
			stateQuery.setInt(1, 20);
			stateQuery.setString(2, "메가커피");
			stateQuery.setString(3, "서울시 강남구 역삼동 1번지");
			stateQuery.setString(4, "02-123-7878");
			stateQuery.setString(5, "운영시간 : 월-금: 07:00-21:00, 주말: 08:00-20:00");
			
			int rows = stateQuery.executeUpdate();
			System.out.println(rows + "행이 추가되었습니다.");
			
			stateQuery.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	static void update() {
		String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:XE";
		String user = "kh_cafe";
		String password = "1234";
		
		try {
			Connection con = DriverManager.getConnection(jdbcUrl, user, password);
			String updateQuery = "UPDATE MENU SET PRICE = ? WHERE MENU_ID = ?";
			PreparedStatement stateQuery = con.prepareStatement(updateQuery);
			
			stateQuery.setDouble(1, 59.99);
			stateQuery.setInt(2, 1);
			
			int rows = stateQuery.executeUpdate();
			System.out.println(rows + "행이 수정되었습니다.");
			stateQuery.close();
			
			String updateQuery2 = "UPDATE CAFES SET C_NAME = ? WHERE C_NAME = ?";
			PreparedStatement stateQuery2 = con.prepareStatement(updateQuery2);
			
			stateQuery2.setString(1, "인스타감성카페");
			stateQuery2.setString(2, "인스타갬성카페");
			
			int rows2 = stateQuery2.executeUpdate();
			System.out.println(rows2 + "행이 수정되었습니다.");
			stateQuery2.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	static void delete() {
		String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:XE";
		String user = "kh_cafe";
		String password = "1234";
		
		try {
			Connection con = DriverManager.getConnection(jdbcUrl, user, password);
			String deleteQuery = "DELETE FROM CAFES WHERE C_NAME = ?";
			PreparedStatement stateQuery = con.prepareStatement(deleteQuery);
			stateQuery.setString(1, "인스타감성카페");
			int rows = stateQuery.executeUpdate();
			System.out.println(rows + "행이 삭제되었습니다.");
			stateQuery.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	static void selectOne() {
		String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:XE";
		String user = "kh_cafe";
		String password = "1234";
		
		try {
			Connection con = DriverManager.getConnection(jdbcUrl, user, password);
			String selectQuery = "SELECT COUNT(*) FROM MENU WHERE C_ID = ?";
			PreparedStatement stateQuery = con.prepareStatement(selectQuery);
			int targetCId = 2;
			stateQuery.setInt(1, targetCId);
			ResultSet result = stateQuery.executeQuery();
			
			if(result.next()) {
				int count = result.getInt("COUNT(*)");
				System.out.println("메뉴 수 : " + count);
			}else {
				System.out.println("없는 카페입니다.");
			}
			
			String selectQuery2 = "SELECT * FROM MENU WHERE PRICE BETWEEN 3 AND 5";
			PreparedStatement stateQuery2 = con.prepareStatement(selectQuery2);
			ResultSet result2 = stateQuery2.executeQuery();
			
			while(result2.next()) {
				int menuId = result2.getInt("MENU_ID");
				int cafeId = result2.getInt("C_ID");
				String menuName = result2.getNString("MENU_NAME");
				double price = result2.getDouble("PRICE");
				String description = result2.getNString("DESCRIPTION");
				
				System.out.println("메뉴ID : " +menuId+ " |카페ID : " +cafeId+ " |메뉴이름 : " +menuName+ " |가격 : " +price+ " |메뉴설명 : " +description);
			}
			
			String selectQuery3 = "SELECT * FROM CAFES WHERE C_ID = ?";
			PreparedStatement stateQuery3 = con.prepareStatement(selectQuery3);
			int targetCId2 = 1;
			stateQuery3.setInt(1, targetCId2);
			ResultSet result3 = stateQuery3.executeQuery();
			
			if(result3.next()) {
				int cafeId = result3.getInt("C_ID");
				String cafeName = result3.getNString("C_NAME");
				String address = result3.getNString("ADDRESS");
				String phoneNumber = result3.getNString("PHONE_NUMBER");
				String operatingHours = result3.getNString("OPERATING_HOURS");
				
				System.out.println("카페ID : " +cafeId+ " |카페이름 : " +cafeName+ " |주소 : " +address+ " |전화번호 : " +phoneNumber+ " |운영시간 : " + operatingHours);
			}else {
				System.out.println("없는 카페입니다.");
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
