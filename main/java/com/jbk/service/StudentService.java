package com.jbk.service;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import com.jbk.entity.Student;

public interface StudentService {

	public void add(Student student);

	public void edit(Student student);
	
	public void delete(int id);
	
	public Student getStudent(int id);
	
	public List<Student> getAllStudent();

	public Student getValidation(String userName);

	public List<Student> getByFirstName(String string);


	
	public static String getEncryption(String password) {
	
	    MessageDigest md;
		try {
			md = MessageDigest.getInstance("MD5");
		
        byte[] hashInBytes = md.digest(password.getBytes(StandardCharsets.UTF_8));

        StringBuilder sb = new StringBuilder();
        for (byte b : hashInBytes) {
            sb.append(String.format("%02x", b));
        }
         password=sb.toString();
        
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return password;
	}
}
