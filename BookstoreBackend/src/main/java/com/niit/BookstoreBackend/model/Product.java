package com.niit.BookstoreBackend.model;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity //DB name
@Table // table name in DB

public class Product {
	
	@Id // indicates member field is primary key of current entity
	@GeneratedValue(strategy = GenerationType.IDENTITY) // increments specified column / field
//	@Column(name = "Product_Id")
	int prodid;
	
	@JsonIgnore
	int catid , supid;
	
//	@Column(name = "Product_Quantity")
	int prodqty ;
	
	@Min(value = 1 , message = "Product cost should be > 0 !!")
//	@Column(name = "Product_Cost")
	int prodprice ;
	
	@NotBlank(message = "Please enter Product name !!")
//	@Column(name = "Product_Name")
	String prod_name ;
	
	@NotBlank(message = "Please enter Product description !!")
//	@Column(name = "Product_Description")
	String prod_desc ;
	
//	@Column(name = "Product_Code")
	String code ;
	
	// Default Constructor - code gets a unique UUID .
	public Product() {
		this.code = "PRD" + UUID.randomUUID().toString().substring(26).toUpperCase() ;
	}
	
	@Transient
	MultipartFile p_image ;
	
		// getter-setter methods 
	
	/* for multipart file - product image */
	public MultipartFile getP_image() {
		return p_image;
	}

	public void setP_image(MultipartFile p_image) {
		this.p_image = p_image;
	}

	/* for generating unique image code */
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	/* for product id : */
	public int getProdid() {
		return prodid;
	}

	public void setProdid(int prodid) {
		this.prodid = prodid;
	}

	
	/* for category id : */
	public int getCatid() {
		return catid;
	}

	public void setCatid(int catid) {
		this.catid = catid;
	}

	
	/* for supplier id : */
	public int getSupid() {
		return supid;
	}

	public void setSupid(int supid) {
		this.supid = supid;
	}
	
	
	/* for product quantity : */
	public int getProdqty() {
		return prodqty;
	}

	public void setProdqty(int prodqty) {
		this.prodqty = prodqty;
	}
	
	
	/* for product price : */
	public int getProdprice() {
		return prodprice;
	}

	public void setProdprice(int prodprice) {
		this.prodprice = prodprice;
	}

		
	/* for product name : */
	public String getProd_name() {
		return prod_name;
	}

	public void setProd_name(String prod_name) {
		this.prod_name = prod_name;
	}

	
	/* for product description : */
	public String getProd_desc() {
		return prod_desc;
	}

	public void setProd_desc(String prod_desc) {
		this.prod_desc = prod_desc;
	}
	
	

}