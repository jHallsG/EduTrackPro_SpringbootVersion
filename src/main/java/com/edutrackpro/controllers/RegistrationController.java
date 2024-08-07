package com.edutrackpro.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.edutrackpro.api.UserDTO;
import com.edutrackpro.service.UserService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/register")
public class RegistrationController {
	
	@Autowired
	private UserService userService;

	@GetMapping("/")
	public String register(Model model) {
		
		model.addAttribute("userRegistration", new UserDTO());
		
		return "register";
	}
	
	@PostMapping("/submitRegistration")
	public String submitRegistration(@Valid @ModelAttribute("userRegistration") UserDTO users, BindingResult res) {
		
		if (res.hasErrors()) {

			List<ObjectError> errors = res.getAllErrors();
			for (ObjectError errorItem : errors) {
				System.out.println("Error Item " + errorItem);
			}

			return "register";
		}
		
		System.out.println(users.getUserEmail());
		System.out.println(users.getPassword());
//		userService.registerUser(users.getUserEmail());
		
		return "redirect:/login/";
	}
}
