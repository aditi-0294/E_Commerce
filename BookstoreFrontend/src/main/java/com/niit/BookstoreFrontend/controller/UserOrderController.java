package com.niit.BookstoreFrontend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.BookstoreBackend.dao.CartItemDAO;
import com.niit.BookstoreBackend.dao.UserDetailDAO;
import com.niit.BookstoreBackend.dao.UserOrderDAO;
import com.niit.BookstoreBackend.model.Cart;
import com.niit.BookstoreBackend.model.UserDetail;
import com.niit.BookstoreBackend.model.UserOrder;

@Controller
public class UserOrderController {

	@Autowired
	CartItemDAO cartItemDAO ;
	
	@Autowired
	UserOrderDAO userOrderDAO ;
	
	@Autowired
	UserDetailDAO userDetailDAO ;
	
	public UserOrderController() {
		
		System.out.println("Default Constructor of Cart Controller of frontend controller package ....");
		System.out.println();
		
	}
	
	
	@RequestMapping(value = "/cart/orderForm/{cartid}")
	public String generateOrder(@PathVariable int cartid , Model m) {
		
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

	
	
	@RequestMapping(value = "/cart/confirm/{cartid}")
	public String showConfirmOrder(@ModelAttribute UserOrder order , @PathVariable int cartid , Model m) {
		
		System.out.println("Redirecting to order.jsp from UserOrderController of frontend controller package(confirmOrder Method)");
		System.out.println();
	
		m.addAttribute("userClickThanks" , true) ;
		m.addAttribute("title" , "Thank You Page") ;
		
		System.out.println("Deleting Cart (UserrderController - showConfirmOrder");
		cartItemDAO.removeAllCartItem(cartid);
		System.out.println("Cart Deleted - UserOrderController - showConfirmOrder");
		
		return "page_control" ;
		
		
	}
	
	
/*	
	//@Value("/order")
	@RequestMapping(value = "/cart/confirm/{cartid}" )
	public String showConfirmOrder(@PathVariable Integer cartid , Model m) {
		
		System.out.println("Redirecting to order.jsp from UserOrderController of frontend controller package(confirmOrder Method)");
		System.out.println();
	
		//m.addAttribute("userClickThanks" , true) ;
		//m.addAttribute("title" , "Thank You Page") ;
		
		System.out.println("Deleting Cart (UserrderController - showConfirmOrder");
		cartItemDAO.removeAllCartItem(cartid);
		System.out.println("Cart Deleted - UserOrderController - showConfirmOrder");
		
		return "page_control" ;
		
		
	}
	
*/	
	
}
