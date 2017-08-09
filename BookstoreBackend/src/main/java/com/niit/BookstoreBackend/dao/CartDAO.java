/*

package com.niit.BookstoreBackend.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.BookstoreBackend.model.Cart;

@Repository(value = "cartDAO") // marks specific class as DAO thus clarifying its role
public class CartDAO {

	@Autowired
	UserDetailDAO userDetailDAO ;
	
	@Autowired
	CartItemDAO cartItemDAO ;
	
	@Autowired // tells container to inject a dependency
	SessionFactory sessionFactory;

	public CartDAO(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	
	@Transactional
	public void insertUpdateCart(Cart cart) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(cart);
	}

	
	public Cart getCart(int cartid) {

		Session session = sessionFactory.openSession();
		Cart cart = (Cart) session.get(Cart.class, cartid);
		session.close();
		return cart;
	}

	
	@Transactional
	public void deleteCart(Cart cart) {
		sessionFactory.getCurrentSession().delete(cart);
	}
*/
	
	/*
	public List<Category> getCategoryDetails() {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from Category");
		List<Category> list = query.list();
		session.close();
		return list;
	}
	 */
	
	/*
	public List<Cart> getCartDetails() {
		Session session = sessionFactory.openSession() ;
		Query query = session.createQuery("from Cart") ;
		List<Cart> list = query.list();
		session.close();
		return list ;
	}
	
	/*
	public Cart getByUserName(int userid) {
		Session session = sessionFactory.openSession() ;
		Query query = session.createQuery("from Cart WHERE userid = :userid").setParameter("userid" , userid) ;
		List<Cart> userlist = (List<Cart>)query.list();
		return null ;
	}
	
}

*/