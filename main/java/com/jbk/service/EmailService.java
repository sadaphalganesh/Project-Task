package com.jbk.service;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.jbk.entity.Admin;

@Service
public class EmailService implements MessengerService {
	
	@Autowired
	Properties props;
	
	@Autowired
	Admin admin;
	
	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public Properties getProps() {
		return props;
	}

	public void setProps(Properties props) {
		this.props = props;
	}


	public void sendEmail(String email,String subject,String message1) {
		System.out.println("im in email service");
		String from=admin.getAdminEmail();
		String password=admin.getEmailPassword();
		
		
		System.out.println(from);
		System.out.println(password);
		 String to=email;
		 System.out.println(to);
		 String sub=subject;
		 String msg=message1;
		  
        //get Session   
        Session session = Session.getDefaultInstance(props,    
         new javax.mail.Authenticator() {    
         protected PasswordAuthentication getPasswordAuthentication() {    
         return new PasswordAuthentication(from,password);  
         }    
        });    
        //compose message    
        try {    
         MimeMessage message = new MimeMessage(session);    
         message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));
         message.setSubject(sub);    
         message.setText(msg);
         //send message  
         Transport.send(message);    
         System.out.println("message sent successfully");    
        } catch (MessagingException e) {throw new RuntimeException(e);}    
 
  }  		
	}

