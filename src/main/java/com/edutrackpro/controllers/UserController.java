package com.edutrackpro.controllers;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.edutrackpro.api.UserDTO;

@Controller
public class UserController {
	
	@GetMapping("/insufficientAuth")
	public String insufficientAuth(Model model) {
		
		UserDTO userDTO = (UserDTO) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		String message = "Authorization request for " + userDTO.getUserEmail();
		
		model.addAttribute("authMessage", message);
		
		return "authErr";
	}
}
