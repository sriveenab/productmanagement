package com.sevya.tasks.controller;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sevya.tasks.dto.CategoryDto;
import com.sevya.tasks.dto.ColorDto;
import com.sevya.tasks.dto.CompanyDto;
import com.sevya.tasks.dto.ProductDto;
import com.sevya.tasks.dto.mappers.CategoryDtoMapper;
import com.sevya.tasks.dto.mappers.ColorDtoMapper;
import com.sevya.tasks.dto.mappers.CompanyDtoMapper;
import com.sevya.tasks.dto.mappers.ProductDtoMapper;
import com.sevya.tasks.model.Category;
import com.sevya.tasks.model.Color;
import com.sevya.tasks.model.Company;
import com.sevya.tasks.model.Product;
import com.sevya.tasks.model.ProductCategoryMapper;
import com.sevya.tasks.repository.ProductRepository;
import com.sevya.tasks.service.CategoryService;
import com.sevya.tasks.service.ColorService;
import com.sevya.tasks.service.CompanyService;
import com.sevya.tasks.service.ProductService;

@RestController
public class ProductManagementController {

	@Autowired
	public CategoryService categoryService;

	@Autowired
	public ColorService colorService;

	@Autowired
	public CompanyService companyService;

	@Autowired
	public ProductService productService;
	
	@Autowired 
	public ProductRepository productRepository;

	@RequestMapping(value = "/category/all", method = RequestMethod.GET)
	public List<CategoryDto> getAllCategories() {
		List<CategoryDto> categoryDtos = new ArrayList<>();
		for (Category category : categoryService.getAllCategories()) {
			categoryDtos.add(CategoryDtoMapper.toCategoryDto(category));
		}
		return categoryDtos;
	}

	@RequestMapping(value = "/color/all", method = RequestMethod.GET)
	public List<ColorDto> getAllColors() {
		List<ColorDto> colorDtos = new ArrayList<>();
		for (Color color : colorService.getAllColors()) {
			colorDtos.add(ColorDtoMapper.toColorDto(color));
		}
		return colorDtos;
	}

	@RequestMapping(value = "/company/all", method = RequestMethod.GET)
	public List<CompanyDto> getAllCompanies() {
		List<CompanyDto> companyDtos = new ArrayList<>();
		for (Company company : companyService.getAllCompanies()) {
			companyDtos.add(CompanyDtoMapper.toCompanyDto(company));
		}
		return companyDtos;
	}

	@RequestMapping(value = "/product", method = RequestMethod.POST)
	public ProductDto saveProduct(@RequestBody ProductDto productDto) throws ParseException {
		Company company = companyService.getCompanyById(productDto.getCompany().getId());
		Color color = colorService.getColorById(productDto.getColor().getId());
		Product product = ProductDtoMapper.toProduct(productDto);
		product.setCreatedDate(new Date());
		product.setColor(color);
		product.setCompany(company);
		List<ProductCategoryMapper> productCategoryMapperObj = new ArrayList<>();
		for (CategoryDto categoryDto : productDto.getCategories()) {
			ProductCategoryMapper productCategoryMapper = new ProductCategoryMapper();
			Category category = categoryService.getCategoryById(categoryDto.getId());
			productCategoryMapper.setCreatedDate(new Date());
			productCategoryMapper.setCategory(category);
			productCategoryMapperObj.add(productCategoryMapper);
		}
		product.setProductCategoryMapper(productCategoryMapperObj);
		productService.saveProduct(product);

		return productDto;

	}

	@RequestMapping(value = "/product/all", method = RequestMethod.GET)
	public List<ProductDto> getAllProducts() {
		List<ProductDto> productDtos = new ArrayList<>();
		for (Product product : productService.getAllProducts()) {
			ProductDto productObj = ProductDtoMapper.toProductDto(product);
			productDtos.add(productObj);
		}
		return productDtos;
	}

	@RequestMapping(value = "/product/{id}", method = RequestMethod.GET)
	public ProductDto getProductById(@PathVariable Integer id) {

		Product product = productService.getProductById(id);
		ProductDto productObj = ProductDtoMapper.toProductDto(product);
		return productObj;
	}

	@RequestMapping(value = "/products/{name}", method = RequestMethod.GET)
	public List<ProductDto> getProductsByName(@PathVariable String name) {

		List<ProductDto> productDtos = new ArrayList<>();
		List<Product> products = productService.getProductsByName(name);
		if (products != null && !products.isEmpty()) {
			for (Product product : products) {
				ProductDto productObj = ProductDtoMapper.toProductDto(product);
				productDtos.add(productObj);
			}
		} 
		return productDtos;
	}
	
	@RequestMapping(value = "/product/{id}", method = RequestMethod.DELETE)
	public void deleteProductById(@PathVariable Integer id) {
		productRepository.deleteProductById(id);
	}

}
