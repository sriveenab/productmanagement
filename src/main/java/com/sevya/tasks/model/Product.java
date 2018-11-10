package com.sevya.tasks.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="product")
public class Product extends BaseModel {
	
	private String name;
	private Date dateOfManufacture;
	private Integer weight;
	private Integer height;
	private Integer length;
	private Float cost;
	
	@ManyToOne(targetEntity=Company.class)
	@JoinColumn(name="comapanyId")	
	private Company company;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="productId")
	private List<ProductCategoryMapper> productCategoryMapper;
	
	@ManyToOne(targetEntity=Color.class)
	@JoinColumn(name="colorId")
	private Color color;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDateOfManufacture() {
		return dateOfManufacture;
	}

	public void setDateOfManufacture(Date dateOfManufacture) {
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

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public List<ProductCategoryMapper> getProductCategoryMapper() {
		return productCategoryMapper;
	}

	public void setProductCategoryMapper(List<ProductCategoryMapper> productCategoryMapper) {
		this.productCategoryMapper = productCategoryMapper;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
	
	
}
