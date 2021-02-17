package com.oshop.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.oshop.model.orders.Orders;

@Repository
public interface OrdersRepositoy extends JpaRepository<Orders, Integer> {

	List<Orders> findByUserEmail(String email);
}
