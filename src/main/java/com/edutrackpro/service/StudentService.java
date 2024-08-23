package com.edutrackpro.service;

import java.util.List;

import com.edutrackpro.api.StudentDTO;

public interface StudentService {
	
	List<StudentDTO> loadStudents();
	List<StudentDTO> search(String search);
	void insertNewStudent(StudentDTO student);
	StudentDTO getStudentById(int id);
	void deleteStudent(int id);
	void updateStudentInfo(StudentDTO student);
}
