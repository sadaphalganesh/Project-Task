package com.jbk.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.jbk.entity.Admin;
import com.jbk.entity.Student;
import com.jbk.service.EmailService;
import com.jbk.service.StudentService;

@Controller
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		
		//SimpleDateFormat dateFormat=new SimpleDateFormat("dd==MM==yyyy");
		//binder.registerCustomEditor(Date.class, "dateOfBirth",new CustomDateEditor(dateFormat, false));
	}
	
	@RequestMapping("/signup")
	public 	String openAddStudentForm(Model model) {
		Student student=new Student();
		model.addAttribute("student",student);
		return "AddStudent";		
	}
	
	@RequestMapping("/login")
	public 	ModelAndView validation(HttpServletRequest request) {
		
		String userName= request.getParameter("userName");
		String password= request.getParameter("password");
	
		Student student=studentService.getValidation(userName,password);
		
		String umane=student.getUserName();
		String pass=student.getPassword();
		
		if(userName.equals(umane)&& password.equals(pass)) {
			HttpSession session=request.getSession();
			session.setAttribute("student", student);
			System.out.println(session.getId());
			ModelAndView modelAndView=new ModelAndView("success");
			return modelAndView ;
		
		}
			
			else {
				ModelAndView modelAndView=new ModelAndView("login");
				modelAndView.addObject("msg","pls enter the correct userNmae and password");
				return modelAndView ;
			}
		}
				
	@RequestMapping("/logout")
	public 	ModelAndView logout(Model model,HttpServletRequest request) {
		request.getSession().invalidate();
		ModelAndView modelAndView=new ModelAndView("login");
		return modelAndView;		
	}
	
	
	
	@RequestMapping("/addStudent")
	public 	String displayAddStudentForm(Model model) {
		Student student=new Student();
		model.addAttribute("student",student);
		return "AddStudent";		
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/saveForm")
	public ModelAndView addToDB(@Valid @ModelAttribute ("student") Student student,BindingResult result) {
	
		if(result.hasErrors()) {
			ModelAndView modelAndView =new ModelAndView("AddStudent");
			return modelAndView;
		}
		
		if(student.getId()==null) {
		studentService.add(student);
		}
		else {
			studentService.edit(student);
		}
		ModelAndView modelAndView =new ModelAndView("login");
		modelAndView.addObject("msg", "Success");
		return modelAndView;
	}
	
	@RequestMapping("/adminLogin")
	public 	String adminLogin(Model model) {
		return "adminLogin";		
	}
	
	@Autowired
	public Admin admin;
	
	
	@RequestMapping(method=RequestMethod.POST,value="/getAllStudents")
	public ModelAndView getAllStudentData(HttpServletRequest request){
				
			String userName=request.getParameter("userName");
			String  password=request.getParameter("password");
			String adminUserName=admin.getUserName();
			String adminPassword=admin.getPassword();
			
			HttpSession session=request.getSession(false);	
			
			if (!(adminUserName.equals(userName))|| !(adminPassword.equals(password))) {
				System.out.println(session.getId());
				ModelAndView modelAndView=new ModelAndView("StudentList");
				modelAndView.addObject("studentList", studentService.getAllStudent());
				return modelAndView;
			}
			else{
				ModelAndView modelAndView=new ModelAndView("adminLogin");
				modelAndView.addObject("msg","wrong admin login credentials");
				return modelAndView;
			}
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/getByFirstName")
	public ModelAndView getByFirstName(HttpServletRequest request) {
			
			HttpSession session=request.getSession(false);
			if(session==null) {
				ModelAndView modelAndView=new ModelAndView("login");
				modelAndView.addObject("msg","Please login to continue");
				return modelAndView;			
			}
			String firstName=request.getParameter("firstName");
			
			if(firstName=="") {
				ModelAndView modelAndView=new ModelAndView("StudentList");
				modelAndView.addObject("studentList", studentService.getAllStudent());
				return modelAndView;
			}
			ModelAndView modelAndView=new ModelAndView("StudentList");
			modelAndView.addObject("studentList", studentService.getByFirstName(firstName));	
			return modelAndView;
	}
	
	
	@RequestMapping(method=RequestMethod.GET, value="/edit")
	public ModelAndView editData(HttpServletRequest request) {
		int id=Integer.parseInt(request.getParameter("id"));
		System.out.println(id);
	    Student student=studentService.getStudent(id);
	    System.out.println(student);
	    studentService.edit(student);
	    ModelAndView modelAndView=new ModelAndView("AddStudent");
	    modelAndView.addObject("student",student);
		return modelAndView;
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/delete")
	public ModelAndView deleteData(HttpServletRequest request) {
		int id=Integer.parseInt(request.getParameter("id"));
	    studentService.delete(id);
	    ModelAndView modelAndView=new ModelAndView("StudentList");
		modelAndView.addObject("studentList", studentService.getAllStudent());
		return modelAndView;
	}
	
	@Autowired
	private EmailService studentEmailService;
	
	
	@RequestMapping(method=RequestMethod.POST, value="/email")
	public ModelAndView sendEmailFromPrompt(HttpServletRequest request) {
		String sendTo=request.getParameter("email");
		System.out.println(sendTo); 
		
		HttpSession session=request.getSession();
		session.setAttribute("sendTo", sendTo);
	    ModelAndView modelAndView=new ModelAndView("message");
		return modelAndView;
		
	}	
	
	
	@RequestMapping(method=RequestMethod.POST, value="/sendEmail")
	public ModelAndView sendEmail(HttpServletRequest request) {
		String email=request.getParameter("sendTo");
		String subject=request.getParameter("subject");	
		String message=request.getParameter("message");
		System.out.println(email);
		System.out.println(message);
		
		studentEmailService.sendEmail(email,subject,message);
		
	    ModelAndView modelAndView=new ModelAndView("hello");
	    modelAndView.addObject("msg", "The msg has been delivered to "+email);
		return modelAndView;
		
	}	
}
	