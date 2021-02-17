package com.oshop.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.oshop.model.Categories;

@Repository
public interface CategoryRepository extends JpaRepository<Categories, Integer> {

}
