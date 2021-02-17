package com.oshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oshop.model.Categories;
import com.oshop.service.CategoryService;

//@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/admin")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;
	
	@RequestMapping(value = "categories")
	public List<Categories> getAllCategories()
	{
		List<Categories> values = categoryService.getAllCategories();
		return ResponseEntity.ok(values).getBody();
	}
}
