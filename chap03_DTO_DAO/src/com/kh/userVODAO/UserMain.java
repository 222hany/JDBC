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
		//DB연결 URL, USERNAME, PASSWORD.
		String jdbcURL = "jdbc:oracle:thin:@localhost:1521:xe";
		String dbUserName = "kh_cafe";
		String dbPassword = "1234";
		
		try {
			Connection cc = DriverManager.getConnection(jdbcURL, dbUserName, dbPassword);
			Scanner sc = new Scanner(System.in);
			
			while(true) {
				System.out.println("User ID를 입력해주세요.");
				System.out.println("종료하고 싶다면 특수문자 제외 [e] 입력");
				String input = sc.nextLine();
				
				//만약 e를 입력했다면(대소문자 상관없이)
				if("e".equalsIgnoreCase(input)) {
					System.out.println("종료하겠습니다.");
					break; //브레이크가 없으면 출력문만 뜨고 종료되지않음.
				}
				
				System.out.println("email을 입력해주세요.");
				String userEmail = sc.nextLine();
				
				int userId = Integer.parseInt(input); //sc.nextint()을 sc.nextLine()로 받기
				
				//select문 출력하기
				String sql = "SELECT * FROM USERINFO WHERE USER_ID = ? AND EMAIL = ?";
				PreparedStatement st = cc.prepareStatement(sql);
				st.setInt(1, userId);
				st.setString(2, userEmail);
				ResultSet result = st.executeQuery();
				
				//selectOne = if
				if(result.next()) {
					System.out.println("유저 ID : " + result.getInt("USER_ID"));
					System.out.println("유저 이름 : " + result.getString("USER_NAME"));
					System.out.println("이메일 : " + result.getString("EMAIL"));
					System.out.println("가입날짜 : " + result.getDate("REG_DATE"));
					System.out.println("====================");
				}else {
					boolean idTrue = checkId(userId); 
					boolean emailTrue = checkEmail(userEmail);
					if(!idTrue && emailTrue){
						System.out.println("일치하는 User가 없습니다.");
						System.out.println("====================");
					}else if(idTrue && !emailTrue) {
						System.out.println("일치하는 Email이 없습니다.");
						System.out.println("====================");
					}else {
						System.out.println("일치하는 User와 Email을 찾을 수 없습니다.");
					}System.out.println();
				}
			}
		} catch (SQLException e) { 
			e.printStackTrace();
		}
	}
	
	public void insertRun() {
		//DB연결 URL, USERNAME, PASSWORD.
		String jdbcURL = "jdbc:oracle:thin:@localhost:1521:xe";
		String dbUserName = "kh_cafe";
		String dbPassword = "1234";
		
		try {
			Connection connection = DriverManager.getConnection(jdbcURL, dbUserName, dbPassword);
			UserDAO userDao = new UserDAO(connection);
			
			Scanner sc = new Scanner(System.in);
			
			System.out.println("User ID : ");
			int userId = sc.nextInt();
			
			System.out.println("아이디를 입력해주세요.");
			String userName =  sc.next();
			
			System.out.println("회원가입이 거의 다 끝났습니다.");
			System.out.println("마지막으로 이메일을 작성해주세요.");
			String email = sc.next();
			
			Date regDate = new Date(); //현재 날짜와 시간을 사용한다는 의미.
			
			//DB에 담기위해 인스턴스 생성 후 작성받은 정보 저장하기.
			UserVO newUser = new UserVO();
			newUser.setUserId(userId);
			newUser.setUserName(userName);
			newUser.setEmail(email);
			newUser.setRegDate(regDate);
			
			//데이터가 정상적으로 들어갔는지 boolean을 사용해 확인.
			if(userDao.createUser(newUser)) { //true
				System.out.println("회원가입이 완료되었습니다.");
			}else { //false
				System.out.println("유저등록에 실패하였습니다.");
			}
			
			//연결 닫기
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void selectAll() {
		//DB연결 URL, USERNAME, PASSWORD.
		String jdbcURL = "jdbc:oracle:thin:@localhost:1521:xe";
		String dbUserName = "kh_cafe";
		String dbPassword = "1234";
		
		try {
			Connection connection = DriverManager.getConnection(jdbcURL, dbUserName, dbPassword);
			UserDAO userDAO = new UserDAO(connection);
			List<UserVO> users = userDAO.getAllUsers();
			
			for(UserVO u : users) {
				System.out.println("유저 ID : " + u.getUserId());
				System.out.println("유저 이름 : " + u.getUserName());
				System.out.println("이메일 : " + u.getEmail());
				System.out.println("가입날짜 : " + u.getRegDate());
				System.out.println("=====================");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}