package com.niit.BookstoreBackend;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.BookstoreBackend.dao.CategoryDAO;
import com.niit.BookstoreBackend.model.Category;

public class CategoryTestCase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(" ******* Flow in Category Test Case - AnnotationConfigApplicationContext ****** ");		
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();  // checks for all annotations 
		
		System.out.println(" ****** Calling Scan Method ... ****** ");
		context.scan("com.niit.BookstoreBackend");  // package scanned by anno file for annotations  ... 
		System.out.println(" ****** Scan Method called and completed succesfully ... ****** ");
		
		System.out.println();
		
		System.out.println(" ****** Calling Refresh Method ****** ");
		context.refresh(); // refreshes and searches for application test
		System.out.println(" ****** Refresh Method called and completed succesfully ... ****** ");

		System.out.println();		
		
		System.out.println(" ****** Start of CRUD Operation ****** "); // only one operation can be performed at a time .
		System.out.println();
		
		// Inserting a Category Object.
		CategoryDAO categoryDAO=(CategoryDAO)context.getBean("categoryDAO");
		
		//Insertion TestCase
		
		System.out.println(" ****** Inserting Category Details  ****** ");
		Category category=new Category();
		
		System.out.println(" ****** First category details : ****** ");
		category.setCat_name("Sample test methods");
		category.setCat_desc("Books by authors Aditi .. ");
		
		
		/*
		System.out.println(" ****** First category details : ****** ");
		category.setCat_name("Medical Thriller genre");
		category.setCat_desc("Books by authors - Robin Cook , Kelly Parsons and many more .... ");
		*/
		
		/*
		System.out.println(" ****** Second category details : ****** ");
		category.setCat_name("Romance and Tragedy genre");
		category.setCat_desc("Books by authors Chetan Bhagat , William Shakespeare and many more .... ");
		*/
		
		/*
		System.out.println(" ****** Third category details : ****** ");
		category.setCat_name("Fantasy genre");
		category.setCat_desc("Books by authors Enid Blyton , J.K. Rowling etc. .... ");
		*/
		
		/*
		System.out.println(" ****** Fourth category details : ****** ");
		category.setCat_name("Technical Books");
		category.setCat_desc("Instrumentation and IT books .... ");
		*/
		
		categoryDAO.insertUpdateCategory(category);		
		System.out.println("Category Inserted");
		
		System.out.println();
		
		System.out.println(" ****** Creating / Inserting Operation is completed ....  ****** ");
		
		System.out.println();
		
		
		//Retrieval TestCase
		/*
		System.out.println(" ****** Retrieving selected Category details : ****** ");
		
		Category category1 = categoryDAO.getCategory(3);
		System.out.println("Category Name : " + category1.getCat_name());
		System.out.println("Category Description : " + category1.getCat_desc());
		
		System.out.println(" ****** Retrieving Operation is completed ... ****** ");
				
		System.out.println();
		*/
		
		//Update the Category
		/*
		System.out.println(" ****** Updating a selected category : ****** ");
				
		Category category3 = categoryDAO.getCategory(3);
		category3.setCat_name("Bella Liptak");
		category3.setCat_desc("Author of Liptak Instrumentation book .... ");
		
		categoryDAO.insertUpdateCategory(category3);
		System.out.println("Category is Updated");
		
		System.out.println();
		
		System.out.println(" ****** Update Operation completed .... ****** ");
		
		System.out.println();
		*/
		
		//Deletion TestCase
		/*
		System.out.println(" ****** Deleting selected category ****** ");
		Category category2 = categoryDAO.getCategory(4);
		categoryDAO.deleteCategory(category2);
		System.out.println("Category is deleted");
				
		System.out.println();
				
		System.out.println(" ****** Delete Operation is completed .... ****** ");
				
		System.out.println();
		*/
				
		//Retrieving the Data // comment while performing retrieval and update operation
		
		System.out.println(" ****** Retrieving the category data : ****** ");
		
		List<Category> list=categoryDAO.getCategoryDetails();
		
		for(Category categoryx:list)
		{
			System.out.println(categoryx.getCatid() + " : " + categoryx.getCat_name() + " : " + categoryx.getCat_desc());
		}
		
		System.out.println();
		
		System.out.println(" ****** End of CRUD Operation ****** ");
	}

}