package com.oshop.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import com.oshop.dto.ShoppingCartProductResponse;
import com.oshop.dto.ShoppingCartResponse;
import com.oshop.model.Product;
import com.oshop.model.ShoppingCart;
import com.oshop.model.ShoppingCartProducts;
import com.oshop.repo.ShoppingCartRepository;

@Service
public class ShoppingCartService {
	int count = 0;
	@Autowired
	private ShoppingCartRepository shoppingCartRepository;
	
	@Transactional
	@Modifying
	public ShoppingCart save(ShoppingCart shoppingCart) {
		
		
		return shoppingCartRepository.save(shoppingCart);
	}

	
	public List<ShoppingCart> getAll() {
		return shoppingCartRepository.findAll();
	}
	
	public TreeSet<ShoppingCartResponse> getCartById(Integer id){
		return shoppingCartRepository.findCartById(id);
	}
	
	public ShoppingCartResponse getCartProductById(Integer sc_fk, Integer pid) {
		Optional<ShoppingCartResponse> scp = shoppingCartRepository.findCartProductById(sc_fk, pid);
		if(scp.isPresent()) {
			return scp.get();
		}
		
		return new ShoppingCartResponse();
	}
	
	public List<ShoppingCartProductResponse> getCartProductsQuantity(Integer sc_fk) {
		return shoppingCartRepository.getCartProductsQuantity(sc_fk);
	}
	public int getCartProductsTQuantity(Integer sc_fk) {
		count = 0;
//		shoppingCartRepository.getCartProductsQuantity(sc_fk).forEach(r -> {
//			count += r.getQuantities();
//		});
		return count;
	}
	
	
//	public List<ProductResponse> getCartProductById(Integer cartId) {
//		List<ProductResponse> pr = shoppingCartRepository.findProductInCarById(cartId);
//		ArrayList<ProductResponse> sc = new ArrayList<>(pr);
//		System.out.println(sc.get(0).getId());
//		
//		return shoppingCartRepository.findProductInCarById(cartId);
//	}

}
