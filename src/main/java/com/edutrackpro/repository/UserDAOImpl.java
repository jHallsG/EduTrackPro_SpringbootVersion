package com.edutrackpro.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.edutrackpro.dao.UserDAO;

@Repository
public class UserDAOImpl implements UserDAO{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public void registerUser(String email, String password) {
		
		Object[] args = {email, password, "USER"};
		jdbcTemplate.update("INSERT INTO User (userEmail, password, role) VALUES (?,?,?)", args);
	}

	@Override
	public int emailExists(String email) {
		
		return jdbcTemplate.queryForObject("SELECT count(*) FROM User WHERE userEmail = ?", Integer.class, email);
	}

	@Override
	public String getPassword(String email) {
		
		return jdbcTemplate.queryForObject("SELECT password from User WHERE userEmail = ?", String.class, email);
	}
	
	
	
	

}
