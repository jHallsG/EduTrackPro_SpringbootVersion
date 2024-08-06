package com.edutrackpro.config;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@SpringBootApplication(scanBasePackages = "com.edutrackpro")
public class AppStarter {
	
	@Autowired
	Environment env;
	
	public static void main(String[] args) {
		SpringApplication springApplication = new SpringApplication(AppStarter.class);
		springApplication.run(args);
	}
	
	// set up JavamailSender credentials. this is for email sending
		@Bean
		public JavaMailSender getJavaMailSender() {
			JavaMailSenderImpl javaMailSenderImpl = new JavaMailSenderImpl();
			javaMailSenderImpl.setHost("smtp.gmail.com");
			System.out.println();
			javaMailSenderImpl.setUsername("javamailsender101@gmail.com"); 
			javaMailSenderImpl.setPassword("tknptwzlcwgjtpzs");
			javaMailSenderImpl.setPort(587);
			javaMailSenderImpl.setJavaMailProperties(setMailProperties());
		
			return javaMailSenderImpl;
		}
		
		private Properties setMailProperties() {
			Properties mailProperties = new Properties();
			mailProperties.put("mail.smtp.starttls.enable", "true");
			mailProperties.put("mail.smtp.ssl.trust", "smtp.gmail.com");		// if this line is missing, will encounter error "cannot convert socket to TLS"
			mailProperties.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");
			
			return mailProperties;
		}
		
		private int getIntValue(String key) {
			int value = Integer.valueOf(env.getProperty(key));
			return value;
		}
}
