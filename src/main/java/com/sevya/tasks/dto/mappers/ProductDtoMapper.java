package com.sevya.tasks.dto.mappers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.sevya.tasks.dto.CategoryDto;
import com.sevya.tasks.dto.ColorDto;
import com.sevya.tasks.dto.CompanyDto;
import com.sevya.tasks.dto.ProductDto;
import com.sevya.tasks.model.Product;
import com.sevya.tasks.model.ProductCategoryMapper;

public class ProductDtoMapper {
	public static ProductDto toProductDto(Product product) {
		ProductDto productDto = new ProductDto();
		productDto.setCost(product.getCost());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String langDate = sdf.format(product.getDateOfManufacture());
		productDto.setDateOfManufacture(langDate);
		productDto.setHeight(product.getHeight());
		productDto.setWeight(product.getWeight());
		productDto.setLength(product.getLength());
		productDto.setName(product.getName());
		productDto.setId(product.getId());
		
		CompanyDto companyDto = CompanyDtoMapper.toCompanyDto(product.getCompany());
		ColorDto colorDto = ColorDtoMapper.toColorDto(product.getColor());
		productDto.setCompany(companyDto);
		productDto.setColor(colorDto);
		List<CategoryDto> categories = new ArrayList<>();
		List<ProductCategoryMapper> productCategoryMapperObj = product.getProductCategoryMapper();
		for(ProductCategoryMapper productCategoryMapper : productCategoryMapperObj) {
			categories.add(CategoryDtoMapper.toCategoryDto(productCategoryMapper.getCategory()));
		}
		productDto.setCategories(categories);
		
		return productDto;
	}
	public static Product toProduct(ProductDto productDto) throws ParseException {
		Product product = new Product();
		product.setCost(productDto.getCost());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date langDate = sdf.parse(productDto.getDateOfManufacture());
		product.setDateOfManufacture(langDate);
		product.setHeight(productDto.getHeight());
		product.setWeight(productDto.getWeight());
		product.setLength(productDto.getLength());
		product.setName(productDto.getName());
		return product;
	}
}
