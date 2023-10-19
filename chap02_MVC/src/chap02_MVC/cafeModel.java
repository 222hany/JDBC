package chap02_MVC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class cafeModel {
	String url = "jdbc:oracle:thin:@localhost:1521:XE";
	String user = "kh_cafe";
	String password = "1234";
	
	public void insertCafe(String name, String address, String phoneNumber, String operatingHours) {
		try {
			Connection con = DriverManager.getConnection(url, user, password);
			
			String sql = "INSERT INTO CAFES (NAME, ADDRESS, PHONE_NUMBER, OPERATING_HOURS)"
					   + "VALUES (?,?,?,?)";
			
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, address);
			ps.setString(3, phoneNumber);
			ps.setString(4, operatingHours);
			
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void updateMenu(String description, int menuId, int cafeId) {
		try {
			Connection con = DriverManager.getConnection(url, user, password);
			
			String sql = "UPDATE MENU SET DESCRIPTION = ? WHERE MENU_ID = ? AND CAFE_ID = ?";
			PreparedStatement st = con.prepareStatement(sql);
			
			st.setString(1, description);
			st.setInt(2, menuId);
			st.setInt(3, cafeId);
			st.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void updateCafe(String operatingHours, int cafeId) {
		try {
			Connection con = DriverManager.getConnection(url, user, password);
			String sql = "UPDATE CAFES SET OPERATING_HOURS = ? WHERE C_ID = ?";
			PreparedStatement st = con.prepareStatement(sql);
			
			st.setString(1, operatingHours);
			st.setInt(2, cafeId);
			st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void deleteCafe(int cafeId) {
		Connection con;
		try {
			con = DriverManager.getConnection(url, user, password);
			String sql = "DELETE FROM CAFES WHERE C_ID = ?";
			PreparedStatement st = con.prepareStatement(sql);
			
			st.setInt(1, cafeId);
			st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void deleteMenu(int menuId, int cafeId) {
		try {
			Connection con = DriverManager.getConnection(url, user, password);
			String sql = "DELETE FROM MENU WHERE MENU_ID = ? AND CAFE_ID = ?";
			PreparedStatement st = con.prepareStatement(sql);
			
			st.setInt(1, menuId);
			st.setInt(2, cafeId);
			st.executeUpdate();
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void deleteOrders(int orderId) {
		try {
			Connection con = DriverManager.getConnection(url, user, password);
			String sql = "DELETE FROM ORDERS WHERE ORDER_ID = ?";
			PreparedStatement st = con.prepareStatement(sql);
			
			st.setInt(1, orderId);
			st.executeUpdate();
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void selectMenu(int menuId) {
		try {
			Connection con = DriverManager.getConnection(url, user, password);
			String sql = "SELECT * FROM MENU WHERE MENU_ID = ?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, menuId);
			ResultSet result = st.executeQuery();
			
			while(result.next()) {
				int menuID = result.getInt("MENU_ID");
				int cafeId = result.getInt("CAFE_ID");
				String menuName = result.getNString("MENU_NAME");
				double price = result.getDouble("PRICE");
				String description = result.getNString("DESCRIPTION");
				
				System.out.println("메뉴ID : " +menuId+ " |카페ID : " +cafeId+ " |메뉴이름 : " +menuName+ " |가격 : " +price+ " |메뉴설명 : " +description);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}