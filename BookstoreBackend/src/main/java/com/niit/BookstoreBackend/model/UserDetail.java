package com.niit.BookstoreBackend.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity //DB name
@Table 	// table name in DB
	//(
	//uniqueConstraints = @UniqueConstraint(columnNames = {"username" , "email"})
	//)
	



public class UserDetail implements Serializable {
	
	@Id // indicates member field is primary key of current entity
	
	//@EmbeddedId - Wont work as @Id is already used
	@GeneratedValue(strategy=GenerationType.IDENTITY) // increments specified column / field
	//@GeneratedValue(generator="system-uuid")
//	@Column(name = "Customer_User_Id")
	int userid ;
	
	//@GenericGenerator(name="system-uuid", strategy = "uuid")
	
	//@Column(name = "username", unique = true, nullable = false)
	
	@Column(unique = true)
	String username ;
	//Serializable username ; // converts to compact form 
	
	
	String password ;
	
//	@Column(name = "Customer_Name")
	String customer_name ;
	
	
	String role ;
	
	
	//@Column(unique  = true)
//	@Column(name = "Customer_Email")
	String email ;
	
//	@Column(name = "Customer_Address")
	String address ; // billing address
	
    //@Column(length = 10)
//	@Column(name = "Contact_Number")
	String mobile_number ;
	//Serializable password , customer_name , role , email , address , mobile_num ;
	
	boolean role_enabled;
	//Serializable role_enabled ;
	
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "cartid")
	Cart cart ;
	
	
	
	// generate getter-setter method
	
	/* for username */
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	
	/* for password */
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	/* for customer_name */
	public String getCustomer_name() {
		return customer_name;
	}
	
	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}
	
	
	/* for role */
	public String getRole() {
		return role;
	}
	
	public void setRole(String role) {
		this.role = role;
	}
	
	
	/* for e-mail */
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	/* for address */
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	
	/* for role_enabled */
	public boolean isRole_enabled() {
		return role_enabled;
	}

	public void setRole_enabled(boolean role_enabled) {
		this.role_enabled = role_enabled;
	}


	/* for user id */
	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	
	/* for Cart class */
	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}


	/* for Mobile */
	public String getMobile_number() {
		return mobile_number;
	}

	public void setMobile_number(String mobile_number) {
		this.mobile_number = mobile_number;
	}


	 
	
	

}