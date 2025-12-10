package com.tcs.bank_app.dto;

import jakarta.validation.constraints.NotBlank;

public class UserDTO {
	
	@NotBlank
	private String userName;
	@NotBlank
	private String userPassword;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	
	
}
