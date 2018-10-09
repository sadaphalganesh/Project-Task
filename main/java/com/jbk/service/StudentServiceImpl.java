package com.jbk.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jbk.dao.StudentDao;
import com.jbk.entity.Student;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentDao studentDao;
	
	
	@Transactional
	public void add(Student student) {
		studentDao.add(student);
	}

	@Transactional
	public void edit(Student student) {
		studentDao.edit(student);
		
	}

	@Transactional
	public void delete(int id) {
		studentDao.delete(id);
		
	}

	@Transactional
	public Student getStudent(int id) {
		return studentDao.getStudent(id);
		
	}

	@Transactional
	public List<Student> getAllStudent() {
		return studentDao.getAllStudent();
	}

	@Transactional
	public Student getValidation(String userName, String password) {
		return studentDao.getStudent(userName);
	}

}