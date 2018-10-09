package com.jbk.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jbk.entity.Student;

@Repository
public class StudentDaoImpl implements StudentDao {

	@Autowired
	private SessionFactory sessionfactory;
	
	@Override
	public void add(Student student) {
		sessionfactory.getCurrentSession().save(student);
		
	}

	@Override
	public void edit(Student student) {
		sessionfactory.getCurrentSession().update(student);
	}

	@Override
	public void delete(int id) {
		Student student=(Student)sessionfactory.getCurrentSession().get(Student.class, id);
		
		sessionfactory.getCurrentSession().delete(student);
	}

	@Override
	public Student getStudent(int id) {
		Student student =(Student) sessionfactory.getCurrentSession().get(Student.class, id);
		return student;
	}

	@Override
	public List<Student> getAllStudent() {
		return sessionfactory.getCurrentSession().createQuery("from Student").list();
		
	}
	
	@Override
	public Student getStudent(String userName) {
		//Query query= sessionfactory.getCurrentSession().createSQLQuery("select * from student where userName="+userName);
		Criteria criteria=sessionfactory.getCurrentSession().createCriteria(Student.class);
		criteria.add(Restrictions.eq("userName",userName));
		
		Student student=(Student)criteria.uniqueResult();
		return student;
	}
	

}
