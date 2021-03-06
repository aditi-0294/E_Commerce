package com.niit.BookstoreFrontend.controller;

import java.util.List;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.BookstoreBackend.dao.UserDetailDAO;
import com.niit.BookstoreBackend.model.EmailService;
import com.niit.BookstoreBackend.model.UserDetail;

@Controller
@RequestMapping("/register")
public class UserController {

	@Autowired
	UserDetailDAO userDetailDAO ;
	
	@Autowired
	EmailService emailservice ;

	public UserController() {
		
		System.out.println("Default Constructor of User Controller of frontend controller package ....");
		System.out.println();
		
	}
	
	
	// show register page where user should sign-up
	@RequestMapping(value = "/newUser" , method = RequestMethod.GET)
	public String showUserPage (@RequestParam(name = "operation" , required = false ) String operation , Model m) {
		
		System.out.println("Redirecting to register.jsp page from User Controller section (showUserPage)");
		System.out.println();
		
		m.addAttribute("userClickRegister" , true) ;
		m.addAttribute("title" , "Register Page") ;
		
		UserDetail userDetail = new UserDetail() ;
		
		if(operation != null) {
			
			if(operation.equals("userDetail")) {
				
				m.addAttribute("message" , "Successfully Registered .... User details submitted successfully !") ;
			}
		}
		
		return "page_control" ;
	}
	

	
	// Add new user - Register page 
	@RequestMapping(value = "/newUser" , method = RequestMethod.POST)
	public String addUserPage (@RequestParam("customer_name") String customer_name , 
			@RequestParam("username") String username , @RequestParam("email") String email ,
			@RequestParam("password") String password , @RequestParam("address") String address ,
			@RequestParam("mobile_number") String mobile_number , UserDetail mUserDetail , Model m ) throws MessagingException {
		
		System.out.println("Redirecting to register.jsp page from User Controller section (showRegisterPage)");
		System.out.println();
		
		System.out.println("Adding user :");
		System.out.println();
		

		List<UserDetail> u_list = userDetailDAO.getUserDetailInfo() ;
		
		System.out.println("Check for duplicate username and email id .... ");
		
		for(int i = 0 ; i < u_list.size() ; i++) {
		
				
				if(mUserDetail.getEmail().equals(u_list.get(i).getEmail())) {
				
					System.out.println("Duplicate email id");
					m.addAttribute("email" , "Email Id already exists !! ") ;
				//	return "redirect:/register/newUser?operation=failed" ;
				//return "redirect:/register/newUser?status=operation_failed" ;
					return "redirect:/register/newUser" ;
					
				}
			
			
				if(mUserDetail.getUsername().equals(u_list.get(i).getUsername())) {
				
					System.out.println("Duplicate username");
					m.addAttribute("username" , "Username already exists !! ") ;
					// return "register" ;
					return "redirect:/register/newUser" ;
				
				}
			
			}
			
		
		
		System.out.println("Checked for duplicate username and password ... ");
		mUserDetail.setCustomer_name(customer_name);
		mUserDetail.setUsername(username);
		mUserDetail.setEmail(email);
		mUserDetail.setPassword(password);
		mUserDetail.setAddress(address);
		//mUserDetail.setMobile_num(mobile_num);
		mUserDetail.setMobile_number(mobile_number);
		
		// set few fields :
		mUserDetail.setRole("User");
		mUserDetail.setRole_enabled(true);
		
		emailservice.sendMail(mUserDetail , 
				
				"Hello " + mUserDetail.getUsername() + " Welcome to BooksArchive - an online bookstore .... Your account has been activated and the password is : " + mUserDetail.getPassword() + 
				
				"Regards , BooksArchive.com team " ,
				
				" Congratulations - Account activated ! "
				
				) ;
		
		// create and store userDetail record in database
		userDetailDAO.insertUpdateUserDetail(mUserDetail);
		
		System.out.println("Add User operation complete ... ");
		
		System.out.println();
		
		
	/*	
	*/	
		return "redirect:/register/newUser?operation=userDetail" ;
	}
	
}

