package com.bit.myhome.vo;

import java.util.Date;

public class UserVO {
	//FIELD
	private Long no;
	private String name;
	private String password;
	private String email;
	private String gender;
	private Date createdAt;
	
	//생성자 2가지로 만들어 주세요
		//1.기본 생성자
		
		//2.전체 세팅
		//3. no와 createdAt 제외한 나머지 필드 세팅용
		
		//getter
		//tostring 오버라이드
	public UserVO(Long no, String name, String password, String email, String gender, Date createdAt) {
		super();
		this.no = no;
		this.name = name;
		this.password = password;
		this.email = email;
		this.gender = gender;
		this.createdAt = createdAt;
	}

	public UserVO(String name, String password, String email, String gender) {
		super();
		this.name = name;
		this.password = password;
		this.email = email;
		this.gender = gender;
	}

	public Long getNo() {
		return no;
	}

	public void setNo(Long no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	@Override
	public String toString() {
		return "UserVO [no=" + no + ", name=" + name + ", password=" + password + ", email=" + email + ", gender="
				+ gender + ", createdAt=" + createdAt + "]";
	}
	
	
	
	
}
