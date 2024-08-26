package com.edutrackpro.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.edutrackpro.api.UserDTO;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/login")
public class LoginController {
	
	@GetMapping("/")
	public String login(@ModelAttribute("userLogin") UserDTO user, Model model) {
		
		return "login";
	}
	
	@PostMapping("/submitLogin")
	public String processLogin(@Valid @ModelAttribute("userLogin") UserDTO user, BindingResult res) {
		
		if (res.hasErrors()) {

			List<ObjectError> errors = res.getAllErrors();
			for (ObjectError errorItem : errors) {
				System.out.println("Error Item " + errorItem);
			}

			return "login";
		}
		
		return "redirect:/students/show";
		
	}
}
