package com.demo1.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo1.entity.CategoryEntity;



public interface CategoryRepository extends JpaRepository<CategoryEntity, Long>{

	
}
