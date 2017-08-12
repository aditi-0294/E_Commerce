package com.niit.BookstoreBackend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.stereotype.Component;

@Entity // DB name
@Table // table name in DB
@Component
public class Category {

	@Id // indicates member field is primary key of current entity
	@GeneratedValue(strategy = GenerationType.IDENTITY) // increments specified column / field

//	@Column(name = "Category_Id")
	int catid;
	
	@NotBlank(message = "Please enter category name !")
//	@Column(name = "Category_Name")
	String cat_name ;
	
	@NotBlank(message = "Please enter category description !")
//	@Column(name = "Category_Description")
	String cat_desc;

	// getter-setter methods

	/* for category id */
	public int getCatid() {
		return catid;
	}

	public void setCat_id(int catid) {
		this.catid = catid;
	}

	/* for category name */
	public String getCat_name() {
		return cat_name;
	}

	public void setCat_name(String cat_name) {
		this.cat_name = cat_name;
	}

	/* for category description */
	public String getCat_desc() {
		return cat_desc;
	}

	public void setCat_desc(String cat_desc) {
		this.cat_desc = cat_desc;
	}

}