package com.edutrackpro.service;

import java.util.List;

import com.edutrackpro.api.Students;

public interface StudentService {
	
	List<Students> loadStudents();
	List<Students> search(String search);
	void insertNewStudent(Students student);
	Students getStudentById(int id);
	void deleteStudent(int id);
	void updateStudentInfo(Students student);
}
