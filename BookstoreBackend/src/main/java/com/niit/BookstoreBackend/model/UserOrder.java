package com.niit.BookstoreBackend.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Table
@Entity
public class UserOrder {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int orderid ;
	
	Date orderDate ;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "cartid")
	Cart cart ;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "userid")
	UserDetail userDetail ;

	
	// getter-setter method
	
	/* For Order Id */
	public int getOrderid() {
		return orderid;
	}

	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}

	
	/* For Purchasing Date */
	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	
	/* For Cart part */
	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	
	/* For UserDetail part */
	public UserDetail getUserDetail() {
		return userDetail;
	}

	public void setUserDetail(UserDetail userDetail) {
		this.userDetail = userDetail;
	}
	
	
	
	
	
	
	
}
