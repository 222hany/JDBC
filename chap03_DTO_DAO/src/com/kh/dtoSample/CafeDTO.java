package com.kh.dtoSample;
// CafeDTO : 데이터 전송 객체 
public class CafeDTO {
	// model SQL 열 형식에 맞춰 데이터를 캡슐화 하고 getter setter을 활용하여 데이터를 저장하고 내보내는 공간
	// 필드 멤버변수 작성
	private int cafeID;
	private String cafeName;
	private String address;
	private String phoneNumber;
	private String operatingHours;
	
	// 생성자 작성
	// 1. 기본 생성자
	public CafeDTO() {
		
	}
	// 2. 파라미터 값을 받을 생성자
	public CafeDTO(int cafeID, String cafeName, String address, String  phoneNumber, String operatingHours) {
		this.cafeID = cafeID;
		this.cafeName = cafeName;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.operatingHours = operatingHours;
	}
	
	// Getter Setter 메서드
	public int getCafeID() {
		return cafeID;
	}
	public void setCafeID(int cafeID) {
		this.cafeID = cafeID;
	}
	public String getCafeName() {
		return cafeName;
	}
	public void setCafeName(String cafeName) {
		this.cafeName = cafeName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getOperatingHours() {
		return operatingHours;
	}
	public void setOperatingHours(String operatingHours) {
		this.operatingHours = operatingHours;
	}
	
	
	
	// @Override(이미 작성된 메서드를 변형해서 나에게 맞는 형식으로 맞출 때 사용)를 활용한 toString 메서드 추가
	@Override
	public String toString() {
		return "CafeDTO";
	}
	
}