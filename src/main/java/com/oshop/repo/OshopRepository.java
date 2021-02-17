package com.oshop.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.oshop.model.Product;

@Repository
public interface OshopRepository extends JpaRepository<Product, Integer> {

}
