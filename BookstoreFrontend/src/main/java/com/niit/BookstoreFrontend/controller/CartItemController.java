package com.niit.BookstoreFrontend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

//import com.niit.BookstoreBackend.dao.CartDAO;
import com.niit.BookstoreBackend.dao.CartItemDAO;
import com.niit.BookstoreBackend.dao.ProductDAO;
import com.niit.BookstoreBackend.dao.UserDetailDAO;
import com.niit.BookstoreBackend.model.Cart;
import com.niit.BookstoreBackend.model.CartItem;
import com.niit.BookstoreBackend.model.Product;
import com.niit.BookstoreBackend.model.UserDetail;

@Controller

public class CartItemController {

	@Autowired
	ProductDAO productDAO ;
	
//	@Autowired 
//	CartDAO cartDAO ;
	
	@Autowired
	CartItemDAO cartItemDAO ;
	
	@Autowired
	UserDetailDAO userDetailDAO ;
	
	public CartItemController() {
		
		System.out.println("Default Constructor of Cart Controller of frontend controller package ....");
		System.out.println();
	
	}
	
	// get Cart
	@RequestMapping(value = "/cart/getCart") 
	public String showCart(Model m) {
		
		System.out.println("Redirecting to cart.jsp from CartItem Controller section (getCart method) .... ");
		System.out.println();
		
		m.addAttribute("title", "User Cart Page");
		m.addAttribute("userClickCart", true);

		System.out.println("Getting user name ");

		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal() ;	
		
		System.out.println("UserName = " + user);
		
		String username = user.getUsername() ;
		
		UserDetail userDetail = userDetailDAO.getUserByUsername(username) ;
		
		Cart cart = userDetail.getCart() ;
		
		m.addAttribute("cart" , cart) ;
		
		return "page_control" ;
	}
	
	
	
	// Add products to Cart
	@RequestMapping(value = "/cart/addToCart/{prodid}/product")
	public String addCartItem (@PathVariable int prodid , @RequestParam Integer units , Model m ) {
		
		System.out.println("Redirecting to singleProduct.jsp from CartItem Controller section (addCart method) .... ");
		System.out.println();
		
		//m.addAttribute("userClickCart", true);
		//m.addAttribute("title", "User Cart Page");
		
		Product product = productDAO.getProduct(prodid) ;
		
		// To get userDetails , get principal object from security context holder
		System.out.println("SecurityContextHolder.getContext().getAuthentication().getPrincipal()");
		
		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal() ;	
		
		String username = user.getUsername() ;
		
		System.out.println("name_id :" + user.getUsername());
		System.out.println();
		
		UserDetail userDetail = userDetailDAO.getUserByUsername(username) ;
	
		Cart cart = userDetail.getCart();
		
		List<CartItem> cartItems = cart.getCartItems() ; // fetches collection of cart items from CartItem table 
		
		System.out.println("Line 103 of CartItem Controller : " + cart.getCartItems().size());
		
	//	Product product = productDAO.getProduct(prodid) ;
		
		// check if purchased product is already existing in cart item table
		//for(int i = 0; i < cartItems.size(); i++) {
			
		for(CartItem cartItem:cartItems) {
			
			System.out.println("ProductId in database table : " + cartItem.getProduct().getProdid());
			
			System.out.println("Product Id : " + prodid);
			
			//CartItem cartItem = cartItems.get(i) ; // returns the element at the specified position
			
		//	if(product.getProdid() == cartItem.getProduct().getProdid()) {
				
			if(cartItem.getProduct().getProdid() == prodid) {
							
				System.out.println("Checking ids' of tables");
				System.out.println();
				
				cartItem.setCartqty(units);
			
				cartItem.setUnitPrice(product.getProdprice() * units);
				
			//	System.out.println("Price : 125");
				
				cartItemDAO.insertUpdateCartItem(cartItem);
				
				return "redirect:/cart/getCart" ;
				
			}
			
		}
		
		CartItem cartItem = new CartItem() ;
		
		System.out.println("Getting Cart Quantity .... ");
		cartItem.setCartqty(units) ;
		
		System.out.println("Cart Quantity = " + cartItem.getCartqty());
		
		System.out.println();
		
		cartItem.setProduct(product); // product id column in cartitem table
		
	//	cartItem.setunitPrice(product.getProdprice() * 1);
		
		cartItem.setUnitPrice(product.getProdprice() * units);
		
		System.out.println("Total price of purchased products = " + cartItem.getUnitPrice());
		
		cartItem.setCart(cart); // cartid column in cartitem table
		
		cartItemDAO.insertUpdateCartItem(cartItem);
	
		//	System.out.println("Price of individual product quantity purchased =  " + cartItem.getunitPrice());
		
		
		
		return "redirect:/cart/getCart" ;
		
	}
	

	
	// remove single product from cart 
	@RequestMapping("/cart/deleteCartItem/{cartItemId}")
	public String deleteCartItem(@PathVariable int cartItemId) {
		
		System.out.println("Redirecting to cart.jsp from CartItem Controller section (deleteCartItem method) .... ");
		System.out.println();
		
		cartItemDAO.removeCartItem(cartItemId);
		
		return "redirect:/cart/getCart" ;
	}
	
	
	// remove entire cart
	@RequestMapping("/cart/deleteCart/{cartid}")
	public String deleteAllCartItems(@PathVariable("cartid") int cartid) {
		
		System.out.println("Redirecting to cart.jsp from CartItem Controller section (deleteAllCartItem method) .... ");
		System.out.println();
		
		cartItemDAO.removeAllCartItem(cartid);
		
		return "redirect:/cart/getCart" ;
	}
	
}
