package com.oshop.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oshop.model.Categories;
import com.oshop.model.Product;
import com.oshop.repo.CategoryRepository;
import com.oshop.repo.OshopRepository;

@Service
public class ProductsService {

	@Autowired
	private OshopRepository oshopRepo;

	public Product save(Product product) {
		return oshopRepo.save(product);
	}

	public List<Product> getAllProducts() {

		return oshopRepo.findAll();
	}

	public Optional<Product> getProductById(Integer id) {

		return oshopRepo.findById(id);
	}
	
	public void delete(Integer id) {
		oshopRepo.deleteById(id);
	}
}
