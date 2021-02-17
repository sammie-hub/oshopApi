package com.oshop.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.oshop.model.orders.Orders;
import com.oshop.service.OrderService;

//@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/order")
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	@RequestMapping(value = "", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Integer> saveOrder(@RequestBody Orders order) {
		order.setDatePlaced(new Date());
		int id = orderService.save(order).getId();
		return ResponseEntity.accepted().body(id);
	}
	
	@RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Orders> getAllOrders() {
		return orderService.getAllOrders();
	}
	
	@RequestMapping(value = "/{email}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Orders> getOrderByUser(@PathVariable String email) {
		return orderService.getOrderByUser(email);
	}
	
	@RequestMapping(value = "/get-order/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Orders getOrderById(@PathVariable int id) {
		return orderService.getOrderById(id);
	}
	
}
