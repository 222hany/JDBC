package com.kh.db.oraclesample;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConnection {

	public static void main(String[] args) {
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
				int accountNumber = result.getInt("account_number");
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

}
