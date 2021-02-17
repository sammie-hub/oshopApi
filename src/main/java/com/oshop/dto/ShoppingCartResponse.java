package com.oshop.dto;

import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.oshop.model.Categories;

public class ShoppingCartResponse implements Comparable<ShoppingCartResponse>{
	
	
	private int quantity;
	
	private int id;
	
	private String imageUrl;
	
	private float price;
	
	private String title;
	
	@OneToOne
	@JoinColumn(name = "c_id")
	private Categories category;

	

	public ShoppingCartResponse(int quantity, int id, String imageUrl, float price, String title,
			Categories category) {
		super();
		this.quantity = quantity;
		this.id = id;
		this.imageUrl = imageUrl;
		this.price = price;
		this.title = title;
		this.category = category;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Categories getCategory() {
		return category;
	}

	public void setCategory(Categories category) {
		this.category = category;
	}

	public ShoppingCartResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ShoppingCartResponse(int quantity) {
		super();
		this.quantity = quantity;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public int compareTo(ShoppingCartResponse b) {  
	    if(id>b.id){  
	        return 1;  
	    }else if(id<b.id){  
	        return -1;  
	    }else{  
	    return 0;  
	    }  
	}  
}  

