package com.niit.BookstoreBackend;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.BookstoreBackend.dao.SupplierDAO;
import com.niit.BookstoreBackend.model.Supplier;

public class SupplierTestCase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(" ******* Flow in Supplier Test Case - AnnotationConfigApplicationContext ****** ");		
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
		
		// Inserting a Supplier Object.
		SupplierDAO supplierDAO=(SupplierDAO)context.getBean("supplierDAO");
		
		//Insertion TestCase
		Supplier supplier = new Supplier() ;
		
		System.out.println(" ****** Inserting Supplier Details  ****** ");
		
		
		System.out.println(" ****** First supplier details : ****** ");
		supplier.setSup_name("India House");
		supplier.setSup_addr(" Mumbai ");
		
		
		/*
		System.out.println(" ****** Second supplier details : ****** ");
		supplier.setSup_name("Diamond Comics");
		supplier.setSup_addr(" Banglore ");
		*/
		
		/*
		System.out.println(" ****** Third supplier details : ****** ");
		supplier.setSup_name("Logista");
		supplier.setSup_addr(" Spain ");
		*/
		
		/*
		System.out.println(" ****** Fourth supplier details : ****** ");
		supplier.setSup_name("Bertrams");
		supplier.setSup_addr(" United Kindom ");
		*/
				
		supplierDAO.insertUpdateSupplier(supplier);		
		System.out.println("Supplier Inserted");
		
		System.out.println();
		
		System.out.println(" ****** Creating / Inserting Operation is completed ....  ****** ");
		
		System.out.println();
		
		
		//Retrieval TestCase
		/*
		System.out.println(" ****** Retrieving selected Supplier details : ****** ");
		
		Supplier supplier1 = supplierDAO.getSupplier(4) ;
		System.out.println("Supplier Name : " + supplier1.getSup_name());
		System.out.println("Supplier Address : " + supplier1.getSup_addr());
		
		System.out.println();
		
		System.out.println(" ****** Retrieving Operation is completed ... ****** ");
		
		System.out.println();
		*/
		
		//Update the Supplier
		/*
		System.out.println(" ****** Updating a selected supplier : ****** ");
		
		Supplier supplier3 = supplierDAO.getSupplier(3);
		supplier3.setSup_name("Miranda House");
		supplier3.setSup_addr("Pune");
		
		supplierDAO.insertUpdateSupplier(supplier3);
		
		System.out.println("The Supplier is  Updated");
						
		System.out.println();
					
		System.out.println(" ****** Update Operation completed .... ****** ");
						
		System.out.println();
		*/

		//Deletion TestCase
		/*
		System.out.println(" ****** Deleting selected supplier ****** ");
		Supplier supplier2 = supplierDAO.getSupplier(5) ;
		supplierDAO.deleteSupplier(supplier2);
		System.out.println("The Supplier is deleted");
		
		System.out.println();
		
		System.out.println(" ****** Delete Operation is completed .... ****** ");
		
		System.out.println();
		*/
		
		//Retrieving the Data // comment while performing retrieval and update operation
		
		System.out.println(" ****** Retrieving the supplier data : ****** ");
		
		List<Supplier> list=supplierDAO.getSupplierDetails();
		
		for(Supplier supplierx:list)
		{
			System.out.println(supplierx.getSupid() + " : " + supplierx.getSup_name() + " : " + supplierx.getSup_addr());
		}
		
		System.out.println();
		
		System.out.println(" ****** End of CRUD Operation ****** ");
		
	}

}