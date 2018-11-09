package com.sevya.tasks.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sevya.tasks.model.Category;
import com.sevya.tasks.model.ProductCategoryMapper;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Integer> {
	
	@Query("FROM Category category where category.id = :categoryId ")
	public Category getCategoryById(@Param("categoryId") Integer categoryId);
	
	@Query("FROM ProductCategoryMapper productCategoryMapper LEFT JOIN FETCH productCategoryMapper.product as product where product.id = :productId")
	public List<ProductCategoryMapper> getCategoryByProductId(@Param("productId") Integer productId);
	
}
