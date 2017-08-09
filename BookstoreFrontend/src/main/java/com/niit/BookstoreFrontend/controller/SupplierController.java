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

import com.niit.BookstoreBackend.dao.SupplierDAO;
import com.niit.BookstoreBackend.model.Category;
import com.niit.BookstoreBackend.model.Supplier;

@Controller
@RequestMapping("/manage")
public class SupplierController {
	
	@Autowired
	SupplierDAO supplierDAO ;

	public SupplierController() {
		
		System.out.println("Default Constructor of Supplier Controller of frontend controller package ....");
		System.out.println();
	}
	
	
	// show suppliers to be managed
	@RequestMapping(value = "/supplier" , method = RequestMethod.GET)
	public String showManageSupplier (@RequestParam(name = "operation" , required = false) String operation , Model m) {
		
		System.out.println("Redirecting to manageSupplier.jsp from Supplier Controller section (showManageSupplier method) .... ");
		System.out.println();
		
		m.addAttribute("userClickManageSupplier" , true) ;
		m.addAttribute("title" , "Manage Suppliers Page") ;
		
		Supplier newSupplier = new Supplier() ;
		
		m.addAttribute("supplier" , newSupplier) ; // manageSupplier.jsp ka modelAttribute name
		
		if(operation != null) {
			
			if(operation.equals("supplier")) {
				
				m.addAttribute("message" , "Supplier details submitted successfully !") ;
			}
		}
		
		return "page_control" ;
	}

	
	
	// Handling Supplier submission
	@RequestMapping(value = "/supplier" , method = RequestMethod.POST)
	public String handleSupplierSubmission(@Valid @ModelAttribute("supplier") Supplier mSupplier , BindingResult result , Model m) {
	
		System.out.println("Redirecting to manageSupplier.jsp from Supplier Controller section (handleSupplierSubmission method).... ");
		System.out.println();
		
		// check if there are any errors 
		if(result.hasErrors()) {
			
			m.addAttribute("userClickManageSupplier" , true) ;
			m.addAttribute("title" , "Manage Suppliers Page") ;
			m.addAttribute("message" , "Validation failed for supplier submission !") ;
					
			return "page_control" ; // incase redirect method is used then error message will not be displayed .
		}		
		
		// create a new supplier record to store these suppliers
		supplierDAO.insertUpdateSupplier(mSupplier);
			
			
		return "redirect:/manage/supplier?operation=supplier" ; // passes message (in the form of query string ) from one url to another url
	}
	
	// Edit or update the supplier
	@RequestMapping(value = "/{supid}/supplier" , method = RequestMethod.GET) 
	public String showEditSupplier(@PathVariable int supid , Model m ) {
			
		System.out.println("Redirecting to manageSupplier.jsp from Supplier Controller section (showEditSupplier method) .... ");
		System.out.println();
		
		System.out.println("Editing the Supplier");
		System.out.println();
		
		m.addAttribute("userClickManageSupplier" , true) ;
			
		m.addAttribute("title" , "Manage Suppliers Page") ;
		
		// fetch supplier from the database
		Supplier newSupplier = supplierDAO.getSupplier(supid)  ;
			
		m.addAttribute("supplier" , newSupplier) ; // manageSupplier.jsp ka modelAttribute name 
			
		return "page_control" ;
	}

	
	
	// Deleting the Supplier
	@RequestMapping(value = "/delete/{supid}/supplier" , method = RequestMethod.GET)
//	public String showDeleteSupplier(@PathVariable int supid , Model m , @RequestParam(name = "operation" , required = false ) String operation) {
	public String showDeleteSupplier(@PathVariable int supid , Model m) {	 
		
		System.out.println("Redirecting to manageSupplier.jsp from Supplier Controller section (showDeleteSupplier method) .... ");
		System.out.println();
		
		System.out.println("Deleting the supplier ... ");
		System.out.println();
		
		/*
		//m.addAttribute("userClickManageSupplier" , true) ;
			
		//m.addAttribute("title" , "Manage Suppliers Page") ;
		
		// fetch supplier from the database
		
			
		//m.addAttribute("supplier" , newSupplier) ; // manageSupplier.jsp ka modelAttribute name 
		*/
		
		Supplier supplier = supplierDAO.getSupplier(supid) ;
		supplierDAO.deleteSupplier(supplier);
		
		
		/*  /// Not Working 
		if(operation != null) {
			
			if(operation.equals("/delete/{supid}/supplier")) {
				
				m.addAttribute("message" , "Supplier deleted successfully !!") ;
			}
		}
		*/
		
	//	m.addAttribute("message" , "Supplier deleted successfully !!") ; // displays on address bar
		//return "redirect:/manage/supplier" ; // doesnt work
		
		return "redirect:/manage/supplier?operation=supplier" ; // passes message (in the form of query string ) from one url to another url
	}
	

}
