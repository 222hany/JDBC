package com.kh.db.oraclesample;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConnection {

	public static void main(String[] args) {
		//selectBank();
		//selectCafe();
		//selectIf();
		selectUniversity();
	}
	
	static void selectBank() {
		//데이터베이스 연결 정보
		//1. 드라이버 연결 : Oracle JDBC 드라이버   클래스명
		String driver = "oracle.jdbc.driver.OracleDriver";
		//2. 오라클 내 컴퓨터 연결
		//                              나의 IP주소:port번호
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "khbank";
		String password = "1234";
		Connection con = null;
		
		try {
		//	연결을 사용하여 쿼리 실행 또는 데이터베이스 작업 수행
			con = DriverManager.getConnection(url, user, password);
			System.out.println("데이터베이스 연결 성공");
		    //SELECT 쿼리
			String selectQuery = "SELECT * FROM BANK";
			PreparedStatement selectState = con.prepareStatement(selectQuery);
			ResultSet result = selectState.executeQuery();
			
			//result.next() : result 객체에서 다음 행(row)으로 이동. 다음행이 있으면 true 반환 그렇지 않으면 false 반환.
			while(result.next()) {
				//khbank에 있는 bank테이블 결과집합에서 account_id를 가져옴
				int accountID = result.getInt("account_id");
				//해보기 1.accountNumber
				String accountNumber = result.getNString("account_number");
				String accountName = result.getNString("account_name");
				double balance = result.getDouble("balance");
				//해보기 2.branchName
				String branchName = result.getNString("branch_name");
				//해보기 3.lastTransactionDate
				Date lastTransactionDate = result.getDate("last_transaction_date");
				System.out.println("ACCOUNT_ID : " + accountID + "| ACCOUNT_NUMBER : " + accountNumber
									+ "| ACCOUNT_NAME : " + accountName + "| BALANCE : " + balance +
									"| LAST_TRANSACTION_DATE : " + lastTransactionDate);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	static void selectCafe() {
		//1. 드라이버 연결
		String driver = "oracle.jdbc.driver.OracleDriver";
		//2. 내 컴 연결
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "kh_cafe";
		String password = "1234";
		Connection con = null;
		//3. 쿼리 실행
		try {
			con = DriverManager.getConnection(url, user, password);
			System.out.println("데이터베이스 연결 확인");
			//select * from menu 작성해서 menu 테이블 가져오기
			String selectQuery = "SELECT * FROM MENU";
			PreparedStatement selectState = con.prepareStatement(selectQuery);
			ResultSet result = selectState.executeQuery();
			
			while(result.next()) {
				int menuId = result.getInt("MENU_ID");
				int customerID = result.getInt("C_ID");
				String menuName = result.getNString("MENU_NAME");
				int price = result.getInt("PRICE");
				String description = result.getNString("DESCRIPTION");
				System.out.println("메뉴ID : " + menuId + " |고객ID : " + customerID + " |메뉴이름 : " + menuName + " |가격 : " + price + 
									" |메뉴설명 : " + description);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	static void selectIf() {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "khbank";
		String password = "1234";
		Connection con = null;
		
		try {
			con = DriverManager.getConnection(url, user, password);
			//WHERE절 사용해서 조건 추가
			String selectQuery = "SELECT * FROM BANK WHERE account_number in (?,?,?,?)";
			PreparedStatement selectState = con.prepareStatement(selectQuery);
			/*
			//여기에 원하는 조건의 account_id 설정
			int targetAID = 10;
			
			//조건 설정
			selectState.setInt(1, targetAID);
			ResultSet result = selectState.executeQuery();
			*/
			
			String[] targetAN = {"1234567890","5555666777","2222333344","4444555566"};
			selectState.setString(1, targetAN[0]);
			selectState.setString(2, targetAN[1]);
			selectState.setString(3, targetAN[2]);
			selectState.setString(4, targetAN[3]);
			ResultSet result = selectState.executeQuery();
			
			//값 존재여부
			if(!result.isBeforeFirst()) {
				System.out.println("데이터 없음.");
			}
			
			while(result.next()) {
				int a = result.getInt("account_id");
				String b = result.getNString("account_number");
				String c = result.getNString("ACCOUNT_NAME");
				int d = result.getInt("BALANCE");
				String e = result.getNString("BRANCH_NAME");
				Date f = result.getDate("LAST_TRANSACTION_DATE");
				System.out.println("ACCOUNT_ID : " + a + " |계좌번호 : " + b + " |예금주 : " + c + " | 잔액 : " + d +
									" |지점명 : " + e + " |마지막 거래 날짜 : " + f);
			}
			
			/*
			if(result.next()) {
				int a = result.getInt("account_id");
				String b = result.getNString("account_number");
				String c = result.getNString("ACCOUNT_NAME");
				int d = result.getInt("BALANCE");
				String e = result.getNString("BRANCH_NAME");
				Date f = result.getDate("LAST_TRANSACTION_DATE");
				System.out.println("ACCOUNT_ID : " + a + " |계좌번호 : " + b + " |예금주 : " + c + " | 잔액 : " + d +
									" |지점명 : " + e + " |마지막 거래 날짜 : " + f);
			}else {
				System.out.println("조건에 해당하는 데이터가 없습니다.");
			}
			*/
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	static void selectUniversity() {
		String driver = "oracle.jdbc.driver.OracleDriver";
		
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "university";
		String password = "1234";
		Connection con = null;
		
		try {
			con = DriverManager.getConnection(url, user, password);
			
			String selectQuery = "SELECT * FROM TB_STUDENT WHERE STUDENT_NO = ?";
			PreparedStatement selectState = con.prepareStatement(selectQuery);
			
			String targetS_No = "A213046";
			selectState.setString(1, targetS_No);
			ResultSet result = selectState.executeQuery();
			
			if(result.next()) {
				String studentNo = result.getNString("STUDENT_NO");
				String departmentNo = result.getNString("DEPARTMENT_NO");
				String studentName = result.getNString("STUDENT_NAME");
				String studentSSN = result.getNString("STUDENT_SSN");
				String studentAddress = result.getNString("STUDENT_ADDRESS");
				Date entranceDate = result.getDate("ENTRANCE_DATE");
				String absenceYN = result.getNString("ABSENCE_YN");
				String coachProfessorNo = result.getNString("COACH_PROFESSOR_NO");
				System.out.println("학번 : " + studentNo + " |학과번호 : " + departmentNo + " |학생이름 : " + studentName +
									" |주민번호 : " + studentSSN + " |주소 : " + studentAddress + " |입학일 : " + entranceDate +
									" |휴학여부 : " + absenceYN + " |지도교수번호 : " + coachProfessorNo);
			}else {
				System.out.println("해당하는 값이 없습니다.");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}