package com.sevya.tasks.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="category")
public class Category extends BaseModel {

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
