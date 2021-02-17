package com.oshop.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class ShoppingCartProducts {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int scp_id;
	
	
	
	public int getScp_id() {
		return scp_id;
	}

	public void setScp_id(int scp_id) {
		this.scp_id = scp_id;
	}
	
	@Column(name = "pid")
	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	private String title;
	
	@OneToOne
	@JoinColumn(name = "c_id")
	private Categories category;
	
	private String imageUrl;
	
	private float price;
	
	private int quantity;
	

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public ShoppingCartProducts() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ShoppingCartProducts(int scp_id, String title, Categories category, String imageUrl, float price) {
		super();
		this.scp_id = scp_id;
		this.title = title;
		this.category = category;
		this.imageUrl = imageUrl;
		this.price = price;
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

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

}
