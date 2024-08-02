package com.edutrackpro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edutrackpro.api.Students;
import com.edutrackpro.dao.StudentDAO;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentDAO studentDAO;

	@Override
	public List<Students> loadStudents() {
		
		List<Students> listOfStudents = studentDAO.loadStudents();

		return listOfStudents;
	}

	@Override
	public List<Students> search(String search) {
		return studentDAO.search(search);
	}

	@Override
	public void insertNewStudent(Students student) {
		
		studentDAO.insertNewStudent(student);
	}

	@Override
	public Students getStudentById(int id) {
		return studentDAO.getStudentById(id);
	}

	@Override
	public void deleteStudent(int id) {
		studentDAO.deleteStudent(id);	
	}

	@Override
	public void updateStudentInfo(Students student) {
		studentDAO.updateStudentInfo(student);
	}
}
