/*
 
package com.niit.BookstoreFrontend.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.niit.BookstoreBackend.dao.CartDAO;
import com.niit.BookstoreBackend.dao.UserDetailDAO;
import com.niit.BookstoreBackend.model.UserDetail;

@Controller
@RequestMapping("/cart")
public class CartController {

	@Autowired
	UserDetailDAO userDetailDAO ;
	
	@Autowired
	CartDAO cartDAO ;
	
	public CartController() {
		
		System.out.println("Default Constructor of Cart Controller of frontend controller package ....");
		System.out.println();
	
	}
	
	
	// To get cartid :
	@RequestMapping(value = "/getCartId" , method = RequestMethod.GET)
	public String getCartId(Model m) {
		
		System.out.println("Redirecting to cart.jsp from Product Controller section (getCartId method) .... ");
		System.out.println();
		
		m.addAttribute("title", "User Cart Page");
		m.addAttribute("userClickCart", true);

		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal() ;	
		
		String name_id = user.getUsername() ;
		
		System.out.println("name_id :" + user.getUsername());
		System.out.println();
		
		UserDetail user1 = userDetailDAO.getUserByUsername(name_id) ;
		
	//	m.addAttribute("cartid" , user1.getCart().getCartid()) ;
		
		return "page_control" ;
		
		
	}
	
	
		
}

*/