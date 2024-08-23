package com.edutrackpro.controllers;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/testing")
public class TestConnectionController {
	
	@GetMapping("/")
	@ResponseBody
	public String test1() {
		return "Test successful... for /";
	}

	@GetMapping("/test")
//	@ResponseBody
	public String test() {
		return "test";
	}
	
	@GetMapping("/error")
	public String error() throws IOException {
		throw new IOException();
	}
}
