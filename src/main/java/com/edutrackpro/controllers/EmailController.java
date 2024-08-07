package com.edutrackpro.controllers;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.edutrackpro.service.EmailService;

@Controller
@RequestMapping("/email")
public class EmailController {
	
	@Autowired
	private EmailService emailService;
	
	@GetMapping("/sendEmail")
	public String errorSend(@RequestParam("error") String error) {
		
		emailService.sendEmail(error);

		return "error-sent";
	}
	
	@GetMapping("/error")
	public String error() throws IOException {
		throw new IOException();
		
	}

}
