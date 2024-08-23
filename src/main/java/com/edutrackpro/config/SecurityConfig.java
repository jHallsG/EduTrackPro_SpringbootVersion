package com.edutrackpro.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity(debug = false)
public class SecurityConfig {
	
	@Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(authorizeRequests -> authorizeRequests
            	.requestMatchers("/delete").hasRole("ADMIN")
        		.requestMatchers("/WEB-INF/views/**","/css/**","/images/**","/javascript/**").permitAll()
        		.requestMatchers("/login/**","/register/**","/error/**"/*,"testing/**"*/).permitAll()
            	.anyRequest().authenticated())
      
            .formLogin(form -> form
                	.loginPage("/login/")
                	.loginProcessingUrl("/login/submitLogin"));
//                	.permitAll());
        
        return http.build();
    }
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}

