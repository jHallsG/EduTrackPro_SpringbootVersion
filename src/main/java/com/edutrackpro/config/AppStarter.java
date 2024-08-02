package com.edutrackpro.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.edutrackpro")
public class AppStarter {
	
	public static void main(String[] args) {
		SpringApplication springApplication = new SpringApplication(AppStarter.class);
		springApplication.run(args);
	}
}
