package com.oshop.dto;

import java.util.List;

public class ShoppingCartProductResponse {

	private Integer quantities;
	
	private Integer ids;

	public Integer getQuantities() {
		return quantities;
	}

	public void setQuantities(Integer quantities) {
		this.quantities = quantities;
	}

	public Integer getIds() {
		return ids;
	}

	public void setIds(Integer ids) {
		this.ids = ids;
	}

	public ShoppingCartProductResponse(Integer quantities, Integer ids) {
		super();
		this.quantities = quantities;
		this.ids = ids;
	}

	public ShoppingCartProductResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	}
