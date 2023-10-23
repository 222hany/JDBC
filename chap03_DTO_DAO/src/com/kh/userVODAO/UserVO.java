package com.kh.userVODAO;

import java.util.Date;

public class UserVO {
	private int userId;		//사용자 ID
	private String userName;//사용자 이름
	private String email;	//사용자 이메일
	private Date regDate;	//등록 날짜
	
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setRegDate(java.util.Date regDate) {
		this.regDate = regDate;
	}
	
	public int getUserId() {
		return userId;
	}
	public String getUserName() {
		return userName;
	}
	public String getEmail() {
		return email;
	}
	public Date getRegDate() {
		return regDate;
	}
}
