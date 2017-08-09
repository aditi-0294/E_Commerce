package com.niit.BookstoreBackend;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.BookstoreBackend.dao.ProductDAO;
import com.niit.BookstoreBackend.model.Product;

public class ProductTestCase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

		System.out.println(" ******* Flow in Product Test Case - AnnotationConfigApplicationContext ****** ");		
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();  // checks for all annotations 
		
		System.out.println(" ****** Calling Scan Method ... ****** ");
		context.scan("com.niit.BookstoreBackend");  // package scanned by anno file for annotations  ... 
		System.out.println(" ****** Scan Method called and completed succesfully ... ****** ");
		
		System.out.println();
		
		System.out.println(" ****** Calling Refresh Method ****** ");
		context.refresh(); // refreshes and searches for application test
		System.out.println(" ****** Refresh Method called and completed succesfully ... ****** ");

		System.out.println();		
		
		System.out.println(" ****** Start of CRUD Operation ****** ");  // only one operation can be performed at a time .
		System.out.println();
		
		// Inserting a Product Object.
		ProductDAO productDAO=(ProductDAO)context.getBean("productDAO");
		
		//Insertion TestCase
		Product product = new Product() ;
		
		System.out.println(" ****** Inserting Product Details  ****** ");
		
		System.out.println(" ****** First product details : ****** ");
		product.setProd_name("Fever");
		product.setProd_desc("Medical Thriller book by Robin cook");
		product.setProdqty(1);
		product.setProdprice(130);
		product.setCatid(1);
		product.setSupid(2);
		
		
		/*
		System.out.println(" ****** Second product details : ****** ");
		product.setProd_name("Pride and Prejudice");
		product.setProd_desc("Romance genre book by Jane Austen");
		product.setProdqty(4);
		product.setProdprice(95);
		product.setCatid(2);
		product.setSupid(1);
		*/
		
		/*
		System.out.println(" ****** Third product details : ****** ");
		product.setProd_name("Harry Potter Series");
		product.setProd_desc("Fictional book series by J.K Rowling ");
		product.setProdqty(2);
		product.setProdprice(2460);
		product.setCatid(4);
		product.setSupid(3);
		*/
		
		/*	
		System.out.println(" ****** Fourth product details : ****** ");
		product.setProd_name("Process Control");
		product.setProd_desc("Instrumentation Engineering bible by Bella Liptak ");
		product.setProdqty(2);
		product.setProdprice(11000);
		product.setCatid(2);
		product.setSupid(2);
		*/
		
		productDAO.insertUpdateProduct(product);
		System.out.println("Product inserted");
		
		System.out.println();
		
		System.out.println(" ****** Creating / Inserting Operation is completed ....  ****** ");
		
		System.out.println();
		
		
		//Retrieval TestCase
		/*
		System.out.println(" ****** Retrieving selected Product details : ****** ");
		
		Product product1 = productDAO.getProduct(2) ;
		
		System.out.println("Product Name : " + product1.getProd_name());
		System.out.println("Product Description : " + product1.getProd_desc());
		System.out.println("Product Quantity : " + product1.getProdqty());
		System.out.println("Product Price : " + product1.getProdprice());
		System.out.println("Category Id. : " + product1.getCatid());
		System.out.println("Supplier Id. : " + product1.getSupid());
	
		System.out.println(" ****** Retrieving Operation is completed ... ****** ");
		
		System.out.println();
		*/
		
				
		//Update the Product
		/*
		System.out.println(" ****** Updating a selected product : ****** ");
		
		Product product3 = productDAO.getProduct(2) ;
		product3.setProd_name("Romeo and Juliet");
		product3.setProd_desc("Drama book by William Shakespeare");
		product3.setProdqty(2);
		product3.setProdprice(900);
		product3.setCatid(2);
		product3.setSupid(2);
		
		productDAO.insertUpdateProduct(product3);
		
		System.out.println("The Product is  Updated");
		
		System.out.println();
		
		System.out.println(" ****** Update Operation completed .... ****** ");
		
		System.out.println();
		*/

		//Deletion TestCase
		/*
		System.out.println(" ****** Deleting selected Product ****** ");
			  	
		Product product2 = productDAO.getProduct(1) ;
		productDAO.deleteProduct(product2);
		System.out.println("The Product is deleted");
				
		System.out.println();
				
		System.out.println(" ****** Delete Operation is completed .... ****** ");
				
		System.out.println();
		*/
				

		//Retrieving the Data // comment while performing retrieval and update operation
		/*
		System.out.println(" ****** Retrieving the product data : ****** ");
		
		List<Product> list=productDAO.getProductDetails();
		
		for(Product productx : list)
		{
			System.out.println(productx.getProd_name() + " : " + productx.getProd_desc() + " : " + productx.getProdqty() + " : " + productx.getProdprice() + " : " + productx.getCatid() + " : " + productx.getSupid() + " : " );
		}
		*/
		
		// Get product by category
		
		System.out.println(" ****** Retrieving products according to category : ****** ");
		
		List<Product> list = productDAO.getProductsByCategory(1) ;
		
		for(Product productx : list)
		{
			System.out.println(productx.getProdid() + " : "+ productx.getProd_name() + " : " + productx.getProd_desc() + " : " + productx.getProdqty() + " : " + productx.getProdprice() + " : " + productx.getCatid() + " : " + productx.getSupid() + " : " );
		}
		
		System.out.println();
	
		System.out.println(" ****** End of CRUD Operation ****** ");
		
		
	}

}