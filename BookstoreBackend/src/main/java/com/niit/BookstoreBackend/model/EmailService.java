package com.niit.BookstoreBackend.model;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.stereotype.Service;

@Service
public class EmailService {
	
	public void sendMail(UserDetail user , String message , String subject) throws MessagingException {
		
		System.out.println("EmailService.java - sendMail() .... ");
		
		final String username = "store.bookarchive@gmail.com" ; // sender mail id 
		final String password = "store.bookarchive" ; // sender mail id ka password
		
		System.out.println("SenderMailId and Password set .... ");
		
		Properties props = new Properties();
	    props.put("mail.smtp.starttls.enable", "true");
	    props.put("mail.smtp.auth", "true");
	    props.put("mail.smtp.host", "smtp.gmail.com");
	    props.put("mail.smtp.port", "587");

	    System.out.println("Email properties executed .... ");
	    
	    Session session = Session.getInstance(props , new javax.mail.Authenticator() { 
	    	
	    	protected PasswordAuthentication getPasswordAuthentication() {
	    		
	    		System.out.println("Inside Session method - for password authentication .... ");
	    		return new PasswordAuthentication(username, password) ;
	    	}
	    	
	    }) ;
	    
	    
	    try {
	    	
	    	System.out.println("Reached try block after authenticating username and password .... ");
	    	
	    	Message e_message = new MimeMessage(session) ;
	    	
	    	e_message.setFrom(new InternetAddress("AditiJain") );
	    	e_message.setRecipients(Message.RecipientType.TO , InternetAddress.parse(user.getEmail()));
	    	
	    	System.out.println("Sender and Receipients set .... ");
	    	
	    	e_message.setSubject(subject);
	    	System.out.println("Subject set .... ");
	    	
	    	e_message.setText(message);
	    	System.out.println("Message Content set .... ");
	    	
	    	Transport.send(e_message);
	    	
	    	System.out.println("Email configuration done ..... ");
	    	
	    } catch(MessagingException e) {
	    	
	    	System.out.println("Exception arised .... ");
	    	e.printStackTrace();
	    	
	    }
		
	}
	
	

}
