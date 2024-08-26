package com.edutrackpro.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.edutrackpro.service.impl.UserDetailsServiceImpl;



@Configuration
@EnableWebSecurity(debug = false)
public class SecurityConfig {
	
	private final UserDetailsServiceImpl userDetailsServiceImpl;

    public SecurityConfig(UserDetailsServiceImpl userDetailsServiceImpl) {
        this.userDetailsServiceImpl = userDetailsServiceImpl;
    }
	
	@Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(authorizeRequests -> authorizeRequests
//            	.requestMatchers("/students/delete").hasRole("ADMIN")
        		.requestMatchers("/WEB-INF/views/**","/css/**","/images/**","/javascript/**").permitAll()
        		.requestMatchers("/login/**","/register/**","/error/**","testing/**").permitAll()
            	.anyRequest().authenticated())
      
            .formLogin(form -> form
                	.loginPage("/login/")
                	// be careful with this if you have a form validation in place. Spring will intercept any login form submission to
                	// conduct it's own security authorization therefore bypassing the controller and it's form validations.
                	.loginProcessingUrl("/login/submitLogin")
                	.usernameParameter("userEmail")
                	.passwordParameter("password")
                	// false: users will redirect to their originally requested page after a successful login
                	// true: users will always be redirected to "/students/show" after a successful login
                	.defaultSuccessUrl("/students/show", false)
                	// specify which URL to redirect to incase of failed login attempt. disabling this will revert to 
                	// default, which will be "/<login-url>?error"
//                	.failureUrl("/login/?error"))
                	.permitAll())
        
        	.authenticationProvider(authenticationProvider());
        			
        return http.build();
    }
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	
	// this will intercept our login page and do password auth behind the scenes
	@Bean
	public AuthenticationProvider authenticationProvider() {
	    DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
	    authProvider.setUserDetailsService(userDetailsServiceImpl);
	    authProvider.setPasswordEncoder(passwordEncoder());
	    return authProvider;
	}

}

