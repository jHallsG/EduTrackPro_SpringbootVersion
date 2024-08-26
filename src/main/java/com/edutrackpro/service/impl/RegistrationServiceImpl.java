package com.edutrackpro.service.impl;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Service;

@Service
public class RegistrationServiceImpl {
	private final PasswordEncoder bcryptPass;
	private final UserDetailsManager userDetailsManager;
	
	public RegistrationServiceImpl(PasswordEncoder bcryptPass, UserDetailsManager userDetailsManager) {
		this.bcryptPass = bcryptPass;
		this.userDetailsManager = userDetailsManager;
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
				.roles("USER")
				.build();
		
		userDetailsManager.createUser(newUser);
	}
}
