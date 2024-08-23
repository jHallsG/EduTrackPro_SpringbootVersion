//package com.edutrackpro.controllers;
//
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//
//@ControllerAdvice
//public class GlobalExceptionHandler {
//	
//	@ExceptionHandler(value = Exception.class)
//	public String PageErrorHandling(Exception exception, Model model) {
//		model.addAttribute("error", exception.getMessage());
//		return "error-page";
//	}
//}
