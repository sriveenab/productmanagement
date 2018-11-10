package com.sevya.tasks.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="company")
public class Company extends BaseModel {

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
