package com.oshop.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oshop.email.SendEmail;
import com.oshop.model.orders.Orders;
import com.oshop.model.users.UserRegisteration;
import com.oshop.repo.OrdersRepositoy;

@Service
public class OrderService {

	@Autowired
	private SendEmail sendemail;
	
	@Autowired
	private OrdersRepositoy orderRepo;

	
	public Orders save(Orders order) {
//		sendemail.sendmail(order.get, email);
		return orderRepo.save(order);
	}
	
	
	public List<Orders> getAllOrders(){
		
		return orderRepo.findAll();
	}
	
	public List<Orders> getOrderByUser(String email){
		List<Orders> order = orderRepo.findByUserEmail(email);
		if(order != null) {
			return order;
		}
		
		throw new NullPointerException();
	}
	
	public Orders getOrderById(int id) {
		return orderRepo.findById(id).get();
	}
}
