package com.niit.BookstoreFrontend.util;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

public class FileUploadUtility {

	public FileUploadUtility() {
		
		System.out.println("Default Constructor of FileUploadUtility of frontend util package ....");
		System.out.println();
		
	}
	
	
	private static final String ABS_PATH = "" ; // represents project location
	
	private static String REAL_PATH = "E:\\NIIT\\github_ECommerce\\E_Commerce\\BookstoreFrontend\\src\\main\\webapp\\resources\\images\\" ; // deployed by tomcat for realtime application

	public static void uploadFile(HttpServletRequest request, MultipartFile p_image, String code) {
		
		// get the real path
		REAL_PATH = request.getSession().getServletContext().getRealPath("/resources/images/") ;
		
		
		// check if the directories exists else create the directories
		
		if(!new File(ABS_PATH).exists()) { // for absolute path ( project location ) 
			
			// create the directories
			new File(ABS_PATH).mkdirs() ;
		}
		

		if(!new File(REAL_PATH).exists()) { // for Real path ( server location ) 
			
			// create the directories
			new File(REAL_PATH).mkdirs() ;
		}
		
		
		// transferTo method of multipart
		try {
			
			//Server Upload
			 p_image.transferTo(new File(REAL_PATH + code + ".jpg"));
			 
			 //Project Directory
			 p_image.transferTo(new File(ABS_PATH + code + ".jpg"));
		}
		
		catch(IOException ie) {
			
		}
	}
	
	


}
