package com.edutrackpro.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.edutrackpro.api.Students;

@Repository
public class StudentsDAOImpl implements StudentDAO{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Students> loadStudents() {
		List<Students> loadStudents = jdbcTemplate.query("SELECT * FROM Students", new BeanPropertyRowMapper<>(Students.class));
		return loadStudents;
	}
	
	public List<Students> search(String search){
		String searchPattern = "%" + search + "%";
		List<Students> searchStudents = jdbcTemplate.query("SELECT * FROM Students WHERE name LIKE ? OR address LIKE ? OR phone LIKE ?", new BeanPropertyRowMapper<>(Students.class), searchPattern, searchPattern, searchPattern);
		return searchStudents;
	}
	
	public void insertNewStudent(Students newStudent){
		Object[] args = {newStudent.getName(), newStudent.getPhone(), newStudent.getAddress()};
		jdbcTemplate.update("INSERT INTO Students (name, phone, address) VALUES (?,?,?)", args);
	}
	
	public Students getStudentById(int studentId){
		Students getStudent = jdbcTemplate.queryForObject("SELECT * FROM Students WHERE id = ?", new BeanPropertyRowMapper<>(Students.class), studentId);
		return getStudent;
	}
	
	public void deleteStudent(int id){
		jdbcTemplate.update("DELETE FROM Students WHERE id = ?", id);
	}
	
	public void updateStudentInfo(Students student) {
		Object[] args = {student.getName(), student.getPhone(), student.getAddress(), student.getId()};
		jdbcTemplate.update("UPDATE Students SET name = ?, phone = ?, address = ? WHERE id = ?", args);
	}

}
