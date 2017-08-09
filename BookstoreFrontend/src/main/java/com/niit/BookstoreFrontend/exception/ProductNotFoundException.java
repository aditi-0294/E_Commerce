package com.niit.BookstoreFrontend.exception;

import java.io.Serializable;

public class ProductNotFoundException extends Exception implements Serializable {

	//
	private static final long serialVersionUID = 1L ;
	
	String message ;
	
	public ProductNotFoundException() {
		
		this("Product is not available !!") ;
		
		System.out.println("Default Constructor of ProductNotFoundException of frontend exception package .... ");
		System.out.println();
		
		
	}
	
	
	// getter method for message
	public String getMessage() {
		return message;
	}


	public ProductNotFoundException(String message) { // overloaded contructor
		
		this.message = System.currentTimeMillis() + " : " + message ;
	}
	
}