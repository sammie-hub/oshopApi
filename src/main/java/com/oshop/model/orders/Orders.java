package com.oshop.model.orders;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "orders")
public class Orders {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private Date datePlaced;
	
	@OneToMany(targetEntity = OrderedProduct.class,cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
	@JoinColumn(name ="o_fk")
	private List<OrderedProduct> oProducts;
	
	private float totalOrderPrice;
	
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
	@JoinColumn(name = "s_id")
	private Shipping shippingDetails;

	private String userEmail;
	
	public Orders() {
		super();
	}

	

	public Orders(Integer id, Date datePlaced, List<OrderedProduct> oProducts, float totalOrderPrice,
			Shipping shippingDetails, String userEmail) {
		super();
		this.id = id;
		this.datePlaced = datePlaced;
		this.oProducts = oProducts;
		this.totalOrderPrice = totalOrderPrice;
		this.shippingDetails = shippingDetails;
		this.userEmail = userEmail;
	}



	public String getUserEmail() {
		return userEmail;
	}



	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}



	public float getTotalOrderPrice() {
		return totalOrderPrice;
	}



	public void setTotalOrderPrice(float totalOrderPrice) {
		this.totalOrderPrice = totalOrderPrice;
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDatePlaced() {
		return datePlaced;
	}

	public void setDatePlaced(Date datePlaced) {
		this.datePlaced = datePlaced;
	}

	public List<OrderedProduct> getoProducts() {
		return oProducts;
	}

	public void setoProducts(List<OrderedProduct> oProducts) {
		this.oProducts = oProducts;
	}

	public Shipping getShippingDetails() {
		return shippingDetails;
	}

	public void setShippingDetails(Shipping shippingDetails) {
		this.shippingDetails = shippingDetails;
	}

}
