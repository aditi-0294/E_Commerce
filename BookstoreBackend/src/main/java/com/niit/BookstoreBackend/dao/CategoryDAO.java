package com.niit.BookstoreBackend.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.BookstoreBackend.model.Category;

@Repository(value = "categoryDAO") // marks specific class as DAO thus clarifying its' role
public class CategoryDAO {
	
	@Autowired // tells container to inject a dependency
	SessionFactory sessionFactory;

	public CategoryDAO(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	
	@Transactional
	public void insertUpdateCategory(Category category) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(category);
	}


	
	public Category getCategory(int catid) {

		Session session = sessionFactory.openSession();
		Category category = (Category) session.get(Category.class, catid);
		session.close();
		return category;
	}

	
	@Transactional
	public void deleteCategory(Category category) {
		sessionFactory.getCurrentSession().delete(category);
	}

	
	public List<Category> getCategoryDetails() {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from Category");
		List<Category> list = query.list();
		session.close();
		return list;
	}

	
	public List<Category> list() {
		
		return null ;
	}

}