package com.sevya.tasks.dto.mappers;

import java.util.ArrayList;
import java.util.List;

import com.sevya.tasks.dto.CategoryDto;
import com.sevya.tasks.model.Category;

public class CategoryDtoMapper {
	public static List<CategoryDto> toCategoryDtos(List<Category> categories) {
		
		List<CategoryDto> categoryDtos = new ArrayList<>();
		for(Category category : categories) {
			categoryDtos.add(toCategoryDto(category));
		}
		return categoryDtos;
	}
	
	public static CategoryDto toCategoryDto(Category category) {
		CategoryDto categoryDto = new CategoryDto();
		categoryDto.setId(category.getId());
		categoryDto.setName(category.getName());
		return categoryDto;
	}
	
	public static List<Category> toCategories(List<CategoryDto> categoryDtos) {
		
		List<Category> categories = new ArrayList<>();
		for(CategoryDto categoryDto : categoryDtos) {
			categories.add(toCategory(categoryDto));
		}
		return categories;
	}
	
	public static Category toCategory(CategoryDto categoryDto) {
		Category category = new Category();
		category.setId(categoryDto.getId());
		category.setName(categoryDto.getName());
		return category;
	}
}
