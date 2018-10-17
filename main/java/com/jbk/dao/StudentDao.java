package com.jbk.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.jbk.entity.Student;

@Repository
public interface StudentDao {
	
	public void add(Student student);

	public void edit(Student student);
	
	public void delete(int id);
	
	public Student getStudent(int id);
	
	public List getAllStudent();
	
	public Student getStudent(String userName);

	public List<Student> getByFirstName(String firstName);
	
}
