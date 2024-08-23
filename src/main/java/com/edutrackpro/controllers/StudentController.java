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

import com.edutrackpro.api.StudentDTO;
import com.edutrackpro.service.StudentService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/students")
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	@GetMapping("/show")
	public String fetchAllStudents(Model model) {
		
		List<StudentDTO> students = studentService.loadStudents();

		model.addAttribute("students", students);

		return "student-list";
	}

	@GetMapping("/add")
	public String addStudent(StudentDTO student, Model model) {
		model.addAttribute("addStudent", student);

		model.addAttribute("title", "New");

		return "add-student";
	}

	@PostMapping("/submit")
	public String submitNewStudent(@Valid @ModelAttribute("addStudent") StudentDTO student, BindingResult res) { // StudentDTO and Students have the
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

		StudentDTO student = studentService.getStudentById(id);

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

		List<StudentDTO> students = studentService.search(query);

		model.addAttribute("students", students);

		return "student-list";
	}
}
