package com.sevya.tasks.service;

import java.util.List;

import com.sevya.tasks.model.Product;

public interface ProductService {
	public Product saveProduct(Product product);
	
	public List<Product> getAllProducts();
	
	public Product getProductById(Integer id);
	
	public List<Product> getProductsByName(String name);
}
