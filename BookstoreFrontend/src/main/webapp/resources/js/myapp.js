$(function() {

	// solving the active menu problem

	switch (menu) {
	
	/*
	case 'Home Page':

		$('#home').addClass('active');
		break;
	*/
	
	case 'All Products Page':

		$('#listProducts').addClass('active');
	//	$('#a_' + menu).addClass('active');
		break;

	case 'Manage Products Page':

		$('#manageProducts').addClass('active');
		break;
		
	case 'Manage Categories Page':

		$('#manageCategory').addClass('active');
		break;

	case 'Manage Suppliers Page':

		$('#manageSupplier').addClass('active');
		break;
		
	case 'About Us Page':

		$('#about').addClass('active');
		break;

	case 'Contact Us Page':

		$('#contact').addClass('active');
		break;

	
	case 'Register Page':

		$('#register').addClass('active');
		break;

	case 'Login Page':

		$('#login').addClass('active');
		break;

	default:
		if(menu == "Home Page")
			break ;
		$('#listProducts').addClass('active');
		$('#a_'+menu).addClass('active');
		break;

	}
	
	
	// code for jQuery dataTable
	// create a datasets
	
	/*
	var products = [
						
		['1','ABC'],
		['2','DEF'],
		['3','GHI'],
		['4','JKL'],
		['5','MNO'],
		['6','PQR'],
		['7','STU'],
		['8','VW'],
		['9','XYZ']
		
	];
	 
	*/
	
	
	// JQuery for product table
	
	var $table = $('#productListTable') ;
	
	// execute the following code only where we have this table 
	if($table.length) {
		
	//	console.log('Inside the table') ;
	
	var jsonUrl = '' ;
	
	if(window.catid == '') { // user asks for all the products
		jsonUrl = window.contextRoot + '/json/data/all/products' ;
	}
	else {
		jsonUrl = window.contextRoot + '/json/data/category/'+ window.catid +'/products' ;
	}
		
		$table.DataTable( {
			
			lengthMenu: [[3,5,10,-1] , ['3 Products' , '5 Products' , '10 Products' , 'ALL Products']], //-1 : display all records else display 3 , 5 and 10 records 
			pageLength: 5 , // no. of records per page
			//data: products
			
			ajax : {
				
				url: jsonUrl ,
				dataSrc: '' //collection of objects without any name 
			} ,
			
			columns : [
						{
							data: 'code' ,
							mRender: function(data, type, row) {
								
								return '<img src = "'+window.contextRoot+'/resources/images/'+data+'.jpg" class = "dataTableImg" />' ;
								
							}
						} ,
				
						{
							data: 'prod_name' 
						} ,
						
						{
							data: 'prodqty' ,
							
							// if quantity is zero then table should display out of stock message  
							mRender: function(data, type, row) {
								
								if(data < 1) {
									
									return '<span style = "color : tomato"> Out of Stock ! </span>' ;
								}
								
								return data ;
							}
						} ,
												
						{
							data: 'prodprice' ,
							  mRender : function(data, type, row) {
								return '&#8377; ' + data //&#8377 - for rs. symbol and &#160 for spacing
						    }
						} ,
						
						
						{
							data : 'prodid' ,
							bSortable: false , // removes sorting symbol from the last column
							mRender : function(data, type, row) { // here , data represents the id but row contains information about the entire product 
								
								var str = '' ;
						
								str += '<a href = "'+window.contextRoot+ '/show/'+data+'/product" class = "btn btn-info"> View </a>' ; 
							  //str += '<a href = "'+window.contextRoot+ '/show/'+data+'/product" class = "btn btn-info"><span class = "glyphicon glyphicon-eye-open"></span></a>' ;
								/*
								if(row.prodqty < 1) { // disable cart button option
								
									str += '<a href = "javascript:void(0)" class = "btn btn-success disable"> Add to cart </a>' ;
									 //str += '<a href = "'+window.contextRoot+ '/cart/add/'+data+'/product" class = "btn btn-primary"><span class = "glyphicon glyphicon-shopping-cart"></span></a>' ;
									
								}
								
								
								else {
									
									str += '<a href = "'+window.contextRoot+ '/cart/add/'+data+'/product" class = "btn btn-success"> Add to cart </a>' ;
								//  str += '<a href = "'+window.contextRoot+ '/cart/add/'+data+'/product" class = "btn btn-primary"><span class = "glyphicon glyphicon-shopping-cart"></span></a>' ;
								
								}
								*/
							
								return str ;
							
							}
						}
						
						
						
												
										
			]
			
		}) ;
		
		// dismissing the alert after 3 secs 
		var $alert = $('.alert') ;
		
		if($alert.length) {
			
			setTimeout(function() {
				
				$alert.fadeOut('slow') ;				
				
			} , 3000) ;
			
		}
		
		
	}
	
	
	
	/*	Data Table for admin	*/
 	
		// *****************	Admin Products start		*****************
	var $adminProductsTable = $('#AdminProductsTable') ;
	
	// execute the following code only where we have this table 
	if($adminProductsTable.length) {
		
	//	console.log('Inside the table') ;
	
	var jsonUrl = window.contextRoot + '/json/data/admin/all/products' ;
	
		
	$adminProductsTable.DataTable( {
			
			lengthMenu: [[10,20,50,-1] , ['10 Products' , '20 Products' , '50 Products' , 'ALL Products']], //-1 : display all records else display 10 , 20 and 50 records 
			pageLength: 10 , // no. of records per page
			//data: products
			
			ajax : {
				
				url: jsonUrl ,
				dataSrc: '' //collection of objects without any name 
			} ,
			
			columns : [
				
						{
							
							data: 'prodid'
							
						} ,
						
						{
							data: 'code' ,
							mRender: function(data, type, row) {
								
								return '<img src = "'+window.contextRoot+'/resources/images/'+data+'.jpg" class = "adminDataTableImg" />' ;
								
							}
						
						} ,
				
						{
							data: 'prod_name' 
						} ,
						
						{
							data: 'prodqty' ,
							
							// if quantity is zero then table should display out of stock message  
							mRender: function(data, type, row) {
								
								if(data < 1) {
									
									return '<span style = "color : tomato"> Out of Stock ! </span>' ;
								}
								
								return data ;
							}
						} ,
												
						{
							data: 'prodprice' ,
							  mRender : function(data, type, row) {
								return '&#8377; ' + data //&#8377 - for rs. symbol and &#160 for spacing
						    }
						} ,
						
						
						{
							data : 'prodid' ,
							bSortable: false , // removes sorting symbol from the last column
							mRender : function(data, type, row) { // here , data represents the id but row contains information about the entire product 
								
								var str = '' ;
						
								// for editing or updating the product
								str += '<a href = "'+window.contextRoot+'/manage/'+data+'/product" class = "btn btn-info"> Edit </a> &#160;&#160;'
								
								// for deleting the product
								str += '<a href = "'+window.contextRoot+'/manage/delete/'+data+'/product" class = "btn btn-danger"> Delete </a>'

								
								return str ;
								
								/*
								if(row.prodqty < 1) { // disable cart button option
								
									str += '<a href = "javascript:void(0)" class = "btn btn-success disable"> Add to cart </a>' ;
									 //str += '<a href = "'+window.contextRoot+ '/cart/add/'+data+'/product" class = "btn btn-primary"><span class = "glyphicon glyphicon-shopping-cart"></span></a>' ;
									
								}
								
								
								else {
									
									str += '<a href = "'+window.contextRoot+ '/cart/add/'+data+'/product" class = "btn btn-success"> Add to cart </a>' ;
								//  str += '<a href = "'+window.contextRoot+ '/cart/add/'+data+'/product" class = "btn btn-primary"><span class = "glyphicon glyphicon-shopping-cart"></span></a>' ;
								
								}
								
							
								return str ;
							*/
								
							}
						}
						
						
						
												
										
			]
			
		}) ;
		
	}
	
	// *****************	Admin Products End		*****************
	
	// *****************	Admin Categories start		*****************

	/*
	var $adminCategoryTable = $('#AdminCategoryTable') ;
	
	// execute the following code only where we have this table 
	if($adminCategoryTable.length) {
		
	//	console.log('Inside the table') ;
	
	var jsonUrl = window.contextRoot + '/json/data/admin/all/categories' ;
	
		
	$adminCategoryTable.DataTable( {
			
			lengthMenu: [[10,20,50,-1] , ['10 Products' , '20 Products' , '50 Products' , 'ALL Products']], //-1 : display all records else display 10 , 20 and 50 records 
			pageLength: 10 , // no. of records per page
			//data: products
			
			ajax : {
				
				url: jsonUrl ,
				dataSrc: '' //collection of objects without any name 
			} ,
			
			columns : [
				
						{
							
							data: 'catid'
							
						} ,
						
						{
							data: 'cat_name' 
						} ,
						
						{
							data: 'cat_desc'
						} ,
						{
							data : 'catid' ,
							bSortable: false , // removes sorting symbol from the last column
							mRender : function(data, type, row) { // here , data represents the id but row contains information about the entire product 
								
								var str = '' ;
						
								// for editing or updating the category
								str += '<a href = "'+window.contextRoot+'/manage/'+data+'/category" class = "btn btn-info"> Edit </a> &#160;&#160; '
								
								// for deleting the category
								str += '<a href = "'+window.contextRoot+'/manage/delete/'+data+'/category" class = "btn btn-danger"> Delete </a>'

								
								return str ;
								
							}
						}
										
			]
			
		}) ;
		
	}
	
	*/
	
	

	var $adminCategoryTable = $('#AdminCategoryTable') ;
	
	// execute the following code only where we have this table 
	if($adminCategoryTable.length) {
		
	//	console.log('Inside the table') ;
	
	var jsonUrl = window.contextRoot + '/json/data/admin/all/categories' ;
	
		
	$adminCategoryTable.DataTable( {
			
			lengthMenu: [[10,20,50,-1] , ['10 Products' , '20 Products' , '50 Products' , 'ALL Products']], //-1 : display all records else display 10 , 20 and 50 records 
			pageLength: 10 , // no. of records per page
			//data: products
			
			ajax : {
				
				url: jsonUrl ,
				dataSrc: '' //collection of objects without any name 
			} ,
			
			columns : [
				
						{
							
							data: 'catid'
							
						} ,
						
						{
							data: 'cat_name' 
						} ,
						
						{
							data: 'cat_desc'
						} ,
						{
							data : 'catid' ,
							bSortable: false , // removes sorting symbol from the last column
							mRender : function(data, type, row) { // here , data represents the id but row contains information about the entire product 
								
								var str = '' ;
						
								// for editing or updating the category
								str += '<a href = "'+window.contextRoot+'/manage/'+data+'/category" class = "btn btn-info"> Edit </a> &#160;&#160;'
								
								// for deleting the category
								str += '<a href = "'+window.contextRoot+'/manage/delete/'+data+'/category" class = "btn btn-danger"> Delete </a>'

								
								return str ;
								
							}
						}
										
			]
			
		}) ;
		
	}

	
	// *****************	Admin Categories End		*****************
	
	// *****************	Admin Suppliers start		*****************

	var $adminSupplierTable = $('#AdminSupplierTable') ;
	
	// execute the following code only where we have this table 
	if($adminSupplierTable.length) {
		
	//	console.log('Inside the table') ;
	
	var jsonUrl = window.contextRoot + '/json/data/admin/all/suppliers' ;
	
		
	$adminSupplierTable.DataTable( {
			
			lengthMenu: [[10,20,50,-1] , ['10 Products' , '20 Products' , '50 Products' , 'ALL Products']], //-1 : display all records else display 10 , 20 and 50 records 
			pageLength: 10 , // no. of records per page
			//data: products
			
			ajax : {
				
				url: jsonUrl ,
				dataSrc: '' //collection of objects without any name 
			} ,
			
			columns : [
				
						{
							
							data: 'supid'
							
						} ,
						
						{
							data: 'sup_name' 
						} ,
						
						{
							data: 'sup_addr'
						} ,
						{
							data : 'supid' ,
							bSortable: false , // removes sorting symbol from the last column
							mRender : function(data, type, row) { // here , data represents the id but row contains information about the entire product 
								
								var str = '' ;
						
								// for editing or updating the supplier
								str += '<a href = "'+window.contextRoot+'/manage/'+data+'/supplier" class = "btn btn-info"> Edit </a> &#160;&#160;'
								
								// for deleting the supplier
								str += '<a href = "'+window.contextRoot+'/manage/delete/'+data+'/supplier" class = "btn btn-danger"> Delete </a>'

								
								return str ;
								
							}
						}
										
			]
			
		}) ;
		
	}
	
	// *****************	Admin Suppliers End		*****************
	/*	End of Data Table for Admin	*/
	
	});
