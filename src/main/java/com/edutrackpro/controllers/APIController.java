package com.edutrackpro.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.edutrackpro.api.Students;
import com.edutrackpro.service.StudentService;

@RestController("/api")
public class APIController {
	
	@Autowired
	private StudentService studentService;
	
	@ResponseBody
	@GetMapping("/showAPI")
	public List<Students> studentsAPIList(Model model) {

		List<Students> students = studentService.loadStudents();

		return students;
	}

}
