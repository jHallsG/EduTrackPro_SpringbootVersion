package com.edutrackpro.service;

public interface EmailService {
	
	void sendEmail(String errorMessage);
	void requestAuthorization(String authMessage);

}
