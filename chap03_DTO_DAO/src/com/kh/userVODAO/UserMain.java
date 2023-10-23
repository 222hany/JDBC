package com.kh.userVODAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class UserMain {

	public static void main(String[] args) {
		UserMain um = new UserMain();
		//um.insertRun();
		//um.selectAll();
		um.selectScanner();
	}
	
	public boolean checkId(int userId) throws SQLException {
		String jdbcURL = "jdbc:oracle:thin:@localhost:1521:xe";
		String dbUserName = "kh_cafe";
		String dbPassword = "1234";
		
		Connection connection = DriverManager.getConnection(jdbcURL, dbUserName, dbPassword);
		String sql = "SELECT * FROM USERINFO WHERE USER_ID = ?";
		PreparedStatement st = connection.prepareStatement(sql);
		st.setInt(1, userId);
		ResultSet result = st.executeQuery();
		
		if(result.next()) {
			int id = result.getInt(1);
			return id > 0;
		}
		return false;
	}
	
	public boolean checkEmail(String userEmail) throws SQLException {
		String jdbcURL = "jdbc:oracle:thin:@localhost:1521:xe";
		String dbUserName = "kh_cafe";
		String dbPassword = "1234";
		
		Connection connection = DriverManager.getConnection(jdbcURL, dbUserName, dbPassword);
		String sql = "SELECT COUNT(*) FROM USERINFO WHERE EMAIL = ?";
		PreparedStatement st = connection.prepareStatement(sql);
		st.setString(1, userEmail);
		ResultSet result = st.executeQuery();
		
		if(result.next()) {
			int count = result.getInt(1);
			return count > 0;
		}
		return false;
	}
	
	public void selectScanner() {
		//DB���� URL, USERNAME, PASSWORD.
		String jdbcURL = "jdbc:oracle:thin:@localhost:1521:xe";
		String dbUserName = "kh_cafe";
		String dbPassword = "1234";
		
		try {
			Connection cc = DriverManager.getConnection(jdbcURL, dbUserName, dbPassword);
			Scanner sc = new Scanner(System.in);
			
			while(true) {
				System.out.println("User ID�� �Է����ּ���.");
				System.out.println("�����ϰ� �ʹٸ� Ư������ ���� [e] �Է�");
				String input = sc.nextLine();
				
				//���� e�� �Է��ߴٸ�(��ҹ��� �������)
				if("e".equalsIgnoreCase(input)) {
					System.out.println("�����ϰڽ��ϴ�.");
					break; //�극��ũ�� ������ ��¹��� �߰� �����������.
				}
				
				System.out.println("email�� �Է����ּ���.");
				String userEmail = sc.nextLine();
				
				int userId = Integer.parseInt(input); //sc.nextint()�� sc.nextLine()�� �ޱ�
				
				//select�� ����ϱ�
				String sql = "SELECT * FROM USERINFO WHERE USER_ID = ? AND EMAIL = ?";
				PreparedStatement st = cc.prepareStatement(sql);
				st.setInt(1, userId);
				st.setString(2, userEmail);
				ResultSet result = st.executeQuery();
				
				//selectOne = if
				if(result.next()) {
					System.out.println("���� ID : " + result.getInt("USER_ID"));
					System.out.println("���� �̸� : " + result.getString("USER_NAME"));
					System.out.println("�̸��� : " + result.getString("EMAIL"));
					System.out.println("���Գ�¥ : " + result.getDate("REG_DATE"));
					System.out.println("====================");
				}else {
					boolean idTrue = checkId(userId); 
					boolean emailTrue = checkEmail(userEmail);
					if(!idTrue && emailTrue){
						System.out.println("��ġ�ϴ� User�� �����ϴ�.");
						System.out.println("====================");
					}else if(idTrue && !emailTrue) {
						System.out.println("��ġ�ϴ� Email�� �����ϴ�.");
						System.out.println("====================");
					}else {
						System.out.println("��ġ�ϴ� User�� Email�� ã�� �� �����ϴ�.");
					}System.out.println();
				}
			}
		} catch (SQLException e) { 
			e.printStackTrace();
		}
	}
	
	public void insertRun() {
		//DB���� URL, USERNAME, PASSWORD.
		String jdbcURL = "jdbc:oracle:thin:@localhost:1521:xe";
		String dbUserName = "kh_cafe";
		String dbPassword = "1234";
		
		try {
			Connection connection = DriverManager.getConnection(jdbcURL, dbUserName, dbPassword);
			UserDAO userDao = new UserDAO(connection);
			
			Scanner sc = new Scanner(System.in);
			
			System.out.println("User ID : ");
			int userId = sc.nextInt();
			
			System.out.println("���̵� �Է����ּ���.");
			String userName =  sc.next();
			
			System.out.println("ȸ�������� ���� �� �������ϴ�.");
			System.out.println("���������� �̸����� �ۼ����ּ���.");
			String email = sc.next();
			
			Date regDate = new Date(); //���� ��¥�� �ð��� ����Ѵٴ� �ǹ�.
			
			//DB�� ������� �ν��Ͻ� ���� �� �ۼ����� ���� �����ϱ�.
			UserVO newUser = new UserVO();
			newUser.setUserId(userId);
			newUser.setUserName(userName);
			newUser.setEmail(email);
			newUser.setRegDate(regDate);
			
			//�����Ͱ� ���������� ������ boolean�� ����� Ȯ��.
			if(userDao.createUser(newUser)) { //true
				System.out.println("ȸ�������� �Ϸ�Ǿ����ϴ�.");
			}else { //false
				System.out.println("������Ͽ� �����Ͽ����ϴ�.");
			}
			
			//���� �ݱ�
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void selectAll() {
		//DB���� URL, USERNAME, PASSWORD.
		String jdbcURL = "jdbc:oracle:thin:@localhost:1521:xe";
		String dbUserName = "kh_cafe";
		String dbPassword = "1234";
		
		try {
			Connection connection = DriverManager.getConnection(jdbcURL, dbUserName, dbPassword);
			UserDAO userDAO = new UserDAO(connection);
			List<UserVO> users = userDAO.getAllUsers();
			
			for(UserVO u : users) {
				System.out.println("���� ID : " + u.getUserId());
				System.out.println("���� �̸� : " + u.getUserName());
				System.out.println("�̸��� : " + u.getEmail());
				System.out.println("���Գ�¥ : " + u.getRegDate());
				System.out.println("=====================");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}