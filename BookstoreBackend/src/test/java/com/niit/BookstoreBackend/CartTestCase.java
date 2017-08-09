/*
 
package com.niit.BookstoreBackend;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.BookstoreBackend.dao.CartDAO;
import com.niit.BookstoreBackend.dao.CartItemDAO;
import com.niit.BookstoreBackend.dao.UserDetailDAO;
import com.niit.BookstoreBackend.model.Cart;
import com.niit.BookstoreBackend.model.UserDetail;

public class CartTestCase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(" ******* Flow in Cart Test Case - AnnotationConfigApplicationContext ****** ");		
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();  // checks for all annotations 
		
		System.out.println(" ****** Calling Scan Method ... ****** ");
		context.scan("com.niit.BookstoreBackend");  // package scanned by anno file for annotations  ... 
		System.out.println(" ****** Scan Method called and completed succesfully ... ****** ");
		
		System.out.println();
		
		System.out.println(" ****** Calling Refresh Method ****** ");
		context.refresh(); // refreshes and searches for application test
		System.out.println(" ****** Refresh Method called and completed succesfully ... ****** ");

		System.out.println();		
		
		// Start of CRUD Operation - only one operation can be performed at a time .
		System.out.println();
		
		// Inserting a Cart Object.
		CartDAO CartDAO = (CartDAO)context.getBean("cartDAO");
		UserDetailDAO userDetailDAO = (UserDetailDAO)context.getBean("userDetailDAO") ;
		CartItemDAO cartItemDAO = (CartItemDAO)context.getBean("cartItemDAO") ;
		
		//Insertion TestCase
		Cart cart = new Cart() ;
		UserDetail userDetail = new UserDetail() ;
		CartItem cartItem = new CartItem() ;
		
		System.out.println(" ****** Inserting Cart Information  ****** ");
		
		System.out.println(" ****** First cart details : ****** ");
		//cart.setCartid(0);
		cart.setGrandTotal(0);
	//	cart.getCartItems();
		cart.getUserDetail();
	//	cart.setCartid(0);
	//	cart.setUserDetail(userDetail);
	//	cart.setUserDetail(userDetail);
	//	cart.getCartItems();
		
		CartDAO.insertUpdateCart(cart);
		
		System.out.println("Details of cart inserted");
		
		System.out.println();
		
		System.out.println(" ****** Creating / Inserting Operation is completed ....  ****** ");
		
		System.out.println();
		
	}	
		
		
		
}

*/