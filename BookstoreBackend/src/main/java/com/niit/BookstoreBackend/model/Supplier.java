package com.niit.BookstoreBackend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;

@Entity //DB name
@Table // table name in DB

public class Supplier {

	@Id // indicates member field is primary key of current entity
	@GeneratedValue(strategy = GenerationType.IDENTITY) // increments specified column / field
	
//	@Column(name = "Supplier_Id")
	int supid;
	
	@NotBlank(message = "Please enter supplier name !")
//	@Column(name = "Supplier_Name")
	String sup_name ;
	
	@NotBlank(message = "Please enter supplier description !")
//	@Column(name = "Supplier_Address")
	String sup_addr;

	// generate getter-setter method
	
	/* for supplier id */
	public int getSupid() {
		return supid;
	}

	public void setSupid(int supid) {
		this.supid = supid;
	}

			
	/* for supplier name */
	public String getSup_name() {
		return sup_name;
	}

	public void setSup_name(String sup_name) {
		this.sup_name = sup_name;
	}

	
	/* for supplier address */
	public String getSup_addr() {
		return sup_addr;
	}

	public void setSup_addr(String sup_addr) {
		this.sup_addr = sup_addr;
	}

		
}