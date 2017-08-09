package com.niit.BookstoreBackend.dao;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.BookstoreBackend.model.Cart;
import com.niit.BookstoreBackend.model.CartItem;
import com.niit.BookstoreBackend.model.UserDetail;
import com.niit.BookstoreBackend.model.UserOrder;

@Repository(value = "userOrderDAO")
public class UserOrderDAO {


	@Autowired
	CartItemDAO cartItemDAO ;
	
	@Autowired
	SessionFactory sessionFactory ;
	
	public UserOrderDAO(SessionFactory sessionFactory) {
		
		this.sessionFactory = sessionFactory ;
		
	}
	
	
	@Transactional
	public UserOrder generateOrder(Cart cart) { // since cart table contains CartItems info and CartItems table contains UserDetail info
		
		Session session = sessionFactory.getCurrentSession() ;
		
		List<CartItem> cartItem = cart.getCartItems() ;
		
		double grandTotal = 0 ;
		
		for(CartItem cartItemx:cartItem) {
			
			grandTotal += cartItemx.getUnitPrice() ;
			
		}
		
		cart.setGrandTotal(grandTotal);

		UserDetail userDetail = cart.getUserDetail() ;
		
		UserOrder userOrder = new UserOrder() ;
		
		userOrder.setOrderDate(new Date());
		
		userOrder.setCart(cart);
		
		userOrder.setUserDetail(userDetail);
		
		session.saveOrUpdate(userOrder);
		
		return userOrder ;
		
	}
	
}
