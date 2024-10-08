package com.edutrackpro.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	
	@GetMapping("/requestAuth")
	public String requestAuth(@RequestParam("usermessage") String message, RedirectAttributes redirectAttributes) {
		
		emailService.requestAuthorization(message);
		
		redirectAttributes.addFlashAttribute("messageSent", "Authorization request successfully sent!");
		
		return "redirect:/students/show";
	}

}
