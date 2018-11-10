package com.sevya.tasks.service;

import java.util.List;

import com.sevya.tasks.model.Category;
import com.sevya.tasks.model.ProductCategoryMapper;

public interface CategoryService {
	public List<Category> getAllCategories();
	
	public Category getCategoryById(Integer id);
	
	public List<ProductCategoryMapper> getCategoriesByProductId(Integer productId);
}
