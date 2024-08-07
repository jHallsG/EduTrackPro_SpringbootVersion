package com.edutrackpro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edutrackpro.dao.UserDAO;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserDAO userDAO;

	@Override
	public void registerUser(String name) {
		userDAO.registerUser(name);	
	}
}
