package com.levilee.store.entity;

import java.util.Date;

public class Products {
     private int productid;
     @Override
	public String toString() {
		return "Products [productid=" + productid + ", username=" + username
				+ ", description=" + description + ", price=" + price
				+ ", category=" + category + ", photo1=" + photo1 + ", photo2="
				+ photo2 + ", releasedate=" + releasedate + ", status="
				+ status + "]";
	}
	private String username;
     private String description;
     private double price;
     private String  category;
     private String photo1;
     private String photo2;
     private Date releasedate;
     private int status;
     
   private int cartid;
	public int getCartid() {
	return cartid;
}
public void setCartid(int cartid) {
	this.cartid = cartid;
}
	public int getProductid() {
		return productid;
	}
	public void setProductid(int productid) {
		this.productid = productid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}

	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getPhoto1() {
		return photo1;
	}
	public void setPhoto1(String photo1) {
		this.photo1 = photo1;
	}
	public String getPhoto2() {
		return photo2;
	}
	public void setPhoto2(String photo2) {
		this.photo2 = photo2;
	}
	public Date getReleasedate() {
		return releasedate;
	}
	public void setReleasedate(Date releasedate) {
		this.releasedate = releasedate;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
}
