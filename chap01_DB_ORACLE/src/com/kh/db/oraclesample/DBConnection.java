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
		//�����ͺ��̽� ���� ����
		//1. ����̹� ���� : Oracle JDBC ����̹�   Ŭ������
		String driver = "oracle.jdbc.driver.OracleDriver";
		//2. ����Ŭ �� ��ǻ�� ����
		//                              ���� IP�ּ�:port��ȣ
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "khbank";
		String password = "1234";
		Connection con = null;
		
		try {
		//	������ ����Ͽ� ���� ���� �Ǵ� �����ͺ��̽� �۾� ����
			con = DriverManager.getConnection(url, user, password);
			System.out.println("�����ͺ��̽� ���� ����");
		    //SELECT ����
			String selectQuery = "SELECT * FROM BANK";
			PreparedStatement selectState = con.prepareStatement(selectQuery);
			ResultSet result = selectState.executeQuery();
			
			//result.next() : result ��ü���� ���� ��(row)���� �̵�. �������� ������ true ��ȯ �׷��� ������ false ��ȯ.
			while(result.next()) {
				//khbank�� �ִ� bank���̺� ������տ��� account_id�� ������
				int accountID = result.getInt("account_id");
				//�غ��� 1.accountNumber
				String accountNumber = result.getNString("account_number");
				String accountName = result.getNString("account_name");
				double balance = result.getDouble("balance");
				//�غ��� 2.branchName
				String branchName = result.getNString("branch_name");
				//�غ��� 3.lastTransactionDate
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
		//1. ����̹� ����
		String driver = "oracle.jdbc.driver.OracleDriver";
		//2. �� �� ����
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "kh_cafe";
		String password = "1234";
		Connection con = null;
		//3. ���� ����
		try {
			con = DriverManager.getConnection(url, user, password);
			System.out.println("�����ͺ��̽� ���� Ȯ��");
			//select * from menu �ۼ��ؼ� menu ���̺� ��������
			String selectQuery = "SELECT * FROM MENU";
			PreparedStatement selectState = con.prepareStatement(selectQuery);
			ResultSet result = selectState.executeQuery();
			
			while(result.next()) {
				int menuId = result.getInt("MENU_ID");
				int customerID = result.getInt("C_ID");
				String menuName = result.getNString("MENU_NAME");
				int price = result.getInt("PRICE");
				String description = result.getNString("DESCRIPTION");
				System.out.println("�޴�ID : " + menuId + " |��ID : " + customerID + " |�޴��̸� : " + menuName + " |���� : " + price + 
									" |�޴����� : " + description);
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
			//WHERE�� ����ؼ� ���� �߰�
			String selectQuery = "SELECT * FROM BANK WHERE account_number in (?,?,?,?)";
			PreparedStatement selectState = con.prepareStatement(selectQuery);
			/*
			//���⿡ ���ϴ� ������ account_id ����
			int targetAID = 10;
			
			//���� ����
			selectState.setInt(1, targetAID);
			ResultSet result = selectState.executeQuery();
			*/
			
			String[] targetAN = {"1234567890","5555666777","2222333344","4444555566"};
			selectState.setString(1, targetAN[0]);
			selectState.setString(2, targetAN[1]);
			selectState.setString(3, targetAN[2]);
			selectState.setString(4, targetAN[3]);
			ResultSet result = selectState.executeQuery();
			
			//�� ���翩��
			if(!result.isBeforeFirst()) {
				System.out.println("������ ����.");
			}
			
			while(result.next()) {
				int a = result.getInt("account_id");
				String b = result.getNString("account_number");
				String c = result.getNString("ACCOUNT_NAME");
				int d = result.getInt("BALANCE");
				String e = result.getNString("BRANCH_NAME");
				Date f = result.getDate("LAST_TRANSACTION_DATE");
				System.out.println("ACCOUNT_ID : " + a + " |���¹�ȣ : " + b + " |������ : " + c + " | �ܾ� : " + d +
									" |������ : " + e + " |������ �ŷ� ��¥ : " + f);
			}
			
			/*
			if(result.next()) {
				int a = result.getInt("account_id");
				String b = result.getNString("account_number");
				String c = result.getNString("ACCOUNT_NAME");
				int d = result.getInt("BALANCE");
				String e = result.getNString("BRANCH_NAME");
				Date f = result.getDate("LAST_TRANSACTION_DATE");
				System.out.println("ACCOUNT_ID : " + a + " |���¹�ȣ : " + b + " |������ : " + c + " | �ܾ� : " + d +
									" |������ : " + e + " |������ �ŷ� ��¥ : " + f);
			}else {
				System.out.println("���ǿ� �ش��ϴ� �����Ͱ� �����ϴ�.");
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
				System.out.println("�й� : " + studentNo + " |�а���ȣ : " + departmentNo + " |�л��̸� : " + studentName +
									" |�ֹι�ȣ : " + studentSSN + " |�ּ� : " + studentAddress + " |������ : " + entranceDate +
									" |���п��� : " + absenceYN + " |����������ȣ : " + coachProfessorNo);
			}else {
				System.out.println("�ش��ϴ� ���� �����ϴ�.");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}