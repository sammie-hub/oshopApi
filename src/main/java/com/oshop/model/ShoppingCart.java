package com.oshop.model;

import java.time.LocalDateTime;
import java.util.Date;
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

@Entity
@Table(name = "shoppingCart")
public class ShoppingCart {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "local_date_time", columnDefinition = "TIMESTAMP")
	private Date localDateTime;
	
	private int totalProducts;
	
	@OneToMany(targetEntity = ShoppingCartProducts.class,cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
	@JoinColumn(name ="sc_fk")
	private List<ShoppingCartProducts> products;

	public ShoppingCart() {
		super();
		// TODO Auto-generated constructor stub
	}

	public List<ShoppingCartProducts> getProducts() {
		return products;
	}

	public ShoppingCart(int id, Date localDateTime, int totalProducts, List<ShoppingCartProducts> products) {
		super();
		this.id = id;
		this.localDateTime = localDateTime;
		this.totalProducts = totalProducts;
		this.products = products;
	}

	public void setProducts(List<ShoppingCartProducts> products) {
		this.products = products;
	}

	public int getTotalProducts() {
		return totalProducts;
	}

	public void setTotalProducts(int totalProducts) {
		this.totalProducts = totalProducts;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getLocalDateTime() {
		return localDateTime;
	}

	public void setLocalDateTime(Date localDateTime) {
		this.localDateTime = localDateTime;
	}

}
