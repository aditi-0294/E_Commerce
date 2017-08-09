package com.niit.BookstoreBackend.dao;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.BookstoreBackend.model.Cart;
import com.niit.BookstoreBackend.model.UserDetail;

@Repository(value = "userDetailDAO") // marks specific class as DAO thus clarifying its' role
public class UserDetailDAO {
	
	//@Autowired
	//CartDAO cartDAO ;
	
	@Autowired // tells container to inject a dependency
	SessionFactory sessionFactory;
	
	public UserDetailDAO(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	
	@Transactional
	public void insertUpdateUserDetail(UserDetail userDetail)
	{
		Session session=sessionFactory.getCurrentSession();
		userDetail.setRole_enabled(true);
		userDetail.setRole("User");
		Cart cart = new Cart() ;
		cart.setUserDetail(userDetail);
		userDetail.setCart(cart);
		session.saveOrUpdate(userDetail);
	}
	
	@Transactional
	public UserDetail getUserDetail(String username) {
		
		//Serializable username = null ; // convert its state to compact form
		Session session=sessionFactory.openSession();
		//Transaction tx = session.beginTransaction() ;
		
		UserDetail userDetail =(UserDetail)session.get(UserDetail.class,"username");
		
		//try {
			//session.save(userDetail);
			//session.beginTransaction();
            //session.save(userDetail);
            //session.getTransaction().commit();
			//session.flush(); // flush a batch of inserts and release memory
			//Session.clear();
			//tx.commit() ; //commit the transaction 
			
		session.close();
			
		//}
		//catch(Exception e) {
			//System.out.println("Exception Arised : " + e);
			//e.printStackTrace();
	//	}
		
		return userDetail;
		
	}
	
	
	@Transactional
	public void deleteUserDetail(UserDetail userDetail) {
		sessionFactory.getCurrentSession().delete(userDetail);
	}
	
	
	public List<UserDetail> getUserDetailInfo()
	{
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from UserDetail");
		List<UserDetail> list=query.list();
		
		//try {
		//session.save(getUserDetailInfo()) ;
			//session.beginTransaction();
            //session.save(query);
            //session.getTransaction().commit();
			//session.flush();
		
		session.close();
	  //}
		
		//catch(Exception e) {
			//System.out.println("Exception Arised : " + e);
			//e.printStackTrace();
		//}
		
		return list;
		
 }

	
	
	// get userDetail by username
	@Transactional
	public UserDetail getUserByUsername(String username) {
	
		String selectQuery = "FROM UserDetail WHERE username = :username" ;
		
		try{
		return sessionFactory.getCurrentSession().createQuery(selectQuery , UserDetail.class )
									.setParameter("username" ,  username)
									.getSingleResult() ;
		
	
		}

		catch(Exception ex) {
			
			return null ;
			
		}
		
	//	List<UserDetail> userlist = new ArrayList() ;
    //	UserDetail userlist = (UserDetail) query.list() ;
	//	session.close();
	//	return userlist;
		
	}
	
	
}