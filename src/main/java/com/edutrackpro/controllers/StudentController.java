package com.edutrackpro.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.edutrackpro.api.Students;
import com.edutrackpro.service.StudentService;

@Controller
@RequestMapping("/students")
public class StudentController {
	
	
	@Autowired
	private StudentService studentService;
	
	@GetMapping("/test")
	@ResponseBody
	public String test() {
		return "Test successful...";
	}
	
	
	@GetMapping("/show")
	public String fetchAllStudents(Model model) {
		
		List<Students> students = studentService.loadStudents();
		
		model.addAttribute("students",students);
		
		return "student-list";
	}
	
	@GetMapping("/add")
	public String addStudent(@ModelAttribute("addStudent") Students student, Model model) {
		
		model.addAttribute("title", "New");
		
		return "add-student";
	}
	
	@PostMapping("/submit")
	public String submitNewStudent(Students student) {	// StudentDTO and Students have the same fields 
		
		
		if (student.getId() > 0) {
			studentService.updateStudentInfo(student);
		} else {
			studentService.insertNewStudent(student);
		}
		
		return "redirect:/students/show";
	}
	
	@GetMapping("/update")
	public String updateStudent(@RequestParam("userId") int id, Model model ) {
		
		Students student = studentService.getStudentById(id);
		
		model.addAttribute("addStudent", student);
		model.addAttribute("title", "Edit");
		
		return "add-student";
	}
	
	@GetMapping("/delete")
	public String deleteStudent(@RequestParam("userId") int id) {
		
		studentService.deleteStudent(id);
		
		return "redirect:/students/show";
	}
	
	@GetMapping("/search")
	public String searchStudent(@RequestParam("query") String query, Model model) {
		
		List<Students> students = studentService.search(query);
		
		model.addAttribute("students",students);
		
		return "student-list";
	}
	
	@ResponseBody
	@GetMapping("/showAPI")
	public List<Students> studentsAPIList(Model model) {
		
		List<Students> students = studentService.loadStudents();
		
		return students;
	}

}
