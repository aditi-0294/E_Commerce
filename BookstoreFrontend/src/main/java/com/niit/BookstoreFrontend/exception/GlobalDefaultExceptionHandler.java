package com.niit.BookstoreFrontend.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice // auto-detects by classpath scanning ?
public class GlobalDefaultExceptionHandler {

		public GlobalDefaultExceptionHandler() {
		
			System.out.println("Default Constructor of GlobalDefaultExceptionHandler of frontend exception package .... ");
			System.out.println();
		}
		
		
		// global error handler
		@ExceptionHandler(NoHandlerFoundException.class)
		public String handlerNoHandlerFoundException(Model m) {
			
			System.out.println("Redirecting to error.jsp page from Exception Handler section .. ");
			System.out.println();
			
			
			m.addAttribute("errorTitle" , "The page is not constructed ... ! ") ;

			m.addAttribute("errorDescription" , "The page you are looking for is currently not available ... ! ") ;
			
			m.addAttribute("title" , "404 Error Page") ;
			
			return "error" ;
			
		}
	
		
		// error handler only for product integer
		@ExceptionHandler(ProductNotFoundException.class)
		public String handlerProductNotFoundException(Model m) {
			
			System.out.println("Redirecting to error.jsp page from Exception Handler section .. ");
			System.out.println();
			
			
			m.addAttribute("errorTitle" , "Product is not available ... ! ") ;

			m.addAttribute("errorDescription" , "The product you are looking for is not currently available ... ! ") ;
			
			m.addAttribute("title" , "Product unavailable") ;
			return "error" ;
			
		}
	
}
