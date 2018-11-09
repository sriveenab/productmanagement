package com.sevya.tasks.dto;

import java.util.List;

public class ProductDto {
	private Integer id;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	private String name;
	private String dateOfManufacture;
	private Integer weight;
	private Integer height;
	private Integer length;
	private Float cost;
	private CompanyDto company;
	private ColorDto color;
	private List<CategoryDto> categories;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDateOfManufacture() {
		return dateOfManufacture;
	}
	public void setDateOfManufacture(String dateOfManufacture) {
		this.dateOfManufacture = dateOfManufacture;
	}
	public Integer getWeight() {
		return weight;
	}
	public void setWeight(Integer weight) {
		this.weight = weight;
	}
	public Integer getHeight() {
		return height;
	}
	public void setHeight(Integer height) {
		this.height = height;
	}
	public Integer getLength() {
		return length;
	}
	public void setLength(Integer length) {
		this.length = length;
	}
	public Float getCost() {
		return cost;
	}
	public void setCost(Float cost) {
		this.cost = cost;
	}
	public CompanyDto getCompany() {
		return company;
	}
	public void setCompany(CompanyDto company) {
		this.company = company;
	}
	public ColorDto getColor() {
		return color;
	}
	public void setColor(ColorDto color) {
		this.color = color;
	}
	public List<CategoryDto> getCategories() {
		return categories;
	}
	public void setCategories(List<CategoryDto> categories) {
		this.categories = categories;
	}
	
}
