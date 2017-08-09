package com.niit.BookstoreFrontend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

//import com.niit.BookstoreBackend.dao.CartDAO;
import com.niit.BookstoreBackend.dao.CategoryDAO;
import com.niit.BookstoreBackend.dao.ProductDAO;
import com.niit.BookstoreBackend.dao.SupplierDAO;
import com.niit.BookstoreBackend.model.Cart;
import com.niit.BookstoreBackend.model.Category;
import com.niit.BookstoreBackend.model.Product;
import com.niit.BookstoreBackend.model.Supplier;

@Controller
@RequestMapping("/json/data")
public class JsonDataController {

	public JsonDataController() {

		System.out.println("Default Constructor of Json Data Controller of frontend controller package ....") ;
		System.out.println() ;

	}

	@Autowired
	ProductDAO productDAO ;

	@Autowired
	CategoryDAO categoryDAO ;
	
	@Autowired
	SupplierDAO supplierDAO ;
	
	//@Autowired
	//CartDAO cartDAO ;
	
	// Get all products for users
	@RequestMapping("/all/products")
	@ResponseBody // returns data in JSON format
	public List<Product> getAllProducts() {

		System.out.println(" JSON Controller (getAllProducts method) of frontend controller package .... ") ;
		System.out.println() ;
		
		return productDAO.getProductDetails() ;
	}

	
	// Get category wise products for users
	@RequestMapping("/category/{catid}/products")
	@ResponseBody // returns data in JSON format
	public List<Product> getProductsByCategory(@PathVariable int catid) {
		
		System.out.println(" JSON Controller (getProductsByCategory method) of frontend controller package .... ") ;
		System.out.println();
		
		return productDAO.getProductsByCategory(catid) ;
	}

	
	// Get all products - admin
	@RequestMapping("/admin/all/products")
	@ResponseBody // returns data in JSON format
	public List<Product> getAllProductsForAdmin() {

		System.out.println(" JSON Controller (getAllProductsForAdmin method) of frontend controller package .... ") ;
		System.out.println();
		return productDAO.getProductDetails() ;
	}

	
	// Get all categories - admin
	@RequestMapping("/admin/all/categories")
	@ResponseBody // Returns data in JSON format
	public List<Category> getAllCategoriesForAdmin() {
		
		System.out.println(" JSON Controller (getAllCategoriesForAdmin method) of frontend controller package .... ") ;
		System.out.println() ;
		
		return categoryDAO.getCategoryDetails() ;
	}
	
	
	// Get all suppliers - admin
	@RequestMapping("/admin/all/suppliers")
	@ResponseBody // Returns data in JSON format
	public List<Supplier> getAllSuppliersForAdmin() {
		
		System.out.println(" JSON Controller (getAllSuppliersForAdmin method) of frontend controller package .... ") ;
		System.out.println() ;
		
		return supplierDAO.getSupplierDetails() ;
		
	}
	
	/*
	// Get Cart 
	@RequestMapping("/cart/getCart")
	@ResponseBody
	public List<Cart> getCartItems() { // public Cart getCartItems(@PathVariable(value = "cartid") int cartid)
		
		System.out.println(" JSON Controller (getCartItems method) of frontend controller package .... ") ;
		System.out.println() ;
		
		return cartDAO.getCartDetails() ; // return cartDAO.getCart<ByCartId>(cartid) ;
		
	}
	*/
}
