package com.oshop.repo;

import java.util.List;
import java.util.Optional;
import java.util.TreeSet;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.oshop.dto.ShoppingCartProductResponse;
import com.oshop.dto.ShoppingCartResponse;
import com.oshop.model.Product;
import com.oshop.model.ShoppingCart;
import com.oshop.model.ShoppingCartProducts;

@Repository
public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Integer> {
	
	//@Query("SELECT p.id, p.image_url, p.price, p.title, p.c_id, p.s_id FROM Product p inner join ShoppingCart s on s.id = p.s_id")
//	@Query("select s.id from Product s inner join s.ShoppingCart p where s.id = :id")
	//@Query("SELECT new com.oshop.dto.ProductResponse(s.id, s.totalProducts, p) FROM ShoppingCart s INNER JOIN s.products p where s.id=:cartId")
//	@Query("select new com.oshop.dto.ProductResponse(s.id, s.totalProducts, p) from ShoppingCart s Left JOIN s.products p where s.id=:cartId")
//	List<ProductResponse> findProductInCarById(@Param("cartId") Integer cartId);

//	@Query("")
//	String saveProductInCart();

	@Query("select new com.oshop.dto.ShoppingCartResponse(p.quantity, p.id, p.imageUrl, p.price, p.title, p.category) from ShoppingCart s Left JOIN s.products p where s.id = :sc_fk and p.id = :pid")
	Optional<ShoppingCartResponse> findCartProductById(@Param("sc_fk") Integer sc_fk, @Param("pid") Integer pid);
	
	@Query("select new com.oshop.dto.ShoppingCartProductResponse(p.quantity, p.id) from ShoppingCart s Left JOIN s.products p where s.id = :sc_fk")
	List<ShoppingCartProductResponse> getCartProductsQuantity(@Param("sc_fk") Integer sc_fk);
	
	@Query("select new com.oshop.dto.ShoppingCartResponse(p.quantity, p.id, p.imageUrl, p.price, p.title, p.category) from ShoppingCart s Left JOIN s.products p where s.id = :sc_fk")
	TreeSet<ShoppingCartResponse> findCartById(@Param("sc_fk") Integer sc_fk);
}
