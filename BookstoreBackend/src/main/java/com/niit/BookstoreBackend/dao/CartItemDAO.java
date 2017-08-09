package com.niit.BookstoreBackend.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.BookstoreBackend.model.Cart;
import com.niit.BookstoreBackend.model.CartItem;

@Repository(value = "cartItemDAO") // marks specific class as DAO thus clarifying its role
public class CartItemDAO {
	
	//@Autowired
	//ProductDAO productDAO ;
	
	//@Autowired
	//CartDAO cartDAO ;
	
	@Autowired // tells container to inject a dependency
	SessionFactory sessionFactory;

	public CartItemDAO(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	// adds and updates cart item
	@Transactional
	public void insertUpdateCartItem(CartItem cartItem) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(cartItem);
	}

	 
	// to remove single item from cart
	@Transactional
	public void removeCartItem(int cartItemId) {
		
		Session session = sessionFactory.getCurrentSession() ;
		CartItem cartItem = (CartItem) session.get(CartItem.class, cartItemId);
		session.delete(cartItem);
		
	}
	

	// remove all cart items
	@Transactional
	public void removeAllCartItem(int cartid) {
		
		Session session = sessionFactory.getCurrentSession() ;
		Cart cart = (Cart)session.get(Cart.class,cartid) ;
				
		List<CartItem> cartItems = cart.getCartItems() ;	
		
		for(CartItem cartItem:cartItems) {
			
			session.delete(cartItem);
			
		}
	}
	
	
	
	
	@Transactional
	public Cart getCart(int cartid) {
		Session session = sessionFactory.getCurrentSession() ;
		Cart cart = (Cart)session.get(Cart.class, cartid) ;
		return cart ;
	}
	

	

}
