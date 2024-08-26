package com.edutrackpro.service.impl;

import java.security.Principal;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

import com.edutrackpro.api.StudentDTO;
import com.edutrackpro.dao.StudentDAO;
import com.edutrackpro.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentDAO studentDAO;

	@Override
	public List<StudentDTO> loadStudents() {
		
		List<StudentDTO> listOfStudents = studentDAO.loadStudents();

		return listOfStudents;
	}

	@Override
	public List<StudentDTO> search(String search) {
		return studentDAO.search(search);
	}

	@Override
	public void insertNewStudent(StudentDTO student) {
		
		studentDAO.insertNewStudent(student);
	}

	@Override
	public StudentDTO getStudentById(int id) {
		return studentDAO.getStudentById(id);
	}

	@Override
	public void deleteStudent(int id) {
		studentDAO.deleteStudent(id);	
	}

	@Override
	public void updateStudentInfo(StudentDTO student) {
		studentDAO.updateStudentInfo(student);
	}
	
	public boolean isAdmin(Principal principal) {
		Authentication auth = (Authentication) principal;
		Collection<? extends GrantedAuthority> grantedAuth =  auth.getAuthorities();
		boolean isAdmin = grantedAuth.stream().anyMatch(authority -> authority
				.getAuthority().equals("ADMIN"));
		
		return isAdmin;
	}
}
