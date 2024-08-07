package com.edutrackpro.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAOImpl implements UserDAO{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public void registerUser(String name) {
		
		Object[] args = {name, "USER"};
		jdbcTemplate.update("INSERT INTO User (userName, role) VALUES (?,?)", args);
	}

}
