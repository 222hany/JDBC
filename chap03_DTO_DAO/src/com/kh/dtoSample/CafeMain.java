package com.kh.dtoSample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CafeMain {

	public static void main(String[] args) {
		// Connection에 연결할 내용 작성 (url, username, password
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String userName = "khcafe";
		String password = "khcafe";
		try {
			Connection con = DriverManager.getConnection(url, userName, password);
			//인스턴스 생성하여 뷰 초기화
			CafeView view = new CafeView();
			
			// 인스턴스 생성하여 컨트롤러 초기화
			CafeController controller = new CafeController(con, view);
			
			// 카페 정보 표시하는 메서드 가져오기
			controller.displayAllCafes();
			
			// connection.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}
}