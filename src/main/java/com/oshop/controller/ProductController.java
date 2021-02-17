package com.oshop.controller;

import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.oshop.model.Categories;
import com.oshop.model.Product;
import com.oshop.service.ProductsService;

//@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/admin")
public class ProductController {
	
	@Autowired
	private ProductsService productService;
	
	@RequestMapping(value = "/products/product", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Product> createProduct(@RequestBody Product product) throws URISyntaxException {
		
		Product result = productService.save(product);
		return ResponseEntity.ok().build();
	}
	
	@RequestMapping(value = "products/product", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Product>> getAllProducts()
	{
		List<Product> list = productService.getAllProducts();
		return ResponseEntity.ok(list);
	}
	
	@RequestMapping(value = "products/product/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Optional<Product>> getProductById(@PathVariable int id)
	{
		Optional<Product> product = productService.getProductById(id);
		ResponseEntity<Optional<Product>> response = product.isPresent() ? ResponseEntity.ok(product) : ResponseEntity.notFound().build();
		return response;
	}
		
	@RequestMapping(value = "products/product/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Product> updateProduct(@PathVariable int id, @RequestBody Product product)
	{
		product.setId(id);
		productService.save(product);
		return ResponseEntity.ok().build();
	}
	
	@RequestMapping(value = "products/product/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Product> deleteProduct(@PathVariable int id)
	{
		productService.delete(id);
		return ResponseEntity.ok().build();
	}

}
