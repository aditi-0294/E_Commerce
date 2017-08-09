/*

package com.niit.BookstoreBackend;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.BookstoreBackend.dao.CartDAO;
import com.niit.BookstoreBackend.dao.CartItemDAO;
import com.niit.BookstoreBackend.dao.ProductDAO;
import com.niit.BookstoreBackend.model.Cart;
import com.niit.BookstoreBackend.model.Product;

public class CartItemTestCase {
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(" ******* Flow in CartItem Test Case - AnnotationConfigApplicationContext ****** ");		
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
		
		// Inserting a cart detail Object.
		CartItemDAO cartItemDAO = (CartItemDAO)context.getBean("cartItemDAO");
		CartDAO cartDAO = (CartDAO)context.getBean("cartDAO");
		ProductDAO productDAO = (ProductDAO)context.getBean("productDAO") ;
		
		//Insertion TestCase
		CartItem cartItem = new CartItem() ;
		Cart cart = new Cart() ;
		Product product = new Product() ;
		
		System.out.println(" ****** Inserting CartItem Information  ****** ");
		
		System.out.println(" ****** First cart details : ****** ");
		//cartItem.setCartItemId(0);
		cartItem.setCartqty(0);
		cartItem.setUnit_price(0);
		//cartItem.setProduct(product);
		cartItem.getProduct() ;
		cartItem.getCart() ;
		//cartItem.setCart(cart);
				
		cartItemDAO.insertUpdateCartItem(cartItem);
		
		System.out.println("Details of cartItem inserted");
		
		System.out.println();
		
		System.out.println(" ****** Creating / Inserting Operation is completed ....  ****** ");
		
		System.out.println();
		
	}	
		
		
		


}

*/