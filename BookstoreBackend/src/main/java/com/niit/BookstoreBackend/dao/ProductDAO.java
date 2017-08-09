package com.niit.BookstoreBackend.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.BookstoreBackend.model.Product;

@Repository(value = "productDAO") // marks specific class as DAO thus clarifying its' role


public class ProductDAO {
	
	@Autowired // tells container to inject a dependency
	SessionFactory sessionFactory;
	
	public ProductDAO(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	
	@Transactional
	public void insertUpdateProduct(Product product)
	{
		Session session=sessionFactory.getCurrentSession();
		session.saveOrUpdate(product);
	}
	
	public Product getProduct(int prodid) {
		
		Session session=sessionFactory.openSession();
		Product product = (Product)session.get(Product.class,prodid);
		session.close();
		return product;
	}
	
	@Transactional
	public void deleteProduct(Product product) {
		sessionFactory.getCurrentSession().delete(product);
	}
	
	public List<Product> getProductDetails() {
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Product");
		List<Product> list=query.list();
		session.close();
		return list;
	}
	
	public List<Product> getProductsByCategory(int catid) {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from Product WHERE catid = :catid" , Product.class).setParameter("catid" , catid) ;
		List<Product> list = query.list();
		session.close();
		return list ;
	}
	
}