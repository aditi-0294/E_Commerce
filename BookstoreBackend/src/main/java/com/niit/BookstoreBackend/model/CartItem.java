package com.niit.BookstoreBackend.model;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.niit.BookstoreBackend.model.Cart;
import com.niit.BookstoreBackend.model.Product;

@Table
@Entity
public class CartItem {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
//	@Column(name = "CartItem_Id")
	int cartItemId ;
	
//	@Column(name = "CartItem_Quantity")
	int cartqty ; // quantity purchased by user
	
//	@Column(name = "CartItem_Total_Price")
	double unitPrice ; // individual product ka price 
	

	@ManyToOne
	@JoinColumn(name = "prodid")
	Product product ;
	
	
	
	@ManyToOne
	@JoinColumn(name = "cartid")
	Cart cart ;


	// getter-setter methods
	
	
	/* For CartItem Id */
	public int getCartItemId() {
		return cartItemId;
	}

	public void setCartItemId(int cartItemId) {
		this.cartItemId = cartItemId;
	}


	
	/* For Products */
	public Product getProduct() {
		return product;
	}


	public void setProduct(Product product) {
		this.product = product;
	}

	
	/* For Cart Id */
	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}


	/* For Cart Quantity */
	public int getCartqty() {
		return cartqty;
	}

	public void setCartqty(int cartqty) {
		this.cartqty = cartqty;
	}

	
	/* For Total Price of products purchased by user */
	public double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}
	


}
