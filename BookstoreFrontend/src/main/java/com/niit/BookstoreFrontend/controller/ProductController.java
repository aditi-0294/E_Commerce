package com.niit.BookstoreFrontend.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.niit.BookstoreBackend.dao.CategoryDAO;
import com.niit.BookstoreBackend.dao.ProductDAO;
import com.niit.BookstoreBackend.dao.SupplierDAO;
import com.niit.BookstoreBackend.model.Category;
import com.niit.BookstoreBackend.model.Product;
import com.niit.BookstoreBackend.model.Supplier;
//import com.niit.BookstoreFrontend.utils.ProductFileUpload;
//import com.niit.BookstoreFrontend.util.FileUploadUtility;

@Controller
@RequestMapping("/manage")
public class ProductController {

	
	@Autowired
	CategoryDAO categoryDAO ;

	@Autowired
	ProductDAO productDAO ;
	
	@Autowired
	SupplierDAO supplierDAO ;
	
	
	public ProductController() {
		
		System.out.println("Default Constructor of Product Controller of frontend controller package ....");
		System.out.println();
	}

	
	// shows products to be managed
	@RequestMapping(value = "/products" , method = RequestMethod.GET)
	public String showManageProducts(@RequestParam(name = "operation" , required = false ) String operation , Model m ) {
		
		System.out.println("Redirecting to manageProducts.jsp from Product Controller section (showManageProducts method) .... ");
		System.out.println();
		
		m.addAttribute("userClickManageProducts" , true) ;
		
		m.addAttribute("title" , "Manage Products Page") ;
	
		Product newProduct = new Product() ;
		
		// set few of the fields
		// newProduct.setSupid(0);
		
		m.addAttribute("product" , newProduct) ; // manageProducts.jsp ka modelAttribute name 
		
		if(operation != null) {
			
			if(operation.equals("product")) {
				
				m.addAttribute("message" , "Product submitted successfully !") ;
			}
		}
		
		return "page_control" ;
	}
	
	
	
	//handling product submission 
	@RequestMapping(value = "/products" , method = RequestMethod.POST)
	public String handleProductSubmission(@Valid @ModelAttribute("product") Product mProduct , BindingResult result , HttpServletRequest request , Model m) { // after product submission - store into database and then redirect it to another url
		
		System.out.println("Redirecting to manageProducts.jsp from Product Controller section (handleProductSubmission method) .... ");
		System.out.println();
		
		// check if there are any errors 
		if(result.hasErrors()) {
			
			m.addAttribute("userClickManageProducts" , true) ;
			m.addAttribute("title" , "Manage Products Page") ;
			m.addAttribute("message" , "Validation failed for product submission !") ;
			
			return "page_control" ; // incase redirect method is used then error message will not be displayed .
		}
		
		// Create a new product record to store these product 
	//	if(mProduct.getProdid() == 0) {
			
			
			
	//	}
		
		productDAO.insertUpdateProduct(mProduct);
		
		// Image storing :
		System.out.println();
		
		System.out.println("Image storing starts");
		System.out.println();
		System.out.println();
		
		String img_path = "E:\\NIIT\\github_ECommerce\\E_Commerce\\BookstoreFrontend\\src\\main\\webapp\\resources\\images\\" ; // project location
		
		String file_info = img_path + mProduct.getCode() + ".jpg" ; // format in which file will be stored (eg.: ..../images/UID_code.jpg)
		
		File file = new File(file_info) ; // creates a new instance in memory of file path . If path exists , no new instance is created .
		
		MultipartFile file_data = mProduct.getP_image() ; // uploaded file received in multipart request
		
		// if file is not empty
		if(!file_data.isEmpty()) {
			
			try {
				byte buff[] = file_data.getBytes() ; // encodes a given String into a sequence of bytes and returns an array of bytes
				
				System.out.println();
				System.out.println("Length of file size in bytes :" + buff.length); 
				System.out.println();
				
				FileOutputStream fos = new FileOutputStream(file) ; // write data (streams of raw bytes - image data) to a file
				BufferedOutputStream bos = new BufferedOutputStream(fos) ; // for converting binary data( bytes ) to characters and back
				bos.write(buff); // writes output to file
				
			}
			
			catch(Exception e) {
				
				System.out.println("Exception Arised in file upload !!!! : " + e);
			}
			
		}
		
		
		// if file is empty
		else {
			
			System.out.println("File uploading problem !!!! .... ");
			
		}
		
		System.out.println("Done - Image stored in folder !!!!!! ..... ");
		
		/*
		// image upload
		if(!mProduct.getP_image().getOriginalFilename().equals("")) { // filename not equals to an empty string so file element (image file) is available for upload
		
		//	FileUploadUtility.uploadFile(request , mProduct.getP_image() , mProduct.getCode()) ; 
			
			ProductFileUpload.uploadFile(request, mProduct.getP_image(), mProduct.getCode());
			
			/* first parameter - HttpServlet Request object (request) - to get the real path
			 * second parameter - multipart file - available in p_image file field
			 * third parameter - // code
			 */
			
		//}
		
		return "redirect:/manage/products?operation=product" ; // passes message (in the form of query string ) from one url to another url
	}
	
	
	
	// return categories for all request mapping ( for all product )
	@ModelAttribute("category") // links with manageProducts.jsp ka items value
	public List<Category> getCategory() {

		System.out.println("Redirecting to manageProducts.jsp from Product Controller section (getCategory method) .... ");
		System.out.println();
		
		return categoryDAO.getCategoryDetails() ; 
	}

	

	// return suppliers for all request mapping ( for all product )
	@ModelAttribute("supplier") // links with manageProducts.jsp ka items value
	public List<Supplier> getSupplier() {

		System.out.println("Redirecting to manageProducts.jsp from Product Controller section (getSupplier method) .... ");
		System.out.println();
		
		return supplierDAO.getSupplierDetails() ; 
	}


	
	// Edit or update the product
	@RequestMapping(value = "/{prodid}/product" , method = RequestMethod.GET) 
	public String showEditProducts(@PathVariable int prodid , Model m ) {
			
		System.out.println("Redirecting to manageProducts.jsp from Product Controller section (showEditProducts method) .... ");
		System.out.println();
		
		System.out.println("Editing the product");
		System.out.println();
		
		m.addAttribute("userClickManageProducts" , true) ;
			
		m.addAttribute("title" , "Manage Products Page") ;
		
		// fetch product from the database
		Product newProduct = productDAO.getProduct(prodid) ;
			
		m.addAttribute("product" , newProduct) ; // manageProducts.jsp ka modelAttribute name 
			
		return "page_control" ;
	}
	 	
	
	
	// Delete the product
	@RequestMapping(value = "/delete/{prodid}/product" , method = RequestMethod.GET)
//	public String showDeleteProducts(@PathVariable int prodid , Model m , @RequestParam(name = "operation" , required = false ) String operation) {
	public String showDeleteProducts(@PathVariable int prodid , Model m) {	 
		
		System.out.println("Redirecting to manageProducts.jsp from Product Controller section (showDeleteProducts method) .... ");
		System.out.println();
		
		System.out.println("Deleting the product");
		System.out.println();
		
		/*
		//m.addAttribute("userClickManageProducts" , true) ;
			
		//m.addAttribute("title" , "Manage Products Page") ;
		
		// fetch product from the database
		
			
		//m.addAttribute("product" , newProduct) ; // manageProducts.jsp ka modelAttribute name 
		*/
		
		Product product = productDAO.getProduct(prodid) ;
		
		productDAO.deleteProduct(product);
		
		/*  /// Not Working 
		if(operation != null) {
			
			if(operation.equals("/delete/{prodid}/product")) {
				
				m.addAttribute("message" , "Product deleted successfully !!") ;
			}
		}
		*/
		
	//	m.addAttribute("message" , "Product deleted successfully !!") ; // displays on address bar
		//return "redirect:/manage/product" ; // doesnt work
		
		return "redirect:/manage/products?operation=product" ; // passes message (in the form of query string ) from one url to another url
	}
}
