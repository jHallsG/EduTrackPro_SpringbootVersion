package com.edutrackpro.service.impl;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class RegistrationServiceImpl {
	private final PasswordEncoder bcryptPass;
	private final UserDetailsServiceImpl userDetailsServiceImpl;
	
	public RegistrationServiceImpl(PasswordEncoder bcryptPass, UserDetailsServiceImpl userDetailsServiceImpl) {
		this.bcryptPass = bcryptPass;
		this.userDetailsServiceImpl = userDetailsServiceImpl;
	}

	public void registerNewUser(String username, String password) {
		
		if (username == null || username.isEmpty()) {
		    throw new IllegalArgumentException("Username cannot be empty");
		}
		
		if (password == null || password.length() < 8) {
			throw new IllegalArgumentException("Password must be at least 8 characters long"); 
		}
		 

		UserDetails newUser = User
				.withUsername(username)
				.password(bcryptPass.encode(password))
				.roles("user")
				.build();
		
		saveUser(newUser);
	}
	
	private void saveUser(UserDetails user) {
	
		userDetailsServiceImpl.createUser(user);
	}
}
