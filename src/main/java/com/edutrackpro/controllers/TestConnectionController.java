package com.edutrackpro.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestConnectionController {

	@GetMapping("/test")
	@ResponseBody
	public String test() {
		return "Test successful...";
	}
}
