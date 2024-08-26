package com.edutrackpro.api;

import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.edutrackpro.customvalidator.CharPasswordNotBlankValidator;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class UserDTO implements UserDetails{
	
	private int userId;
	@NotBlank
	@Email
	private String userEmail;
	private String role;
	@CharPasswordNotBlankValidator
	private String password;
	
	public int getUserId() {
		return userId;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public String getRole() {
		return role;
	}
//	public char[] getPassword() {
//		return password;
//	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public void setRole(String role) {
		this.role = role;
	}
//	public void setPassword(char[] password) {
//		this.password = password;
//	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	// ======================================================================== //
	@Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singletonList(new SimpleGrantedAuthority(role));
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return userEmail;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;  // Customize this based on your requirements
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;  // Customize this based on your requirements
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;  // Customize this based on your requirements
    }

    @Override
    public boolean isEnabled() {
        return true;  // Customize this based on your requirements
    }
}
