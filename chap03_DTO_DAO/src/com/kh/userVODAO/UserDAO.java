package com.kh.userVODAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
	private Connection connection;
	
	public UserDAO(Connection connection) {
		this.connection = connection;
	}
	
	public boolean createUser(UserVO user) {
		String sql = "INSERT INTO USERINFO (USER_ID, USER_NAME, EMAIL, REG_DATE)"
				   + "VALUES (?,?,?,?)";
		try {
			PreparedStatement st = connection.prepareStatement(sql);
			st.setInt(1, user.getUserId());
			st.setString(2, user.getUserName());
			st.setString(3, user.getEmail());
			st.setDate(4, new Date(user.getRegDate().getTime()));
			
			int rows = st.executeUpdate();
			return rows > 0; //값이 들어오면 0보다 커지므로 true가 됨.
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public List<UserVO> getAllUsers() throws SQLException{
		List<UserVO> users = new ArrayList<>();
		String sql = "SELECT * FROM USERINFO ORDER BY USER_ID";
		PreparedStatement st = connection.prepareStatement(sql);
		ResultSet result = st.executeQuery();
		while(result.next()) {
			UserVO user = new UserVO();
			user.setUserId(result.getInt("USER_ID"));
			user.setUserName(result.getString("USER_NAME"));
			user.setEmail(result.getString("EMAIL"));
			user.setRegDate(result.getDate("REG_DATE"));
			users.add(user);
		}
		return users;
	}
}
