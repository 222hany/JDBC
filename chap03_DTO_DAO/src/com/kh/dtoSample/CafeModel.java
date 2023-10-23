package com.kh.dtoSample;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CafeModel {
	
	private Connection connection;
	
	public CafeModel(Connection connection) { // 생성자
		this.connection = connection;
	}
	
	public List<CafeDTO> getCafes() {
		List<CafeDTO> cafes = new ArrayList<>();
		String query  = "SELECT * FROM cafes";
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ResultSet result = ps.executeQuery();
			while(result.next()){
				/* 
				 * 기존에는 int cafeID = result.getInt("cafeID" 처럼 예약어나 참조어를 사용하여 넣어줄 값을 작성했지만,
				 * 이제는 DTO를 활용하여 예약어나 참조어를 캡슐화(보호)하여 따로 DTO로 작성한다.
				 * DTO로 작성해준 객체를 인스턴스화 하여 객체 안에 있는 멤버변수를 호출한다.
				 */
				CafeDTO cafe = new CafeDTO();
				cafe.setCafeID(result.getInt("cafe_id"));
				cafe.setCafeName(result.getString("name"));
				cafe.setAddress(result.getString("address"));
				cafe.setPhoneNumber(result.getString("phone_number"));
				cafe.setOperatingHours(result.getString("operating_hours"));
				cafes.add(cafe);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cafes;
	}
}