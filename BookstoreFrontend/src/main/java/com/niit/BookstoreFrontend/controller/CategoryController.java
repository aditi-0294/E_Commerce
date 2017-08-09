package com.niit.BookstoreFrontend.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.BookstoreBackend.dao.CategoryDAO;
import com.niit.BookstoreBackend.model.Category;

@Controller
@RequestMapping("/manage")
public class CategoryController {
	
	@Autowired
	CategoryDAO categoryDAO ;
	
	public CategoryController() {
		
		System.out.println("Default Constructor of Category Controller of frontend controller package ....");
		System.out.println();
	}
	
	
	// show categories to be managed
	@RequestMapping(value = "/category" , method = RequestMethod.GET)
	public String showManageCategory (@RequestParam(name = "operation" , required = false) String operation , Model m) {
		
		System.out.println("Redirecting to manageCategory.jsp from Category Controller section (showManageCategory method) .... ");
		System.out.println();
		
		m.addAttribute("userClickManageCategory" , true) ;
		m.addAttribute("title" , "Manage Categories Page") ;
		
		Category newCategory = new Category() ;
		
		m.addAttribute("category" , newCategory) ; // manageCategory.jsp ka modelAttribute name
		
		if(operation != null) {
			
			if(operation.equals("category")) {
				
				m.addAttribute("message" , "Category details submitted successfully !") ;
			}
		}
		
		return "page_control" ;
	}

	
	
	// Handling Category submission
	@RequestMapping(value = "/category" , method = RequestMethod.POST)
	public String handleCategorySubmission(@Valid @ModelAttribute("category") Category mCategory , BindingResult result , Model m) {
	
		System.out.println("Redirecting to manageCategory.jsp from Category Controller section (handleCategorySubmission method).... ");
		System.out.println();
		
		// check if there are any errors 
		if(result.hasErrors()) {
			
			m.addAttribute("userClickManageCategory" , true) ;
			m.addAttribute("title" , "Manage Categories Page") ;
			m.addAttribute("message" , "Validation failed for category submission !") ;
					
			return "page_control" ; // incase redirect method is used then error message will not be displayed .
		}		
		
		// create a new record to store these categories
	
		//categoryDAO.insertUpdateCategory(mCategory); // insert new record if category id is null or zero
		//categoryDAO.insertUpdateCategory(mCategory);
		
		
		if(mCategory.getCatid()==0) {
			
			categoryDAO.insertUpdateCategory(mCategory); // insert new record if category id is null or zero
		
		}
		
		else {
			
			categoryDAO.insertUpdateCategory(mCategory); // update existing record if category id exists 
	
		}
		
		
		return "redirect:/manage/category?operation=category" ; // passes message (in the form of query string ) from one url to another url
	}
	
	// Edit or update the category
	@RequestMapping(value = "/{catid}/category" , method = RequestMethod.GET) 
	public String showEditCategory(@PathVariable int catid , Model m ) {
			
		System.out.println("Redirecting to manageCategory.jsp from Category Controller section (showEditCategory method) .... ");
		System.out.println();
		
		System.out.println("Editing the Category");
		System.out.println();
		
		m.addAttribute("userClickManageCategory" , true) ;
			
		m.addAttribute("title" , "Manage Categories Page") ;
		
		// fetch category from the database
		Category newCategory = categoryDAO.getCategory(catid) ;
			
		m.addAttribute("category" , newCategory) ; // manageSupplier.jsp ka modelAttribute name 
		
		return "page_control" ;
	}

	
	
	// Deleting the Category
	@RequestMapping(value = "/delete/{catid}/category" , method = RequestMethod.GET)
//	public String showDeleteCategory(@PathVariable int catid , Model m , @RequestParam(name = "operation" , required = false ) String operation) {
	public String showDeleteCategory(@PathVariable int catid , Model m) {	 
		
		System.out.println("Redirecting to manageCategory.jsp from Category Controller section (showDeleteCategory method) .... ");
		System.out.println();
		
		System.out.println("Deleting the category ... ");
		System.out.println();
		
		/*
		//m.addAttribute("userClickManageCategory" , true) ;
			
		//m.addAttribute("title" , "Manage Categories Page") ;
		
		// fetch category from the database
		
			
		//m.addAttribute("category" , newCategory) ; // manageCategory.jsp ka modelAttribute name 
		*/
		
		Category category = categoryDAO.getCategory(catid) ;
		
		categoryDAO.deleteCategory(category) ;
		
		/*  /// Not Working 
		if(operation != null) {
			
			if(operation.equals("/delete/{catid}/category")) {
				
				m.addAttribute("message" , "Category deleted successfully !!") ;
			}
		}
		*/
		
	//	m.addAttribute("message" , "Category deleted successfully !!") ; // displays on address bar
		//return "redirect:/manage/category" ; // doesnt work
		
		return "redirect:/manage/category?operation=category" ; // passes message (in the form of query string ) from one url to another url
	}
	

}
