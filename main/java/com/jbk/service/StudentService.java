package com.jbk.service;

import java.util.List;

import com.jbk.entity.Student;

public interface StudentService {

	public void add(Student student);

	public void edit(Student student);
	
	public void delete(int id);
	
	public Student getStudent(int id);
	
	public List<Student> getAllStudent();

	public Student getValidation(String userName, String password);

	public List<Student> getByFirstName(String string);
}
