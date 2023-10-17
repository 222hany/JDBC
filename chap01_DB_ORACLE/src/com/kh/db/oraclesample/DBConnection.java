package com.kh.db.oraclesample;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConnection {

	public static void main(String[] args) {
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
				int accountNumber = result.getInt("account_number");
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

}
