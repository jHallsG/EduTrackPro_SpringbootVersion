package com.edutrackpro.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.edutrackpro.api.StudentDTO;
import com.edutrackpro.dao.StudentDAO;

@Repository
public class StudentsDAOImpl implements StudentDAO{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<StudentDTO> loadStudents() {
		List<StudentDTO> loadStudents = jdbcTemplate.query("SELECT * FROM Students", new BeanPropertyRowMapper<>(StudentDTO.class));
		return loadStudents;
	}
	
	public List<StudentDTO> search(String search){
		String searchPattern = "%" + search + "%";
		List<StudentDTO> searchStudents = jdbcTemplate.query("SELECT * FROM Students WHERE name LIKE ? OR address LIKE ? OR phone LIKE ?", new BeanPropertyRowMapper<>(StudentDTO.class), searchPattern, searchPattern, searchPattern);
		return searchStudents;
	}
	
	public void insertNewStudent(StudentDTO newStudent){
		Object[] args = {newStudent.getName(), newStudent.getPhone(), newStudent.getAddress()};
		jdbcTemplate.update("INSERT INTO Students (name, phone, address) VALUES (?,?,?)", args);
	}
	
	public StudentDTO getStudentById(int studentId){
		StudentDTO getStudent = jdbcTemplate.queryForObject("SELECT * FROM Students WHERE id = ?", new BeanPropertyRowMapper<>(StudentDTO.class), studentId);
		return getStudent;
	}
	
	public void deleteStudent(int id){
		jdbcTemplate.update("DELETE FROM Students WHERE id = ?", id);
	}
	
	public void updateStudentInfo(StudentDTO student) {
		Object[] args = {student.getName(), student.getPhone(), student.getAddress(), student.getId()};
		jdbcTemplate.update("UPDATE Students SET name = ?, phone = ?, address = ? WHERE id = ?", args);
	}

}
