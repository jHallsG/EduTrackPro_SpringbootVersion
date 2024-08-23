package com.edutrackpro.dao;

public interface UserDAO {
	
	void registerUser(String email, String password);
	int emailExists(String email);
	String getPassword(String email);

}
