package com.edutrackpro.dao;

import java.util.List;

import com.edutrackpro.api.StudentDTO;

public interface StudentDAO {
	
	List<StudentDTO> loadStudents();
	List<StudentDTO> search(String search);
	void insertNewStudent(StudentDTO student);
	StudentDTO getStudentById(int id);
	void deleteStudent(int id);
	void updateStudentInfo(StudentDTO student);

}
