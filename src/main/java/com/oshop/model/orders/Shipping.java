package com.oshop.model.orders;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "shipping")
public class Shipping {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String name;
	
	private String adrressLine1;
	
	public Shipping() {
		super();
	}

	public Shipping(Integer id, String name, String adrressLine1, String adrressLine2, String city, String country) {
		super();
		this.id = id;
		this.name = name;
		this.adrressLine1 = adrressLine1;
		this.adrressLine2 = adrressLine2;
		this.city = city;
		this.country = country;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAdrressLine1() {
		return adrressLine1;
	}

	public void setAdrressLine1(String adrressLine1) {
		this.adrressLine1 = adrressLine1;
	}

	public String getAdrressLine2() {
		return adrressLine2;
	}

	public void setAdrressLine2(String adrressLine2) {
		this.adrressLine2 = adrressLine2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	private String adrressLine2;
	
	private String city;
	
	private String country;

}
