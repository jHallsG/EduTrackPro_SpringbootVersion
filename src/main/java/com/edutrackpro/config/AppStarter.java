package com.edutrackpro.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

@SpringBootApplication(scanBasePackages = "com.edutrackpro")
public class AppStarter {
	
	@Autowired
	Environment env;
	
	public static void main(String[] args) {
		SpringApplication springApplication = new SpringApplication(AppStarter.class);
		springApplication.run(args);
	}
}
