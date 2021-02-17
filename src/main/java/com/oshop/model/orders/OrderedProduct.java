package com.oshop.model.orders;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.oshop.model.Categories;

@Entity
@Table(name = "order_product")
public class OrderedProduct {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String title;

	private String imageUrl;

	private int quantity;

	private float totalPrice;

	@OneToOne
	@JoinColumn(name = "c_id")
	private Categories category;

	private float price;

	public OrderedProduct(Integer id, String title, String imageUrl, int quantity, int totalPrice, Categories category,
			int price) {
		super();
		this.id = id;
		this.title = title;
		this.imageUrl = imageUrl;
		this.quantity = quantity;
		this.totalPrice = totalPrice;
		this.category = category;
		this.price = price;
	}

	public Categories getCategory() {
		return category;
	}

	public void setCategory(Categories category) {
		this.category = category;
	}

	public OrderedProduct() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public float getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

}
