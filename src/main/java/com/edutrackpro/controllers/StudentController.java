package com.edutrackpro.controllers;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.edutrackpro.api.Students;
import com.edutrackpro.service.EmailServiceImpl;
import com.edutrackpro.service.StudentService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/students")
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	@Autowired
	private EmailServiceImpl emailService;

	@GetMapping("/test")
	@ResponseBody
	public String test() {
		return "Test successful...";
	}

	@GetMapping("/show")
	public String fetchAllStudents(Model model) {

		List<Students> students = studentService.loadStudents();

		model.addAttribute("students", students);

		return "student-list";
	}

	@GetMapping("/add")
	public String addStudent(Students student, Model model) {
		model.addAttribute("addStudent", student);

		model.addAttribute("title", "New");

		return "add-student";
	}

	@PostMapping("/submit")
	public String submitNewStudent(@Valid @ModelAttribute("addStudent") Students student, BindingResult res) { // StudentDTO and Students have the
																					// same fields
		if (res.hasErrors()) {

			List<ObjectError> errors = res.getAllErrors();
			for (ObjectError errorItem : errors) {
				System.out.println("Error Item " + errorItem);
			}

			return "add-student";
		}

		if (student.getId() > 0) {
			studentService.updateStudentInfo(student);
		} else {
			studentService.insertNewStudent(student);
		}

		return "redirect:/students/show";
	}

	@GetMapping("/update")
	public String updateStudent(@RequestParam("userId") int id, Model model) {

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

		model.addAttribute("students", students);

		return "student-list";
	}
	
	@GetMapping("/sendEmail")
	public String errorSend(@RequestParam("error") String error) {
		
		emailService.sendEmail(error);

		return "error-sent";
	}
	
	@GetMapping("/error")
	public String error() throws IOException {
		throw new IOException();
		
	}

	@ResponseBody
	@GetMapping("/showAPI")
	public List<Students> studentsAPIList(Model model) {

		List<Students> students = studentService.loadStudents();

		return students;
	}
	
	@ExceptionHandler(value = Exception.class)
	public String PageErrorHandling(Exception exception, Model model) {
		model.addAttribute("error", exception.getMessage());
		return "error-page";
	}

}
