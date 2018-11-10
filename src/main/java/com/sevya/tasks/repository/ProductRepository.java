package com.sevya.tasks.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sevya.tasks.model.Product;

@Repository
@Transactional(readOnly = true)
public interface ProductRepository extends CrudRepository<Product, Integer> {
	
	@Query("FROM Product product where product.id = :id")
	public Product getProductById(@Param("id") Integer id);
	
	@Query("FROM Product product where product.name LIKE %:name% ")
	public List<Product> getProductsByName(@Param("name") String name);
	
	@Modifying
	@Transactional
	@Query("DELETE FROM Product product where product.id = :id")
	public void deleteProductById(@Param("id") Integer id);
}
