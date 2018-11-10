package com.sevya.tasks.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sevya.tasks.model.Category;
import com.sevya.tasks.model.ProductCategoryMapper;
import com.sevya.tasks.repository.CategoryRepository;
import com.sevya.tasks.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	public CategoryRepository categoryRepository;
	
	@Override
	public List<Category> getAllCategories() {
		// TODO Auto-generated method stub
		List<Category> categories = new ArrayList<>();
		for(Category category : categoryRepository.findAll()) {
			categories.add(category);
		}
		return categories;
	}

	@Override
	public Category getCategoryById(Integer id) {
		// TODO Auto-generated method stub
		Category category = categoryRepository.getCategoryById(id);
		return category;
	}

	@Override
	public List<ProductCategoryMapper> getCategoriesByProductId(Integer productId) {
		// TODO Auto-generated method stub
		List<ProductCategoryMapper> productCategoryMappers = categoryRepository.getCategoryByProductId(productId);
		
		return productCategoryMappers;
	}

	
}
