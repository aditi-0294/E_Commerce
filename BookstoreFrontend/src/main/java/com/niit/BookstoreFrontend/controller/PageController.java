package com.niit.BookstoreFrontend.controller;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.BookstoreBackend.dao.CartItemDAO;
import com.niit.BookstoreBackend.dao.CategoryDAO;
import com.niit.BookstoreBackend.dao.ProductDAO;
import com.niit.BookstoreBackend.dao.UserOrderDAO;
import com.niit.BookstoreBackend.model.Cart;
import com.niit.BookstoreBackend.model.Category;
import com.niit.BookstoreBackend.model.Product;
import com.niit.BookstoreBackend.model.UserDetail;
import com.niit.BookstoreBackend.model.UserOrder;
import com.niit.BookstoreFrontend.exception.ProductNotFoundException;

@Controller // specifies that class is a controller which takes request and sends the view information .
public class PageController {

	@Autowired // tells spring to instantiate class
	CategoryDAO categoryDAO;

	@Autowired
	ProductDAO productDAO;
	
	@Autowired
	CartItemDAO cartItemDAO;
	
	@Autowired
	UserOrderDAO userOrderDAO;
	
	
	public PageController() {
		System.out.println("Default Constructor of Page Controller of frontend controller package .... ");
		System.out.println();
	}

	// First page : index.jsp
	@RequestMapping(value = { "/", "/home", "/index"})
	public String indexPage(Model m) {
		System.out.println("Redirecting to index.jsp page from Page Controller section .. ");
		System.out.println();

		m.addAttribute("title", "Home Page");

		// passing the list of categories
	//	m.addAttribute("list", categoryDAO.getCategoryDetails()); // header file ka items
		m.addAttribute("list", categoryDAO.getCategoryDetails()); // header file ka items
		
		m.addAttribute("userClickHome", true);

		return "page_control";
	}

	
	// About Us page
	@RequestMapping(value = "/aboutUs")
	public String aboutUsPage(Model m) {
		System.out.println("Redirecting to aboutUs.jsp page from Page Controller section .. ");
		System.out.println();

		m.addAttribute("title", "About Us Page");
		m.addAttribute("userClickAboutUs", true);

		return "page_control";
	}

	
	// Contact Us page
	@RequestMapping(value = "/contactUs")
	public String contactUsPage(Model m) {
		System.out.println("Redirecting to contactUs.jsp page from Page Controller section .. ");
		System.out.println();

		m.addAttribute("title", "Contact Us Page");
		m.addAttribute("userClickContactUs", true);

		return "page_control";
	}

	
	// Methods to load all products 
	@RequestMapping(value = "/show/all/products")
	public String showAllProductsPage(Model m) {
		System.out.println("Redirecting to listProducts.jsp page from Page Controller section .. ");
		System.out.println();

		m.addAttribute("title", "All Products Page");

		// passing the list of categories
		m.addAttribute("list", categoryDAO.getCategoryDetails()); // header file ka items , CategoryDAO ka getDetails() method

		m.addAttribute("userClickAllProducts", true); // from listProducts.jsp page

		return "page_control";
	}

	
	
	// Methods to load all products based on category
	@RequestMapping(value = "/show/category/{catid}/products")
	public String showCategoryProductsPage(@PathVariable("catid") int catid , Model m) {
		System.out.println("Redirecting to listProducts.jsp page from Page Controller section .. ");
		System.out.println();

		// categoryDAO to fetch a single category product
		Category category = null ;
		
		category = categoryDAO.getCategory(catid) ;
		
		m.addAttribute("title", category.getCat_name());

		// passing the list of categories
		m.addAttribute("list", categoryDAO.list()); // header file ka items , categoryDAO ka List<> categories method
	//	m.addAttribute("list", categoryDAO.getCategoryDetails()); // header file ka items , categoryDAO ka List<> categories method
		// passing the single category object
		m.addAttribute("category", category);
		m.addAttribute("userClickCategoryProducts", true);

		return "page_control";
	}

	
	
	// Viewing single product page 
	@RequestMapping(value = "/show/{prodid}/product")
	public String showSingleProduct(@PathVariable int prodid , Model m) throws ProductNotFoundException { // checked exception
		System.out.println("Redirecting to singleProduct.jsp page from Page Controller section .. ");
		System.out.println();

		Product product = productDAO.getProduct(prodid) ; // Get products by their ids' 
		
		// if product not available then throw exception 
		if(product == null) throw new ProductNotFoundException() ; // incase of unhecked exception - use try catch block mechanism
		
		m.addAttribute("title" , product.getProd_name()) ;
		m.addAttribute("product" , product) ;
		
		m.addAttribute("userClickShowProduct" , true) ;
		
		return "page_control" ;
		
	}
	
	
	// generalized exception - error handler only for product string
		@ExceptionHandler(Exception.class)
		public String handlerException(Exception ex , Model m) {
				
			System.out.println("Redirecting to error.jsp page from Exception Handler section .. Page Controller package ");
			System.out.println();
				
				
			m.addAttribute("errorTitle" , "Error .... ! Contact your administrator ... ! ") ;

			
			// to print entire stacktrace - only for debugging application and not for production environment
			StringWriter sw = new StringWriter() ;
			PrintWriter pw = new PrintWriter(sw) ;
			
			ex.printStackTrace(pw) ;
			
			
		//	m.addAttribute("errorDescription" , ex.toString()) ; // gives error in readable format instead of 404 / 400 etc. codes
			m.addAttribute("errorDescription" , sw.toString()) ; // stackTrace - gives error in readable format instead of 404 / 400 etc. codes	
			m.addAttribute("title" , "Error ....! ") ;
			return "error" ;
				
		}


	
	/*
	// Register page
	@RequestMapping(value = "/register/newUser")
	public String registerPage(Model m) {
		System.out.println("Redirecting to register.jsp page from Page Controller section .. ");
		System.out.println();

		m.addAttribute("title", "Register Page");
		m.addAttribute("userClickRegister", true);
		return "page_control";
	}
	*/
	
	// Sign-In / Login page
	@RequestMapping(value = "/login")
	public String loginPage(@RequestParam(name = "error" , required = false) String error_operation , Model m) {
//	public String loginPage(Model m) {
		System.out.println("Redirecting to login.jsp page from Page Controller section .. ");
		System.out.println();

		m.addAttribute("title", "Login Page");
		m.addAttribute("userClickLogin", true);
		
		if(error_operation != null) {
			
			m.addAttribute("message" , "Invalid / Wrong details entered ... Please enter valid credentials !!") ;
		}
		
		return "login";
		//return "page_control";
	}

	
	// Security-error / access-denied page
	@RequestMapping(value = "/access-denied")
	public String accessDeniedPage (Model m) {
		
		System.out.println("Redirecting to error.jsp page from Page Controller section .. ");
		System.out.println() ;
		
		m.addAttribute("errorTitle" , "Access Denied .... !! ") ;
		
		m.addAttribute("errorDescription" , "The page is available only for admin and not for users .... !! ") ;
		
		m.addAttribute("title" , "403 Access Denied Page ") ;
		
		return "error" ;
	}

	/*
	// Order Details page 
	@RequestMapping(value = "/cart/orderForm/{cartid}")
	public String showOrderDetailPage (@PathVariable int cartid , Model m) {
		
		
		System.out.println("Redirecting to cart.jsp page from UserOrderController of frontend Controller Package (generate order method) ....");
		System.out.println();
		
		m.addAttribute("userClickOrder" , true) ;
		m.addAttribute("title","Order") ;
		
		Cart cart = cartItemDAO.getCart(cartid) ;
		
		UserDetail userDetail = cart.getUserDetail() ;
		
		cart.setUserDetail(userDetail);
		
		UserOrder userOrder = userOrderDAO.generateOrder(cart) ;
		
		m.addAttribute("order" , userOrder) ;
		m.addAttribute("cartid" , cartid) ;
		
		return "page_control" ;

		
		
	}
*/	
	
/*	
	//Cart page 
	@RequestMapping(value = "/cart")
	public String cartPage(Model m) {
		System.out.println("Redirecting to cart.jsp page from Page Controller section .. ");
		System.out.println();

		m.addAttribute("title", "User Cart Page");
		m.addAttribute("userClickCart", true);

		return "page_control";

	}
*/


	/*
	@RequestMapping(value = "/cart/confirm/{cartid}")
	public String showConfirmOrder(@ModelAttribute UserOrder order , @PathVariable int cartid , Model m) {
		
		System.out.println("Redirecting to order.jsp from UserOrderController of frontend controller package(confirmOrder Method)");
		System.out.println();
	
		m.addAttribute("userClickThanks" , true) ;
		m.addAttribute("title" , "Thank You Page") ;
		
		System.out.println("Deleting Cart (UserrderController - showConfirmOrder");
		cartItemDAO.removeAllCartItem(cartid);
		System.out.println("Cart Deleted - UserOrderController - showConfirmOrder");
		
		return "redirect:/cart/confirm/{cartid}" ;
		
		
	}
	
*/

}
