package com.niit.BookstoreBackend.model;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Table
@Entity
public class Cart {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
//	@Column(name = "Cart_Id")
	int cartid ; 
	
//	@Column(name = "Grand_Total")
	double grandTotal ; // total price of all items purchased
	
	
	@OneToOne
	@JoinColumn(name = "userid")
	UserDetail userDetail ;
	
	
	
	@OneToMany(mappedBy = "cart" , fetch = FetchType.EAGER)
	List<CartItem> cartItems ;


	// getter-setter methods

	/**
	 * @return the cartid
	 */
	public int getCartid() {
		return cartid;
	}



	/**
	 * @param cartid the cartid to set
	 */
	public void setCartid(int cartid) {
		this.cartid = cartid;
	}



	/**
	 * @return the grandTotal
	 */
	public double getGrandTotal() {
		return grandTotal;
	}



	/**
	 * @param grandTotal the grandTotal to set
	 */
	public void setGrandTotal(double grandTotal) {
		this.grandTotal = grandTotal;
	}



	/**
	 * @return the userDetail
	 */
	public UserDetail getUserDetail() {
		return userDetail;
	}



	/**
	 * @param userDetail the userDetail to set
	 */
	public void setUserDetail(UserDetail userDetail) {
		this.userDetail = userDetail;
	}



	/**
	 * @return the cartItems
	 */
	public List<CartItem> getCartItems() {
		return cartItems;
	}



	/**
	 * @param cartItems the cartItems to set
	 */
	public void setCartItems(List<CartItem> cartItems) {
		this.cartItems = cartItems;
	}


	
	
	
	
	
}
