package com.sevya.tasks.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="productcategorymapper")
public class ProductCategoryMapper extends BaseModel {
	
	@ManyToOne(targetEntity=Product.class)
	@JoinColumn(name="productId")
	private Product product;
	
	@ManyToOne(targetEntity=Category.class)
	@JoinColumn(name="categoryId")
	private Category category;

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	
	
}
