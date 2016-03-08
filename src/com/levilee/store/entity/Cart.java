package com.levilee.store.entity;

public class Cart {
	private int cartid;

	private String username;
	private int productid;
	private int amount;

	public int getCartid() {
		return cartid;
	}
	
	public void setCartid(int cartid) {
		this.cartid = cartid;
	}
	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getProductid() {
		return productid;
	}

	public void setProductid(int productid) {
		this.productid = productid;
	}

}
