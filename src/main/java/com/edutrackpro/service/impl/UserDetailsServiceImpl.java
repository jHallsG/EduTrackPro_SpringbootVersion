package com.edutrackpro.service.impl;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Service;

import com.edutrackpro.api.UserDTO;

@Service
public class UserDetailsServiceImpl implements UserDetailsService, UserDetailsManager {

	private final JdbcTemplate jdbcTemplate;

	public UserDetailsServiceImpl(JdbcTemplate jdbcTemplate) {
		System.out.println("UserDetailsServiceImpl constructor called");
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		List<UserDTO> checkUsername = jdbcTemplate.query("SELECT * FROM user WHERE userEmail = ?",
				new BeanPropertyRowMapper<>(UserDTO.class), username);

		if (checkUsername.size() == 0) {
			throw new UsernameNotFoundException("User does not exist");
		}

		// UserDTO is made to implement UserDetails. This line of code is no longer necessary.
		//		UserDetails existingUser = User
		//				.withUsername(checkUsername.get(0)
		//				.getUserEmail())
		//				.password(pass)
		//				.roles(checkUsername.get(0).getRole()).build();	
		//		return existingUser;
		
		return checkUsername.get(0);
	}

	@Override
	public void createUser(UserDetails user) {
		if (userExists(user.getUsername()))
			throw new RuntimeException("User already exists");

		String roles = user.getAuthorities().stream()
				// by default, Spring Security prefixes user roles with "ROLE_". we just removed it
				.map(authority -> authority.getAuthority()/*.replace("ROLE_", ""))*/)
				.reduce((role1, role2) -> role1 + "," + role2).orElse("");

		jdbcTemplate.update("INSERT INTO user (userEmail,password,role) VALUES (?,?,?)", user.getUsername(),
				user.getPassword(), roles.toUpperCase());
	}

	@Override
	public void updateUser(UserDetails user) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteUser(String username) {
		// TODO Auto-generated method stub

	}

	@Override
	public void changePassword(String oldPassword, String newPassword) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean userExists(String username) {
		int userCount = jdbcTemplate.queryForObject("SELECT count(*) FROM user WHERE userEmail =?", Integer.class,
				username);

		if (userCount > 0)
			return true;
		else
			return false;
	}
}
