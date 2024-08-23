package com.edutrackpro.api;

import com.edutrackpro.customvalidator.CharPasswordNotBlankValidator;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class UserDTO {
	
	private int userId;
	@NotBlank
	@Email
	private String userEmail;
	private String role;
	@CharPasswordNotBlankValidator
	private char[] password;
	
	public int getUserId() {
		return userId;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public String getRole() {
		return role;
	}
	public char[] getPassword() {
		return password;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public void setPassword(char[] password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		
		String strVersion = userEmail + " " + role + " " + password;
		return role;
	}
}
