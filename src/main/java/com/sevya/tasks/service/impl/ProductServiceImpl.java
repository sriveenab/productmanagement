package com.sevya.tasks.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sevya.tasks.model.Product;
import com.sevya.tasks.repository.ProductRepository;
import com.sevya.tasks.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	public ProductRepository productRepository;
	
	@Override
	public Product saveProduct(Product product) {
		return productRepository.save(product);
	}

	@Override
	public List<Product> getAllProducts() {
		List<Product> products = new ArrayList<>();
		for(Product product : productRepository.findAll()) {
			products.add(product);
		}
		return products;
	}

	@Override
	public Product getProductById(Integer id) {
		return productRepository.getProductById(id);
	}

	@Override
	public List<Product> getProductsByName(String name) {
		return productRepository.getProductsByName(name);
	}


}
