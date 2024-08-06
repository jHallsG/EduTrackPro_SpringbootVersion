package com.edutrackpro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService{
	
	@Autowired
	private JavaMailSender javamailSenderImpl;

	@Override
	public void sendEmail(String errorMessage) {
		SimpleMailMessage newEmail = new SimpleMailMessage();
		newEmail.setTo("clarkspark373@gmail.com");
		newEmail.setSubject("Website Error Encountered");
		newEmail.setText("Error message encountered by user. Logs are as follows: \n\n" + errorMessage);
		
		javamailSenderImpl.send(newEmail);
	}
}
