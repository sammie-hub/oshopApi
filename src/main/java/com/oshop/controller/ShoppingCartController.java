package com.oshop.controller;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.TreeSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.oshop.dto.ShoppingCartProductResponse;
import com.oshop.dto.ShoppingCartResponse;
import com.oshop.model.Product;
import com.oshop.model.ShoppingCart;
import com.oshop.model.ShoppingCartProducts;
import com.oshop.service.ShoppingCartService;

//@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/")
@EnableTransactionManagement
public class ShoppingCartController {

	@Autowired
	private ShoppingCartService shoppingCartService;
	
	@RequestMapping(value = "cart", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Integer> addProduct(@RequestBody ShoppingCart shoppingCart) {
		shoppingCart.setLocalDateTime(new Date());
		int id = shoppingCartService.save(shoppingCart).getId();
		return ResponseEntity.accepted().body(id);
	}
	
	@RequestMapping(value = "createCart", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Integer> createShoppingCart(@RequestBody ShoppingCart shoppingCart) throws URISyntaxException {
		
		int id = shoppingCartService.save(shoppingCart).getId();
		return ResponseEntity.accepted().body(id);
	}
	
	@RequestMapping(value = "cart", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<ShoppingCart> getAllCartProducts()
	{
		return shoppingCartService.getAll();
	}
	
	@RequestMapping(value = "/cart/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public TreeSet<ShoppingCartResponse> getCartById(@PathVariable int id)
	{
		return shoppingCartService.getCartById(id);
	}
	
	@RequestMapping(value = "/cart/{sc_fk}/{pid}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ShoppingCartResponse getProduct(@PathVariable int sc_fk, @PathVariable int pid)
	{
		return shoppingCartService.getCartProductById(sc_fk, pid);
	}
	
	@RequestMapping(value = "/cart/q/{sc_fk}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<ShoppingCartProductResponse> getCartProductsQuantity(@PathVariable int sc_fk)
	{
		return shoppingCartService.getCartProductsQuantity(sc_fk);
	}
	
}
