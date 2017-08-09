package com.niit.BookstoreBackend;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

//import com.niit.BookstoreBackend.dao.CartDAO;
import com.niit.BookstoreBackend.dao.UserDetailDAO;
import com.niit.BookstoreBackend.model.Cart;
import com.niit.BookstoreBackend.model.UserDetail;

public class UserDetailTestCase {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(" ******* Flow in UserDetail Test Case - AnnotationConfigApplicationContext ****** ");		
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
		
		// Inserting a UserDetail Object.
		UserDetailDAO userDetailDAO = (UserDetailDAO)context.getBean("userDetailDAO");
		//CartDAO cartDAO = (CartDAO)context.getBean("cartDAO") ;
		
		//Insertion TestCase
		UserDetail userDetail = new UserDetail() ;
		Cart cart = new Cart() ;
		
		System.out.println(" ****** Inserting UserDetail Information  ****** ");
		
		
		System.out.println(" ****** First user details : ****** ");
		//userDetail.setUserid(0);
		userDetail.setCustomer_name("Admin");
		userDetail.setUsername("admin"); 
		userDetail.setPassword("admin"); 
		userDetail.setRole("Admin"); 
		userDetail.setRole_enabled(true);
		userDetail.setEmail("admin@rediffmail.com"); 
		userDetail.setAddress("Mumbai");
		userDetail.setMobile_number("1234567890"); 
		userDetail.setCart(cart); 
		cart.setUserDetail(userDetail);
		
		/*
		System.out.println(" ****** Second user details : ****** ");
		userDetail.setCustomer_name("User");
		userDetail.setUsername("user");
		userDetail.setPassword("user");
		userDetail.setRole("User");
		userDetail.setRole_enabled(true);
		userDetail.setEmail("user@yahoo.co.in");
		userDetail.setAddress("Pune");
		userDetail.setMobile_num("1234567890");
		userDetail.setCart(cart); 
		cart.setUserDetail(userDetail);
		*/
		
		/*
		System.out.println(" ****** Third user details : ****** ");
		userDetail.setCustomer_name("Prince");
		userDetail.setUsername("prnce");
		userDetail.setPassword("prince");
		userDetail.setRole("User");
		userDetail.setenabled(true);
		userDetail.setEmail("a.aditi0294@rediffmail.com");
		userDetail.setAddress("Banglore");
		userDetail.setMobile_num("1234567890");
		*/
		
		/*
		System.out.println(" ****** Fourth user details : ****** ");
		userDetail.setCustomer_name("Brussie");
		userDetail.setUsername("bruce");
		userDetail.setPassword("bruce");
		userDetail.setRole("User");
		userDetail.setenabled(true);
		userDetail.setEmail("ditisa500@yahoo.co.in");
		userDetail.setAddress("goa");
		userDetail.setMobile_num("XXXXXXXXXX");
		*/
				
		userDetailDAO.insertUpdateUserDetail(userDetail);
		
		System.out.println("Details of user inserted");
		
		System.out.println();
		
		System.out.println(" ****** Creating / Inserting Operation is completed ....  ****** ");
		
		System.out.println();
		
		
		//Retrieval TestCase
		/*
		System.out.println(" ****** Retrieving selected details of user : ****** ");
	
		UserDetail userDetail1 = userDetailDAO.getUserDetail("Adi") ;
		
		System.out.println("Customer Name : " + userDetail1.getCustomer_name());
		System.out.println("User_name : " + userDetail1.getUsername());
		System.out.println("Password : " + userDetail1.getPassword());
		System.out.println("Role as Admin / User : " + userDetail1.getRole());
		System.out.println("Enable role : " + userDetail1.isenabled());
		System.out.println("Email Id. : " + userDetail1.getEmail());
		System.out.println("Address : " + userDetail1.getAddress());
		System.out.println("Mobile number : " + userDetail1.getMobile_num());
		
		System.out.println(" ****** Retrieving Operation is completed ... ****** ");
		
		System.out.println();
		*/
		
		
		//Update the UserDetail 
		/*
		System.out.println(" ****** Updating a selected user : ****** ");
				
		UserDetail userDetail3 = userDetailDAO.getUserDetail("Sdt");
		userDetail3.setCustomer_name("Aditi");
		userDetail3.setUsername("asd");
		userDetail3.setPassword("asd");
		userDetail3.setRole("Supplier");
		userDetail3.setenabled(false);
		userDetail3.setEmail("ditisa500@yahoo.co.in");
		userDetail3.setAddress("brussel");
		userDetail3.setMobile_num("XXXXXXXXXX");
		
		userDetailDAO.insertUpdateUserDetail(userDetail3);
		
		System.out.println("Details of a particular user is  Updated");
				
		System.out.println();
				
		System.out.println(" ****** Update Operation completed .... ****** ");
				
		System.out.println();
		*/
		
		//Deletion TestCase
		/*
		System.out.println(" ****** Deleting selected User Details :  ****** ");
	  	
	  	UserDetail userDetail2 = userDetailDAO.getUserDetail("Sdt") ;
		userDetailDAO.deleteUserDetail(userDetail2);
		System.out.println("Details of the user is deleted");
		
		System.out.println();
		
		System.out.println(" ****** Delete Operation is completed .... ****** ");
		
		System.out.println();
		*/
				
		
		//Retrieving the Data // comment while performing retrieval and update  operation
		/*
		System.out.println(" ****** Retrieving the user details : ****** ");
		
		List<UserDetail> list = userDetailDAO.getUserDetailInfo();
		
		for(UserDetail userDetailx : list)
		{
			System.out.println(userDetailx.getCustomer_name() + " : " + userDetailx.getUsername() + " : " + 
					userDetailx.getPassword() + " : " + userDetailx.getRole() + " : " + userDetailx.isRole_enabled() +
					" : " + userDetailx.getEmail() + " : " + userDetailx.getAddress() + " : " + 
					userDetailx.getMobile_num() + " : " );
		}
		
		System.out.println();
		*/
		// End of CRUD Operation 		
		
	}

}